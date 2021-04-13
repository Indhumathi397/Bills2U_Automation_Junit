package bills2u_root;

import Config.PropertyClass;
import bills2u_suite.Invoices_Payers_Page;
import bills2u_suite.Payments_Payer_Page;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.cli.*;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Root_Class_Payers {

    public static WebDriver driver;

    public static Logger log = Logger.getLogger(Root_Class_TestNG.class.getName());

    public static ExtentReports reportPayer;
    public static ExtentTest testPayer;
    @SuppressWarnings("deprecation")
    public static ExtentHtmlReporter htmlReportPayer;

    public static String reportDir;
    public static String billersUrl;
    public static String screenShotDir;
    public static String billersUsername;
    public static String billersPassword;
    public static String logDir;
    public static String inDir;

    public static Properties prop = null;

    public static void main(String[] args) throws InterruptedException, IOException {
        StopWatch watch = new StopWatch();
        watch.start();

       Options options = new Options();

        Option reportDirOption = new Option("rd", "ReportDir", true, "HTML REPORT DIRECTORY");
        reportDirOption.setRequired(true);
        options.addOption(reportDirOption);

        Option screenshotDirOption = new Option("sd", "ScreenShotDir", true, "SCREENSHOT DIRECTORY");
        screenshotDirOption.setRequired(true);
        options.addOption(screenshotDirOption);

        Option inDirOption=new Option("in","InputDir",true,"INPUT DIRECTORY");
        inDirOption.setRequired(true);
        options.addOption(inDirOption);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter help = new HelpFormatter();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            help.printHelp("utility-name", options);
            System.exit(1);
        }

        reportDir = cmd.getOptionValue("ReportDir");
        billersUrl = cmd.getOptionValue("BillersURL");
        screenShotDir = cmd.getOptionValue("ScreenShotDir");
        billersUsername = cmd.getOptionValue("BillersUser");
        billersPassword = cmd.getOptionValue("BillersPass");
        logDir=cmd.getOptionValue("ChromeLog");
        inDir=cmd.getOptionValue("InputDir");

        reportPayer = new ExtentReports();
        htmlReportPayer = new ExtentHtmlReporter(reportDir + "/RinggitPay_PayerSite_Automation_Report.html");
        htmlReportPayer.config().setDocumentTitle("Automation Test Report");
        htmlReportPayer.config().setReportName("Bills2U Automation Test Report");
        htmlReportPayer.config().setTheme(Theme.DARK);
        reportPayer.attachReporter(htmlReportPayer);
        reportPayer.setSystemInfo("Automation Tester", "Indhumathi & Rahul");
        reportPayer.setSystemInfo("Project Name", "Bills2U");
        reportPayer.setSystemInfo("OS", "Windows10");

        initProcess();

        new Invoices_Payers_Page()
                .TC_IN_001()
                .TC_IN_002()
                .TC_IN_003()
                .TC_IN_004()
                .TC_IN_005()
                .TC_IN_006()
               .TC_IN_007()
                 .TC_IN_008()
                .TC_IN_009()
                .TC_IN_010()
                .TC_IN_011()
                .TC_IN_012()
                .TC_IN_013()
                .TC_IN_014()
                .TC_IN_015()
                .TC_IN_016()
                .TC_IN_017()
                .TC_IN_018()
                .TC_IN_019()
                .TC_IN_020()
                .TC_IN_021()
                .TC_IN_022()
                .TC_IN_023()
                .TC_IN_024()
                .TC_IN_025();
        new Payments_Payer_Page()
                .TC_Pay_001()
                .TC_Pay_002()
                .TC_Pay_003()
                .TC_Pay_004()
                .TC_Pay_005()
                .TC_Pay_006()
                .TC_Pay_007()
                .TC_Pay_008()
                .TC_Pay_009()
                .TC_Pay_010()
                .TC_Pay_011()
                .TC_Pay_012()
                .TC_Pay_013()
                .TC_Pay_014()
                .TC_Pay_015()
                .TC_Pay_016()
                .TC_Pay_017()
                .TC_Pay_018()
                .TC_Pay_019()
                .TC_Pay_020()
                .TC_Pay_021()
                .TC_Pay_022();


        exitProcess();
        reportPayer.flush();
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

    public static void initProcess() throws IOException {
        DOMConfigurator.configure("log4j.xml");
        getTestData();
        log.info("Opening Chrome browser");
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(screenShotDir + "/Open_Browser.jpeg"));
            log.info("Chrome browser has launched");
        } catch (Exception ex) {
            log.info("Chrome browser has not opened, but it displayed the Exception as...\n" + ex.getMessage());
        }
        log.info("Navigating to Billers portal");
        try {
            driver.get(prop.getProperty("Bills2U.payersUrl"));
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
    }

}
