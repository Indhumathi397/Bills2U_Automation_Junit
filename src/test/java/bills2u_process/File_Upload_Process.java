package bills2u_process;

import Config.PropertyClass;
import bills2u_constant.Obj_Rep_Home;
import bills2u_constant.Obj_Rep_Invoice;
import bills2u_constant.Obj_Rep_Login;
import bills2u_constant.Obj_Rep_Tooltip;
import bills2u_root.Root_Class_TestNG;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.io.Files;
import com.opencsv.CSVReader;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

public class File_Upload_Process extends Root_Class_TestNG {
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

    public static void clickOnInvoiceMenuProcess() throws IOException {
        try {
            Obj_Rep_Home objHome = new Obj_Rep_Home();
            PageFactory.initElements(driver, objHome);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            log.info("Waiting till the 'Invoice' menu is display");
            wait.until(ExpectedConditions.visibilityOf(objHome.invoiceMenu));
            log.info("Waiting till the 'Invoice' menu is click");
            wait.until(ExpectedConditions.elementToBeClickable(objHome.invoiceMenu));
            try {
                log.info("Clicking on the 'Invoice' menu");
                act.moveToElement(objHome.invoiceMenu).click().build().perform();
                log.info("'Invoice' menu has clicked");
                Thread.sleep(5000);
            } catch (Exception ex) {
                log.info("'Invoice' menu has not clicked.   But it displayed the exception as...\n" + ex.getMessage());
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnInvoiceMenuProcess.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnInvoiceMenuProcess.jpeg").build());
        }
    }

    public static void clickOnInvoiceBatch() throws IOException {
        try {
            Obj_Rep_Home objHome = new Obj_Rep_Home();
            PageFactory.initElements(driver, objHome);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            log.info("Waiting till the 'Invoice Batch' menu is display.");
            wait.until(ExpectedConditions.visibilityOf(objHome.invoiceBatchMenu));
            log.info("Waiting till the 'Invoice Batch' menu is click");
            wait.until(ExpectedConditions.elementToBeClickable(objHome.invoiceBatchMenu));
            if (objHome.invoiceBatchMenu.isDisplayed()) {
                if (objHome.invoiceBatchMenu.getText().equals("Invoice Batch")) {
                    act.moveToElement(objHome.invoiceBatchMenu).click().build().perform();
                    log.info("'Invoice Batch' menu has clicked");
                    log.info("Waiting till the page is loading");
                    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                    Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
                    PageFactory.initElements(driver, objInvoice);
                    log.info("Waiting till the 'Invoice Batch' Label is display");
                    wait.until(ExpectedConditions.visibilityOf(objInvoice.invoiceBatchText));
                    if (objInvoice.invoiceBatchText.isDisplayed()) {
                        Thread.sleep(5000);
                        if (objInvoice.invoiceBatchText.getText().equals("Invoice Batch")) {
                            test.pass("Biller has able to navigate to the 'Invoice batch' page");
                            log.info("Biller has able to navigate to the 'Invoice batch' page");

                        } else {
                            test.fail("'Invoice Batch' label has deviates from expected data.  And it displayed " + objInvoice.invoiceBatchText.getText());
                        }
                    } else {
                        test.fail("'Invoice Batch' Label has not displayed");
                        log.info("'Invoice Batch' label has not displayed");
                    }
                } else {
                    test.fail("'Invoice Batch' menu has deviates from it's Expected data.  And it displayed " + objHome.invoiceMenu.getText());
                    log.info("'Invoice Batch' menu has deviates from it's Expected data.  And it displayed " + objHome.invoiceMenu.getText());
                }
            } else {
                test.fail("'Invoice Batch' menu has not displayed");
                log.info("'Invoice Batch' menu has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnInvoiceBatch.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnInvoiceBatch.jpeg").build());
        }
    }

    public static void clickOnBatchUpload() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            //Click on Batch Upload
            log.info("Waiting till the 'Batch Upload' button is visible");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.batchUploadButton));
            log.info("Waiting till the 'Batch Upload' button is click");
            wait.until(ExpectedConditions.elementToBeClickable(objInvoice.batchUploadButton));
            if (objInvoice.batchUploadButton.isDisplayed()) {
                log.info("'Batch Upload' button has displayed");
                if (objInvoice.batchUploadButton.getText().equals("Batch Upload")) {
                    log.info("'Batch Upload' button has matched with it's Expected data");
                    try {
                        act.moveToElement(objInvoice.batchUploadButton).click().build().perform();
                        log.info("'Batch Upload' has clicked");
                        log.info("Waiting till the 'New Invoice Batch' label is display");
                        wait.until(ExpectedConditions.visibilityOf(objInvoice.newInvoiceBatchText));
                        Thread.sleep(5000);
                        if (objInvoice.newInvoiceBatchText.getText().equals("New Invoice Batch")) {
                            log.info("Biller has able to view New Invoice Batch page");
                            test.pass("Biller has able to view New Invoice Batch page");
                        } else {
                            log.info("'New Invoice Batch' label has not matched with this expected result.  But it displayed as " + objInvoice.newInvoiceBatchText.getText());
                            test.fail("'New Invoice Batch' label has not matched with this expected result.  But it displayed as " + objInvoice.newInvoiceBatchText.getText());
                        }
                    } catch (Exception ex) {
                        log.info("'Batch upload' has not clicked.  But it displayed the Exception as.." + ex.getMessage());
                        test.fail("'Batch upload' has not clicked.  But it displayed the Exception as.." + ex.getMessage());
                    }
                }
            } else {
                log.info("'Batch Upload' button has not displayed");
                test.fail("'Batch Upload' button has not displayed");

            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnBatchUpload.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnBatchUpload.jpeg").build());
        }
    }

    public static void checkName() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            log.info("Waiting till the 'Name' text box is display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.nameTxtbox));
            try {
                if (objInvoice.nameTxtbox.isDisplayed()) {
                    String nameText = objInvoice.nameTxtbox.getAttribute("value");
                    log.info("Biller has able to view the default batch name as '" + nameText + "'");
                    test.pass("Biller has able to view the default batch name as '" + nameText + "'");
                } else {
                    log.info("'Name' Text box has not displayed");
                    test.fail("'Name' Text box has not displayed");
                }
            } catch (Exception ex) {
                test.fail("Biller unable to view the default batch name.  But it displayed the Exception as.." + ex.getMessage());
                log.info("Biller unable to view the default batch name.  But it displayed the Exception as.." + ex.getMessage());
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/checkName.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/checkName.jpeg").build());
        }
    }

    public static void enterDataInName() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            objInvoice.nameTxtbox.clear();
            try {
                objInvoice.nameTxtbox.sendKeys(prop.getProperty("Bills2U.FileUpload.Name"));
                if (objInvoice.nameTxtbox.getAttribute("value").equals(prop.getProperty("Bills2U.FileUpload.Name"))) {
                    log.info("Biller has able to edit the data in name field");
                    test.pass("Biller has able to edit the data in name field");
                } else {
                    log.info("'Name' has entered as '" + objInvoice.nameTxtbox.getAttribute("value") + "'.  But the Expected data is '" + prop.getProperty("name") + "'.");
                    test.fail("'Name' has entered as '" + objInvoice.nameTxtbox.getAttribute("value") + "'.  But the Expected data is '" + prop.getProperty("name") + "'.");

                }
            } catch (Exception ex) {
                log.info("Biller unable to edit the data in name field.  But it displayed the Exception as.." + ex.getMessage());
                test.fail("Biller unable to edit the data in name field.  But it displayed the Exception as.." + ex.getMessage());
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/enterDataInName.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/enterDataInName.jpeg").build());
        }
    }

    public static void setTheReminder() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            if (objInvoice.addReminderBtn.isDisplayed()) {
                try {
                    wait.until(ExpectedConditions.visibilityOf(objInvoice.addReminderBtn));
                    wait.until(ExpectedConditions.elementToBeClickable(objInvoice.addReminderBtn));
                    objInvoice.addReminderBtn.click();
                    Thread.sleep(5000);
                    try {
                        wait.until(ExpectedConditions.visibilityOf(objInvoice.selectOption));
                        wait.until(ExpectedConditions.elementToBeClickable(objInvoice.selectOption));
                        act.moveToElement(objInvoice.selectOption).click().build().perform();
                        try {
                            objInvoice.selectOption.sendKeys(prop.getProperty("Bills2U.FileUpload.ReminderType"));
                            Thread.sleep(5000);
                            objInvoice.selectOption.sendKeys(Keys.ENTER);
                            Thread.sleep(5000);
                            objInvoice.daysTxtBox.sendKeys(prop.getProperty("Bills2U.FileUpload.Days"));
                            objInvoice.doneBtn.click();
                            test.pass("Biller has able to set the reminders");
                        } catch (Exception ex) {
                            test.fail("Reminder has not selected" + ex.getMessage());
                        }

                    } catch (Exception ex) {
                        log.info("Drop down list has not clicked, but it displayed the Exception as.." + ex.getMessage());
                        test.fail("Drop down list has not clicked, but it displayed the Exception as.." + ex.getMessage());
                    }
                } catch (Exception ex) {
                    log.info("Add Reminder button has not clicked, but it displayed the Exception as.." + ex.getMessage());
                    test.fail("Add Reminder button has not clicked, but it displayed the Exception as.." + ex.getMessage());
                }
            } else {
                test.fail("Add Reminder button has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/setTheReminder.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/setTheReminder.jpeg").build());
        }
    }

    public static void selectFeedType() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            try {
                objInvoice.feedDataTypeSelect.click();
                objInvoice.feedDataTypeSelect.sendKeys(prop.getProperty("Bills2U.FileUpload.FeedDataType"));
                Thread.sleep(5000);
                objInvoice.feedDataTypeSelect.sendKeys(Keys.ENTER);
                if (objInvoice.feedDataTypeSelect.getText().equals(prop.getProperty("Bills2U.FileUpload.FeedDataType"))) {
                    test.pass("Biller has able to select the feed type");
                    log.info("Biller has able to select the feed type");
                } else {
                    test.fail("Biller unable to select the feed type");
                    log.info("Biller unable to select the feed type");
                }
            } catch (Exception ex) {
                test.fail("Feed Data type has not selected, but it displayed the Exception as.." + ex.getMessage());
                log.info("Feed Data type has not selected, but it displayed the Exception as.." + ex.getMessage());
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/selectFeedType.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/selectFeedType.jpeg").build());
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
                        out.println("File Name :- " + fileName);
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
            out.println("File Name :- " + fileName);
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
                                    out.println(prop.getProperty("Bills2U.FileUpload.Email"));
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
                    out.println("Total rows which we have is " + li.size());
                    Iterator<String[]> i1 = li.iterator();
                    while (i1.hasNext()) {
                        String[] str = i1.next();
                        out.print(" Values are ");
                        for (int i = 0; i < str.length; i++) {
                            if (str[i].equals(prop.getProperty("Bills2U.FileUpload.ExistingEmail"))) {
                                out.print(" " + str[i]);
                            }
                        }
                        out.println("    ");
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

    public static void selectOrUnselectNotify() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            log.info("Waiting till the 'Notify On' checkbox has to be display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.checkNotify));
            if (objInvoice.checkNotify.isDisplayed()) {
                log.info("'Notify On' checkbox has displayed");
                log.info("Waiting till the 'Notify On' checkbox has to be click");
                wait.until(ExpectedConditions.elementToBeClickable(objInvoice.checkNotify));
                if (objInvoice.checkNotify.isEnabled()) {
                    log.info("'Notify On' checkbox has enabled to click");
                    try {
                        act.moveToElement(objInvoice.checkNotify).click().build().perform();
                        test.pass("Biller has able to select or unselect the notify on publish field check box");
                        log.info("Biller has able to select or unselect the notify on publish field check box");
                    } catch (Exception ex) {
                        test.fail("Biller unable to select or unselect the notify on publish field check box.  And it displayed the exception as..." + ex.getMessage());
                        log.info("Biller unable to select or unselect the notify on publish field check box.  And it displayed the exception as..." + ex.getMessage());
                    }
                } else {
                    test.fail("'Notify On' checkbox has not enabled to click");
                    log.info("'Notify On' checkbox has not enabled to click");
                }
            } else {
                test.fail("'Notify On' checkbox has not displayed");
                log.info("'Notify On' checkbox has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/selectOrUnselectNotify.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/selectOrUnselectNotify.jpeg").build());
        }
    }

    public static void uploadFile() throws IOException {
        try {
            getTestData();
            String downloadPath = prop.getProperty("Bills2U.FileUpload.DownloadPath");
            File getLatestFile = getLatestFilefromDir(downloadPath);
            assert getLatestFile != null;
            String fileName = getLatestFile.getName();
            out.println("File Name :- " + fileName);
            out.println(downloadPath + getLatestFile.getName());
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            try {
                out.println(downloadPath + fileName);
                objInvoice.uploadFile.sendKeys(downloadPath + fileName);
                out.println(downloadPath + fileName);
                Thread.sleep(15000);
                Actions act = new Actions(driver);
                act.moveToElement(objInvoice.uploadSuccessfullMsg).build().perform();
                out.println(prop.getProperty("Bills2U.FileUpload.UploadSuccessfulMsg"));
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

    public static void placeTheCursorOnBatchUpload() throws IOException {
        try {
            Obj_Rep_Tooltip objTooltip = new Obj_Rep_Tooltip();
            PageFactory.initElements(driver, objTooltip);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            log.info("Waiting till the 'Add' label is display");
            wait.until(ExpectedConditions.visibilityOf(objTooltip.batchUpload));
            if (objTooltip.batchUpload.isDisplayed()) {
                if (objTooltip.batchUpload.isEnabled()) {
                    log.info("Waiting till the 'Add' is click");
                    wait.until(ExpectedConditions.elementToBeClickable(objTooltip.batchUpload));
                    try {
                        log.info("Placing the cursor on 'Add'");
                        act.moveToElement(objTooltip.batchUpload).build().perform();

                        PageFactory.initElements(driver, objTooltip);
                        out.println(objTooltip.batchUpload.getAttribute("aria-describedby"));
                        out.println(objTooltip.expandTooltip.getAttribute("id"));

                        if (objTooltip.batchUpload.getAttribute("aria-describedby").equals(objTooltip.batchUploadTooltip.getAttribute("id"))) {
                            JavascriptExecutor j = (JavascriptExecutor) driver;
                            j.executeScript("document.getElementById('cdk-describedby-message-15').value='Add';");
                            String s = (String) j.executeScript("return document.getElementById('cdk-describedby-message-15').value");
                            out.println(s);
                            if (s.equals("Add")) {
                                test.pass("Biller has able to view the Add tooltip");
                                log.info("Biller has able to view the Add tooltip");
                            } else {
                                test.fail("'Add Tooltip' has deviated from it's expected data.  But it displayed as " + s);
                                log.info("'Add Tooltip' has deviated from it's expected data.  But it displayed as " + s);
                            }
                        } else {
                            test.fail("Tooltip Locator has not matched");
                            log.info("Tooltip Locator has not matched");
                        }
                    } catch (Exception ex) {
                        test.fail("Add has not clicked.  But it displayed the Exception as..\n" + ex.getMessage());
                        log.info("Add has not clicked.  But it displayed the Exception as..\n" + ex.getMessage());
                    }
                } else {
                    test.fail("'Add' has not enabled to click");
                    log.info("'Add' has not enabled to click");
                }
            } else {
                test.fail("'Add' has not displayed");
                log.info("'Add' has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/placeTheCursorOnBatchUpload.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/placeTheCursorOnBatchUpload.jpeg").build());
        }
    }

    public static void checkInvoiceList() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            act.moveToElement(objInvoice.invoiceNoInInvoiceList).build().perform();
            log.info("Waiting till the 'Invoice Number' is visible");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.invoiceNoInInvoiceList));
            if (objInvoice.invoiceNoInInvoiceList.isDisplayed()) {
                if (objInvoice.recipientInInvoiceList.isDisplayed()) {
                    if (objInvoice.ref1InInvoiceList.isDisplayed()) {
                        if (objInvoice.invoiceAmtInInvoiceList.isDisplayed()) {
                            test.pass("Biller has able to view the invoice list");
                            log.info("Biller has able to view the invoice list");
                        } else {
                            test.fail("'Invoice Amt.' has not displayed");
                            log.info("'Invoice Amt.' has not displayed");
                        }
                    } else {
                        test.fail("'Ref1' has not displayed");
                        log.info("'Ref1' has not displayed");
                    }
                } else {
                    test.fail("'Recipient' has not displayed");
                    log.info("'Recipient' has not displayed");
                }
            } else {
                test.fail("'Invoice Number' has not displayed");
                log.info("'Invoice Number' has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/checkInvoiceList.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/checkInvoiceList.jpeg").build());
        }
    }

    public static void clickOnEditRecipient() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            act.moveToElement(objInvoice.editRecipient).build().perform();
            log.info("Waiting till the 'Edit Recipient' has to be display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.editRecipient));
            if (objInvoice.editRecipient.isDisplayed()) {
                log.info("'Edit Recipient' has displayed");
                log.info("Waiting till the 'Edit Recipient' has to be click");
                if (objInvoice.editRecipient.isEnabled()) {
                    log.info("'Edit Recipient' has enabled to click");
                    try {
                        act.moveToElement(objInvoice.editRecipient).click().build().perform();
                        wait.until(ExpectedConditions.visibilityOf(objInvoice.recipientHeader));
                        if (objInvoice.recipientHeader.isDisplayed()) {
                            if (objInvoice.recipientHeader.getText().equals("Recipient")) {
                                test.pass("Biller has able to view the recipient pop-up page");
                                log.info("Biller has able to view the recipient pop-up page");
                            } else {
                                test.fail("Biller unable to view the recipient pop-up page");
                                log.info("Biller unable to view the recipient pop-up page");
                            }
                        } else {
                            test.fail("Recipient header has not displayed");
                            log.info("Recipient header has not displayed");
                        }
                    } catch (Exception ex) {
                        test.fail("Biller unable to view the recipient pop-up page.  And it displayed the Exception as..." + ex.getMessage());
                        log.info("Biller unable to view the recipient pop-up page.  And it displayed the Exception as..." + ex.getMessage());
                    }
                } else {
                    test.fail("'Edit Recipient' has not enabled to click");
                    log.info("'Edit Recipient' has not enabled to click");
                }
            } else {
                test.fail("'Edit Recipient' has not displayed");
                log.info("'Edit Recipient' has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnEditRecipient.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnEditRecipient.jpeg").build());
        }
    }

    public static void enterEmailAndPhoneInRecipient() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            log.info("Waiting till the 'Email' text box has to be display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.emailRecipient));
            if (objInvoice.emailRecipient.isDisplayed()) {
                log.info("'Email' text box has displayed");
                try {
                    objInvoice.emailRecipient.sendKeys(prop.getProperty("Bills2u.EditRecipient.email"));
                    if (objInvoice.emailRecipient.getAttribute("value").equals(prop.getProperty("Bills2u.EditRecipient.email"))) {
                        log.info("Waiting till the 'Phone' text box has to be display");
                        wait.until(ExpectedConditions.visibilityOf(objInvoice.phoneRecipient));
                        if (objInvoice.phoneRecipient.isDisplayed()) {
                            log.info("'Phone' text box has displayed");
                            try {
                                objInvoice.phoneRecipient.sendKeys(prop.getProperty("Bills2u.EditRecipient.phone"));
                                if (objInvoice.phoneRecipient.getAttribute("value").equals(prop.getProperty("Bills2u.EditRecipient.phone"))) {
                                    test.pass("Biller has able to enter the data in email and phone number fields");
                                    log.info("Biller has able to enter the data in email and phone number fields");
                                } else {
                                    test.fail("'Phone' attribute has deviates from it's expected data.  And it entered as '" + objInvoice.phoneRecipient.getAttribute("value"));
                                    log.info("'Phone' attribute has deviates from it's expected data.  And it entered as '" + objInvoice.phoneRecipient.getAttribute("value"));
                                }
                            } catch (Exception ex) {
                                test.fail("'Phone' has not entered.  But it displayed the exception as..." + ex.getMessage());
                                log.info("'Phone' has not entered.  But it displayed the exception as..." + ex.getMessage());
                            }
                        } else {
                            test.fail("'Phone' text box has not displayed");
                            log.info("'Phone' text box has not displayed");
                        }
                    } else {
                        test.fail("'Email' attribute has deviates from it's expected data.  And it entered as '" + objInvoice.emailRecipient.getAttribute("value"));
                        log.info("'Email' attribute has deviates from it's expected data.  And it entered as '" + objInvoice.emailRecipient.getAttribute("value"));
                    }
                } catch (Exception ex) {
                    test.fail("'Email' has not entered.  But it displayed the exception as..." + ex.getMessage());
                    log.info("'Email' has not entered.  But it displayed the exception as..." + ex.getMessage());
                }
            } else {
                test.fail("'Email' text box has not displayed");
                log.info("'Email' text box has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/enterEmailAndPhoneInRecipient.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/enterEmailAndPhoneInRecipient.jpeg").build());
        }
    }

    public static void clickOnSaveInRecipient() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            log.info("Waiting till the 'Save' icon has to be display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.saveRecipient));
            if (objInvoice.saveRecipient.isDisplayed()) {
                log.info("'Save' icon has displayed");
                log.info("Waiting till the 'Save' icon has to be click");
                if (objInvoice.saveRecipient.isEnabled()) {
                    log.info("'Save' icon has enabled to click");
                    try {
                        act.moveToElement(objInvoice.saveRecipient).click().build().perform();
                        wait.until(ExpectedConditions.visibilityOf(objInvoice.dialogMessage));
                        if (objInvoice.dialogMessage.isDisplayed()) {
                            if (objInvoice.dialogMessage.getText().equals(prop.getProperty("Bills2u.EditRecipient.successfulMessage"))) {
                                test.pass("Biller has able to view the message as '" + objInvoice.dialogMessage.getText() + "'.");
                                log.info("Biller has able to view the message as '" + objInvoice.dialogMessage.getText() + "'.");
                            } else {
                                test.fail("Saved Successful message has deviates from it's expected data.  And it displayed the message as '" + objInvoice.dialogMessage.getText() + "'.");
                                log.info("Saved Successful message has deviates from it's expected data.  And it displayed the message as '" + objInvoice.dialogMessage.getText() + "'.");
                            }
                        } else {
                            test.fail("Biller has not view the successful message");
                            log.info("Biller has not view the successful message");
                        }
                    } catch (Exception ex) {
                        test.fail("'Save' icon unable to click.  And it displayed the Exception as..." + ex.getMessage());
                        log.info("'Save' icon unable to click.  And it displayed the Exception as..." + ex.getMessage());
                    }
                } else {
                    test.fail("'Save' icon has not enabled to click");
                    log.info("'Save' icon has not enabled to click");
                }
            } else {
                test.fail("'Save' icon has not displayed");
                log.info("'Save' icon has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnSaveInRecipient.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnSaveInRecipient.jpeg").build());
        }
    }

    public static void closeRecipient() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            log.info("Waiting till the 'Close' icon has to be display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.recipientClose));
            if (objInvoice.recipientClose.isDisplayed()) {
                log.info("'Close' icon has displayed");
                log.info("Waiting till the 'Close' icon has to be click");
                if (objInvoice.recipientClose.isEnabled()) {
                    log.info("'Close' icon has enabled to click");
                    try {
                        act.moveToElement(objInvoice.recipientClose).click().build().perform();
                        Thread.sleep(3000);
                    } catch (Exception ex) {
                        test.fail("'Close' icon unable to click.  And it displayed the Exception as..." + ex.getMessage());
                        log.info("'Close' icon unable to click.  And it displayed the Exception as..." + ex.getMessage());
                    }
                } else {
                    test.fail("'Close' icon has not enabled to click");
                    log.info("'Close' icon has not enabled to click");
                }
            } else {
                test.fail("'Close' icon has not displayed");
                log.info("'Close' icon has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/closeRecipient.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/closeRecipient.jpeg").build());
        }
    }

    public static void clickOnDeleteInRecipient() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Thread.sleep(5000);
            Actions act = new Actions(driver);
            log.info("Waiting till the 'Delete' icon has to be display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.deleteRecipient));
            if (objInvoice.deleteRecipient.isDisplayed()) {
                log.info("'Delete' icon has displayed");
                log.info("Waiting till the 'Delete' icon has to be click");
                if (objInvoice.deleteRecipient.isEnabled()) {
                    log.info("'Delete' icon has enabled to click");
                    try {
                        act.moveToElement(objInvoice.deleteRecipient).click().build().perform();
                        wait.until(ExpectedConditions.visibilityOf(objInvoice.dialogMessage));
                        if (objInvoice.dialogMessage.isDisplayed()) {
                            if (objInvoice.dialogMessage.getText().equals(prop.getProperty("Bills2u.EditRecipient.deleteMessage"))) {
                                test.pass("Biller has able to view the message as '" + objInvoice.dialogMessage.getText() + "'.");
                                log.info("Biller has able to view the message as '" + objInvoice.dialogMessage.getText() + "'.");
                            } else {
                                test.fail("Deleted Successful message has deviates from it's expected data.  And it displayed the message as '" + objInvoice.dialogMessage.getText() + "'.");
                                log.info("Deleted Successful message has deviates from it's expected data.  And it displayed the message as '" + objInvoice.dialogMessage.getText() + "'.");
                            }
                        } else {
                            test.fail("Biller has not view the successful message");
                            log.info("Biller has not view the successful message");
                        }
                    } catch (Exception ex) {
                        test.fail("'Delete' icon unable to click.  And it displayed the Exception as..." + ex.getMessage());
                        log.info("'Delete' icon unable to click.  And it displayed the Exception as..." + ex.getMessage());
                    }
                } else {
                    test.fail("'Delete' icon has not enabled to click");
                    log.info("'Delete' icon has not enabled to click");
                }
            } else {
                test.fail("'Delete' icon has not displayed");
                log.info("'Delete' icon has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnDeleteInRecipient.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnDeleteInRecipient.jpeg").build());
        }
    }

    public static void clickOnDelete() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            act.moveToElement(objInvoice.deleteIcon).build().perform();
            log.info("Waiting till the 'Delete' icon has to be display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.deleteIcon));
            if (objInvoice.deleteIcon.isDisplayed()) {
                log.info("'Delete' icon has displayed");
                log.info("Waiting till the 'Delete' icon has to be click");
                if (objInvoice.deleteIcon.isEnabled()) {
                    log.info("'Delete' icon has enabled to click");
                    try {
                        act.moveToElement(objInvoice.deleteIcon).click().build().perform();
                        wait.until(ExpectedConditions.visibilityOf(objInvoice.deleteHeader));
                        if (objInvoice.deleteHeader.isDisplayed()) {
                            if (objInvoice.deleteHeader.getText().equals("Delete")) {
                                test.pass("Biller has able to view the delete pop-up");
                                log.info("Biller has able to view the delete pop-up");
                            } else {
                                test.fail("Biller unable to view the delete pop-up");
                                log.info("Biller unable to view the delete pop-up");
                            }
                        } else {
                            test.fail("Biller has not view the successful message");
                            log.info("Biller has not view the successful message");
                        }
                    } catch (Exception ex) {
                        test.fail("'Delete' icon unable to click.  And it displayed the Exception as..." + ex.getMessage());
                        log.info("'Delete' icon unable to click.  And it displayed the Exception as..." + ex.getMessage());
                    }
                } else {
                    test.fail("'Delete' icon has not enabled to click");
                    log.info("'Delete' icon has not enabled to click");
                }
            } else {
                test.fail("'Delete' icon has not displayed");
                log.info("'Delete' icon has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnDelete.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnDelete.jpeg").build());
        }
    }

    public static void clickOnDeleteButton() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            log.info("Waiting till the 'Delete' button has to be display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.deleteButton));
            if (objInvoice.deleteButton.isDisplayed()) {
                log.info("'Delete' button has displayed");
                log.info("Waiting till the 'Delete' button has to be click");
                if (objInvoice.deleteButton.isEnabled()) {
                    log.info("'Delete' button has enabled to click");
                    try {
                        act.moveToElement(objInvoice.deleteButton).click().build().perform();
                        wait.until(ExpectedConditions.visibilityOf(objInvoice.findTxtbox));
                        if (objInvoice.findTxtbox.isDisplayed()) {
                            if (objInvoice.findTxtbox.isEnabled()) {
                                objInvoice.findTxtbox.sendKeys(prop.getProperty("Bills2u.EditRecipient.InvNumber"));
                                wait.until(ExpectedConditions.visibilityOf(objInvoice.getNoResult));
                                if (objInvoice.getNoResult.isDisplayed()) {
                                    test.pass("Biller has able to delete the particular invoice");
                                    log.info("Biller has able to delete the particular invoice");
                                } else {
                                    test.fail("'No Result' has not displayed");
                                    log.info("'No Result' has not displayed");
                                }
                            } else {
                                test.fail("'Find' text box has not enabled to click");
                                log.info("'Find' text box has not enabled to click");
                            }
                        } else {
                            test.fail("'Find' text box has not displayed");
                            log.info("'Find' text box has not displayed");
                        }

                    } catch (Exception ex) {
                        test.fail("'Delete' button unable to click.  And it displayed the Exception as..." + ex.getMessage());
                        log.info("'Delete' button unable to click.  And it displayed the Exception as..." + ex.getMessage());
                    }
                } else {
                    test.fail("'Delete' button has not enabled to click");
                    log.info("'Delete' button has not enabled to click");
                }
            } else {
                test.fail("'Delete' button has not displayed");
                log.info("'Delete' button has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnDeleteButton.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnDeleteButton.jpeg").build());
        }
    }

    public static void enterInvoiceNumberInFind() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            wait.until(ExpectedConditions.visibilityOf(objInvoice.findTxtbox));
            if (objInvoice.findTxtbox.isDisplayed()) {
                if (objInvoice.findTxtbox.isEnabled()) {
                    if (!objInvoice.findTxtbox.getAttribute("value").isEmpty()) {
                        objInvoice.findTxtbox.clear();
                    }
                    objInvoice.findTxtbox.sendKeys(prop.getProperty("Bills2u.EditRecipient.InvNumber"));
                    act.moveToElement(objInvoice.invoiceNumberInTable).build().perform();
                    wait.until(ExpectedConditions.visibilityOf(objInvoice.invoiceNumberInTable));

                    if (objInvoice.invoiceNumberInTable.isDisplayed()) {
                        if (objInvoice.invoiceNumberInTable.getText().equals(prop.getProperty("Bills2u.EditRecipient.InvNumber"))) {
                            test.pass("Biller has able to view the Invoice List by Invoice No");
                            log.info("Biller has able to view the Invoice List by Invoice No");
                        } else {
                            test.fail("'Invoice number has deviates from it's expected result.  And it displayed the Invoice no as '" + objInvoice.invoiceNumberInTable + "'.");
                            log.info("'Invoice number has deviates from it's expected result.  And it displayed the Invoice no as '" + objInvoice.invoiceNumberInTable + "'.");
                        }
                    } else {
                        test.fail("'Invoice number' has not displayed");
                        log.info("'Invoice number' has not displayed");
                    }
                } else {
                    test.fail("'Find' text box has not enabled to click");
                    log.info("'Find' text box has not enabled to click");
                }
            } else {
                test.fail("'Find' text box has not displayed");
                log.info("'Find' text box has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/enterInvoiceNumberInFind.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/enterInvoiceNumberInFind.jpeg").build());
        }
    }

    public static void enterRecipientInFind() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            wait.until(ExpectedConditions.visibilityOf(objInvoice.findTxtbox));
            if (objInvoice.findTxtbox.isDisplayed()) {
                if (objInvoice.findTxtbox.isEnabled()) {
                    if (!objInvoice.findTxtbox.getAttribute("value").isEmpty()) {
                        objInvoice.findTxtbox.clear();
                    }
                    objInvoice.findTxtbox.sendKeys(prop.getProperty("Bills2u.EditRecipient.Recipient"));
                    act.moveToElement(objInvoice.recipientInTable).build().perform();
                    wait.until(ExpectedConditions.visibilityOf(objInvoice.recipientInTable));

                    if (objInvoice.recipientInTable.isDisplayed()) {
                        if (objInvoice.recipientInTable.getText().equals(prop.getProperty("Bills2u.EditRecipient.Recipient"))) {
                            test.pass("Biller has able to view the Invoice List by Recipient");
                            log.info("Biller has able to view the Invoice List by Recipient");
                        } else {
                            test.fail("'Recipient' has deviates from it's expected result.  And it displayed the Invoice no as '" + objInvoice.recipientInTable + "'.");
                            log.info("'Recipient' has deviates from it's expected result.  And it displayed the Invoice no as '" + objInvoice.recipientInTable + "'.");
                        }
                    } else {
                        test.fail("'Recipient' has not displayed");
                        log.info("'Recipient' has not displayed");
                    }
                } else {
                    test.fail("'Find' text box has not enabled to click");
                    log.info("'Find' text box has not enabled to click");
                }
            } else {
                test.fail("'Find' text box has not displayed");
                log.info("'Find' text box has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/enterRecipientInFind.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/enterRecipientInFind.jpeg").build());
        }
    }

    public static void enterRef1InFind() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            wait.until(ExpectedConditions.visibilityOf(objInvoice.findTxtbox));
            if (objInvoice.findTxtbox.isDisplayed()) {
                if (objInvoice.findTxtbox.isEnabled()) {
                    if (!objInvoice.findTxtbox.getAttribute("value").isEmpty()) {
                        objInvoice.findTxtbox.clear();
                    }
                    objInvoice.findTxtbox.sendKeys(prop.getProperty("Bills2u.EditRecipient.Ref1"));
                    act.moveToElement(objInvoice.ref1InTable).build().perform();
                    wait.until(ExpectedConditions.visibilityOf(objInvoice.ref1InTable));
                    if (objInvoice.ref1InTable.isDisplayed()) {
                        if (objInvoice.ref1InTable.getText().equals(prop.getProperty("Bills2u.EditRecipient.Ref1"))) {
                            test.pass("Biller has able to view the Invoice List by Ref1");
                            log.info("Biller has able to view the Invoice List by Ref1");
                        } else {
                            test.fail("'Ref1' has deviates from it's expected result.  And it displayed the Invoice no as '" + objInvoice.ref1InTable + "'.");
                            log.info("'Ref1' has deviates from it's expected result.  And it displayed the Invoice no as '" + objInvoice.ref1InTable + "'.");
                        }
                    } else {
                        test.fail("'Ref1' has not displayed");
                        log.info("'Ref1' has not displayed");
                    }
                } else {
                    test.fail("'Find' text box has not enabled to click");
                    log.info("'Find' text box has not enabled to click");
                }
            } else {
                test.fail("'Find' text box has not displayed");
                log.info("'Find' text box has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/enterRef1InFind.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/enterRef1InFind.jpeg").build());
        }
    }

    public static void enterInvoiceAmount() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            wait.until(ExpectedConditions.visibilityOf(objInvoice.findTxtbox));
            if (objInvoice.findTxtbox.isDisplayed()) {
                if (objInvoice.findTxtbox.isEnabled()) {
                    if (!objInvoice.findTxtbox.getAttribute("value").isEmpty()) {
                        objInvoice.findTxtbox.clear();
                    }
                    objInvoice.findTxtbox.sendKeys(prop.getProperty("Bills2u.EditRecipient.InvAmt"));
                    act.moveToElement(objInvoice.invoiceAmountInTable).build().perform();
                    wait.until(ExpectedConditions.visibilityOf(objInvoice.invoiceAmountInTable));

                    if (objInvoice.invoiceAmountInTable.isDisplayed()) {
                        test.pass("Biller has able to view the Invoice List by Invoice Amount");
                        log.info("Biller has able to view the Invoice List by Invoice Amount");

                    } else {
                        test.fail("'Invoice Amount' has not displayed");
                        log.info("'Invoice Amount' has not displayed");
                    }
                } else {
                    test.fail("'Find' text box has not enabled to click");
                    log.info("'Find' text box has not enabled to click");
                }
            } else {
                test.fail("'Find' text box has not displayed");
                log.info("'Find' text box has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/enterInvoiceAmount.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/enterInvoiceAmount.jpeg").build());
        }
    }

    public static void enterEmptyData() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(objInvoice.findTxtbox));
            if (objInvoice.findTxtbox.isDisplayed()) {
                if (objInvoice.findTxtbox.isEnabled()) {
                    objInvoice.findTxtbox.clear();
                    objInvoice.findTxtbox.sendKeys(Keys.SPACE, Keys.SPACE);
                    wait.until(ExpectedConditions.visibilityOf(objInvoice.getNoResult));
                    if (objInvoice.getNoResult.isDisplayed()) {
                        if (objInvoice.getNoResult.getText().equals(prop.getProperty("Bills2U.FileUpload.NoResult"))) {
                            test.pass("Biller has able to view 'No Results.' message");
                            log.info("Biller has able to view 'No Results.' message");
                        } else {
                            test.fail("''No Results.' message has deviates from it's expected data.  And it displayed the message as " + objInvoice.getNoResult.getText());
                            log.info("''No Results.' message has deviates from it's expected data.  And it displayed the message as " + objInvoice.getNoResult.getText());
                        }
                    } else {
                        test.fail("'No Result' has not displayed");
                        log.info("'No Result' has not displayed");
                    }
                } else {
                    test.fail("'Find' text box has not enabled to click");
                    log.info("'Find' text box has not enabled to click");
                }
            } else {
                test.fail("'Find' text box has not displayed");
                log.info("'Find' text box has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/enterEmptyData.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/enterEmptyData.jpeg").build());
        }
    }

    public static void clickOnExportButton() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            log.info("Waiting till the 'Export' button has to be visible");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.exportBtn));
            if (objInvoice.exportBtn.isDisplayed()) {
                log.info("'Export' button has displayed");
                if (objInvoice.exportBtn.isEnabled()) {
                    log.info("'Export' button has enabled to click");
                    log.info("Waiting till the 'Export' button has to be click");
                    wait.until(ExpectedConditions.elementToBeClickable(objInvoice.exportBtn));
                    try {
                        act.moveToElement(objInvoice.exportBtn).click().build().perform();
                        Thread.sleep(10000);
                        String downloadPath = prop.getProperty("Bills2U.FileUpload.DownloadPath");
                        File getLatestFile = getLatestFilefromDir(downloadPath);
                        String fileName = getFileNameWithoutExtension(getLatestFile);
                        out.println("File Name :- " + fileName);

                        assert getLatestFile != null;
                        if (getLatestFile.exists()) {
                            if (getLatestFile.getName().equals(fileName + ".csv")) {
                                test.pass("Biller has able to download and view all the invoice listing details in Excel sheet ");
                                log.info("Biller has able to download and view all the invoice listing details in Excel sheet ");
                            } else {
                                test.fail("The latest file not is .csv extension.  But it has the extension as " + getLatestFile.getName());
                                log.info("The latest file not is .csv extension.  But it has the extension as " + getLatestFile.getName());
                            }
                        } else {
                            test.fail("Biller has not able to download the file.  And the latest file name is " + getLatestFile.getName());
                        }
                    } catch (Exception ex) {
                        test.fail("'Export' button has not clicked.  But it displayed the exception as.." + ex.getMessage());
                        log.info("'Export' button has not clicked.  But it displayed the exception as.." + ex.getMessage());
                    }
                } else {
                    test.fail("'Export' button has not enabled to click");
                    log.info("'Export' button has not enabled to click");
                }
            } else {
                test.fail("'Export' Button has not displayed");
                log.info("'Export' button has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnExportButton.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnExportButton.jpeg").build());
        }
    }

    public static void enterEmailInColumnFilter() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            log.info("Waiting till the 'Email' text box has to be visible");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.emailColumnFilter));
            if (objInvoice.emailColumnFilter.isDisplayed()) {
                log.info("'Email' text box has displayed");
                if (objInvoice.emailColumnFilter.isEnabled()) {
                    log.info("'Email' text box has enabled");
                    try {
                        objInvoice.emailColumnFilter.sendKeys(prop.getProperty("Bills2U.FileUpload.Email"));
                        try {
                            if (objInvoice.filteredEmail.isDisplayed()) {
                                test.pass("Biller has able to view the Recipients details depends on the entered data in Email column filter ");
                                log.info("Biller has able to view the Recipients details depends on the entered data in Email column filter ");
                            }
                        } catch (Exception ex) {
                            test.pass("Biller has able to filter the Recipient details but the entered Email does not exist.");
                            log.info("Biller has able to filter the Recipient details but the entered Email does not exist.");
                        }
                    } catch (Exception ex) {
                        test.fail("'Email has not entered in text box.  And it displayed the Exception as.. " + ex.getMessage());
                        log.info("'Email has not entered in text box.  And it displayed the Exception as.. " + ex.getMessage());
                    }
                } else {
                    test.fail("'Email' text box has not enabled");
                    log.info("'Email' text box has not enabled");
                }
            } else {
                test.fail("'Email' text box has not displayed");
                log.info("'Email' text box has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/enterEmailInColumnFilter.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/enterEmailInColumnFilter.jpeg").build());
        }
    }

    public static void enterEmptySpaceInEmail() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(objInvoice.emailColumnFilter));
            if (objInvoice.emailColumnFilter.isDisplayed()) {
                if (objInvoice.emailColumnFilter.isEnabled()) {
                    objInvoice.emailColumnFilter.clear();
                    objInvoice.emailColumnFilter.sendKeys(Keys.SPACE, Keys.SPACE);

                    try {
                        wait.until(ExpectedConditions.visibilityOf(objInvoice.noResultEditRecipient));
                        if (objInvoice.noResultEditRecipient.isDisplayed()) {
                            if (objInvoice.noResultEditRecipient.getText().equals(prop.getProperty("Bills2U.PaymentHistory.noResult"))) {
                                test.pass("Biller has able to view 'No Results.' message");
                                log.info("Biller has able to view 'No Results.' message");
                            } else {
                                test.fail("''No Results.' message has deviates from it's expected data.  And it displayed the message as " + objInvoice.noResultEditRecipient.getText());
                                log.info("''No Results.' message has deviates from it's expected data.  And it displayed the message as " + objInvoice.noResultEditRecipient.getText());
                            }
                        } else {
                            test.fail("'No Result' has not displayed");
                            log.info("'No Result' has not displayed");
                        }
                    } catch (Exception ex) {
                        test.fail("'No Result' has not displayed.  And displayed the Exception as.." + ex.getMessage());
                        log.info("'No Result' has not displayed.  And displayed the Exception as.." + ex.getMessage());
                    }
                } else {
                    test.fail("'Email' text box has not enabled to click");
                    log.info("'Email' text box has not enabled to click");
                }
            } else {
                test.fail("'Email' text box has not displayed");
                log.info("'Email' text box has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/enterEmptySpaceInEmail.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/enterEmptySpaceInEmail.jpeg").build());
        }
    }

    public static void enterPhoneInColumnFilter() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            log.info("Waiting till the 'Phone number' text box has to be visible");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.phoneColumnFilter));
            if (objInvoice.phoneColumnFilter.isDisplayed()) {
                log.info("'Phone number' text box has displayed");
                if (objInvoice.phoneColumnFilter.isEnabled()) {
                    log.info("'Phone number' text box has enabled");
                    try {
                        objInvoice.phoneColumnFilter.sendKeys(prop.getProperty("Bills2U.FileUpload.Phone"));
                        try {
                            if (objInvoice.filteredPhone.isDisplayed()) {
                                test.pass("Biller has able to view the Recipients details depends on the entered data in Phone number column filter ");
                                log.info("Biller has able to view the Recipients details depends on the entered data in Phone number column filter ");
                            }
                        } catch (Exception ex) {
                            test.pass("Biller has able to filter the Recipient details but the entered Phone number does not exist.");
                            log.info("Biller has able to filter the Recipient details but the entered Phone number does not exist.");
                        }
                    } catch (Exception ex) {
                        test.fail("'Phone number has not entered in text box.  And it displayed the Exception as.. " + ex.getMessage());
                        log.info("'Phone number has not entered in text box.  And it displayed the Exception as.. " + ex.getMessage());
                    }
                } else {
                    test.fail("'Phone number' text box has not enabled");
                    log.info("'Phone number' text box has not enabled");
                }
            } else {
                test.fail("'Phone number' text box has not displayed");
                log.info("'Phone number' text box has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/enterPhoneInColumnFilter.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/enterPhoneInColumnFilter.jpeg").build());
        }
    }

    public static void enterEmptySpaceInPhone() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(objInvoice.phoneColumnFilter));
            if (objInvoice.phoneColumnFilter.isDisplayed()) {
                if (objInvoice.phoneColumnFilter.isEnabled()) {
                    objInvoice.phoneColumnFilter.clear();
                    objInvoice.phoneColumnFilter.sendKeys(Keys.SPACE, Keys.SPACE);

                    try {
                        wait.until(ExpectedConditions.visibilityOf(objInvoice.noResultEditRecipient));
                        if (objInvoice.noResultEditRecipient.isDisplayed()) {
                            if (objInvoice.noResultEditRecipient.getText().equals(prop.getProperty("Bills2U.PaymentHistory.noResult"))) {
                                test.pass("Biller has able to view 'No Results.' message");
                                log.info("Biller has able to view 'No Results.' message");
                            } else {
                                test.fail("''No Results.' message has deviates from it's expected data.  And it displayed the message as " + objInvoice.noResultEditRecipient.getText());
                                log.info("''No Results.' message has deviates from it's expected data.  And it displayed the message as " + objInvoice.noResultEditRecipient.getText());
                            }
                        } else {
                            test.fail("'No Result' has not displayed");
                            log.info("'No Result' has not displayed");
                        }
                    } catch (Exception ex) {
                        test.fail("'No Result' has not displayed.  And displayed the Exception as.." + ex.getMessage());
                        log.info("'No Result' has not displayed.  And displayed the Exception as.." + ex.getMessage());
                    }
                } else {
                    test.fail("'Phone' text box has not enabled to click");
                    log.info("'Phone' text box has not enabled to click");
                }
            } else {
                test.fail("'Phone' text box has not displayed");
                log.info("'Phone' text box has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/enterEmptySpaceInPhone.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/enterEmptySpaceInPhone.jpeg").build());
        }
    }

    public static void enterEmailAndPhoneForUpwardTesting() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            objInvoice.emailRecipient.sendKeys("indhu@gmail.com");
            objInvoice.phoneRecipient.sendKeys("0987654321");
            objInvoice.saveRecipient.click();
            objInvoice.emailRecipient.sendKeys("mathi@gmail.com");
            objInvoice.phoneRecipient.sendKeys("0980354321");
            objInvoice.saveRecipient.click();

            objInvoice.emailRecipient.sendKeys("indhumathi@gmail.com");
            objInvoice.phoneRecipient.sendKeys("0989854321");
            objInvoice.saveRecipient.click();
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/enterEmailAndPhoneForUpwardTesting.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/enterEmailAndPhoneForUpwardTesting.jpeg").build());
        }
    }

    public static void upwardAero() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);

            objInvoice.upwardArrow.click();

            System.out.println(objInvoice.getCellFromTable.size());
            String[] strArry = new String[objInvoice.getCellFromTable.size()];
            for (int i = 0; i < objInvoice.getCellFromTable.size(); i++) {
                strArry[i] = objInvoice.getCellFromTable.get(i).getText();
                out.println(strArry[i]);
            }

            boolean sortFunctionality = true;
            outer:
            for (int i = 0; i < strArry.length; i++) {
                for (int j = i + 1; j < i; j++) {
                    int result = strArry[j].compareTo(strArry[i]);
                    if (!(result > 0)) {
                        String details = "Data in the Table is not SORTED::" + strArry[j] + ":::" + strArry[i];
                        test.fail(details);
                        out.println(details);
                        sortFunctionality = false;
                        break outer;
                    } else {
                        out.println("Data in the Table is SORTED::" + strArry[j] + ":::" + strArry[i]);
                    }
                }
            }


            if (sortFunctionality) {
                test.pass("Biller has able to view the list of Email in ascending order");
                out.println("SORT Functionality is working");
            } else {
                test.fail("Biller unable to view the list of Email in ascending order");
                out.println("SORT Functionality is not working");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/upwardAero.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/upwardAero.jpeg").build());
        }
    }

    public static void downwardAero() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            objInvoice.upwardArrow.click();
            out.println(objInvoice.getCellFromTable.size());
            String[] strArry = new String[objInvoice.getCellFromTable.size()];
            for (int i = 0; i < objInvoice.getCellFromTable.size(); i++) {
                strArry[i] = objInvoice.getCellFromTable.get(i).getText();
                out.println(strArry[i]);
            }

            boolean sortFunctionality = true;
            outer:
            for (int i = 0; i < strArry.length; i++) {
                for (int j = i + 1; j < i; j++) {
                    int result = strArry[j].compareTo(strArry[i]);
                    if (!(result > 0)) {
                        String details = "Data in the Table is not SORTED::" + strArry[j] + ":::" + strArry[i];
                        test.fail(details);
                        out.println(details);
                        sortFunctionality = true;
                        break outer;
                    } else {
                        out.println("Data in the Table is SORTED::" + strArry[j] + ":::" + strArry[i]);
                    }
                }
            }


            if (sortFunctionality) {
                test.pass("Biller has able to view the list of Email in Descending order");
                out.println("SORT Functionality is working");
            } else {
                test.fail("Biller unable to view the list of Email in Descending order");
                out.println("SORT Functionality is not working");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/downwardAero.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/downwardAero.jpeg").build());
        }
    }

    public static void selectFeedTypeAsKdu() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            try {
                objInvoice.feedDataTypeSelect.click();
                objInvoice.feedDataTypeSelect.sendKeys(prop.getProperty("Bills2U.FileUpload.FeedDataTypeKdu"));
                Thread.sleep(5000);
                objInvoice.feedDataTypeSelect.sendKeys(Keys.ENTER);
                if (objInvoice.feedDataTypeSelect.getText().equals(prop.getProperty("Bills2U.FileUpload.FeedDataTypeKdu"))) {
                    test.pass("Biller has able to select the feed type");
                    log.info("Biller has able to select the feed type");
                } else {
                    test.fail("Biller unable to select the feed type");
                    log.info("Biller unable to select the feed type");
                }
            } catch (Exception ex) {
                test.fail("Feed Data type has not selected, but it displayed the Exception as.." + ex.getMessage());
                log.info("Feed Data type has not selected, but it displayed the Exception as.." + ex.getMessage());
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/selectFeedTypeAsKdu.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/selectFeedTypeAsKdu.jpeg").build());
        }
    }

}
