package bills2u_process;


import Config.PropertyClass;
import bills2u_constant.*;
import bills2u_root.Root_Class_TestNG;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Properties;

public class ProcessClassTestNG extends Root_Class_TestNG {

    public static Properties prop = null;
    private static String BatchNameInput;

    public static void getTestData() throws IOException {
        PropertyClass rp = new PropertyClass();
        prop = rp.readPropertiesFile();
    }
    public static void enterDataInBatchProgress() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            log.info("Waiting till the 'Batch Progress' text box has to be display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.batchProgressTxtbox));
            if (objInvoice.batchProgressTxtbox.isDisplayed()) {
                log.info("'Batch Progress' text box has displayed");
                if (objInvoice.batchProgressTxtbox.isEnabled()) {
                    log.info("'Batch Progress' text box has enabled to type");
                    objInvoice.batchProgressTxtbox.sendKeys(prop.getProperty("Bills2U.InvoiceBatchList.BatchProgress"));
                } else {
                    test.fail("'Batch Progress' text box has not enabled to type");
                    log.info("'Batch Progress' text box has not enabled to type");
                }
            } else {
                test.fail("'Batch Progress' text box has not displayed");
                log.info("'Batch Progress' text box has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/enterDataInBatchProgress.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/enterDataInBatchProgress.jpeg").build());
        }
    }




    public static void clickOnCancelBtn() throws InterruptedException, IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            if (objInvoice.addTransactionCancel.isDisplayed()) {
                if (objInvoice.addTransactionCancel.isEnabled()) {
                    log.info("Waiting till the Cancel button is click");
                    wait.until(ExpectedConditions.elementToBeClickable(objInvoice.addTransactionCancel));
                    act.moveToElement(objInvoice.addTransactionCancel).click().build().perform();
                    Thread.sleep(2000);
                } else {
                    test.fail("Cancel button has not enabled to click");
                    log.info("Cancel button has not enabled to click");
                }
            } else {
                log.info("Cancel button has not displayed");
                test.fail("Cancel button has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnCancelBtn.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnCancelBtn.jpeg").build());
        }
    }


















    public static void clickCancelInPauseDialog() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            Actions act = new Actions(driver);
            if (objInvoice.cancelButton.isDisplayed()) {
                if (objInvoice.cancelButton.isEnabled()) {
                    try {
                        act.moveToElement(objInvoice.cancelButton).click().build().perform();
                        Thread.sleep(5000);
                    } catch (Exception ex) {
                        test.fail("Biller unable to click on cancel");
                        log.info("Biller unable to click on cancel");
                    }
                } else {
                    test.fail("Cancel has not enabled to click");
                    log.info("Cancel has not enabled to click");
                }
            } else {
                log.info("Cancel has not displayed");
                test.fail("Cancel has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickCancelInPauseDialog.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickCancelInPauseDialog.jpeg").build());
        }
    }



    //Dashboard


    //Invoice Batch List


    public static void ClickBatchEntry() {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            bList.btnBatchEntry.click();
            Thread.sleep(2000);
            if (bList.txtNewInvoiceBatch.isDisplayed() && bList.txtNewInvoiceBatch.getText().equals("New Invoice Batch")) {
                test.pass("Biller able to view New Invoice Batch page");
            } else {
                test.fail("Biller not able to view New Invoice Batch page");
            }
        } catch (InterruptedException e) {
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

    public static void GoToEditInvoiceBatchList() {
        try {
            getTestData();
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

    public static void GoToEditInvoiceBatchPublishedList() {
        try {
            getTestData();
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            if (bList.txtVerifyPublishedEditBatchInvoice.getText().contains("PUBLISHED")) {
                bList.goToEditInvoiceBatch.click();
                Thread.sleep(1000);
                if (bList.txtVerifyEditBatchInvoice.getText().contains(prop.getProperty("Bills2U.EditBatchList.BatchName.Filter"))) {
                    test.pass("Biller be able to navigate to the \"Invoice batch edit\" page");
                } else {
                    test.fail("Biller not be able to navigate to the \"Invoice batch edit\" page");
                }
            } else {
                test.fail("Biller Batch Status is not Published");
            }

        } catch (Exception e) {
            test.fail(e.getMessage());
        }


    }

    public static void GoToEditInvoiceBatchStoppedList() {
        try {
            getTestData();
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            if (bList.txtVerifyPublishedEditBatchInvoice.getText().contains("STOPPED")) {
                bList.goToEditInvoiceBatch.click();
                Thread.sleep(1000);
                if (bList.txtVerifyEditBatchInvoice.getText().contains(prop.getProperty("Bills2U.EditBatchList.BatchName.Filter"))) {
                    test.pass("Biller be able to navigate to the \"Invoice batch edit\" page");
                } else {
                    test.fail("Biller not be able to navigate to the \"Invoice batch edit\" page");
                }
            } else {
                test.fail("Biller Batch Status is not Stooped");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }


    }

    public static void CheckBatchName() {

        try {
            Obj_Rep_BatchUpload bUpload = new Obj_Rep_BatchUpload();
            PageFactory.initElements(driver, bUpload);
            if (bUpload.iptBatchName.isDisplayed()) {
                test.pass("Biller able to view the default batch name");
            } else {
                test.fail("Biller not able to view the default batch name");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }

    }

    public static void EnterBatchName() {

        try {
            Obj_Rep_BatchUpload bUpload = new Obj_Rep_BatchUpload();
            PageFactory.initElements(driver, bUpload);
            var id = (int) Math.floor(Math.random() * 50000);
            BatchNameInput = "SELENUIM-RPM " + id;
            bUpload.iptBatchName.clear();
            bUpload.iptBatchName.sendKeys(BatchNameInput);
            if (bUpload.iptBatchName.isDisplayed() && bUpload.iptBatchName.getText().equals(bUpload.iptBatchName.getText())) {
                test.pass("Biller able to edit the data in name field");
            } else {
                test.pass("Biller not able to edit the data in name field");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }


    }

    public static void ReminderSetup() {

        try {
            Obj_Rep_ReminderSetup bUpload = new Obj_Rep_ReminderSetup();
            PageFactory.initElements(driver, bUpload);
            bUpload.btnAddReminder.click();
            Thread.sleep(2000);
            bUpload.chooseReminder.click();
            driver.findElement(By.xpath("//mat-option/span[contains(.,'Before Due')]")).click();
            bUpload.iptDaysOrDate.sendKeys("1");
            bUpload.btnReminderSetupDone.click();

            if (bUpload.chooseReminder.getText().contains("Before Due")) {
                test.pass("Biller able to set the reminders");
            } else {
                test.fail("Biller not able to set the reminders");
            }

        } catch (Exception e) {
            test.fail(e.getMessage());
        }


    }

    public static void ChooseFeedType() {

        try {
            Obj_Rep_BatchUpload bUpload = new Obj_Rep_BatchUpload();
            PageFactory.initElements(driver, bUpload);
            bUpload.chooseFeedType.click();
            driver.findElement(By.xpath("//mat-option/span[contains(.,'DEFAULT EXCEL TEMPLATE')]")).click();
            if (bUpload.chooseFeedType.getText().equals("DEFAULT EXCEL TEMPLATE")) {
                test.pass("Biller able to set the FEED TYPE");
            } else {
                test.fail("Biller not able to set the FEED TYPE");
            }

        } catch (Exception e) {
            test.fail(e.getMessage());
        }

    }


    public static void NotifyOnPublishCheckboxClick() {

        try {
            Obj_Rep_BatchUpload bUpload = new Obj_Rep_BatchUpload();
            PageFactory.initElements(driver, bUpload);
            bUpload.chkNotifyOnPublish.click();
            if (bUpload.chkNotifyOnPublish.isSelected()) {
                test.pass("Biller able to select the Check Box");
            } else if (!bUpload.chkNotifyOnPublish.isSelected()) {
                bUpload.chkNotifyOnPublish.click();
                test.pass("Biller able to select the Check Box");
            } else {
                test.fail("Biller not able to select the Check Box");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }


    }

    public static void UploadBatchFeedTemplateFile() {

        try {
            Obj_Rep_BatchUpload bUpload = new Obj_Rep_BatchUpload();
            PageFactory.initElements(driver, bUpload);
            bUpload.uploadBatchFeedFile.sendKeys("C:\\\\Users\\\\Rahul\\\\Downloads\\\\DEFAULT_EXCEL_TEMPLATE.XLSX");
            Thread.sleep(10000);

            if (driver.findElement(By.xpath("/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[1]/form/div[6]/p"))
                    .getText().equals("File Processed Successfully.")) {
                test.pass("Biller able to upload the file");
            } else {
                test.fail("Biller not able to upload the file");
            }
            new File("C:\\\\Users\\\\Rahul\\\\Downloads\\\\DEFAULT_EXCEL_TEMPLATE.XLSX").delete();
        } catch (Exception e) {
            test.fail("File upload has not worked properly.  But it displayed the Exception as.."+e.getMessage());
        }


    }

    public static void VerifyBillGeanratedCheckBoxClick() {

        try {
            Obj_Rep_BatchUpload bUpload = new Obj_Rep_BatchUpload();
            PageFactory.initElements(driver, bUpload);
            if (bUpload.chkVerifyBillGenerateBox.isSelected()) {
                test.pass("Biller able to select the Check Box VERIFY BILL GENERATE");
            } else if (!bUpload.chkVerifyBillGenerateBox.isSelected()) {
                bUpload.chkVerifyBillGenerateBox.click();
                test.pass("Biller able to select the Check Box VERIFY BILL GENERATE");
            } else {
                test.pass("Biller not able to select the Check Box VERIFY BILL GENERATE");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }


    }

    public static void ClickPublishButton() {

        try {
            Obj_Rep_BatchUpload bUpload = new Obj_Rep_BatchUpload();
            PageFactory.initElements(driver, bUpload);
            WebDriverWait wait=new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.visibilityOf(bUpload.btnPublish));
            wait.until(ExpectedConditions.elementToBeClickable(bUpload.btnPublish));
            Thread.sleep(5000);
            Actions act=new Actions(driver);
            act.moveToElement(bUpload.btnPublish).click().build().perform();
            wait.until(ExpectedConditions.visibilityOf(bUpload.btnPublishAnyway));
            wait.until(ExpectedConditions.elementToBeClickable(bUpload.btnPublishAnyway));
            Thread.sleep(1000);
            act.moveToElement(bUpload.btnPublishAnyway).click().build().perform();
            Thread.sleep(5000);
            driver.findElement(By.xpath("/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/div[1]/div[1]/mat-form-field/div/div[1]/div[1]/input"))
                    .sendKeys(BatchNameInput);
            Thread.sleep(3000);
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            if (bList.txtInvoiceBatch.getText().equals("Invoice Batch")) {
                test.pass("Collection be published and it should be reflected to payer site");
            } else {
                test.fail("Collection be published and it should be reflected to payer site");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }

    }

    public static void ClickBatchUploadDraftButton() {

        try {
            Obj_Rep_BatchUpload bUpload = new Obj_Rep_BatchUpload();
            PageFactory.initElements(driver, bUpload);
            if (bUpload.btnBatchUploadDraft.isEnabled()) {
                Actions act=new Actions(driver);
                act.moveToElement(bUpload.btnBatchUploadDraft).click().build().perform();
                Thread.sleep(2000);
                act.moveToElement(bUpload.btnSaveDraftAnyway).click().build().perform();
                Thread.sleep(2000);
                Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
                PageFactory.initElements(driver, bList);
                if (bList.txtInvoiceBatch.getText().equals("Invoice Batch")) {
                    test.pass("Collection should be Drafted and should not be reflected to Payer site");
                } else {
                    test.fail("Collection should not be Drafted and should not be reflected to Payer site and in Dashboard ");
                }
            } else {
                test.fail("Draft not enabled");
            }

        } catch (Exception e) {
            test.fail(e.getMessage());
        }


    }

    public static void ClickBatchUploadBackButton() {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            Obj_Rep_BatchUpload bUpload = new Obj_Rep_BatchUpload();
            PageFactory.initElements(driver, bUpload);
            Actions act=new Actions(driver);
            act.moveToElement(bUpload.btnBatchUploadBack).click().build().perform();
            bUpload.btnBatchUploadBack.click();
            Thread.sleep(5000);
            if (bList.txtInvoiceBatch.getText().equals("Invoice Batch")) {
                test.pass("Collection should not be published and should not be reflected to Payer site");
            } else {
                test.fail("Collection should not be published and should not be reflected to Payer site and in Dashboard ");
            }
        } catch (Exception e) {
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
            } else {
                test.fail("Biller not able to set the before due reminder setup");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static boolean isFileDownloadedVerify(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < Objects.requireNonNull(dirContents).length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
//                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

    public static void ClickPublishButtonToUpload() {

        try {
            Obj_Rep_BatchUpload bUpload = new Obj_Rep_BatchUpload();
            PageFactory.initElements(driver, bUpload);
            bUpload.txtLinkClickHere.click();
            Thread.sleep(1000);
            bUpload.uploadBatchFeedFile.sendKeys("C:\\\\Users\\\\Rahul\\\\Downloads\\\\DEFAULT_EXCEL_TEMPLATE.XLSX");
            Thread.sleep(10000);
            new File("C:\\\\Users\\\\Rahul\\\\Downloads\\\\DEFAULT_EXCEL_TEMPLATE.XLSX").delete();
            if (bUpload.chkVerifyBillGenerateBox.isSelected()) {
//                test.pass("Biller able to select the Check Box VERIFY BILL GENERATE");
            } else if (!bUpload.chkVerifyBillGenerateBox.isSelected()) {
                bUpload.chkVerifyBillGenerateBox.click();
//                test.pass("Biller able to select the Check Box VERIFY BILL GENERATE");
            } else {
//                test.pass("Biller not able to select the Check Box VERIFY BILL GENERATE");
            }

            Thread.sleep(5000);
            bUpload.btnPublish.click();
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

    public static void ClickAddInvoice() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);
            bEntry.btnAddInvoice.click();
            Thread.sleep(3000);
            if (bEntry.txtNewAddInvoice.getText().contains("New Invoice Batch")) {
                test.pass("Biller able to view the new invoice creation page");
            } else {
                test.fail("Biller not able to view the new invoice creation page");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }

    }

    public static void VerifyBillsToData() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);

            bEntry.iptPayerName.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.PayerName"));
            bEntry.iptEmail.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Email"));
            bEntry.iptAddress.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Address"));
            bEntry.iptCity.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.City"));
            bEntry.iptState.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.State"));
            bEntry.iptCountry.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Country"));
            bEntry.iptPhoneNo.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.PhoneNo"));
            bEntry.iptPostalCode.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.PostalCode"));
            bEntry.iptInvoiceNumber.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.InvoiceNo"));
            IssueDateSelect();
            DueDateSelect();
            bEntry.iptRef1.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Ref1"));
            bEntry.iptRef2.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Ref2"));
            Thread.sleep(3000);
            if (bEntry.iptPayerName.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.PayerName"))
                    && bEntry.iptEmail.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Email"))
                    && bEntry.iptAddress.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Address"))
                    && bEntry.iptCity.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.City"))
                    && bEntry.iptState.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.State"))
                    && bEntry.iptCountry.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Country"))
                    && bEntry.iptPhoneNo.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.PhoneNo"))
                    && bEntry.iptPostalCode.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.PostalCode"))
                    && bEntry.iptInvoiceNumber.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.InvoiceNo"))
                    && !bEntry.iptIssueDate.getAttribute("value").isEmpty()
                    && !bEntry.iptDueDate.getAttribute("value").isEmpty()
                    && bEntry.iptRef1.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Ref1"))
                    && bEntry.iptRef2.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Ref2"))) {
                test.pass("Biller able to enter the BillsTo data");
            } else {
                test.fail("Biller not able to enter the BillsTo data");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }

    }

    public static void IssueDateSelect() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);
            bEntry.iptIssueDate.click();
            Thread.sleep(1000);
            WebElement yearSelect = driver.findElement(By.xpath("/html/body/app-root/div/div[2]/div[4]/div/mat-datepicker-content/mat-calendar/mat-calendar-header/div/div/button[1]"));
            yearSelect.click();
            Thread.sleep(1000);
            WebElement chooseYear = driver.findElement(By.cssSelector("td[aria-label='"
                    + prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.IssueDate.Year") + "']"));
            chooseYear.click();
            Thread.sleep(1000);
            WebElement chooseMonth = driver.findElement(By.cssSelector("td[aria-label='01-"
                    + prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.IssueDate.Month") + "-"
                    + prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.IssueDate.Year") + "']"));
            chooseMonth.click();
            Thread.sleep(1000);
            WebElement chooseDay = driver.findElement(By.cssSelector("td[aria-label='"
                    + prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.IssueDate.Day") + "-"
                    + prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.IssueDate.Month") + "-"
                    + prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.IssueDate.Year")
                    + "']"));
            chooseDay.click();
        } catch (InterruptedException e) {
            test.fail(e.getMessage());
        }
    }

    public static void DueDateSelect() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);
            bEntry.iptDueDate.click();
            Thread.sleep(1000);
            WebElement yearSelect = driver.findElement(By.xpath("/html/body/app-root/div/div[2]/div[4]/div/mat-datepicker-content/mat-calendar/mat-calendar-header/div/div/button[1]"));
            yearSelect.click();
            Thread.sleep(1000);
            WebElement chooseYear = driver.findElement(By.cssSelector("td[aria-label='"
                    + prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.DueDate.Year") + "']"));
            chooseYear.click();
            Thread.sleep(1000);
            WebElement chooseMonth = driver.findElement(By.cssSelector("td[aria-label='01-"
                    + prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.DueDate.Month") + "-"
                    + prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.DueDate.Year") + "']"));
            chooseMonth.click();
            Thread.sleep(1000);
            WebElement chooseDay = driver.findElement(By.cssSelector("td[aria-label='"
                    + prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.DueDate.Day") + "-"
                    + prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.DueDate.Month") + "-"
                    + prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.DueDate.Year")
                    + "']"));
            chooseDay.click();
        } catch (InterruptedException e) {
            test.fail(e.getMessage());
        }
    }

    public static void ClickSVGIcon() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);
            bEntry.filterSvgIcon.click();

            Thread.sleep(3000);
            if (bEntry.chkBoxUnitPrice.isDisplayed() && bEntry.chkBoxDescription.isDisplayed()) {
                test.pass("Biller should able to view the \"Show field\" tooltip");
            } else {
                test.fail("Biller should able to view the \"Show field\" tooltip");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }

    }

    public static void ClickCheckboxUnitPrice() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);
            Thread.sleep(3000);
            bEntry.chkBoxUnitPrice.click();

            Thread.sleep(3000);
            if (!bEntry.chkBoxUnitPrice.isSelected()) {
                test.pass("Biller able to select unit price");
            } else {
                test.fail("Biller not able to select unit price");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }

    }

    public static void ClickCheckboxDescription() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);
            bEntry.chkBoxDescription.click();

            Thread.sleep(3000);
            if (!bEntry.chkBoxUnitPrice.isSelected()) {
                test.pass("Biller able to select Description");
            } else {
                test.fail("Biller not able to select Description");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }

    }

    public static void VerifyAddItem() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);

            bEntry.iptItem.clear();
            bEntry.iptItem.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.name1"));
            bEntry.iptDescription.clear();
            bEntry.iptDescription.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Description1"));
            bEntry.iptQuantity.clear();
            bEntry.iptQuantity.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Quantity1"));
            for (int i = 0; i <= 15; i++) {
                bEntry.iptUnitPrice.sendKeys(Keys.BACK_SPACE);
            }
            bEntry.iptUnitPrice.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.UnitPrice1"));
            for (int i = 0; i <= 15; i++) {
                bEntry.iptTotalTax.sendKeys(Keys.BACK_SPACE);
            }
            bEntry.iptTotalTax.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.TotalTax1"));
            for (int i = 0; i <= 15; i++) {
                bEntry.iptAmount.sendKeys(Keys.BACK_SPACE);
            }
            bEntry.iptAmount.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Amount1"));


            Thread.sleep(3000);
            if (bEntry.iptItem.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.name1"))
                    && bEntry.iptDescription.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Description1"))
                    && bEntry.iptQuantity.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Quantity1"))
                    && bEntry.iptUnitPrice.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.UnitPrice1"))
                    && bEntry.iptTotalTax.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.TotalTax1"))
                    && bEntry.iptAmount.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Amount1"))
            ) {
                test.pass("Biller able to enter the Item data");
            } else {
                test.fail("Biller not able to enter the Item data");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }

    }

    public static void VerifyAddItemWithoutUnitPrice() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);

            bEntry.iptItem.clear();
            bEntry.iptItem.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.name1"));
            bEntry.iptDescription.clear();
            bEntry.iptDescription.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Description1"));
            for (int i = 0; i <= 15; i++) {
                bEntry.filterUnitAmount.sendKeys(Keys.BACK_SPACE);
            }
            bEntry.filterUnitAmount.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Amount1"));


            Thread.sleep(3000);
            if (bEntry.iptItem.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.name1"))
                    && bEntry.iptDescription.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Description1"))
                    && bEntry.filterUnitAmount.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Amount1"))
            ) {
                test.pass("Biller able to enter the Item data");
            } else {
                test.fail("Biller not able to enter the Item data");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }

    }

    public static void VerifyAddItemWithoutDescription() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);

            bEntry.iptItem.clear();
            bEntry.iptItem.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.name1"));
            bEntry.iptQuantity.clear();
            bEntry.iptQuantity.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Quantity1"));
            for (int i = 0; i <= 15; i++) {
                bEntry.iptUnitPrice.sendKeys(Keys.BACK_SPACE);
            }
            bEntry.iptUnitPrice.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.UnitPrice1"));
            for (int i = 0; i <= 15; i++) {
                bEntry.getFilterDescriptionTotalTax.sendKeys(Keys.BACK_SPACE);
            }
            bEntry.getFilterDescriptionTotalTax.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.TotalTax1"));
            for (int i = 0; i <= 15; i++) {
                bEntry.filterDescriptionAmount.sendKeys(Keys.BACK_SPACE);
            }
            bEntry.filterDescriptionAmount.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Amount1"));

            Thread.sleep(3000);
            if (bEntry.iptItem.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.name1"))
                    && bEntry.iptQuantity.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Quantity1"))
                    && bEntry.iptUnitPrice.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.UnitPrice1"))
                    && bEntry.getFilterDescriptionTotalTax.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.TotalTax1"))
                    && bEntry.filterDescriptionAmount.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Amount1"))
            ) {
                test.pass("Biller able to enter the Item data");
            } else {
                test.fail("Biller not able to enter the Item data");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }

    }

    public static void ClickNewInvoiceBatchCloseIcon() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);
            bEntry.newBatchInvoiceCloseIcon.click();
            Thread.sleep(3000);

        } catch (Exception e) {
            test.fail(e.getMessage());
        }

    }

    public static void ClickItemSaveIcon() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);
            bEntry.btnSaveItem.click();
            Thread.sleep(3000);
            if (bEntry.iptItem.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.name1"))
                    && bEntry.iptDescription.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Description1"))
                    && bEntry.iptQuantity.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Quantity1"))
                    && bEntry.iptUnitPrice.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.UnitPrice1"))
                    && bEntry.iptTotalTax.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.TotalTax1"))
                    && bEntry.iptAmount.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Amount1"))
            ) {
                test.pass("Biller able to view the item in item list");
            } else {
                test.fail("Biller not able to view the item in item list");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }

    }

    public static void ClickItemSaveIconWithoutUnitPrice() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);
            bEntry.filterUnitSaveItem.click();
            Thread.sleep(3000);
            if (bEntry.iptItem.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.name1"))
                    && bEntry.iptDescription.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Description1"))
                    && bEntry.filterUnitAmount.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Amount1"))
            ) {
                test.pass("Biller able to save the item in item list");
            } else {
                test.fail("Biller not able to save the item in item list");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }

    }

    public static void ClickItemSaveIconWithoutDescription() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);
            bEntry.filterDescriptionSaveItem.click();
            Thread.sleep(3000);
            if (bEntry.iptItem.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.name1"))
                    && bEntry.iptQuantity.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Quantity1"))
                    && bEntry.iptUnitPrice.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.UnitPrice1"))
                    && bEntry.getFilterDescriptionTotalTax.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.TotalTax1"))
                    && bEntry.filterDescriptionAmount.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Amount1"))
            ) {
                test.pass("Biller able to view the item in item list");
            } else {
                test.fail("Biller not able to view the item in item list");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }

    }

    public static void ClickNewBatchSaveIcon() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);
            bEntry.btnSaveNewBatch.click();
            Thread.sleep(3000);
            if (bEntry.txtVerifyNewInvoiceBatch.getText().contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.InvoiceNo"))) {
                test.pass("Biller able to save the New Invoice Batch and should Redirect to New Invoice Batch publish page");
            } else {
                test.fail("Biller not able to save the New Invoice Batch and should Redirect to New Invoice Batch publish page");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }

    }


    public static void ClickItemDeleteIcon() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);
            bEntry.btnDeleteItem.click();
            Thread.sleep(3000);
            if (bEntry.btnAddItem.isEnabled()) {
                test.pass("Biller able deleted the item");
            } else {
                test.fail("Biller not able deleted the item");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }

    }

    public static void VerifyEditItem() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);

            bEntry.btnSaveItem.click();
            Thread.sleep(5000);
            bEntry.iptItem.clear();
            bEntry.iptItem.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.name1"));
            bEntry.iptDescription.clear();
            bEntry.iptDescription.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Description1"));
            bEntry.iptQuantity.clear();
            bEntry.iptQuantity.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Quantity1"));
            for (int i = 0; i <= 15; i++) {
                bEntry.iptUnitPrice.sendKeys(Keys.BACK_SPACE);
            }
            bEntry.iptUnitPrice.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.UnitPrice1"));
            for (int i = 0; i <= 15; i++) {
                bEntry.iptTotalTax.sendKeys(Keys.BACK_SPACE);
            }
            bEntry.iptTotalTax.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.TotalTax1"));

            for (int i = 0; i <= 15; i++) {
                bEntry.iptAmount.sendKeys(Keys.BACK_SPACE);
            }
            bEntry.iptAmount.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Amount2"));

            bEntry.btnSaveItem.click();
            Thread.sleep(5000);
            if (bEntry.iptItem.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.name1"))
                    && bEntry.iptDescription.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Description1"))
                    && bEntry.iptQuantity.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Quantity1"))
                    && bEntry.iptUnitPrice.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.UnitPrice1"))
                    && bEntry.iptTotalTax.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.TotalTax1"))
                    && bEntry.iptAmount.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Amount2"))
            ) {
                test.pass("Biller able to edited the particular item");
            } else {
                test.fail("Biller not able to edited the particular item");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
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


    public static void DownloadEditInvoiceBatchReport() {
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

    //Merchant


    public static void clickOnGeneralSetting(){
        Obj_Rep_Setup objSetup=new Obj_Rep_Setup();
        PageFactory.initElements(driver,objSetup);
        if(objSetup.generalSettingBtn.isDisplayed()){
            if(objSetup.generalSettingBtn.isEnabled()){
                try{
                    objSetup.generalSettingBtn.click();
                    if(objSetup.generalSettingHeader.isDisplayed()){
                        if(objSetup.generalSettingHeader.getText().equals("General Settings")){
                            test.pass("Biller has able to view the General Settings section");
                        }else {
                            test.fail("General Setting header has deviate's from it's expected data.  And it displayed as "+objSetup.generalSettingHeader.getText());
                        }
                    }else {
                        test.fail("General setting header has not displayed");
                    }
                }catch (Exception ex){

                }
            }else {
                test.fail("General settings button has not enabled");
            }
        }else {
            test.fail("General settings button has not displayed");
        }
    }

    public static void selectFeedTypeInGeneralSetting(){
        Obj_Rep_Setup objSetup=new Obj_Rep_Setup();
        PageFactory.initElements(driver,objSetup);
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(objSetup.feedType));
        wait.until(ExpectedConditions.visibilityOf(objSetup.feedType));
    }

}

