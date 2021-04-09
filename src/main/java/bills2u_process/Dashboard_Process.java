package bills2u_process;

import bills2u_constant.Obj_Rep_Dashboard;
import bills2u_constant.Obj_Rep_Menu;
import bills2u_root.Root_Class;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Dashboard_Process extends Root_Class {

    public static void ClickDashboardMenu() {

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
            test.fail(e.getMessage());
        }
    }

    public static void DashFromDate() {
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
            test.fail(e.getMessage());
        }
    }

    public static void DashToDate() {
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
            test.fail(e.getMessage());
        }
    }

    public static void VerifyInvoiceCount() {
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
            test.fail(e.getMessage());
        }

    }

    public static void VerifyOutStandingAmount() {
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
            test.fail(e.getMessage());
        }

    }

    public static void VerifyInvoiceAgingTrend() {
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
            test.fail(e.getMessage());
        }

    }

    public static void VerifyPaymentTrend() {
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
            test.fail(e.getMessage());
        }

    }

    public static void ClickBatchNameSelect() {
        try {

            Obj_Rep_Dashboard dashboard = new Obj_Rep_Dashboard();
            PageFactory.initElements(driver, dashboard);
            dashboard.dBatchSelect.click();
            WebElement chooseSelectAll = driver.findElement(By.xpath("//mat-option/span[contains(.,'Select All')]"));
            chooseSelectAll.click();
            Thread.sleep(3000);
        } catch (Exception e) {
            test.fail(e.getMessage());
        }

    }

    public static void EnterBatchNameInSearch() {
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
            test.fail(e.getMessage());
        }

    }

    public static void SelectBatchName() {
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
            test.fail(e.getMessage());
        }

    }

    public static void VerifyUpdatedData() {
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
            test.fail(e.getMessage());
        }

    }

    public static void TxtPTrendReceiveToDate() {
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
            test.fail(e.getMessage());
        }

    }

    public static void TxtPTrendOverDueToAmt() {
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
            test.fail(e.getMessage());
        }

    }

    public static void TxtPTrendTotalCollected() {
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
            test.fail(e.getMessage());
        }

    }

    public static void TxtPTrendReceiveFromDate() {
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
            test.fail(e.getMessage());
        }

    }

    public static void TxtPTrendOverDueFromAmt() {
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
            test.fail(e.getMessage());
        }

    }

}
