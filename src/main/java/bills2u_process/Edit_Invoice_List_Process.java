package bills2u_process;

import Config.PropertyClass;
import bills2u_constant.*;
import bills2u_root.Root_Class;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.io.Files;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Edit_Invoice_List_Process extends Root_Class {

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

    public static void EnterInvoiceNumber() {
        try {
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            eBList.filterInvoiceNumber.sendKeys(prop.getProperty("Bills2U.EditBatchList.Invoice.Filter"));


        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public static void FindFilterInvoiceBatch(String data) {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            bList.iptFindFilter.clear();
            bList.iptFindFilter.sendKeys(data);
            Thread.sleep(7000);

        } catch (InterruptedException e) {
            test.fail(e.getMessage());
        }


    }

    public static void GoToEditInvoiceBatchList() {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            bList.goToEditInvoiceBatch.click();
            Thread.sleep(1000);
            if (bList.txtVerifyEditBatchInvoice.getText().contains(prop.getProperty("Bills2U.EditBatchList.BatchName.Filter"))) {
                test.pass("Biller be able to navigate to the \"Invoice batch edit\" page");
            } else {
                test.fail("Biller not be able to navigate to the \"Invoice batch edit\" page");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
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

    public static void VerifyEnteredInvoiceNumber() {
        try {
            EnterInvoiceNumber();
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            if (eBList.filterInvoiceNumber.getAttribute("value").contains(prop.getProperty("Bills2U.EditBatchList.Invoice.Filter"))) {
                test.pass("Biller be able to enter the invoice number in filter");
            } else {
                test.fail("Biller not be able to enter the invoice number in filter");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public static void EnterRef1Number() {
        try {
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            eBList.filterRef1.sendKeys(prop.getProperty("Bills2U.EditBatchList.Ref1.Filter"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }

    public static void VerifyEnteredRef1Number() {
        try {
            EnterRef1Number();
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            if (eBList.filterRef1.getAttribute("value").contains(prop.getProperty("Bills2U.EditBatchList.Ref1.Filter"))) {
                test.pass("Biller be able to enter the reference1 in filter");
            } else {
                test.fail("Biller not be able to enter the reference1 in filter");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public static void EnterRef2Number() {
        try {
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            eBList.filterRef2.sendKeys(prop.getProperty("Bills2U.EditBatchList.Ref2.Filter"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }

    public static void VerifyEnteredRef2Number() {
        try {
            EnterRef2Number();
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            if (eBList.filterRef2.getAttribute("value").contains(prop.getProperty("Bills2U.EditBatchList.Ref2.Filter"))) {
                test.pass("Biller be able to enter the reference2 in filter");
            } else {
                test.fail("Biller not be able to enter the reference2 in filter");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public static void ClickSearchBtnInvoiceNumber() {
        try {
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            eBList.btnSearchInBatchInvoices.click();
            Thread.sleep(7000);

            if (eBList.rowVerifyInvoiceNumber.getText().contains(prop.getProperty("Bills2U.EditBatchList.Invoice.Filter"))) {
                test.pass("Biller be able to view the filtered invoice list by invoice number");
            } else {
                test.fail("Biller not be able to view the filtered invoice list by invoice number");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }

    public static void ClickSearchBtnRef1() {
        try {
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            eBList.btnSearchInBatchInvoices.click();
            Thread.sleep(7000);

            if (eBList.rowVerifyRef1.getText().contains(prop.getProperty("Bills2U.EditBatchList.Ref1.Filter"))) {
                test.pass("Biller be able to view the filtered invoice list by reference 1");
            } else {
                test.fail("Biller not be able to view the filtered invoice list by reference 1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }

    public static void ClickSearchBtnRef2() {
        try {
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            eBList.btnSearchInBatchInvoices.click();
            Thread.sleep(7000);

            if (eBList.rowVerifyRef2.getText().contains(prop.getProperty("Bills2U.EditBatchList.Ref2.Filter"))) {
                test.pass("Biller be able to view the filtered invoice list by reference 2");
            } else {
                test.fail("Biller not be able to view the filtered invoice list by reference 2");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }

    public static void ClickSearchBtnInvoiceBatchList() {
        try {
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            eBList.btnSearchInBatchInvoices.click();
            Thread.sleep(7000);

            if (eBList.rowVerifyInvoiceNumber.getText().contains(prop.getProperty("Bills2U.EditBatchList.Invoice.Filter"))
                    && eBList.rowVerifyRef1.getText().contains(prop.getProperty("Bills2U.EditBatchList.Ref1.Filter"))
                    && eBList.rowVerifyRef2.getText().contains(prop.getProperty("Bills2U.EditBatchList.Ref2.Filter"))) {
                test.pass("Biller be able to view the filtered invoice list by invoice no, Ref1 and Ref2");
            } else {
                test.fail("Biller not be able to view the filtered invoice list by invoice no, Ref1 and Ref2");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }

    public static void VerifyStopBtnEnable() {
        try {
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            Thread.sleep(1000);

            if (eBList.btnStop.isEnabled()
                    && eBList.btnStop.getText().contains(prop.getProperty("Bills2U.EditBatchList.BtnStop"))) {
                test.pass("Biller be able to view the \"Stop\" button");
            } else {
                test.fail("Biller not be able to view the \"Stop\" button");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }

    public static void VerifyInvoiceBatchStatus(String status) {
        try {
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            Thread.sleep(1000);

            if (eBList.txtInvoiceStatus.getText().contains(status)) {
                test.pass("Biller be able to view the invoice batch status \""+status+"\"");
            } else {
                test.fail("Biller not be able to view the invoice batch status \""+status+"\"");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }

    public static void VerifyBatchInvoicesRowStatus(String status) {
        try {
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            Thread.sleep(10000);
            for (int i = 0; i < eBList.RowBatchInvoiceStatus.size(); i++) {
                try {
                    Actions act = new Actions(driver);
                    act.moveToElement(eBList.RowBatchInvoiceStatus.get(i)).build().perform();
                    Thread.sleep(1000);
                    if (eBList.RowBatchInvoiceStatus.get(i).getText().contains(status)) {
                        System.out.println(eBList.RowBatchInvoiceStatus.get(i).getText());
                        test.pass("Row " + i + ": Biller be able to view the invoice status as \"Active\"");
                    } else {
                        test.fail("Row " + i + ": Biller not be able to view the invoice status as \\\"Active\\\"");
                    }
                } catch (NoSuchElementException nE) {
                    nE.printStackTrace();
                    break;

                }
            }
            Thread.sleep(10000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }

    public static void ClickStopButton() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            js.executeScript("arguments[0].scrollIntoView();", eBList.btnStop);

            eBList.btnStop.click();
            Thread.sleep(2000);

            if (eBList.popupStopTitle.getText().contains("Stop")) {
                test.pass("Biller be able to view the pop up as \"This action will disable future payment and dispatch of reminders for all invoices in this batch\"");
            } else {
                test.fail("Biller not be able to view the pop up as \"This action will disable future payment and dispatch of reminders for all invoices in this batch\"");
            }
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }

    public static void ClickResumeButton() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            js.executeScript("arguments[0].scrollIntoView();", eBList.btnStop);

            eBList.btnResume.click();
            Thread.sleep(2000);

            if (eBList.popupStopTitle.getText().contains("Resume")) {
                test.pass("Biller be able to view the pop up as \"This action will enable future payment and dispatch of reminders for all invoices in this batch\"");
            } else {
                test.fail("Biller not be able to view the pop up as \"This action will enable future payment and dispatch of reminders for all invoices in this batch\"");
            }
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }

    public static void VerifyStopPopup() {
        try {
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            Thread.sleep(2000);

            if (eBList.popupStopTitle.getText().contains("Stop")
                    && eBList.popupStopMessage.isDisplayed()
                    && eBList.popupStopButton.isDisplayed()
                    && eBList.popupStopCancelButton.isDisplayed()   ) {
                test.pass("Biller be able to view the pop up in proper manner");
            } else {
                test.fail("Biller not be able to view the pop up in proper manner");
            }
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }

    public static void ClickStopPopupStopButton() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            js.executeScript("arguments[0].scrollIntoView();", eBList.btnStop);

            eBList.popupStopButton.click();
            Thread.sleep(2000);

            if (eBList.txtInvoiceStatus.getText().contains("Stopped")) {
                test.pass("Biller be able to view the invoice batch status \"Stopped\"");
            } else {
                test.fail("Biller not be able to view the invoice batch status \"Stopped\"");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }

    public static void VerifyResumeBtnEnable() {
        try {
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            Thread.sleep(1000);

            if (eBList.btnResume.isEnabled()
                    && eBList.btnResume.getText().contains(prop.getProperty("Bills2U.EditBatchList.BtnResume"))) {
                test.pass("Biller be able to view the \"Resume\" button");
            } else {
                test.fail("Biller not be able to view the \"Resume\" button");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }

    public static void VerifyBatchInvoicesRowStoppedStatus(String status) {
        try {
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            Thread.sleep(10000);
            for (int i = 0; i < eBList.RowBatchInvoiceStatus.size(); i++) {
                try {
                    Actions act = new Actions(driver);
                    act.moveToElement(eBList.RowBatchInvoiceStatus.get(i)).build().perform();
                    Thread.sleep(1000);
                    if (eBList.RowBatchInvoiceStatus.get(i).getText().contains(status)) {
                        System.out.println(eBList.RowBatchInvoiceStatus.get(i).getText());
                        test.pass("Row " + i + ": Biller be able to view the invoice status as \"Stopped\"");
                    } else {
                        test.fail("Row " + i + ": Biller not be able to view the invoice status as \\\"Stopped\\\"");
                    }
                } catch (NoSuchElementException nE) {
                    nE.printStackTrace();
                    break;

                }
            }
            Thread.sleep(10000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }

    public static void VerifyResumePopup() {
        try {
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            Thread.sleep(2000);

            if (eBList.popupResumeTitle.getText().contains("Resume")
                    && eBList.popupResumeMessage.isDisplayed()
                    && eBList.popupResumeButton.isDisplayed()
                    && eBList.popupResumeCancelButton.isDisplayed()   ) {
                test.pass("Biller be able to view the pop up in proper manner");
            } else {
                test.fail("Biller not be able to view the pop up in proper manner");
            }
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }

    public static void ClickResumePopupResumeButton() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            js.executeScript("arguments[0].scrollIntoView();", eBList.btnStop);

            eBList.popupStopButton.click();
            Thread.sleep(2000);

            if (eBList.txtInvoiceStatus.getText().contains("Published")) {
                test.pass("Biller be able to view the invoice batch status \"Published\"");
            } else {
                test.fail("Biller not be able to view the invoice batch status \"Published\"");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }

    public boolean isFileDownloadedVerify(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < Objects.requireNonNull(dirContents).length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                System.out.println(dirContents[i].getName());
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

    public void DownloadEditInvoiceBatchReport() {
        try {
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            eBList.editInvoiceExportButton.click();
            Thread.sleep(1000);
            if (isFileDownloadedVerify(prop.getProperty("Bills2U.EditBatchList.DownloadLocation"), prop.getProperty("Bills2U.EditBatchList.ExportFileName"))) {
                test.pass("Biller should be able to download all the details in Excel sheet in \"Invoice batch edit\" page");
            } else {
                test.fail("Biller should be able to download all the details in Excel sheet in \"Invoice batch edit\" page");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }
    }
}
