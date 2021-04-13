package bills2u_process;

import Config.PropertyClass;
import bills2u_constant.Obj_Rep_EditInvoiceBatch;
import bills2u_constant.Obj_Rep_InvoiceBatchList;
import bills2u_constant.Obj_Rep_Menu;
import bills2u_root.Root_Class_TestNG;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.io.Files;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Edit_Invoice_List_Process extends Root_Class_TestNG {

    public static void getTestData() throws IOException {
        PropertyClass rp=new PropertyClass();
        prop = rp.readPropertiesFile();
    }


    public static void EnterInvoiceNumber() throws IOException {
        try {
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            eBList.filterInvoiceNumber.sendKeys(prop.getProperty("Bills2U.EditBatchList.Invoice.Filter"));


        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/EnterInvoiceNumber.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/EnterInvoiceNumber.jpeg").build());
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

    public static void VerifyEnteredInvoiceNumber() throws IOException {
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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyEnteredInvoiceNumber.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyEnteredInvoiceNumber.jpeg").build());
        }

    }

    public static void EnterRef1Number() throws IOException {
        try {
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            eBList.filterRef1.sendKeys(prop.getProperty("Bills2U.EditBatchList.Ref1.Filter"));
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/EnterRef1Number.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/EnterRef1Number.jpeg").build());
        }



    }

    public static void VerifyEnteredRef1Number() throws IOException {
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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyEnteredRef1Number.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyEnteredRef1Number.jpeg").build());
        }

    }

    public static void EnterRef2Number() throws IOException {
        try {
            Obj_Rep_EditInvoiceBatch eBList = new Obj_Rep_EditInvoiceBatch();
            PageFactory.initElements(driver, eBList);
            eBList.filterRef2.sendKeys(prop.getProperty("Bills2U.EditBatchList.Ref2.Filter"));
        } catch (Exception e) {
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/EnterRef2Number.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/EnterRef2Number.jpeg").build());
        }



    }

    public static void VerifyEnteredRef2Number() throws IOException {
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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyEnteredRef2Number.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyEnteredRef2Number.jpeg").build());
        }

    }

    public static void ClickSearchBtnInvoiceNumber() throws IOException {
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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickSearchBtnInvoiceNumber.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickSearchBtnInvoiceNumber.jpeg").build());
        }



    }

    public static void ClickSearchBtnRef1() throws IOException {
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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickSearchBtnRef1.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickSearchBtnRef1.jpeg").build());
        }



    }

    public static void ClickSearchBtnRef2() throws IOException {
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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickSearchBtnRef2.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickSearchBtnRef2.jpeg").build());
        }



    }

    public static void ClickSearchBtnInvoiceBatchList() throws IOException {
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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickSearchBtnInvoiceBatchList.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickSearchBtnInvoiceBatchList.jpeg").build());
        }



    }

    public static void VerifyStopBtnEnable() throws IOException {
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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyStopBtnEnable.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyStopBtnEnable.jpeg").build());
        }



    }

    public static void VerifyInvoiceBatchStatus(String status) throws IOException {
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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyInvoiceBatchStatus.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyInvoiceBatchStatus.jpeg").build());
        }



    }

    public static void VerifyBatchInvoicesRowStatus(String status) throws IOException {
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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyBatchInvoicesRowStatus.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyBatchInvoicesRowStatus.jpeg").build());
        }



    }

    public static void ClickStopButton() throws IOException {
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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickStopButton.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickStopButton.jpeg").build());
        }



    }

    public static void ClickResumeButton() throws IOException {
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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickResumeButton.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickResumeButton.jpeg").build());
        }



    }

    public static void VerifyStopPopup() throws IOException {
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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyStopPopup.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyStopPopup.jpeg").build());
        }



    }

    public static void ClickStopPopupStopButton() throws IOException {
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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickStopPopupStopButton.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickStopPopupStopButton.jpeg").build());
        }



    }

    public static void VerifyResumeBtnEnable() throws IOException {
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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyResumeBtnEnable.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyResumeBtnEnable.jpeg").build());
        }



    }

    public static void VerifyBatchInvoicesRowStoppedStatus(String status) throws IOException {
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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyBatchInvoicesRowStoppedStatus.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyBatchInvoicesRowStoppedStatus.jpeg").build());
        }



    }

    public static void VerifyResumePopup() throws IOException {
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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyResumePopup.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/VerifyResumePopup.jpeg").build());
        }



    }

    public static void ClickResumePopupResumeButton() throws IOException {
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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickResumePopupResumeButton.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/ClickResumePopupResumeButton.jpeg").build());
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

    public void DownloadEditInvoiceBatchReport() throws IOException {
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
            File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory")+"/DownloadEditInvoiceBatchReport.jpeg"));
            log.info(e.getMessage());
            test.fail(e.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory")+"/DownloadEditInvoiceBatchReport.jpeg").build());
        }
    }
}
