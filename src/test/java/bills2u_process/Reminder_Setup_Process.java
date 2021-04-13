package bills2u_process;

import Config.PropertyClass;
import bills2u_constant.*;
import bills2u_root.Root_Class_TestNG;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class Reminder_Setup_Process extends Root_Class_TestNG {
    public static void getTestData() throws IOException {
        PropertyClass rp=new PropertyClass();
        prop = rp.readPropertiesFile();
    }

    public static void loginProcess() throws IOException {

        try {
            getTestData();
            Obj_Rep_Home objHome = new Obj_Rep_Home();
            PageFactory.initElements(driver, objHome);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            //Click on Login Now
            try {
                log.info("Waiting till the 'Login Now' button is display");
                wait.until(ExpectedConditions.visibilityOf(objHome.loginNowButton));
                log.info("Waiting till the 'Login Now' button is click");
                wait.until(ExpectedConditions.elementToBeClickable(objHome.loginNowButton));
                String loginNowText = objHome.loginNowButton.getText();
                log.info("Clicking on the 'Login now' button");
                objHome.loginNowButton.click();
                log.info(loginNowText + " has clicked");

                //Login page
                Obj_Rep_Login objLogin = new Obj_Rep_Login();
                PageFactory.initElements(driver, objLogin);

                //Enter the username
                log.info("Waiting till the Username text box is display");
                wait.until(ExpectedConditions.visibilityOf(objLogin.username));
                try {
                    log.info("Entering username");
                    objLogin.username.sendKeys(prop.getProperty("Bills2U.Login.billersUsername"));
                    log.info("Username has entered.");
                } catch (Exception ex) {
                    log.info("Username has not entered, but it displayed the Exception as.." + ex.getMessage());
                    test.fail("Username has not entered, but it displayed the Exception as.." + ex.getMessage());
                }

                //Enter the Password
                log.info("Waiting till the 'Password' is display");
                wait.until(ExpectedConditions.visibilityOf(objLogin.password));
                try {
                    log.info("Entering password");
                    objLogin.password.sendKeys(prop.getProperty("Bills2U.Login.billersPassword"));
                    log.info("Password has entered");
                } catch (Exception ex) {
                    log.info("Password has not entered, but it displayed the Exception as.." + ex.getMessage());
                    test.fail("Password has not entered, but it displayed the Exception as.." + ex.getMessage());
                }
                //Click on Login
                log.info("Waiting till the 'Login' button is display");
                wait.until(ExpectedConditions.visibilityOf(objLogin.loginButton));
                log.info("Waiting till the 'Login' button is click");
                wait.until(ExpectedConditions.elementToBeClickable(objLogin.loginButton));
                try {
                    log.info("Clicking on the 'Login' button");
                    act.moveToElement(objLogin.loginButton).click().build().perform();
                    log.info("'Login' button has clicked");
                    log.info("Waiting till the 'Setup' menu is display");
                    wait.until(ExpectedConditions.visibilityOf(objHome.setupMenu));
                    if (objHome.setupMenu.isDisplayed()) {
                        if (objHome.setupMenu.getText().equals("Setup")) {
                            log.info("Waiting till the 'Invoice' menu is display");
                            wait.until(ExpectedConditions.visibilityOf(objHome.invoiceMenu));
                            if (objHome.invoiceMenu.isDisplayed()) {
                                if (objHome.invoiceMenu.getText().equals("Invoice")) {
                                    test.pass("Biller has able to view the Biller home Page.");
                                    log.info("Biller has able to view the Biller home Page.");
                                } else {
                                    test.fail("'Invoice' menu has deviated from it's expected result.  But it displayed " + objHome.setupMenu.getText());
                                    log.info("'Invoice' menu has deviated from it's expected result.  But it displayed " + objHome.setupMenu.getText());
                                }
                            } else {
                                log.info("'Invoice' menu has not displayed");
                                test.fail("'Invoice' menu has not displayed");
                            }
                        } else {
                            test.fail("'Setup' menu has deviated from it's expected result.  But it displayed " + objHome.setupMenu.getText());
                            log.info("'Setup' menu has deviated from it's expected result.  But it displayed " + objHome.setupMenu.getText());
                        }
                    } else {
                        log.info("'Setup' menu has not displayed");
                        test.fail("'Setup' menu has not displayed");
                    }
                } catch (Exception ex) {
                    log.info("'Login' button has not clicked, but it displayed the Exception as.." + ex.getMessage());
                    test.fail("'Login' button has not clicked, but it displayed the Exception as.." + ex.getMessage());
                }
                log.info("Waiting till the Page is loading");
                driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            } catch (Exception ex) {
                log.info("Login process has not completed.  But it displayed the Exception as..\n" + ex.getMessage());
                test.fail("Login process has not completed.  But it displayed the Exception as..\n" + ex.getMessage());
            }
        }catch (Exception ex){
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/loginProcess.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/loginProcess.jpeg").build());
        }
    }

    public static void GotToInVoiceBatch() {
        try {
            Obj_Rep_Menu menu = new Obj_Rep_Menu();
            PageFactory.initElements(driver, menu);
            menu.menuInvoice.click();
            menu.menuInvoiceBatch.click();
            Thread.sleep(5000);
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            if (bList.txtInvoiceBatch.isDisplayed() && bList.txtInvoiceBatch.getText().equals("Invoice Batch")) {
                test.pass("Biller able to navigate to the \"Invoice batch\" page");
            } else {
                test.fail("err: Biller not able to navigate to the \"Invoice batch\" page");
            }
        } catch (InterruptedException e) {
            test.fail(e.getMessage());
        }


    }

    public static void ClickAddReminder() {
        try {
            Obj_Rep_ReminderSetup rSetup = new Obj_Rep_ReminderSetup();
            PageFactory.initElements(driver, rSetup);
            rSetup.closeChip.click();
            Thread.sleep(1000);
            rSetup.btnAddReminder.click();
            Thread.sleep(1000);

            if (rSetup.txtReminderSetupVerify.getText().contains(prop.getProperty("Bills2U.ReminderSetup.TxtReminderSetup"))) {
                test.pass("Biller able to view the \"Reminder setup\" pop up");
            } else {
                test.fail("Biller not able to view the \"Reminder setup\" pop up");
            }

        } catch (Exception e) {
            test.fail(e.getMessage());
        }


    }

    public static void ClickBatchUpload() {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            bList.btnBatchUpload.click();
            Thread.sleep(2000);
            if (bList.txtNewBatchInvoice.isDisplayed() && bList.txtNewBatchInvoice.getText().equals("New Invoice Batch")) {
                test.pass("Biller able to view New Invoice Batch page");
            } else {
                test.fail("Biller not able to view New Invoice Batch page");
            }
        } catch (InterruptedException e) {
            test.fail(e.getMessage());
        }


    }

    public static void VerifyReminderSetupOption() {
        try {
            Obj_Rep_ReminderSetup rSetup = new Obj_Rep_ReminderSetup();
            PageFactory.initElements(driver, rSetup);
            rSetup.chooseReminder.click();
            Thread.sleep(1000);

            if (rSetup.chooseReminderOptionBeforeDue.isDisplayed()
                    && rSetup.chooseReminderOptionAfterDue.isDisplayed()
                    && rSetup.chooseReminderOptionOnDate.isDisplayed()
                    && rSetup.chooseReminderOptionOnDue.isDisplayed()) {
                test.pass("Biller able to view the four types of reminders \"Before Due, On Due, After Due, On Date\"");
            } else {
                test.fail("Biller not able to view the four types of reminders \"Before Due, On Due, After Due, On Date\"");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void ClickOptionBeforeDue() {
        try {
            Obj_Rep_ReminderSetup rSetup = new Obj_Rep_ReminderSetup();
            PageFactory.initElements(driver, rSetup);
            rSetup.chooseReminderOptionBeforeDue.click();
            Thread.sleep(1000);

            if (rSetup.chooseReminder.getText().contains("Before Due")) {
                test.pass("Biller able to view  the \"Before Due\"Reminder setup popup");
            } else {
                test.fail("Biller not able to view  the \"Before Due\"Reminder setup popup");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void ClickOptionAfterDue() {
        try {
            Obj_Rep_ReminderSetup rSetup = new Obj_Rep_ReminderSetup();
            PageFactory.initElements(driver, rSetup);
            rSetup.chooseReminderOptionAfterDue.click();
            Thread.sleep(1000);

            if (rSetup.chooseReminder.getText().contains("After Due")) {
                test.pass("Biller able to view  the \"After Due\"Reminder setup popup");
            } else {
                test.fail("Biller not able to view  the \"After Due\"Reminder setup popup");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void ClickOptionOnDue() {
        try {
            Obj_Rep_ReminderSetup rSetup = new Obj_Rep_ReminderSetup();
            PageFactory.initElements(driver, rSetup);
            rSetup.chooseReminderOptionOnDue.click();
            Thread.sleep(1000);

            if (rSetup.chooseReminder.getText().contains("On Due")) {
                test.pass("Biller able to view  the \"On Due\"Reminder setup popup");
            } else {
                test.fail("Biller not able to view  the \"On Due\"Reminder setup popup");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void ClickOptionOnDate() {
        try {
            Obj_Rep_ReminderSetup rSetup = new Obj_Rep_ReminderSetup();
            PageFactory.initElements(driver, rSetup);
            rSetup.chooseReminderOptionOnDate.click();
            Thread.sleep(1000);

            if (rSetup.chooseReminder.getText().contains("On Date")) {
                test.pass("Biller able to view  the \"On Date\"Reminder setup popup");
            } else {
                test.fail("Biller not able to view  the \"On Date\"Reminder setup popup");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void EnterDaysValue() {
        try {
            Obj_Rep_ReminderSetup rSetup = new Obj_Rep_ReminderSetup();
            PageFactory.initElements(driver, rSetup);
            rSetup.iptDaysOrDate.sendKeys(prop.getProperty("Bills2U.ReminderSetup.Days"));
            Thread.sleep(3000);
            System.out.println(rSetup.iptDaysOrDate.getText());
            if (rSetup.iptDaysOrDate.getAttribute("value").contains(prop.getProperty("Bills2U.ReminderSetup.Days"))) {
                test.pass("Biller able to enter the days in \"Days field\" ");
            } else {
                test.fail("Biller not able to enter the days in \"Days field\" ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void SelectDateValue() {
        try {
            Obj_Rep_ReminderSetup rSetup = new Obj_Rep_ReminderSetup();
            PageFactory.initElements(driver, rSetup);
            rSetup.selectDate.click();
            Thread.sleep(1000);
            WebElement yearSelect = driver.findElement(By.xpath("/html/body/app-root/div/div[2]/div[4]/div/mat-datepicker-content/mat-calendar/mat-calendar-header/div/div/button[1]"));
            yearSelect.click();
            Thread.sleep(1000);
            WebElement chooseYear = driver.findElement(By.cssSelector("td[aria-label='2021']"));
            chooseYear.click();
            Thread.sleep(1000);
            WebElement chooseMonth = driver.findElement(By.cssSelector("td[aria-label='01-06-2021']"));
            chooseMonth.click();
            Thread.sleep(1000);
            WebElement chooseDay = driver.findElement(By.cssSelector("td[aria-label='01-06-2021']"));
            chooseDay.click();

            Thread.sleep(1000);
            System.out.println(rSetup.selectDate.getText());
            if (rSetup.selectDate.getAttribute("value").contains("01-06-2021")) {
                test.pass("Biller able to enter the days in \"Days field\" ");
            } else {
                test.fail("Biller not able to enter the days in \"Days field\" ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void ClickSetupDoneButton() {
        try {
            Obj_Rep_ReminderSetup rSetup = new Obj_Rep_ReminderSetup();
            PageFactory.initElements(driver, rSetup);
            rSetup.btnReminderSetupDone.click();
            Thread.sleep(5000);

            if (rSetup.txtChipVerifyReminder.getText()
                    .contains("" + prop.getProperty("Bills2U.ReminderSetup.Days")
                            + " day before due")) {
                test.pass("Biller able to set the before due reminder setup");
            } else if (rSetup.txtChipVerifyReminderAfterDue.getText().contains("" + prop.getProperty("Bills2U.ReminderSetup.Days")
                    + " day after due")) {
                test.pass("Biller able to set the after due reminder setup");
            } else {
                test.fail("Biller not able to set the before due reminder setup");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void clickHereProcess() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            log.info("Waiting till the 'Click here' has to be display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.clickHere));
            if (objInvoice.clickHere.isDisplayed()) {
                log.info("'Click here' link has displayed");
                log.info("Waiting till the 'Click here' has to be enable");
                wait.until(ExpectedConditions.visibilityOf(objInvoice.clickHere));
                if (objInvoice.clickHere.isEnabled()) {
                    log.info("'Click here' link has enabled to click");
                    try {
                        act.moveToElement(objInvoice.clickHere).click().build().perform();
                        Thread.sleep(10000);
                        String downloadPath = prop.getProperty("Bills2U.FileUpload.DownloadPath");
                        File getLatestFile = getLatestFilefromDir(downloadPath);
                        String fileName = getFileNameWithoutExtension(getLatestFile);
                        System.out.println("File Name :- " + fileName);
                        assert getLatestFile != null;
                        if (getLatestFile.exists()) {
                            test.pass("Biller has able to download the file and latest downloaded file name is '" + getLatestFile.getName() + "'.");

                        } else {
                            test.fail("Biller has not able to download the file.  And the latest file name is " + getLatestFile.getName());
                        }
                    } catch (Exception ex) {
                        test.fail("Biller unable to download the file.  And it displayed the exception as..\n" + ex.getMessage());
                        log.info("Biller unable to download the file.  And it displayed the exception as..\n" + ex.getMessage());
                    }
                } else {
                    log.info("'Click here' link has not enabled to click");
                    test.fail("'Click here' link has not enabled to click");
                }
            } else {
                test.fail("'Click here' link has not displayed");
                log.info("'Click here' link has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickHereProcess.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickHereProcess.jpeg").build());
        }
    }

    private static String getFileNameWithoutExtension(File file) {
        String fileName = "";

        try {
            if (file != null && file.exists()) {
                String name = file.getName();
                fileName = name.replaceFirst("[.][^.]+$", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
            fileName = "";
        }

        return fileName;

    }

    private static File getLatestFilefromDir(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }

    public static void uploadFile() throws IOException {
        try {
            getTestData();
            String downloadPath = prop.getProperty("Bills2U.FileUpload.DownloadPath");
            File getLatestFile = getLatestFilefromDir(downloadPath);
            assert getLatestFile != null;
            String fileName = getLatestFile.getName();
            System.out.println("File Name :- " + fileName);
            System.out.println(downloadPath + getLatestFile.getName());
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            try {
                System.out.println(downloadPath + fileName);
                objInvoice.uploadFile.sendKeys(downloadPath + fileName);
                System.out.println(downloadPath + fileName);
                Thread.sleep(15000);
                Actions act = new Actions(driver);
                act.moveToElement(objInvoice.uploadSuccessfullMsg).build().perform();
                System.out.println(prop.getProperty("Bills2U.FileUpload.UploadSuccessfulMsg"));
                if (objInvoice.uploadSuccessfullMsg.getText().equals(prop.getProperty("Bills2U.FileUpload.UploadSuccessfulMsg"))) {
                    test.pass("Biller has able to view the message as file processed successfully");
                    log.info("Biller has able to view the message as file processed successfully");
                } else {
                    test.fail("Biller unable to view the message as file processed successfully.  But it displayed " + objInvoice.uploadSuccessfullMsg.getText());
                    log.info("Biller unable to view the message as file processed successfully");

                }
            } catch (Exception ex) {
                test.fail(ex.getMessage());
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/uploadFile.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/uploadFile.jpeg").build());
        }
    }

    public static void ClickPublishButton() {
        try {

            getTestData();
            Obj_Rep_BatchUpload bUpload = new Obj_Rep_BatchUpload();
            PageFactory.initElements(driver, bUpload);
            clickHereProcess();
            Thread.sleep(1000);
            uploadFile();
            Actions act=new Actions(driver);

            String downloadPath = prop.getProperty("Bills2U.FileUpload.DownloadPath");
            File getLatestFile = getLatestFilefromDir(downloadPath);
            assert getLatestFile != null;
            String fileName = getLatestFile.getName();
            Thread.sleep(10000);
            new File(downloadPath+fileName).delete();
            act.moveToElement(bUpload.chkVerifyBillGenerateBox).build().perform();
           if (!bUpload.chkVerifyBillGenerateBox.isSelected()) {
               bUpload.chkVerifyBillGenerateBox.click();
           }

            Thread.sleep(5000);
            act.moveToElement(bUpload.btnPublish).click().build().perform();
            Thread.sleep(1000);
            bUpload.btnPublishAnyway.click();
            Thread.sleep(10000);
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            if (bList.txtInvoiceBatch.isDisplayed() && bList.txtInvoiceBatch.getText().equals("Invoice Batch")) {
                test.pass("Biller  able to upload and publish the invoice batch");
            } else {
                test.fail("Biller not able to upload and publish the invoice batch");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }
    }

    public static void VerifySetupCancelButton() {
        try {
            Obj_Rep_ReminderSetup rSetup = new Obj_Rep_ReminderSetup();
            PageFactory.initElements(driver, rSetup);

            if (rSetup.btnReminderPopupCancel.isDisplayed()) {
                test.pass("Biller able to view the \"Cancel\" button ");
            } else {
                test.fail("Biller able to view the \"Cancel\" button ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static void ClickSetupCancelButton() {
        try {
            Obj_Rep_ReminderSetup rSetup = new Obj_Rep_ReminderSetup();
            PageFactory.initElements(driver, rSetup);
            rSetup.chooseReminderOptionBeforeDue.click();
            Thread.sleep(1000);
            rSetup.btnReminderPopupCancel.click();
            Thread.sleep(2000);

            if (!rSetup.btnReminderPopupCancel.isDisplayed()) {
                test.pass("Biller able to cancel the reminder");
            } else {
                test.fail("Biller able to cancel the reminder");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void ClickSetupCloseButton() {
        try {
            Obj_Rep_ReminderSetup rSetup = new Obj_Rep_ReminderSetup();
            PageFactory.initElements(driver, rSetup);
            rSetup.chooseReminderOptionBeforeDue.click();
            Thread.sleep(1000);
            rSetup.btnReminderPopupClose.click();
            Thread.sleep(2000);

            if (!rSetup.btnReminderPopupCancel.isDisplayed()) {
                test.pass("Biller able to close the reminder");
            } else {
                test.fail("Biller able to close the reminder");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }


}
