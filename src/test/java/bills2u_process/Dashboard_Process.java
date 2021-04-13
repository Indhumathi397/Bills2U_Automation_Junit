package bills2u_process;

import bills2u_constant.Obj_Rep_Dashboard;
import bills2u_constant.Obj_Rep_Menu;
import bills2u_root.Root_Class_TestNG;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class Dashboard_Process extends Root_Class_TestNG {

    public static void ClickDashboardMenu() throws IOException {

        try {
            Obj_Rep_Menu menu = new Obj_Rep_Menu();
            PageFactory.initElements(driver, menu);
            menu.menuDashboard.click();
            Thread.sleep(10000);

            Obj_Rep_Dashboard dashboard = new Obj_Rep_Dashboard();
            PageFactory.initElements(driver, dashboard);
            if (dashboard.txtDashBoard.getText().contains("Dashboard")) {
                test.pass("Biller able to view the Dashboard page");
            } else {
                test.fail("Biller not able to view the Dashboard page");
            }
            Thread.sleep(3000);
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickDashboardMenu.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickDashboardMenu.jpeg").build());
        }
    }

    public static void DashFromDate()  throws IOException {
        try {
            getTestData();
            Obj_Rep_Dashboard dashboard = new Obj_Rep_Dashboard();
            PageFactory.initElements(driver, dashboard);
            dashboard.dashFromDate.click();
            Thread.sleep(1000);
            WebElement yearSelect = driver.findElement(By.xpath("/html/body/app-root/div/div[2]/div[2]/div/mat-datepicker-content/mat-calendar/mat-calendar-header/div/div/button[1]"));
            yearSelect.click();
            Thread.sleep(1000);
            WebElement chooseYear = driver.findElement(By.cssSelector("td[aria-label='"
                    + prop.getProperty("Bills2U.Dashboard.FromDate.Year") + "']"));
            chooseYear.click();
            Thread.sleep(1000);
            WebElement chooseMonth = driver.findElement(By.cssSelector("td[aria-label='01-"
                    + prop.getProperty("Bills2U.Dashboard.FromDate.Month") + "-"
                    + prop.getProperty("Bills2U.Dashboard.FromDate.Year") + "']"));
            chooseMonth.click();
            Thread.sleep(1000);
            WebElement chooseDay = driver.findElement(By.cssSelector("td[aria-label='"
                    + prop.getProperty("Bills2U.Dashboard.FromDate.Day") + "-"
                    + prop.getProperty("Bills2U.Dashboard.FromDate.Month") + "-"
                    + prop.getProperty("Bills2U.Dashboard.FromDate.Year")
                    + "']"));
            chooseDay.click();

            Thread.sleep(1000);
            if (dashboard.dashFromDate.isDisplayed() && dashboard.dashFromDate.getAttribute("value").equals(
                    prop.getProperty("Bills2U.Dashboard.FromDate.Day") +
                            "-" +
                            prop.getProperty("Bills2U.Dashboard.FromDate.Month") +
                            "-" +
                            prop.getProperty("Bills2U.Dashboard.FromDate.Year"))) {
                test.pass("Biller able to select the From Date");
                Thread.sleep(3000);
            } else {
                test.fail("Biller not able to select the From Date");
            }
            Thread.sleep(3000);
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/DashFromDate.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/DashFromDate.jpeg").build());
        }
    }

    public static void DashToDate()  throws IOException {
        try {
            getTestData();
            Obj_Rep_Dashboard dashboard = new Obj_Rep_Dashboard();
            PageFactory.initElements(driver, dashboard);
            dashboard.dashToDate.click();
            Thread.sleep(1000);
            WebElement yearSelect = driver.findElement(By.xpath("/html/body/app-root/div/div[2]/div[2]/div/mat-datepicker-content/mat-calendar/mat-calendar-header/div/div/button[1]"));
            yearSelect.click();
            Thread.sleep(1000);
            WebElement chooseYear = driver.findElement(By.cssSelector("td[aria-label='"
                    + prop.getProperty("Bills2U.Dashboard.ToDate.Year") + "']"));
            chooseYear.click();
            Thread.sleep(1000);
            WebElement chooseMonth = driver.findElement(By.cssSelector("td[aria-label='01-"
                    + prop.getProperty("Bills2U.Dashboard.ToDate.Month") + "-"
                    + prop.getProperty("Bills2U.Dashboard.ToDate.Year") + "']"));
            chooseMonth.click();
            Thread.sleep(1000);
            WebElement chooseDay = driver.findElement(By.cssSelector("td[aria-label='"
                    + prop.getProperty("Bills2U.Dashboard.ToDate.Day") + "-"
                    + prop.getProperty("Bills2U.Dashboard.ToDate.Month") + "-"
                    + prop.getProperty("Bills2U.Dashboard.ToDate.Year")
                    + "']"));
            chooseDay.click();

            Thread.sleep(10000);
            if (dashboard.dashToDate.isDisplayed() && dashboard.dashToDate.getAttribute("value").equals(
                    prop.getProperty("Bills2U.Dashboard.ToDate.Day") +
                            "-" +
                            prop.getProperty("Bills2U.Dashboard.ToDate.Month") +
                            "-" +
                            prop.getProperty("Bills2U.Dashboard.ToDate.Year"))) {
                test.pass("Biller able to select the To Date");
                Thread.sleep(3000);
            } else {
                test.fail("Biller not able to select the To Date");
            }
            Thread.sleep(5000);
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/DashToDate.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/DashToDate.jpeg").build());
        }
    }

    public static void VerifyInvoiceCount()  throws IOException {
        try {
            getTestData();
            Obj_Rep_Dashboard dashboard = new Obj_Rep_Dashboard();
            PageFactory.initElements(driver, dashboard);
            if (dashboard.dInvoiceCountPaid.getText().contains(prop.getProperty("Bills2U.Dashboard.InvoiceCount.Paid"))
                    && dashboard.dInvoiceCountUnPaid.getText().contains(prop.getProperty("Bills2U.Dashboard.InvoiceCount.UnPaid"))
                    && dashboard.dInvoiceCountOverDue.getText().contains(prop.getProperty("Bills2U.Dashboard.InvoiceCount.OverDue"))) {
                test.pass("Biller able to view the updated Invoice Count  Chart based on filter action");

            } else {
                test.fail("Biller not able to view the updated Invoice Count  Chart based on filter action");
            }
            Thread.sleep(3000);
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyInvoiceCount.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyInvoiceCount.jpeg").build());
        }

    }

    public static void VerifyOutStandingAmount()  throws IOException {
        try {
            getTestData();
            Obj_Rep_Dashboard dashboard = new Obj_Rep_Dashboard();
            PageFactory.initElements(driver, dashboard);
            if (dashboard.dOutstandAmtPaid.getText().contains(prop.getProperty("Bills2U.Dashboard.OutstandingAmt.Paid"))
                    && dashboard.dOutstandAmtUnPaid.getText().contains(prop.getProperty("Bills2U.Dashboard.OutstandingAmt.UnPaid"))
                    && dashboard.dOutstandAmtOverDue.getText().contains(prop.getProperty("Bills2U.Dashboard.OutstandingAmt.OverDue"))) {
                test.pass("Biller able to view the updated Invoice Outstanding Amount  Chart based on filter action");
                Thread.sleep(3000);
            } else {
                test.fail("Biller not able to view the updated Outstanding Amount Trend Chart based on filter action");
            }
            Thread.sleep(3000);
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyOutStandingAmount.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyOutStandingAmount.jpeg").build());
        }

    }

    public static void VerifyInvoiceAgingTrend()  throws IOException {
        try {
            Obj_Rep_Dashboard dashboard = new Obj_Rep_Dashboard();
            PageFactory.initElements(driver, dashboard);
            if (dashboard.dAgeTrendVerify.isDisplayed()) {
                test.pass("Biller able to view the updated Invoice Aging Trend Chart based on filter action");
                Thread.sleep(3000);
            } else {
                test.fail("Biller not able to view the updated Invoice Aging Trend Chart based on filter action");
            }
            Thread.sleep(3000);
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyInvoiceAgingTrend.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyInvoiceAgingTrend.jpeg").build());
        }

    }

    public static void VerifyPaymentTrend()  throws IOException {
        try {
            getTestData();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Obj_Rep_Dashboard dashboard = new Obj_Rep_Dashboard();
            PageFactory.initElements(driver, dashboard);
            js.executeScript("arguments[0].scrollIntoView();", dashboard.dPayTrendReceivableAsOfFrom);
            Thread.sleep(3000);

            if (dashboard.dPayTrendReceivableAsOfFrom.getText().contains(prop.getProperty("Bills2U.Dashboard.BatchFilter.PayTrend.ReceivableFrom"))
                    && dashboard.dPayTrendOverDueAsOfFrom.getText().contains(prop.getProperty("Bills2U.Dashboard.BatchFilter.PayTrend.OverDueFrom"))
                    && dashboard.dPayTrendTotalCollectedBtw.getText().contains(prop.getProperty("Bills2U.Dashboard.BatchFilter.PayTrend.TotalCollected"))
                    && dashboard.dPayTrendReceivableAsOfTo.getText().contains(prop.getProperty("Bills2U.Dashboard.BatchFilter.PayTrend.ReceivableTo"))
                    && dashboard.dPayTrendOverDueAsOfTo.getText().contains(prop.getProperty("Bills2U.Dashboard.BatchFilter.PayTrend.OverDueTo"))
            ) {
                test.pass("Biller able to view the Updated Payment Trend Chart");
                Thread.sleep(3000);
            } else {
                test.fail("Biller not able to view the Updated Payment Trend Chart");
            }
            Thread.sleep(3000);
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyPaymentTrend.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyPaymentTrend.jpeg").build());
        }

    }

    public static void ClickBatchNameSelect()  throws IOException {
        try {

            Obj_Rep_Dashboard dashboard = new Obj_Rep_Dashboard();
            PageFactory.initElements(driver, dashboard);
            dashboard.dBatchSelect.click();
            WebElement chooseSelectAll = driver.findElement(By.xpath("//mat-option/span[contains(.,'Select All')]"));
            chooseSelectAll.click();
            Thread.sleep(3000);
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickBatchNameSelect.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickBatchNameSelect.jpeg").build());
        }

    }

    public static void EnterBatchNameInSearch()  throws IOException {
        try {
            getTestData();
            Obj_Rep_Dashboard dashboard = new Obj_Rep_Dashboard();
            PageFactory.initElements(driver, dashboard);
            dashboard.dBatchSearchFilter.sendKeys(prop.getProperty("Bills2U.Dashboard.BatchNameSelectFilter.Data1"));
            Thread.sleep(7000);
            if (dashboard.dBatchSearchFilter.getAttribute("value").contains(prop.getProperty("Bills2U.Dashboard.BatchNameSelectFilter.Data1"))) {
                test.pass("Biller able to enter the data in search field");
            } else {
                test.fail("Biller not able to enter the data in search field");
            }
            dashboard.dBatchSearchFilterClose.click();
            Thread.sleep(3000);
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/EnterBatchNameInSearch.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/EnterBatchNameInSearch.jpeg").build());
        }

    }

    public static void SelectBatchName()  throws IOException {
        try {
            getTestData();
            Obj_Rep_Dashboard dashboard = new Obj_Rep_Dashboard();
            PageFactory.initElements(driver, dashboard);
            WebElement chooseData1 = driver.findElement(By.xpath("//mat-option/span[contains(.,'" + prop.getProperty("Bills2U.Dashboard.BatchNameSelectFilter.Data1") + "')]"));
            chooseData1.click();
            Thread.sleep(5000);
            WebElement chooseData2 = driver.findElement(By.xpath("//mat-option/span[contains(.,'" + prop.getProperty("Bills2U.Dashboard.BatchNameSelectFilter.Data2") + "')]"));
            chooseData2.click();
            Thread.sleep(5000);
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ESCAPE).build().perform();
            if (dashboard.dBatchSelect.getText().contains(prop.getProperty("Bills2U.Dashboard.BatchNameSelectFilter.Data1"))
                    && dashboard.dBatchSelect.getText().contains(prop.getProperty("Bills2U.Dashboard.BatchNameSelectFilter.Data2"))) {
                test.pass("Biller able to select the batch Option should be selected");
            } else {
                test.fail("Biller not able to select the batch Option should be selected");
            }
            Thread.sleep(3000);
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/SelectBatchName.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/SelectBatchName.jpeg").build());
        }

    }

    public static void VerifyUpdatedData()  throws IOException {
        try {
            getTestData();
            Obj_Rep_Dashboard dashboard = new Obj_Rep_Dashboard();
            PageFactory.initElements(driver, dashboard);

            if (dashboard.dInvoiceCountPaid.getText().contains(prop.getProperty("Bills2U.Dashboard.BatchFilter.InvoiceCount.Paid"))
                    && dashboard.dInvoiceCountUnPaid.getText().contains(prop.getProperty("Bills2U.Dashboard.BatchFilter.InvoiceCount.UnPaid"))
                    && dashboard.dInvoiceCountOverDue.getText().contains(prop.getProperty("Bills2U.Dashboard.BatchFilter.InvoiceCount.OverDue"))
                    && dashboard.dOutstandAmtPaid.getText().contains(prop.getProperty("Bills2U.Dashboard.BatchFilter.OutstandingAmt.Paid"))
                    && dashboard.dOutstandAmtUnPaid.getText().contains(prop.getProperty("Bills2U.Dashboard.BatchFilter.OutstandingAmt.UnPaid"))
                    && dashboard.dOutstandAmtOverDue.getText().contains(prop.getProperty("Bills2U.Dashboard.BatchFilter.OutstandingAmt.OverDue"))) {
                test.pass("Biller able to View the updated chart based upon Selected batches");
            } else {
                test.fail("Biller not able to View the updated chart based upon Selected batches");
            }
            Thread.sleep(3000);
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyUpdatedData.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyUpdatedData.jpeg").build());
        }

    }

    public static void TxtPTrendReceiveToDate()  throws IOException {
        try {
            getTestData();
            Obj_Rep_Dashboard dashboard = new Obj_Rep_Dashboard();
            PageFactory.initElements(driver, dashboard);
            if (dashboard.dPayTrendReceivableAsOfToDate.getText().contains(prop.getProperty("Bills2U.Dashboard.PayTrend.ReceivableToDate"))) {
                test.pass("Biller able to view the To date's Unpaid amount");
            } else {
                test.fail("Biller not able to view the To date's Unpaid amount");
            }
            Thread.sleep(3000);
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/TxtPTrendReceiveToDate.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/TxtPTrendReceiveToDate.jpeg").build());
        }

    }

    public static void TxtPTrendOverDueToAmt()  throws IOException {
        try {
            getTestData();
            Obj_Rep_Dashboard dashboard = new Obj_Rep_Dashboard();
            PageFactory.initElements(driver, dashboard);
            if (dashboard.dPayTrendOverDueAsOfToDate.getText().contains(prop.getProperty("Bills2U.Dashboard.PayTrend.OverDueToDate"))) {
                test.pass("Biller able to view the To date's Overdue amount");
            } else {
                test.fail("Biller not able to view the To date's Overdue amount");
            }
            Thread.sleep(3000);
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/TxtPTrendOverDueToAmt.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/TxtPTrendOverDueToAmt.jpeg").build());
        }

    }

    public static void TxtPTrendTotalCollected()  throws IOException {
        try {
            getTestData();
            Obj_Rep_Dashboard dashboard = new Obj_Rep_Dashboard();
            PageFactory.initElements(driver, dashboard);
            if (dashboard.dPayTrendTotalCollectedBtwDate.getText().contains(prop.getProperty("Bills2U.Dashboard.PayTrend.TotalCollectedDate"))) {
                test.pass("Biller able to view the Paid amount between selected From and To date");
            } else {
                test.fail("Biller not able to view the Paid amount between selected From and To date");
            }
            Thread.sleep(3000);
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/TxtPTrendTotalCollected.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/TxtPTrendTotalCollected.jpeg").build());
        }

    }

    public static void TxtPTrendReceiveFromDate()  throws IOException {
        try {
            getTestData();
            Thread.sleep(10000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Obj_Rep_Dashboard dashboard = new Obj_Rep_Dashboard();
            PageFactory.initElements(driver, dashboard);
            js.executeScript("arguments[0].scrollIntoView();", dashboard.dPayTrendReceivableAsOfFrom);
            Thread.sleep(3000);

            if (dashboard.dPayTrendReceivableAsOfFromDate.getText().contains(prop.getProperty("Bills2U.Dashboard.PayTrend.ReceivableFromDate"))) {
                test.pass("Biller able to view the From date's Unpaid amount");
            } else {
                test.fail("Biller not able to view the From date's Unpaid amount");
            }
            Thread.sleep(3000);
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/TxtPTrendReceiveFromDate.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/TxtPTrendReceiveFromDate.jpeg").build());
        }

    }

    public static void TxtPTrendOverDueFromAmt() throws IOException {
        try {
            getTestData();
            Obj_Rep_Dashboard dashboard = new Obj_Rep_Dashboard();
            PageFactory.initElements(driver, dashboard);
            if (dashboard.dPayTrendOverDueAsOfFromDate.getText().contains(prop.getProperty("Bills2U.Dashboard.PayTrend.OverDueFromDate"))) {
                test.pass("Biller able to view the From date's Overdue amount");
            } else {
                test.fail("Biller not able to view the From date's Overdue amount");
            }Thread.sleep(3000);
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/TxtPTrendOverDueFromAmt.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/TxtPTrendOverDueFromAmt.jpeg").build());
        }

    }

}
