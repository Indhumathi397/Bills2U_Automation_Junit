package bills2u_root;

import Config.PropertyClass;
import bills2u_constant.Obj_Rep_Home;
import bills2u_constant.Obj_Rep_Login;
import bills2u_constant.Obj_Rep_Logout;
import bills2u_suite.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Root_Class_TestNG {


    public static WebDriver driver;

    public static Logger log = Logger.getLogger(Root_Class_TestNG.class.getName());

    public static ExtentReports report;
    public static ExtentTest test;
    public static ExtentHtmlReporter htmlReport;
    public static String Date;

    public static Properties prop = null;
    public static StopWatch watch = new StopWatch();
@Test
    public void DashboardTest() throws IOException {
    new Dashboard_Page()
            .TC_Dash_001()
            .TC_Dash_002()
            .TC_Dash_003();
}
    @Test
    public void InvoiceBatchListTest() throws IOException {
        new Invoice_Batch_List_Page()
                .TC_IBL_001()
                .TC_IBL_002()
                .TC_IBL_003()
                .TC_IBL_004()
                .TC_IBL_005()
                .TC_IBL_006()
                .TC_IBL_007()
                .TC_IBL_008()
                .TC_IBL_009()
                .TC_IBL_010()
                .TC_IBL_011()
                .TC_IBL_012()
                .TC_IBL_013()
                .TC_IBL_014()
                .TC_IBL_015()
                .TC_IBL_016()
                .TC_IBL_017()
                .TC_IBL_018()
                .TC_IBL_019()
                .TC_IBL_020()
                .TC_IBL_021();
    }
    @Test
    public void BatchUploadTest() throws IOException {
        new Batch_upload_page()
                .TC_BU_001()
                .TC_BU_002()
                .TC_BU_003()
                .TC_BU_004();
    }
    @Test
    public void FileUploadTest() throws IOException {
        new File_Upload_Page()
                .TC_FU_001()
                .TC_FU_002()
                .TC_FU_003()
                .TC_FU_004()
                .TC_FU_005()
                .TC_FU_006()
                .TC_FU_007()
                .TC_FU_008()
                .TC_FU_009()
                .TC_FU_010();
    }
    @Test
    public void ReminderSetupTest() throws IOException {
        new Reminder_Setup_Page()
                .TC_RS_001()
                .TC_RS_002()
                .TC_RS_003()
                .TC_RS_004()
                .TC_RS_005()
                .TC_RS_006();
    }
    @Test
    public void BatchEntryTest() throws IOException {
        new Batch_Entry_Page()
                .TC_BE_001()
                .TC_BE_002()
                .TC_BE_003()
                .TC_BE_004()
                .TC_BE_005();
    }
    @Test
    public void InvoiceDetailTest() throws IOException {
        new Invoice_Detail_Page()
                .TC_ID_001()
                .TC_ID_002()
                .TC_ID_003()
                .TC_ID_004()
                .TC_ID_005()
                .TC_ID_006()
                .TC_ID_007()
                .TC_ID_008()
                .TC_ID_009()
                .TC_ID_010()
                .TC_ID_011()
                .TC_ID_012()
                .TC_ID_013()
                .TC_ID_014()
                .TC_ID_015()
                .TC_ID_016()
                .TC_ID_017()
                .TC_ID_018()
                .TC_ID_019();
    }
    @Test
    public void InvoiceListingTest() throws IOException {
        new Invoice_Listing_Page()
                .TC_IL_001()
                .TC_IL_002()
                .TC_IL_003()
                .TC_IL_004()
                .TC_IL_005()
                .TC_IL_006()
                .TC_IL_007()
                .TC_IL_008()
                .TC_IL_009()
                .TC_IL_010()
                .TC_IL_011()
                .TC_IL_012()
                .TC_IL_013()
                .TC_IL_014()
                .TC_IL_015()
                .TC_IL_016()
                .TC_IL_017();
    }
    @Test
    public void EditInvoiceListTest() throws IOException {
        new Edit_Invoice_List_Page()
                .TC_EIL_001()
                .TC_EIL_002()
                .TC_EIL_003()
                .TC_EIL_004();
    }
    @Test
    public void PaymentListingPageTest() throws IOException {
        new Payment_Listing_Page()
                .TC_PL_001()
                .TC_PL_002()
                .TC_PL_003()
                .TC_PL_004()
                .TC_PL_005()
                .TC_PL_006()
                .TC_PL_007()
                .TC_PL_008()
                .TC_PL_009()
                .TC_PL_010()
                .TC_PL_011()
                .TC_PL_012()
                .TC_PL_013()
                .TC_PL_014()
                .TC_PL_015()
                .TC_PL_016()
                .TC_PL_017()
                .TC_PL_018()
                .TC_PL_019()
                .TC_PL_020()
                .TC_PL_021();
    }
    @Test
    public void MerchantOnBoardTest() throws IOException {
        new Merchant_On_Board_Page()
                .TC_MOB_001()
                .TC_MOB_002()
                .TC_MOB_003()
                .TC_MOB_004()
                .TC_MOB_005()
                .TC_MOB_006()
                .TC_MOB_007()
                .TC_MOB_008()
                .TC_MOB_009();

    }



    @BeforeTest
    public void initProcess() throws IOException {
        DOMConfigurator.configure("D:\\Bills2U_Automation\\Bills2U_Automation\\src\\test\\java\\log4j.xml");
        watch.start();

        getTestData();
        report = new ExtentReports();
        htmlReport = new ExtentHtmlReporter(prop.getProperty("Bills2U.report.Directory") + "/RinggitPay_Automation_Report.html");
        htmlReport.config().setDocumentTitle("Automation Test Report");
        htmlReport.config().setReportName("Bills2U Automation Test Report");
        htmlReport.config().setTheme(Theme.DARK);
        report.attachReporter(htmlReport);
        report.setSystemInfo("Automation Tester", "Indhumathi & Rahul");
        report.setSystemInfo("Project Name", "Bills2U");
        report.setSystemInfo("OS", "Windows10");

       getTestData();
        log.info("Opening Chrome browser");
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/Open_Browser.jpeg"));
            log.info("Chrome browser has launched");
        } catch (Exception ex) {
            log.info("Chrome browser has not opened, but it displayed the Exception as...\n" + ex.getMessage());
        }
        log.info("Navigating to Billers portal");
        try {
            System.out.println(prop.getProperty("Bills2U.billersUrl"));
            driver.get(prop.getProperty("Bills2U.billersUrl"));
            driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
            Thread.sleep(3000);
            log.info("Billers portal has launched");
        } catch (Exception ex) {
            log.info("Billers portal has not launched.  but it displayed the Exception as..\n" + ex.getMessage());
        }
        log.info("Waiting till the Page is load");
        try {
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            log.info("Browser has waited till the page is load");
        } catch (Exception ex) {
            log.info("Browser has not wait till the page is load.  but it displayed the exception as...\n"
                    + ex.getMessage());
        }
        log.info("Maximizing window");
        try {
            driver.manage().window().maximize();
            log.info("Window has maximized");
        } catch (Exception ex) {
            log.info("Window has not maximized.  but it displayed exception as...\n" + ex.getMessage());
        }
    }

    @AfterTest
    public static void exitProcess() {
        log.info("Quiting the browser");
        try {
            if (driver != null) {
                driver.quit();
                log.info("Browser has closed");
            }
        } catch (Exception ex) {
            log.info("Browser has not closed.  but it displayed the Exception as...\n" + ex.getMessage());
        }
        report.flush();
        watch.stop();
        long timeIntervalSec = watch.getTime(TimeUnit.SECONDS);
        long timeIntervalMin = watch.getTime(TimeUnit.MINUTES);
        long timeIntervalhr = watch.getTime(TimeUnit.HOURS);
        System.out.println("************************************************************************************************");
        System.out.println("Total number of Time Taken to execute the program in Seconds:" + timeIntervalSec);
        System.out.println("Total number of Time Taken to execute the program in Minutes:" + timeIntervalMin);
        System.out.println("Total number of Time Taken to execute the program in Hours:" + timeIntervalhr);
        System.out.println("************************************************************************************************");
    }

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
            ex.printStackTrace();
            log.info(ex.toString());
            test.fail(ex.toString());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/loginProcess.jpeg").build());
        }
    }


    public static void logoutProcess() throws IOException {
        try {
            Obj_Rep_Logout objLogout = new Obj_Rep_Logout();
            PageFactory.initElements(driver, objLogout);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            log.info("Waiting till the Person Icon is display");
            wait.until(ExpectedConditions.visibilityOf(objLogout.personIcon));
            if (objLogout.personIcon.isDisplayed()) {
                if (objLogout.personIcon.isEnabled()) {
                    try {
                        log.info("Waiting till the Person Icon is click");
                        wait.until(ExpectedConditions.elementToBeClickable(objLogout.personIcon));
                        log.info("Clicking on the Person Icon");
                        act.moveToElement(objLogout.personIcon).click().build().perform();
                        log.info("Person Icon has clicked");
                        log.info("Waiting till the Logout is display");
                        wait.until(ExpectedConditions.visibilityOf(objLogout.logOut));
                        if (objLogout.logOut.isDisplayed()) {
                            if (objLogout.logOut.isEnabled()) {
                                try {
                                    log.info("Waiting till the Logout is click");
                                    wait.until(ExpectedConditions.elementToBeClickable(objLogout.logOut));
                                    log.info("Clicking on the Logout");
                                    act.moveToElement(objLogout.logOut).click().build().perform();
                                    log.info("Logout has clicked");
                                    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                                    Thread.sleep(5000);
                                } catch (Exception e) {
                                    log.info("Logout has not clicked.  But it displayed the Exception as " + e.getMessage());
                                    test.fail("Logout has not clicked.  But it displayed the Exception as " + e.getMessage());
                                }
                            } else {
                                log.info("Logout has not enabled to click");
                                test.fail("Logout has not enabled to click");
                            }
                        }
                    } catch (Exception e) {
                        log.info("Person icon has not clicked.  But it displayed the Exception as " + e.getMessage());
                        test.fail("Person icon has not clicked.  But it displayed the Exception as " + e.getMessage());
                    }
                } else {
                    log.info("Person Icon has not enabled to click");
                    test.fail("Person Icon has not enabled to click");
                }
            } else {
                test.fail("Person Icon has not displayed");
                log.info("Person Icon has not displayed");
            }
        }catch (Exception ex){
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/logoutProcess.jpeg"));
            log.info(ex.toString());
            test.fail(ex.toString());
            ex.printStackTrace();
            test.info("Here, the screenshot has been attached.\n",MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/logoutProcess.jpeg").build());
        }
    }




}
