package bills2u_process;

import bills2u_constant.Obj_Rep_InvoiceBatchList;
import bills2u_constant.Obj_Rep_Menu;
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
import java.util.Objects;

public class Invoice_Batch_List_Process extends Root_Class_TestNG {

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

    public static void ClickShowFilter() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(bList.lnkShowFilter));
            bList.lnkShowFilter.click();
            Thread.sleep(2000);
            if (bList.txtInvoiceBatchList.isDisplayed() && bList.txtInvoiceBatchList.getText().equals("Invoice Batch List")) {
                test.pass("Biller able to view to the \"Filters\"");
            } else {
                test.fail("Biller not able to view to the \"Filters\"");
            }
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickShowFilter.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickShowFilter.jpeg").build());
        }


    }

    public static void SelectFromDate() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            bList.dateFrom.click();
            Thread.sleep(1000);
            WebElement yearSelect = driver.findElement(By.xpath("/html/body/app-root/div/div[2]/div[2]/div/mat-datepicker-content/mat-calendar/mat-calendar-header/div/div/button[1]"));
            yearSelect.click();
            Thread.sleep(1000);
            WebElement chooseYear = driver.findElement(By.cssSelector("td[aria-label='2019']"));
            chooseYear.click();
            Thread.sleep(1000);
            WebElement chooseMonth = driver.findElement(By.cssSelector("td[aria-label='01-03-2019']"));
            chooseMonth.click();
            Thread.sleep(1000);
            WebElement chooseDay = driver.findElement(By.cssSelector("td[aria-label='01-03-2019']"));
            chooseDay.click();

            Thread.sleep(1000);
            if (bList.dateFrom.isDisplayed() && bList.dateFrom.getAttribute("value").equals("01-03-2019")) {
                test.pass("Biller able to select the \"From date\" by using calender pop up");
            } else {
                test.fail("Biller not able to select the \"From date\" by using calender pop up");
            }
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/SelectFromDate.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/SelectFromDate.jpeg").build());
        }


    }

    public static void SelectToDate() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            bList.dateTo.click();
            Thread.sleep(1000);
            WebElement yearSelect = driver.findElement(By.xpath("/html/body/app-root/div/div[2]/div[2]/div/mat-datepicker-content/mat-calendar/mat-calendar-header/div/div/button[1]"));
            yearSelect.click();
            Thread.sleep(1000);
            WebElement chooseYear = driver.findElement(By.cssSelector("td[aria-label='2021']"));
            chooseYear.click();
            Thread.sleep(1000);
            WebElement chooseMonth = driver.findElement(By.cssSelector("td[aria-label='01-03-2021']"));
            chooseMonth.click();
            Thread.sleep(1000);
            WebElement chooseDay = driver.findElement(By.cssSelector("td[aria-label='05-03-2021']"));
            chooseDay.click();

            Thread.sleep(1000);
            if (bList.dateTo.isDisplayed() && bList.dateTo.getAttribute("value").equals("05-03-2021")) {
                test.pass("Biller able to select the \"To date\" by using calender pop up");
            } else {
                test.fail("Biller not able to select the \"To date\" by using calender pop up");
            }
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/SelectToDate.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/SelectToDate.jpeg").build());
        }


    }

    public static void ClickStatusInInvoiceBatchList() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            bList.selectStatus.click();
            Thread.sleep(1000);
            if (Boolean.parseBoolean(bList.selectStatus.getAttribute("aria-expanded"))) {
                test.pass("Biller able to view the \"Invoice batch Status list\"in drop down");
            } else {
                test.fail("Biller not able to view the \"Invoice batch Status list\"in drop down");
            }
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickStatusInInvoiceBatchList.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickStatusInInvoiceBatchList.jpeg").build());
        }


    }

    public static void ClickPublishStatusInInvoiceBatchList() throws IOException {
        try {
            WebElement choosePublished = driver.findElement(By.xpath("//mat-option/span[contains(.,'PUBLISHED')]"));
            WebElement chooseStopped = driver.findElement(By.xpath("//mat-option/span[contains(.,'STOPPED')]"));
            WebElement chooseDraft = driver.findElement(By.xpath("//mat-option/span[contains(.,'DRAFT')]"));
            if (choosePublished.getAttribute("checked") != null) {
                choosePublished.click();
            }
            if (chooseStopped.getAttribute("checked") == null) {
                chooseStopped.click();
            }
            if (chooseDraft.getAttribute("checked") == null) {
                chooseDraft.click();
            }

            Thread.sleep(1000);
            if (choosePublished.getAttribute("checked") == null) {
                test.pass("Biller able to select the the \"PUBLISHED\" status in dropdown");
            } else {
                test.fail("Biller not able to select the the \"PUBLISHED\" status in dropdown");
            }
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ESCAPE).build().perform();
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickPublishStatusInInvoiceBatchList.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickPublishStatusInInvoiceBatchList.jpeg").build());
        }


    }

    public static void ClickStoppedStatusInInvoiceBatchList() throws IOException {
        try {
            WebElement choosePublished = driver.findElement(By.xpath("//mat-option/span[contains(.,'PUBLISHED')]"));
            WebElement chooseStopped = driver.findElement(By.xpath("//mat-option/span[contains(.,'STOPPED')]"));
            WebElement chooseDraft = driver.findElement(By.xpath("//mat-option/span[contains(.,'DRAFT')]"));
            if (choosePublished.getAttribute("checked") == null) {
                choosePublished.click();
            }
            if (chooseStopped.getAttribute("checked") != null) {
                chooseStopped.click();
            }
            if (chooseDraft.getAttribute("checked") == null) {
                chooseDraft.click();
            }

            Thread.sleep(1000);
            if (chooseStopped.getAttribute("checked") == null) {
                test.pass("Biller able to select the the \"STOPPED\" status in dropdown");
            } else {
                test.fail("Biller not able to select the the \"STOPPED\" status in dropdown");
            }
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ESCAPE).build().perform();
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickStoppedStatusInInvoiceBatchList.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickStoppedStatusInInvoiceBatchList.jpeg").build());
        }


    }

    public static void ClickDraftStatusInInvoiceBatchList() throws IOException {
        try {
            WebElement choosePublished = driver.findElement(By.xpath("//mat-option/span[contains(.,'PUBLISHED')]"));
            WebElement chooseStopped = driver.findElement(By.xpath("//mat-option/span[contains(.,'STOPPED')]"));
            WebElement chooseDraft = driver.findElement(By.xpath("//mat-option/span[contains(.,'DRAFT')]"));
            if (choosePublished.getAttribute("checked") == null) {
                choosePublished.click();
            }
            if (chooseStopped.getAttribute("checked") == null) {
                chooseStopped.click();
            }
            if (chooseDraft.getAttribute("checked") != null) {
                chooseDraft.click();
            }

            Thread.sleep(1000);
            if (chooseDraft.getAttribute("checked") == null) {
                test.pass("Biller able to select the the \"DRAFT\" status in dropdown");
            } else {
                test.fail("Biller not able to select the the \"DRAFT\" status in dropdown");
            }
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ESCAPE).build().perform();
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickDraftStatusInInvoiceBatchList.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickDraftStatusInInvoiceBatchList.jpeg").build());
        }

    }

    public static void ClickSearchFilterPInvoiceBatchList() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            Thread.sleep(1000);
            bList.btnBListSearchFilter.click();
            Thread.sleep(10000);

            for (int i = 1; i <= 3; i++) {
                if (driver.findElement(By.xpath("//*[@id=\"main-content\"]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[" + i + "]/mat-cell[6]")).getText() != null
                        && driver.findElement(By.xpath("//*[@id=\"main-content\"]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[" + i + "]/mat-cell[6]")).getText().equals("PUBLISHED")) {
                    test.pass("Biller able to filter and view the \"Invoice batch list\" by invoice batch");
                } else {
                    test.fail("Biller not able to filter and view the \"Invoice batch list\" by invoice batch");

                }
            }
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickSearchFilterPInvoiceBatchList.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickSearchFilterPInvoiceBatchList.jpeg").build());
        }


    }

    public static void ClickSearchFilterSInvoiceBatchList() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            Thread.sleep(1000);
            bList.btnBListSearchFilter.click();
            Thread.sleep(10000);

            for (int i = 1; i <= 3; i++) {

                try {
                    if (driver.findElement(By.xpath("//*[@id=\"main-content\"]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[" + i + "]/mat-cell[6]")).getText() != null
                            && driver.findElement(By.xpath("//*[@id=\"main-content\"]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[" + i + "]/mat-cell[6]")).getText().equals("STOPPED")) {

                        test.info("Till now, " + (i - 1) + " records has displayed");
                        test.pass("Biller able to filter and view the \"Invoice batch list\" by invoice batch");
                    } else {
                        test.info("Till now, " + (i - 1) + " records has displayed");
                        test.fail("Biller not able to filter and view the \"Invoice batch list\" by invoice batch");
                    }

                } catch (Exception e) {
                    test.fail(e.getMessage());
                }

            }

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickSearchFilterSInvoiceBatchList.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickSearchFilterSInvoiceBatchList.jpeg").build());
        }


    }

    public static void ClickSearchFilterDInvoiceBatchList() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            Thread.sleep(1000);
            bList.btnBListSearchFilter.click();
            Thread.sleep(10000);

            for (int i = 1; i <= 3; i++) {
                if (driver.findElement(By.xpath("//*[@id=\"main-content\"]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[" + i + "]/mat-cell[6]")).getText() != null
                        && driver.findElement(By.xpath("//*[@id=\"main-content\"]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[" + i + "]/mat-cell[6]")).getText().equals("DRAFT")) {
                    test.pass("Biller able to filter and view the \"Invoice batch list\" by invoice batch");
                } else {
                    test.fail("Biller not able to filter and view the \"Invoice batch list\" by invoice batch");

                }
            }
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickSearchFilterDInvoiceBatchList.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickSearchFilterDInvoiceBatchList.jpeg").build());
        }


    }

    public static void ClickSearchFilterInvoiceBatchList() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            Thread.sleep(1000);
            bList.btnBListSearchFilter.click();
            Thread.sleep(10000);

            if (driver.findElement(By.xpath("//*[@id=\"main-content\"]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[1]"))
                    .isDisplayed()) {
                test.pass("Biller able to filter and view the \"Invoice batch list\" by respective \"From and to date\"");
            } else {
                test.fail("Biller not able to filter and view the \"Invoice batch list\" by respective \"From and to date\"");

            }

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickSearchFilterInvoiceBatchList.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickSearchFilterInvoiceBatchList.jpeg").build());
        }


    }

    public static void FindFilterInvoiceBatch(String data) throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            bList.iptFindFilter.clear();
            bList.iptFindFilter.sendKeys(data);
            Thread.sleep(7000);

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/FindFilterInvoiceBatch.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/FindFilterInvoiceBatch.jpeg").build());
        }


    }

    public static void ColumnFilterBatchName() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            bList.clmFilterBatchName.sendKeys("RPINVB-RPM-3-28-09-2020-6");
            Thread.sleep(3000);
            VerifyColumnFilterBatchName("RPINVB-RPM-3-28-09-2020-6");

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterBatchName.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterBatchName.jpeg").build());
        }


    }

    public static void VerifyColumnFilterBatchName(String data) throws IOException {
        try {

            if (driver.findElement(By.xpath("//*[@id=\"main-content\"]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[1]"))
                    .getText().equals(data)) {
                test.pass("Biller able to view the filtered Invoice batch list by respective entered \"Batch Name\"");
            } else {
                test.fail("Biller not able to view the filtered Invoice batch list by respective entered \"Batch Name\"");

            }

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyColumnFilterBatchName.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyColumnFilterBatchName.jpeg").build());
        }


    }

    public static void ColumnFilterBatchAmount() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            bList.clmFilterBatchAmount.sendKeys("MYR 41,695.00");
            Thread.sleep(3000);

            VerifyColumnFilterBatchAmount("MYR 41,695.00");

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterBatchAmount.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterBatchAmount.jpeg").build());
        }


    }

    public static void VerifyColumnFilterBatchAmount(String data) throws IOException {
        try {

            if (driver.findElement(By.xpath("//*[@id=\"main-content\"]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[2]"))
                    .getText().equals(data)) {
                test.pass("Biller able to view the filtered Invoice batch list by respective entered \"Batch Amount\"");
            } else {
                test.fail("Biller not able to view the filtered Invoice batch list by respective entered \"Batch Amount\"");

            }

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyColumnFilterBatchAmount.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyColumnFilterBatchAmount.jpeg").build());
        }


    }

    public static void ColumnFilterOverDue() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            bList.clmFilterOverDue.sendKeys("MYR 41,695.00");
            Thread.sleep(3000);

            VerifyColumnFilterOverDue("MYR 41,695.00");

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterOverDue.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterOverDue.jpeg").build());
        }


    }

    public static void VerifyColumnFilterOverDue(String data) throws IOException {
        try {

            if (driver.findElement(By.xpath("//*[@id=\"main-content\"]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[3]"))
                    .getText().equals(data)) {
                test.pass("Biller able to view the filtered Invoice batch list by respective entered \"Over Due\"");
            } else {
                test.fail("Biller not able to view the filtered Invoice batch list by respective entered \"Over Due\"");

            }

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyColumnFilterOverDue.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyColumnFilterOverDue.jpeg").build());
        }


    }

    public static void ColumnFilterUnpaid() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            bList.clmFilterUnPaid.sendKeys("MYR 41,695.00");
            Thread.sleep(3000);

            VerifyColumnFilterUnpaid("MYR 41,695.00");

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterUnpaid.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterUnpaid.jpeg").build());
        }


    }

    public static void VerifyColumnFilterUnpaid(String data) throws IOException {
        try {

            if (driver.findElement(By.xpath("//*[@id=\"main-content\"]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[4]"))
                    .getText().equals(data)) {
                test.pass("Biller able to view the filtered Invoice batch list by respective entered \"Unpaid\"");
            } else {
                test.fail("Biller not able to view the filtered Invoice batch list by respective entered \"Unpaid\"");

            }

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyColumnFilterUnpaid.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyColumnFilterUnpaid.jpeg").build());
        }


    }

    public static void ColumnFilterPaid() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            bList.clmFilterPaid.sendKeys("MYR 250.00");
            Thread.sleep(3000);

            VerifyColumnFilterPaid("MYR 250.00");

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterPaid.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterPaid.jpeg").build());
        }


    }

    public static void VerifyColumnFilterPaid(String data) throws IOException {
        try {

            if (driver.findElement(By.xpath("//*[@id=\"main-content\"]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[5]"))
                    .getText().equals(data)) {
                test.pass("Biller able to view the filtered Invoice batch list by respective entered \"Paid\"");
            } else {
                test.fail("Biller not able to view the filtered Invoice batch list by respective entered \"Paid\"");

            }

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyColumnFilterPaid.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyColumnFilterPaid.jpeg").build());
        }


    }

    public static void ColumnStatusFilter() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            bList.clmStatusSelect.click();
            test.pass("Biller should be able to view the invoice status list in dropdown");
            Thread.sleep(2000);
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnStatusFilter.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnStatusFilter.jpeg").build());
        }


    }

    public static void ColumnStatusFilterPublished() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            bList.clmFilterPublished.click();
            Thread.sleep(3000);
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnStatusFilterPublished.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnStatusFilterPublished.jpeg").build());
        }


    }

    public static void ColumnFilterPublished() throws IOException {
        try {
            ColumnStatusFilter();
            ColumnStatusFilterPublished();
            if (driver.findElement(By.xpath("//*[@id=\"main-content\"]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[6]"))
                    .getText().equals("PUBLISHED")) {
                test.pass("Biller able to view the filtered Invoice batch list by respective entered \"Published\"");
            } else {
                test.fail("Biller not able to view the filtered Invoice batch list by respective entered \"Published\"");

            }
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterPublished.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterPublished.jpeg").build());
        }


    }

    public static void ColumnStatusFilterStopped() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            ColumnStatusFilter();
            bList.clmFilterStopped.click();
            Thread.sleep(3000);
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnStatusFilterStopped.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnStatusFilterStopped.jpeg").build());
        }


    }

    public static void ColumnFilterStopped() throws IOException {

        try {
            ColumnStatusFilterStopped();

            if (driver.findElement(By.xpath("//*[@id=\"main-content\"]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[6]"))
                    .getText().equals("STOPPED")) {
                test.pass("Biller able to view the filtered Invoice batch list by respective entered \"Stopped\"");
            } else {
                test.fail("Biller not able to view the filtered Invoice batch list by respective entered \"Stopped\"");

            }
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterStopped.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterStopped.jpeg").build());
        }



    }

    public static void ColumnStatusFilterDraftClick() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            ColumnStatusFilter();
            bList.clmFilterDraft.click();

            if (bList.rowDeleteButton.isEnabled()) {
                test.pass("Biller able to view the \"Delete icon\" in enabled mode");
            } else {
                test.fail("Biller able to view the \"Delete icon\" in disabled mode");
            }
            Thread.sleep(3000);
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnStatusFilterDraftClick.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnStatusFilterDraftClick.jpeg").build());
        }

    }

    public static void ColumnFilterDraft() throws IOException {

        try {
            ColumnStatusFilterDraftClick();

            if (driver.findElement(By.xpath("//*[@id=\"main-content\"]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[6]"))
                    .getText().equals("DRAFT")) {
                test.pass("Biller able to view the filtered Invoice batch list by respective entered \"Draft\"");
            } else {
                test.fail("Biller not able to view the filtered Invoice batch list by respective entered \"Draft\"");

            }
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterDraft.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterDraft.jpeg").build());
        }



    }

    public static void ColumnStatusFilterAll() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            ColumnStatusFilter();
            bList.clmFilterStatusAll.click();
            Thread.sleep(3000);
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnStatusFilterAll.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnStatusFilterAll.jpeg").build());
        }


    }

    public static void ColumnFilterALlOption() throws IOException {

        try {
            ColumnFilterBatchName();
            ColumnStatusFilterAll();

            if (driver.findElement(By.xpath("//*[@id=\"main-content\"]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[6]"))
                    .getText().equals("PUBLISHED")) {
                test.pass("Biller able to filter and view the \"all\" invoice batches");
            } else {
                test.fail("Biller not able to filter and view the \"all\" invoice batches");

            }
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterALlOption.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterALlOption.jpeg").build());
        }



    }

    public static void ColumnFilterCreatedOnDate() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            bList.clmFilterCreatedon.sendKeys("30-Nov-2020");
            Thread.sleep(3000);

            VerifyColumnFilterCreatedOnDate("30-Nov-2020");

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterCreatedOnDate.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterCreatedOnDate.jpeg").build());
        }


    }

    public static void VerifyColumnFilterCreatedOnDate(String data) throws IOException {
        try {

            if (driver.findElement(By.xpath("//*[@id=\"main-content\"]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[7]"))
                    .getText().contains(data)) {
                test.pass("Biller able to view the filtered Invoice batch list by respective entered \"Date\"");
            } else {
                test.fail("Biller not able to view the filtered Invoice batch list by respective entered \"Date\"");

            }

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyColumnFilterCreatedOnDate.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyColumnFilterCreatedOnDate.jpeg").build());
        }


    }

    public static void ColumnFilterCreatedOnTime() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            bList.clmFilterCreatedon.sendKeys("5:56:31 PM");
            Thread.sleep(3000);

            VerifyColumnFilterCreatedOnTime("5:56:31 PM");

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterCreatedOnTime.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterCreatedOnTime.jpeg").build());
        }


    }

    public static void VerifyColumnFilterCreatedOnTime(String data) throws IOException {
        try {

            if (driver.findElement(By.xpath("//*[@id=\"main-content\"]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[7]"))
                    .getText().contains(data)) {
                test.pass("Biller able to view the filtered Invoice batch list by respective entered \"Time\"");
            } else {
                test.fail("Biller not able to view the filtered Invoice batch list by respective entered \"Time\"");

            }

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyColumnFilterCreatedOnTime.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyColumnFilterCreatedOnTime.jpeg").build());
        }


    }

    public static void ColumnFilterCreatedOnDateTime() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            bList.clmFilterCreatedon.sendKeys("30-Nov-2020 5:56:31 PM");
            Thread.sleep(3000);

            VerifyColumnFilterCreatedOnDateTime("30-Nov-2020 5:56:31 PM");

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterCreatedOnDateTime.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterCreatedOnDateTime.jpeg").build());
        }


    }

    public static void VerifyColumnFilterCreatedOnDateTime(String data) throws IOException {
        try {

            if (driver.findElement(By.xpath("//*[@id=\"main-content\"]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[7]"))
                    .getText().contains(data)) {
                test.pass("Biller able to view the filtered Invoice batch list by respective entered \"Date Time\"");
            } else {
                test.fail("Biller not able to view the filtered Invoice batch list by respective entered \"Date Time\"");

            }

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyColumnFilterCreatedOnDateTime.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyColumnFilterCreatedOnDateTime.jpeg").build());
        }


    }

    public static void ColumnFilterBatchProgress() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            bList.clmFilterBatchProgress.sendKeys("0.01");
            Thread.sleep(3000);

            VerifyColumnFilterBatchProgress("0.01");

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterBatchProgress.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ColumnFilterBatchProgress.jpeg").build());
        }


    }

        public static void VerifyColumnFilterBatchProgress(String data) throws IOException {
        try {

            if (driver.findElement(By.xpath("//*[@id=\"main-content\"]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[8]"))
                    .getText().contains(data)) {
                test.pass("Biller able to view the filtered Invoice batch list by respective entered \"Date Time\"");
            } else {
                test.fail("Biller not able to view the filtered Invoice batch list by respective entered \"Date Time\"");

            }

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyColumnFilterBatchProgress.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyColumnFilterBatchProgress.jpeg").build());
        }


    }

    public static void ClickRowDeleteButton() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            bList.rowDeleteButton.click();
            Thread.sleep(1000);
            if (driver.findElement(By.xpath("/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-confirmation-dialog/div/div[1]/h3"))
                    .getText().contains("Delete")) {
                test.pass("Biller able to view the \"This action will permanently delete the invoice batch\" pop up");
            } else {
                test.fail("Biller not able to view the \"This action will permanently delete the invoice batch\" pop up");
            }

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickRowDeleteButton.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickRowDeleteButton.jpeg").build());
        }


    }

    public static void CheckRowDeletePopup() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            Thread.sleep(8000);
            String batchName = driver.findElement(By.xpath("/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[1]/a")).getText();
            if (bList.txtDeletePopup.isDisplayed() && bList.txtDeletePopup.getText().contains("Delete")
                    && bList.txtMessagePopup.isDisplayed() && bList.txtMessagePopup.getText().contains("This action will permanently delete the invoice batch \"" + batchName + "\".")
                    && bList.btnDeletePopup.isDisplayed() && bList.btnDeletePopup.getText().contains("Delete")
                    && bList.btnCancelPopup.isDisplayed() && bList.btnCancelPopup.getText().contains("Cancel")) {
                test.pass("Biller able to view the pop up in proper manner");
            } else {
                test.fail("Biller not able to view the pop up in proper manner");
            }

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/CheckRowDeletePopup.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/CheckRowDeletePopup.jpeg").build());
        }


    }

    public static void ClickButtonDeleteInPopupFromTable() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            Thread.sleep(1000);
            bList.btnDeletePopup.click();
            Thread.sleep(10000);
            String batchName = driver.findElement(By.xpath("/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[1]/a")).getText();
            WebElement filterInputData = driver.findElement(By.xpath("/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[1]/mat-form-field/div/div[1]/div/input"));
            Thread.sleep(1000);
            filterInputData.sendKeys(batchName);
            Thread.sleep(3000);

            if (bList.txtNoResultInTable.isDisplayed()) {
                test.pass("Biller able to delete the respective invoice batch");
            } else {
                test.fail("Biller not able to delete the respective invoice batch");
            }

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickButtonDeleteInPopupFromTable.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickButtonDeleteInPopupFromTable.jpeg").build());
        }


    }

    public static void VerifyBatchProgressCalculation() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            ColumnFilterBatchName();
            String paidAmt = (driver.findElement(By.xpath("/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row/mat-cell[5]/p")).getText());
            String batchAmt = (driver.findElement(By.xpath("/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row/mat-cell[2]/p")).getText());
            float iPaidAmt = Float.parseFloat(paidAmt.replaceAll("[^0-9\\.]", ""));
            float iBatchAmt = Float.parseFloat(batchAmt.replaceAll("[^0-9\\.]", ""));
            float batchProgress = ((iPaidAmt / iBatchAmt) * 100);
            String result = String.valueOf(String.format("%.2f", batchProgress));
            System.out.println(result);
            Thread.sleep(1000);
            if (driver.findElement(By.xpath("//*[@id=\"main-content\"]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[8]"))
                    .getText().contains(result)) {
                test.pass("Biller be able to view the correct batch progress percentile of respective batch");
            } else {
                test.fail("Biller not able to view the correct batch progress percentile of respective batch");
            }

        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyBatchProgressCalculation.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyBatchProgressCalculation.jpeg").build());
        }


    }

    public static boolean isFileDownloadedVerify(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();
        System.out.println(downloadPath+"<<>>"+fileName+"<<>>");
        for (int i = 0; i < Objects.requireNonNull(dirContents).length; i++) {
            System.out.println(dirContents[i].getName());
            if (dirContents[i].getName().contains(fileName)) {
                System.out.println(dirContents[i].getName());
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
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
    public static void clickOnExportButton() throws IOException {
        try {
            getTestData();
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            log.info("Waiting till the 'Export' button has to be visible");
            wait.until(ExpectedConditions.visibilityOf(bList.btnExportInvoiceBatchList));
            if (bList.btnExportInvoiceBatchList.isDisplayed()) {
                log.info("'Export' button has displayed");
                if (bList.btnExportInvoiceBatchList.isEnabled()) {
                    log.info("'Export' button has enabled to click");
                    log.info("Waiting till the 'Export' button has to be click");
                    wait.until(ExpectedConditions.elementToBeClickable(bList.btnExportInvoiceBatchList));
                    try {
                        act.moveToElement(bList.btnExportInvoiceBatchList).click().build().perform();
                        Thread.sleep(10000);
                        String downloadPath = prop.getProperty("Bills2U.FileUpload.DownloadPath");
                        File getLatestFile = getLatestFilefromDir(downloadPath);
                        String fileName = getFileNameWithoutExtension(getLatestFile);
                        System.out.println("File Name :- " + fileName);

                        assert getLatestFile != null;
                        if (getLatestFile.exists()) {
                            if (getLatestFile.getName().equals(fileName + ".csv")) {
                                test.pass("Biller able to download all the details in Excel sheet in \"Invoice batch list page\"");
                                log.info("Biller able to download all the details in Excel sheet in \"Invoice batch list page\"");
                            } else {
                                test.fail("The latest file not in .csv extension.  But it has the extension as " + getLatestFile.getName());
                                log.info("The latest file not in .csv extension.  But it has the extension as " + getLatestFile.getName());
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

    public static void DownloadInvoiceBatchReport() throws IOException {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            bList.btnExportInvoiceBatchList.click();
            Thread.sleep(1000);
            if (isFileDownloadedVerify(prop.getProperty("Bills2U.FileUpload.DownloadPath")
                    , prop.getProperty("Bills2U.InvoiceBatch.ExportFileName"))) {
                test.pass("Biller able to download all the details in Excel sheet in \"Invoice batch list page\"");
            } else {
                test.fail("Biller not able to download all the details in Excel sheet in \"Invoice batch list page\"");
            }
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/DownloadInvoiceBatchReport.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/DownloadInvoiceBatchReport.jpeg").build());
        }


    }

    public static void GoToEditInvoiceBatchList() throws IOException {
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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/GoToEditInvoiceBatchList.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/GoToEditInvoiceBatchList.jpeg").build());
        }


    }

    public static void GoToEditInvoiceBatchPublishedList() throws IOException {
        try {
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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/GoToEditInvoiceBatchPublishedList.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/GoToEditInvoiceBatchPublishedList.jpeg").build());
        }


    }

    public static void GoToEditInvoiceBatchStoppedList() throws IOException {
        try {
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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/GoToEditInvoiceBatchStoppedList.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/GoToEditInvoiceBatchStoppedList.jpeg").build());
        }

        
    }


}