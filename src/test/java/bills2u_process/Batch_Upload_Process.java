package bills2u_process;

import Config.PropertyClass;
import bills2u_constant.*;
import bills2u_root.Root_Class_TestNG;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.io.Files;
import com.opencsv.CSVReader;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Batch_Upload_Process extends Root_Class_TestNG {

    public static String BatchNameInput;

    public static void getTestData() throws IOException {
        PropertyClass rp=new PropertyClass();
        prop = rp.readPropertiesFile();
    }

    public static void GotToInVoiceBatch() throws IOException {
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
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/GotToInVoiceBatch.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/GotToInVoiceBatch.jpeg").build());
        }


    }

    public static void ClickBatchUpload() throws IOException {
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
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickBatchUpload.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickBatchUpload.jpeg").build());
        }


    }

    public static void CheckBatchName() throws IOException {

        try {
            Obj_Rep_BatchUpload bUpload = new Obj_Rep_BatchUpload();
            PageFactory.initElements(driver, bUpload);
            if (bUpload.iptBatchName.isDisplayed()) {
                test.pass("Biller able to view the default batch name");
            } else {
                test.fail("Biller not able to view the default batch name");
            }
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/CheckBatchName.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/CheckBatchName.jpeg").build());
        }

    }

    public static void EnterBatchName() throws IOException {

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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/EnterBatchName.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/EnterBatchName.jpeg").build());
        }


    }

    public static void ReminderSetup() throws IOException {

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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ReminderSetup.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ReminderSetup.jpeg").build());
        }


    }

    public static void ChooseFeedType() throws IOException {

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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ChooseFeedType.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ChooseFeedType.jpeg").build());
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

    public static void DownloadBatchFeedTemplate() throws IOException {
        getTestData();
        try {
            Obj_Rep_BatchUpload bUpload = new Obj_Rep_BatchUpload();
            PageFactory.initElements(driver, bUpload);
            bUpload.txtLinkClickHere.click();
            Thread.sleep(1000);
            if (isFileDownloadedVerify(prop.getProperty("Bills2U.FileUpload.DownloadPath"), "DEFAULT_EXCEL_TEMPLATE.XLSX")) {
                test.pass("Biller able to download the file");
            } else {
                test.fail("Biller not able to download the file");
            }
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/DownloadBatchFeedTemplate.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/DownloadBatchFeedTemplate.jpeg").build());
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

    public static void editExcelFile() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            String downloadPath = prop.getProperty("Bills2U.FileUpload.DownloadPath");
            File getLatestFile = getLatestFilefromDir(downloadPath);
            assert getLatestFile != null;
            String fileName = getLatestFile.getName();
            System.out.println("File Name :- " + fileName);
            if (objInvoice.feedDataTypeSelect.getText().equals(prop.getProperty("Bills2U.FileUpload.FeedDataType"))) {
                try {
                    File file1 = new File(downloadPath + fileName);
                    FileInputStream fileInput = new FileInputStream(file1);
                    XSSFWorkbook book = new XSSFWorkbook(fileInput);
                    XSSFSheet sheet = book.getSheetAt(0);
                    int NoOfRows = sheet.getLastRowNum();
                    if (file1.exists()) {
                        for (int i = 2; i <= NoOfRows; i++) {
                            XSSFRow row = sheet.getRow(i);
                            XSSFCell cell = row.getCell(3);
                            if (cell != null) {
                                String cellValue = cell.getStringCellValue();
                                if (cellValue.equals(prop.getProperty("Bills2U.FileUpload.ExistingEmail"))) {
                                    cell.setCellValue(prop.getProperty("Bills2U.FileUpload.Email"));
                                    System.out.println(prop.getProperty("Bills2U.FileUpload.Email"));
                                }
                            }
                        }
                    }
                    fileInput.close();
                    FileOutputStream fos = new FileOutputStream(downloadPath + fileName);
                    book.write(fos);
                    book.close();
                    fos.close();
                    test.pass("Biller has able to open,edit and enter the data in the file");
                    log.info("Biller has able to open,edit and enter the data in the file");
                } catch (Exception ex) {
                    test.fail("Biller unable to edit the data in the file.  And it displayed the Exception as '" + ex.getMessage() + "'");
                    log.info("Biller unable to edit the data in the file.  And it displayed the Exception as '" + ex.getMessage() + "'");
                    ex.printStackTrace();
                }
            } else {
                try {

                    CSVReader reader = new CSVReader(new FileReader(downloadPath + fileName));
                    List<String[]> li = reader.readAll();
                    System.out.println("Total rows which we have is " + li.size());
                    Iterator<String[]> i1 = li.iterator();
                    while (i1.hasNext()) {
                        String[] str = i1.next();
                        System.out.print(" Values are ");
                        for (int i = 0; i < str.length; i++) {
                            if (str[i].equals(prop.getProperty("Bills2U.FileUpload.ExistingEmail"))) {
                                System.out.print(" " + str[i]);
                            }
                        }
                        System.out.println("    ");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/editExcelFile.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/editExcelFile.jpeg").build());
        }
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

    public static void NotifyOnPublishCheckboxClick() throws IOException {

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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/NotifyOnPublishCheckboxClick.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/NotifyOnPublishCheckboxClick.jpeg").build());
        }


    }

    public static void VerifyBillGeanratedCheckBoxClick() throws IOException {

        try {
            Obj_Rep_BatchUpload bUpload = new Obj_Rep_BatchUpload();
            PageFactory.initElements(driver, bUpload);
            if (bUpload.chkVerifyBillGenerateBox.isSelected()) {
                test.pass("Biller able to select the Check Box VERIFY BILL GENERATE");
            } else if (!bUpload.chkVerifyBillGenerateBox.isSelected()) {
                Actions act=new Actions(driver);
                act.moveToElement(bUpload.chkVerifyBillGenerateBox).click().build().perform();
                test.pass("Biller able to select the Check Box VERIFY BILL GENERATE");
            } else {
                test.pass("Biller not able to select the Check Box VERIFY BILL GENERATE");
            }
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyBillGeanratedCheckBoxClick.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyBillGeanratedCheckBoxClick.jpeg").build());
        }


    }

    public static void ClickPublishButton() throws IOException {

        try {
            Obj_Rep_BatchUpload bUpload = new Obj_Rep_BatchUpload();
            PageFactory.initElements(driver, bUpload);
            Actions act=new Actions(driver);
            Thread.sleep(5000);
            act.moveToElement(bUpload.btnPublish).click().build().perform();
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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickPublishButton.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickPublishButton.jpeg").build());
        }

    }

    public static void ClickBatchUploadDraftButton() throws IOException {

        try {
            Obj_Rep_BatchUpload bUpload = new Obj_Rep_BatchUpload();
            PageFactory.initElements(driver, bUpload);
            if (bUpload.btnBatchUploadDraft.isEnabled()) {
                Actions act=new Actions(driver);
                act.moveToElement(bUpload.btnBatchUploadDraft).click().build().perform();
                Thread.sleep(5000);
                act.moveToElement(bUpload.btnSaveDraftAnyway).click().build().perform();
                Thread.sleep(5000);
                Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
                PageFactory.initElements(driver, bList);
                if (bList.txtInvoiceBatch.getText().equals("Invoice Batch")) {
                    test.pass("Collection should be Drafted and should not be reflected to Payer site");
                } else {
                    test.fail("Collection should not be Drafted and should not be reflected to Payer site and in Dashboard ");
                }
                Thread.sleep(5000);
            } else {
                test.fail("Draft not enabled");
            }

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickBatchUploadDraftButton.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickBatchUploadDraftButton.jpeg").build());
        }
    }

    public static void ClickBatchUploadBackButton() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            Obj_Rep_BatchUpload bUpload = new Obj_Rep_BatchUpload();
            PageFactory.initElements(driver, bUpload);
            Actions act=new Actions(driver);
            act.moveToElement(bUpload.btnBatchUploadBack).click().build().perform();
            Thread.sleep(5000);
            if (bList.txtInvoiceBatch.getText().equals("Invoice Batch")) {
                test.pass("Collection should not be published and should not be reflected to Payer site");
            } else {
                test.fail("Collection should not be published and should not be reflected to Payer site and in Dashboard ");
            }
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickBatchUploadBackButton.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickBatchUploadBackButton.jpeg").build());
        }

        
    }

}
