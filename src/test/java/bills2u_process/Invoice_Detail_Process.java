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

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Invoice_Detail_Process extends Root_Class_TestNG {

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

    public static void clickOnBatchName() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            log.info("Waiting till the 'Batch Name' is visible");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.batchNameInList));
            if (objInvoice.batchNameInList.isDisplayed()) {
                log.info("'Batch Name' has displayed");
                if (objInvoice.batchNameInList.isEnabled()) {
                    log.info("'Batch Name' has enabled to click");
                    try {
                        log.info("Waiting till the 'Batch name' is click");
                        wait.until(ExpectedConditions.elementToBeClickable(objInvoice.batchNameInList));
                        log.info("Clicking on the 'Batch name'");
                        objInvoice.batchNameInList.click();
                        log.info("'Batch name' has clicked");
                        log.info("Waiting till the 'Batch Detail' label is display");
                        wait.until(ExpectedConditions.visibilityOf(objInvoice.batchDetailText));
                        if (objInvoice.batchDetailText.getText().equals("Batch Detail")) {
                            test.pass("Biller has able to click on 'Batch Name link' in Invoice Batch page");
                            log.info("Biller has able to click on 'Batch Name link' in Invoice Batch page");

                        } else {
                            test.fail("'Batch Detail' has not matched with it's Expected data.  But it displayed " + objInvoice.invoiceBatchText.getText());
                            log.info("'Batch Detail' has not matched with it's Expected data.  But it displayed " + objInvoice.invoiceBatchText.getText());
                        }
                    } catch (Exception ex) {
                        test.fail("'Batch name' has not clicked.  But it displayed the Exception as.." + ex.getMessage());
                        log.info("'Batch name' has not clicked.  But it displayed the Exception as.." + ex.getMessage());
                    }
                } else {
                    log.info("'Batch Name' has not enabled");
                    test.fail("'Batch Name' has not enabled");
                }
            } else {
                log.info("'Batch Name' has not displayed");
                test.fail("'Batch Name' has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnBatchName.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnBatchName.jpeg").build());
        }
    }

    public static void clickOnInvoiceNumber() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            log.info("Waiting till the 'Invoice Number' is visible");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.invoiceNoInList));
            if (objInvoice.invoiceNoInList.isDisplayed()) {
                log.info("'Invoice Number' has displayed");
                if (objInvoice.invoiceNoInList.isEnabled()) {
                    log.info("'Invoice Number' has enabled to click");
                    try {
                        log.info("Waiting till the 'Invoice Number' is click");
                        wait.until(ExpectedConditions.elementToBeClickable(objInvoice.invoiceNoInList));
                        log.info("Clicking on the 'Invoice Number'");
                        Thread.sleep(2000);
                        String invNo = objInvoice.invoiceNoInList.getText();
                        act.moveToElement(objInvoice.invoiceNoInList).doubleClick().build().perform();
                        log.info("'Invoice Number' has clicked");
                        Thread.sleep(2000);
                        log.info("Waiting till the Invoice summary header is display");
                        wait.until(ExpectedConditions.visibilityOf(objInvoice.invoiceSummaryHeader));
                        if (objInvoice.invoiceSummaryHeader.getText().equals("INVOICE #" + invNo)) {
                            test.pass("Biller has redirect to Invoice Detail page");
                            log.info("Biller has redirect to Invoice Detail page");

                        } else {
                            test.fail("'Invoice Summary header' has not matched with it's Expected data.  But it displayed " + objInvoice.invoiceSummaryHeader.getText());
                            log.info("'Invoice Summary header' has not matched with it's Expected data.  But it displayed " + objInvoice.invoiceSummaryHeader.getText());
                        }
                    } catch (Exception ex) {
                        test.fail("'Invoice number' has not clicked.  But it displayed the Exception as.." + ex.getMessage());
                        log.info("'Invoice number' has not clicked.  But it displayed the Exception as.." + ex.getMessage());
                    }
                } else {
                    log.info("'Invoice number' has not enabled");
                    test.fail("'Invoice number' has not enabled");
                }
            } else {
                log.info("'Invoice number' has not displayed");
                test.fail("'Invoice number' has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnInvoiceNumber.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnInvoiceNumber.jpeg").build());
        }
    }

    public static void clickOnPaymentHistory() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            log.info("Waiting till the 'Payment History' button is visible");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.paymentHistoryBtn));
            if (objInvoice.paymentHistoryBtn.isDisplayed()) {
                log.info("Payment History button has displayed");
                if (objInvoice.paymentHistoryBtn.isEnabled()) {
                    log.info("Payment History button has enabled to click");
                    log.info("Waiting till the Payment History button is click");
                    wait.until(ExpectedConditions.elementToBeClickable(objInvoice.paymentHistoryBtn));
                    try {
                        Actions act=new Actions(driver);
                        act.moveToElement(objInvoice.paymentHistoryBtn).click().build().perform();
                        log.info("Payment History button is clicked");
                        log.info("Waiting till the 'Payment History' is display");
                        wait.until(ExpectedConditions.visibilityOf(objInvoice.paymentHistoryHeader));
                        if (objInvoice.paymentHistoryHeader.getText().equals("Payment History")) {
                            log.info("Biller has able to view  the Payment History detail");
                            test.pass("Biller has able to view  the Payment History detail");
                            Thread.sleep(2000);
                        } else {
                            log.info("Payment History label has not matched with it's expected.  But it displayed " + objInvoice.paymentHistoryHeader.getText());
                            test.fail("Payment History label has not matched with it's expected.  But it displayed " + objInvoice.paymentHistoryHeader.getText());
                        }
                    } catch (Exception ex) {
                        test.fail("Payment History button has not clicked.  But it displayed the Exception as.." + ex.getMessage());
                    }
                } else {
                    log.info("Payment History button has not enabled to click");
                }
            } else {
                log.info("Payment history button has not displayed");
                test.fail("Payment history button has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnPaymentHistory.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnPaymentHistory.jpeg").build());
        }
    }

    public static void enterTransactionReference() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            log.info("Waiting till the 'Transaction Reference' Text box is display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.transactionReference));
            if (objInvoice.transactionReference.isDisplayed()) {
                log.info("'Transaction Reference' text box has displayed");
                try {
                    objInvoice.transactionReference.sendKeys(prop.getProperty("Bills2U.PaymentHistory.TransactionReference"));
                    log.info("Transaction reference has enabled to type");
                    if (objInvoice.transactionReference.getAttribute("value").equals(prop.getProperty("Bills2U.PaymentHistory.TransactionReference"))) {
                        try {
                            if (objInvoice.filteredTransactionRef.isDisplayed()) {
                                log.info("Biller has able to enter the data depends upon entered data view the payment history.  And it displayed " + objInvoice.filteredTransactionRef.getText());
                                test.pass("Biller has able to enter the data depends upon entered data view the payment history.  And it displayed " + objInvoice.filteredTransactionRef.getText());
                            } else {
                                test.fail("Filtered Transaction Reference has not displayed");
                                log.info("Filtered Transaction Reference has not displayed");
                            }
                        } catch (Exception ex) {
                            if (objInvoice.noResultInPaymentHistory.isDisplayed()) {
                                log.info("Biller has able to enter the data depends upon entered data view the message as " + objInvoice.noResultInPaymentHistory.getText());
                                test.pass("Biller has able to enter the data depends upon entered data view the message as " + objInvoice.noResultInPaymentHistory.getText());
                            } else {
                                test.fail("No Result. message has not displayed");
                                log.info("No Result. message has not displayed");
                            }
                        }
                    } else {
                        test.fail("Transaction Reference has entered incorrect value.");
                        log.info("Transaction Reference has entered incorrect value.");
                    }
                } catch (Exception ex) {
                    log.info("Transaction reference has not entered.  But it displayed the Exception as.." + ex.getMessage());
                    test.fail("Transaction reference has not entered.  But it displayed the Exception as.." + ex.getMessage());

                }
            } else {
                log.info("'Transaction Reference' text box has not displayed");
                test.fail("'Transaction Reference' text box has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/enterTransactionReference.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/enterTransactionReference.jpeg").build());
        }
    }

    public static void placeTheCursorOnTransactionRef() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            Obj_Rep_Tooltip objTooltip = new Obj_Rep_Tooltip();
            PageFactory.initElements(driver, objTooltip);
            Actions act = new Actions(driver);
            act.moveToElement(objInvoice.transactionReference).build().perform();
            try {
                if (objTooltip.transactionTooltip.getText().equals("Transaction Reference")) {
                    test.pass("Biller has able to view the Transaction Reference tooltip");
                    log.info("Biller has able to view the Transaction Reference tooltip");
                } else {
                    test.fail("'Transaction Reference Tooltip' has deviated from it's expected data.  But it displayed as " + objTooltip.transactionTooltip.getText());
                    log.info("'Transaction Reference Tooltip' has deviated from it's expected data.  But it displayed as " + objTooltip.transactionTooltip.getText());
                }

            } catch (Exception ex) {
                test.fail("Transaction Reference has not clicked.  But it displayed the Exception as..\n" + ex.getMessage());
                log.info("Transaction Reference has not clicked.  But it displayed the Exception as..\n" + ex.getMessage());

            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/placeTheCursorOnTransactionRef.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/placeTheCursorOnTransactionRef.jpeg").build());
        }
    }

    public static void enterItemName() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            log.info("Waiting till the 'Item Name' Text box is display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.itemName));
            if (objInvoice.itemName.isDisplayed()) {
                log.info("'Item Name' text box has displayed");
                try {
                    objInvoice.itemName.sendKeys(prop.getProperty("Bills2U.PaymentHistory.ItemName"));
                    log.info("Item Name has enabled to type");
                    if (objInvoice.itemName.getAttribute("value").equals(prop.getProperty("Bills2U.PaymentHistory.ItemName"))) {
                        try {
                            if (objInvoice.filteredItemName.isDisplayed()) {
                                log.info("Biller has able to enter the data depends upon entered data view the payment history.  And it displayed " + objInvoice.filteredItemName.getText());
                                test.pass("Biller has able to enter the data depends upon entered data view the payment history.  And it displayed " + objInvoice.filteredItemName.getText());
                            } else {
                                test.fail("Filtered Item Name has not displayed");
                                log.info("Filtered Item name has not displayed");
                            }
                        } catch (Exception ex) {
                            if (objInvoice.noResultInPaymentHistory.isDisplayed()) {
                                log.info("Biller has able to enter the data depends upon entered data view the message as " + objInvoice.noResultInPaymentHistory.getText());
                                test.pass("Biller has able to enter the data depends upon entered data view the message as " + objInvoice.noResultInPaymentHistory.getText());
                            } else {
                                test.fail("No Result. message has not displayed");
                                log.info("No Result. message has not displayed");
                            }
                        }
                    } else {
                        test.fail("Item Name has entered incorrect value.");
                        log.info("Item Name has entered incorrect value.");
                    }
                } catch (Exception ex) {
                    log.info("Item Name has not entered.  But it displayed the Exception as.." + ex.getMessage());
                    test.fail("Item Name has not entered.  But it displayed the Exception as.." + ex.getMessage());

                }
            } else {
                log.info("'Item Name' text box has not displayed");
                test.fail("'Item Name' text box has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/enterItemName.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/enterItemName.jpeg").build());
        }
    }

    public static void placeTheCursorOnItemName() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            Obj_Rep_Tooltip objTooltip = new Obj_Rep_Tooltip();
            PageFactory.initElements(driver, objTooltip);
            Actions act = new Actions(driver);
            act.moveToElement(objInvoice.itemName).build().perform();
            try {
                if (objTooltip.itemNameTooltip.getText().equals("Item Name")) {
                    test.pass("Biller has able to view the Item Name tooltip");
                    log.info("Biller has able to view the Item Name tooltip");
                } else {
                    test.fail("'Item Name Tooltip' has deviated from it's expected data.  But it displayed as " + objTooltip.itemNameTooltip.getText());
                    log.info("'Item Name Tooltip' has deviated from it's expected data.  But it displayed as " + objTooltip.itemNameTooltip.getText());
                }

            } catch (Exception ex) {
                test.fail("Item Name has not clicked.  But it displayed the Exception as..\n" + ex.getMessage());
                log.info("Item Name has not clicked.  But it displayed the Exception as..\n" + ex.getMessage());
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/placeTheCursorOnItemName.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/placeTheCursorOnItemName.jpeg").build());
        }
    }

    public static void enterRemarks() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            log.info("Waiting till the 'Remarks' Text box is display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.remarks));
            if (objInvoice.remarks.isDisplayed()) {
                log.info("'Remarks' text box has displayed");
                try {
                    objInvoice.remarks.sendKeys(prop.getProperty("Bills2U.PaymentHistory.Remarks"));
                    log.info("Remarks has enabled to type");
                    if (objInvoice.remarks.getAttribute("value").equals(prop.getProperty("Bills2U.PaymentHistory.Remarks"))) {
                        try {
                            if (objInvoice.filteredRemarks.isDisplayed()) {
                                log.info("Biller has able to enter the data depends upon entered data view the payment history.  And it displayed " + objInvoice.filteredRemarks.getText());
                                test.pass("Biller has able to enter the data depends upon entered data view the payment history.  And it displayed " + objInvoice.filteredRemarks.getText());
                            } else {
                                test.fail("Filtered Remarks has not displayed");
                                log.info("Filtered Remarks has not displayed");
                            }
                        } catch (Exception ex) {
                            if (objInvoice.noResultInPaymentHistory.isDisplayed()) {
                                log.info("Biller has able to enter the data depends upon entered data view the message as " + objInvoice.noResultInPaymentHistory.getText());
                                test.pass("Biller has able to enter the data depends upon entered data view the message as " + objInvoice.noResultInPaymentHistory.getText());
                            } else {
                                test.fail("No Result. message has not displayed");
                                log.info("No Result. message has not displayed");
                            }
                        }


                    } else {
                        test.fail("Remarks has entered incorrect value.");
                        log.info("Remarks has entered incorrect value.");
                    }
                } catch (Exception ex) {
                    log.info("Remarks has not entered.  But it displayed the Exception as.." + ex.getMessage());
                    test.fail("Remarks has not entered.  But it displayed the Exception as.." + ex.getMessage());

                }
            } else {
                log.info("'Remarks' text box has not displayed");
                test.fail("'Remarks' text box has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/enterRemarks.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/enterRemarks.jpeg").build());
        }
    }

    public static void placeTheCursorOnRemarks() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            Obj_Rep_Tooltip objTooltip = new Obj_Rep_Tooltip();
            PageFactory.initElements(driver, objTooltip);
            Actions act = new Actions(driver);
            act.moveToElement(objInvoice.remarks).build().perform();
            try {
                if (objTooltip.remarksTooltip.getText().equals("Remarks")) {
                    test.pass("Biller has able to view the Remarks tooltip");
                    log.info("Biller has able to view the Remarks tooltip");
                } else {
                    test.fail("'Remarks Tooltip' has deviated from it's expected data.  But it displayed as " + objTooltip.remarksTooltip.getText());
                    log.info("'Remarks Tooltip' has deviated from it's expected data.  But it displayed as " + objTooltip.remarksTooltip.getText());
                }

            } catch (Exception ex) {
                test.fail("Remarks has not clicked.  But it displayed the Exception as..\n" + ex.getMessage());
                log.info("Remarks has not clicked.  But it displayed the Exception as..\n" + ex.getMessage());
            }
            log.info("'Remarks' has not displayed");

        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/placeTheCursorOnRemarks.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/placeTheCursorOnRemarks.jpeg").build());
        }
    }

    public static void enterPaymentAmount() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            log.info("Waiting till the 'Payment Amount' Text box is display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.paymentAmount));
            if (objInvoice.paymentAmount.isDisplayed()) {
                log.info("'Payment Amount' text box has displayed");
                try {
                    objInvoice.paymentAmount.sendKeys(prop.getProperty("Bills2U.PaymentHistory.PaymentAmount"));
                    log.info("Payment Amount has enabled to type");
                    if (objInvoice.paymentAmount.getAttribute("value").equals(prop.getProperty("Bills2U.PaymentHistory.PaymentAmount"))) {
                        try {
                            objInvoice.filteredPaymentAmount.isDisplayed();
                            log.info("Biller has able to enter the data depends upon entered data view the payment history.  And it displayed " + objInvoice.filteredPaymentAmount.getText());
                            test.pass("Biller has able to enter the data depends upon entered data view the payment history.  And it displayed " + objInvoice.filteredPaymentAmount.getText());
                        } catch (Exception ex) {
                            if (objInvoice.noResultInPaymentHistory.isDisplayed()) {
                                log.info("Biller has able to enter the data depends upon entered data view the message as " + objInvoice.noResultInPaymentHistory.getText());
                                test.pass("Biller has able to enter the data depends upon entered data view the message as " + objInvoice.noResultInPaymentHistory.getText());
                            } else {
                                test.fail("No Result. message has not displayed");
                                log.info("No Result. message has not displayed");
                            }
                        }


                    } else {
                        test.fail("Payment Amount has entered incorrect value.");
                        log.info("Payment Amount has entered incorrect value.");
                    }
                } catch (Exception ex) {
                    log.info("Payment Amount has not entered.  But it displayed the Exception as.." + ex.getMessage());
                    test.fail("Payment Amount has not entered.  But it displayed the Exception as.." + ex.getMessage());

                }
            } else {
                log.info("'Payment Amount' text box has not displayed");
                test.fail("'Payment Amount' text box has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/enterPaymentAmount.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/enterPaymentAmount.jpeg").build());
        }
    }

    public static void placeTheCursorOnPaymentAmount() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            Obj_Rep_Tooltip objTooltip = new Obj_Rep_Tooltip();
            PageFactory.initElements(driver, objTooltip);
            Actions act = new Actions(driver);
            act.moveToElement(objInvoice.paymentAmount).build().perform();
            try {
                if (objTooltip.paymentAmountTooltip.getText().equals("Payment Amount")) {
                    test.pass("Biller has able to view the Payment Amount tooltip");
                    log.info("Biller has able to view the Payment Amount tooltip");
                } else {
                    test.fail("'Payment Amount Tooltip' has deviated from it's expected data.  But it displayed as " + objTooltip.paymentAmountTooltip.getText());
                    log.info("'Payment Amount Tooltip' has deviated from it's expected data.  But it displayed as " + objTooltip.paymentAmountTooltip.getText());
                }

            } catch (Exception ex) {
                test.fail("Payment Amount has not clicked.  But it displayed the Exception as..\n" + ex.getMessage());
                log.info("Payment Amount has not clicked.  But it displayed the Exception as..\n" + ex.getMessage());
            }

        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/placeTheCursorOnPaymentAmount.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/placeTheCursorOnPaymentAmount.jpeg").build());
        }
    }

    public static void enterPaymentDate() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            log.info("Waiting till the 'Payment Date' Text box is display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.paymentDate));
            if (objInvoice.paymentDate.isDisplayed()) {
                log.info("'Payment Date' text box has displayed");
                try {
                    objInvoice.paymentDate.sendKeys(prop.getProperty("Bills2U.PaymentHistory.PaymentDate"));
                    log.info("Payment Date has enabled to type");
                    if (objInvoice.paymentDate.getAttribute("value").equals(prop.getProperty("Bills2U.PaymentHistory.PaymentDate"))) {
                        try {
                            objInvoice.filteredPaymentDate.isDisplayed();
                            log.info("Biller has able to enter the data depends upon entered data view the payment history.  And it displayed " + objInvoice.filteredPaymentDate.getText());
                            test.pass("Biller has able to enter the data depends upon entered data view the payment history.  And it displayed " + objInvoice.filteredPaymentDate.getText());
                        } catch (Exception ex) {
                            if (objInvoice.noResultInPaymentHistory.isDisplayed()) {
                                log.info("Biller has able to enter the data depends upon entered data view the message as " + objInvoice.noResultInPaymentHistory.getText());
                                test.pass("Biller has able to enter the data depends upon entered data view the message as " + objInvoice.noResultInPaymentHistory.getText());
                            } else {
                                test.fail("No Result. message has not displayed");
                                log.info("No Result. message has not displayed");
                            }
                        }


                    } else {
                        test.fail("Payment Date has entered incorrect value.");
                        log.info("Payment Date has entered incorrect value.");
                    }
                } catch (Exception ex) {
                    log.info("Payment Date has not entered.  But it displayed the Exception as.." + ex.getMessage());
                    test.fail("Payment Date has not entered.  But it displayed the Exception as.." + ex.getMessage());

                }
            } else {
                log.info("'Payment Date' text box has not displayed");
                test.fail("'Payment Date' text box has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/enterPaymentDate.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/enterPaymentDate.jpeg").build());
        }
    }

    public static void placeTheCursorOnPaymentDate() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            Obj_Rep_Tooltip objTooltip = new Obj_Rep_Tooltip();
            PageFactory.initElements(driver, objTooltip);
            Actions act = new Actions(driver);
            act.moveToElement(objInvoice.paymentDate).build().perform();
            try {
                if (objTooltip.paymentDateTooltip.getText().equals("Payment Date")) {
                    test.pass("Biller has able to view the Payment Date tooltip");
                    log.info("Biller has able to view the Payment Date tooltip");
                } else {
                    test.fail("'Payment Date Tooltip' has deviated from it's expected data.  But it displayed as " + objTooltip.paymentDateTooltip.getText());
                    log.info("'Payment Date Tooltip' has deviated from it's expected data.  But it displayed as " + objTooltip.paymentDateTooltip.getText());
                }

            } catch (Exception ex) {
                test.fail("Payment Date has not clicked.  But it displayed the Exception as..\n" + ex.getMessage());
                log.info("Payment Date has not clicked.  But it displayed the Exception as..\n" + ex.getMessage());
            }

        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/placeTheCursorOnPaymentDate.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/placeTheCursorOnPaymentDate.jpeg").build());
        }
    }

    public static void enterPaidBy() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            log.info("Waiting till the 'Paid By' Text box is display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.paidBy));
            if (objInvoice.paidBy.isDisplayed()) {
                log.info("'Paid By' text box has displayed");
                try {
                    objInvoice.paidBy.sendKeys(prop.getProperty("Bills2U.PaymentHistory.PaidBy"));
                    log.info("PaidBy has enabled to type");
                    if (objInvoice.paidBy.getAttribute("value").equals(prop.getProperty("Bills2U.PaymentHistory.PaidBy"))) {
                        try {
                            objInvoice.filteredPaidBy.isDisplayed();
                            log.info("Biller has able to enter the data depends upon entered data view the payment history.  And it displayed " + objInvoice.filteredPaidBy.getText());
                            test.pass("Biller has able to enter the data depends upon entered data view the payment history.  And it displayed " + objInvoice.filteredPaidBy.getText());
                        } catch (Exception ex) {
                            if (objInvoice.noResultInPaymentHistory.isDisplayed()) {
                                log.info("Biller has able to enter the data depends upon entered data view the message as " + objInvoice.noResultInPaymentHistory.getText());
                                test.pass("Biller has able to enter the data depends upon entered data view the message as " + objInvoice.noResultInPaymentHistory.getText());
                            } else {
                                test.fail("No Result. message has not displayed");
                                log.info("No Result. message has not displayed");
                            }
                        }


                    } else {
                        test.fail("Paid By has entered incorrect value.");
                        log.info("Paid By has entered incorrect value.");
                    }
                } catch (Exception ex) {
                    log.info("Paid By has not entered.  But it displayed the Exception as.." + ex.getMessage());
                    test.fail("Paid By has not entered.  But it displayed the Exception as.." + ex.getMessage());

                }
            } else {
                log.info("'Paid By' text box has not displayed");
                test.fail("'Paid By' text box has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/enterPaidBy.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/enterPaidBy.jpeg").build());
        }
    }

    public static void placeTheCursorOnPaidBy() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            Obj_Rep_Tooltip objTooltip = new Obj_Rep_Tooltip();
            PageFactory.initElements(driver, objTooltip);
            Actions act = new Actions(driver);
            act.moveToElement(objInvoice.paidBy).build().perform();
            try {
                if (objTooltip.paidByTooltip.getText().equals("Paid By")) {
                    test.pass("Biller has able to view the Paid By tooltip");
                    log.info("Biller has able to view the Paid By tooltip");
                } else {
                    test.fail("'Paid By Tooltip' has deviated from it's expected data.  But it displayed as " + objTooltip.paidByTooltip.getText());
                    log.info("'Paid By Tooltip' has deviated from it's expected data.  But it displayed as " + objTooltip.paidByTooltip.getText());
                }

            } catch (Exception ex) {
                test.fail("Paid By has not clicked.  But it displayed the Exception as..\n" + ex.getMessage());
                log.info("Paid By has not clicked.  But it displayed the Exception as..\n" + ex.getMessage());
            }

        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/placeTheCursorOnPaidBy.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/placeTheCursorOnPaidBy.jpeg").build());
        }
    }

    public static void clickOnAddTransaction() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            log.info("Waiting till the 'Add Transaction' is display");
            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOf(objInvoice.addTransaction));
            if (objInvoice.addTransaction.isDisplayed()) {
                log.info("'Add Transaction' button has displayed");
                if (objInvoice.addTransaction.isEnabled()) {
                    log.info("'Add Transaction' button has enabled to click");
                    log.info("Waiting till the 'Add Transaction' is click");
                    wait.until(ExpectedConditions.elementToBeClickable(objInvoice.addTransaction));
                    try {
                        act.moveToElement(objInvoice.addTransaction).click().build().perform();
                        log.info("'Add Transaction' has clicked");
                        log.info("Waiting till the 'Add Transaction' header is display");
                        wait.until(ExpectedConditions.visibilityOf(objInvoice.addTransactionHeader));
                        if (objInvoice.addTransactionHeader.isDisplayed()) {
                            log.info("'Add Transaction' has displayed");
                            if (objInvoice.addTransactionHeader.getText().equals("Add Transaction")) {
                                log.info("Biller has able to view the Add Transaction Page.");
                                test.pass("Biller has able to view the Add Transaction Page.");

                            } else {
                                log.info("'Add Transaction' label has not matched with it's expected data.  But it displayed " + objInvoice.addTransactionHeader.getText());
                                test.fail("'Add Transaction' label has not matched with it's expected data.  But it displayed " + objInvoice.addTransactionHeader.getText());
                            }
                        } else {
                            log.info("'Add Transaction' label has not displayed");
                            test.fail("'Add Transaction' label has not displayed");
                        }

                    } catch (Exception ex) {
                        log.info("'Add Transaction has not clicked.  But it displayed the Exception as.." + ex.getMessage());
                        test.fail("'Add Transaction has not clicked.  But it displayed the Exception as.." + ex.getMessage());
                    }
                } else {
                    log.info("'Add Transaction' button has not enabled to click");
                    test.fail("'Add Transaction' button has not enabled to click");
                }
            } else {
                log.info("'Add Transaction' button has not displayed");
                test.fail("'Add Transaction' button has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnAddTransaction.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnAddTransaction.jpeg").build());
        }
    }

    public static void checkMantatorySymbolInAddTransaction() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            wait.until(ExpectedConditions.visibilityOf(objInvoice.itemStar));
            if (objInvoice.itemStar.isDisplayed()) {
                if (objInvoice.itemStar.getText().equals(prop.getProperty("Bills2U.AddTransaction.ItemStar"))) {
                    wait.until(ExpectedConditions.visibilityOf(objInvoice.transactionTypeStar));
                    if (objInvoice.transactionTypeStar.isDisplayed()) {
                        if (objInvoice.transactionTypeStar.getText().equals(prop.getProperty("Bills2U.AddTransaction.TransactionTypeStar"))) {
                            wait.until(ExpectedConditions.visibilityOf(objInvoice.chooseDateStar));
                            if (objInvoice.chooseDateStar.isDisplayed()) {
                                if (objInvoice.chooseDateStar.getText().equals(prop.getProperty("Bills2U.AddTransaction.ChooseDateStar"))) {
                                    wait.until(ExpectedConditions.visibilityOf(objInvoice.itemStar));
                                    wait.until(ExpectedConditions.elementToBeClickable(objInvoice.itemStar));
                                    act.moveToElement(objInvoice.itemStar).click().build().perform();
                                    try {
                                        if (objInvoice.itemStar.getText().equals(prop.getProperty("Bills2U.AddTransaction.Item"))) {
                                            objInvoice.itemStar.sendKeys(prop.getProperty("Bills2U.AddTransaction.Item"));
                                            Thread.sleep(2000);
                                            objInvoice.itemStar.sendKeys(Keys.ENTER);
                                            Thread.sleep(2000);
                                        } else {
                                            act.moveToElement(objInvoice.itemStar).click().build().perform();
                                        }
                                    } catch (Exception ex) {
                                        test.fail("Biller has not able to view the Amount with *" + ex.getMessage());
                                    }
                                    wait.until(ExpectedConditions.visibilityOf(objInvoice.amountStar));
                                    if (objInvoice.amountStar.isDisplayed()) {
                                        if (objInvoice.amountStar.getText().equals(prop.getProperty("Bills2U.AddTransaction.AmountStar"))) {
                                            wait.until(ExpectedConditions.visibilityOf(objInvoice.remarksStar));
                                            if (objInvoice.remarksStar.isDisplayed()) {
                                                if (objInvoice.remarksStar.getText().equals(prop.getProperty("Bills2U.AddTransaction.RemarksStar"))) {
                                                    test.pass("Biller has able to view the Mandatory symbol(*) near the Mandatory field");
                                                    log.info("Biller has able to view the Mandatory symbol(*) near the Mandatory field");

                                                } else {
                                                    test.fail("'Remarks *' has deviate from it's expected data.  It displayed as " + objInvoice.remarksStar.getText());
                                                    log.info("'Remarks *' has deviate from it's expected data.  It displayed as " + objInvoice.remarksStar.getText());
                                                }
                                            } else {
                                                test.fail("'Remarks *' has not displayed.");
                                                log.info("'Remarks *' has not displayed");
                                            }
                                        } else {
                                            test.fail("'Amount *' has deviate from it's expected data.  It displayed as " + objInvoice.amountStar.getText());
                                            log.info("'Amount *' has deviate from it's expected data.  It displayed as " + objInvoice.amountStar.getText());
                                        }
                                    } else {
                                        test.fail("'Amount *' has not displayed.");
                                        log.info("'Amount *' has not displayed");
                                    }

                                } else {
                                    test.fail("'Choose a date *' has deviate from it's expected data.  It displayed as " + objInvoice.chooseDateStar.getText());
                                    log.info("'Choose a date *' has deviate from it's expected data.  It displayed as " + objInvoice.chooseDateStar.getText());
                                }


                            } else {
                                test.fail("'Choose a date *' has not displayed.");
                                log.info("'Choose a date *' has not displayed");
                            }
                        } else {
                            test.fail("'Transaction Type *' has deviate from it's expected data.  It displayed as " + objInvoice.transactionTypeStar.getText());
                            log.info("'Transaction Type *' has deviate from it's expected data.  It displayed as " + objInvoice.transactionTypeStar.getText());
                        }

                    } else {
                        test.fail("'Transaction Type *' has not displayed.");
                        log.info("'Transaction Type *' has not displayed");
                    }

                } else {
                    test.fail("'Item *' has deviate from it's expected data.  It displayed as " + objInvoice.itemStar.getText());
                    log.info("'Item *' has deviate from it's expected data.  It displayed as " + objInvoice.itemStar.getText());
                }
            } else {
                log.info("'Item *' has not displayed");
                test.fail("'Item *' has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/checkMantatorySymbolInAddTransaction.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/checkMantatorySymbolInAddTransaction.jpeg").build());
        }
    }

    public static void selectItemName() throws IOException {
        try {
           getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            wait.until(ExpectedConditions.visibilityOf(objInvoice.itemStar));
            wait.until(ExpectedConditions.elementToBeClickable(objInvoice.itemStar));
            act.moveToElement(objInvoice.itemStar).click().build().perform();
            try {
                if (objInvoice.itemStar.getText().equals(prop.getProperty("Bills2U.AddTransaction.Item"))) {
                    objInvoice.itemStar.sendKeys(prop.getProperty("Bills2U.AddTransaction.Item"));
                    Thread.sleep(2000);
                    objInvoice.itemStar.sendKeys(Keys.ENTER);
                    Thread.sleep(2000);
                } else {
                    act.moveToElement(objInvoice.itemStar).click().build().perform();
                }
            } catch (Exception ex) {
                test.fail("Biller has not able to view the Amount with *" + ex.getMessage());
            }
            if (!objInvoice.itemSelectedName.getText().isEmpty()) {
                test.pass("Biller has  able to view the Selected item as '" + objInvoice.itemSelectedName.getText() + "' in Items name");
                log.info("Biller has  able to view the Selected item as '" + objInvoice.itemSelectedName.getText() + "' in Items name");

            } else {
                test.fail("Items name has not selected");
                log.info("Items name has not selected");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/selectItemName.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/selectItemName.jpeg").build());
        }
    }

    public static void checkAmount() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            if (objInvoice.transactionTypeStar.getText().equals("Refund")) {
                objInvoice.transactionTypeStar.sendKeys("Payment");
                Thread.sleep(2000);
                objInvoice.transactionTypeStar.sendKeys(Keys.ENTER);
                Thread.sleep(2000);
            }
            if (!objInvoice.amountValue.getAttribute("value").isEmpty()) {
                test.pass("Amount (" + objInvoice.amountValue.getAttribute("value") + ") has displayed when items selected in Item Name.");
                log.info("Amount (" + objInvoice.amountValue.getAttribute("value") + ") has displayed when items selected in Item Name.");

            } else {
                test.fail("Amount has not generated");
                log.info("Amount has not generated");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/checkAmount.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/checkAmount.jpeg").build());
        }
    }

    public static void selectTransactionTypeAsRefund() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            Actions act = new Actions(driver);
            Thread.sleep(3000);
            System.out.println(objInvoice.transactionTypeValue.getText());
            if (objInvoice.transactionTypeValue.getText().equals("Payment")) {
                act.moveToElement(objInvoice.transactionTypeValue).click().build().perform();
                act.moveToElement(objInvoice.transactionTypeValue).sendKeys(Keys.ARROW_DOWN).build().perform();
                Thread.sleep(2000);
                act.moveToElement(objInvoice.transactionTypeValue).sendKeys(Keys.ENTER).build().perform();
            }
            if (objInvoice.transactionTypeValue.getText().equals("Refund")) {
                test.pass("Biller has able to select the transaction type as '" + objInvoice.transactionTypeValue.getText() + "'");
                log.info("Biller has able to select the transaction type as '" + objInvoice.transactionTypeValue.getText() + "'");
            } else {
                test.fail("Biller unable to select the transaction type");
                log.info("Biller unable to select the transaction type");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/selectTransactionTypeAsRefund.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/selectTransactionTypeAsRefund.jpeg").build());
        }

    }

    public static void selectPaymentDate(){
        try {
            getTestData();
            Obj_Rep_Dashboard dashboard = new Obj_Rep_Dashboard();
            PageFactory.initElements(driver, dashboard);
            WebElement dateSelect = driver.findElement(By.xpath("/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-add-transaction/mat-dialog-content/div[2]/div/form/div[3]/mat-form-field/div/div[1]/div[1]/input"));
            dateSelect.click();
            Thread.sleep(1000);
            WebElement yearSelect=driver.findElement(By.xpath("/html/body/app-root/div/div[2]/div[4]/div/mat-datepicker-content/mat-calendar/mat-calendar-header/div/div/button[1]/span[1]"));
            yearSelect.click();
            Thread.sleep(1000);
            WebElement chooseYear = driver.findElement(By.cssSelector("td[aria-label='"
                    + prop.getProperty("Bills2U.Dashboard.ChooseDate.currentYear") + "']"));
            try{
                chooseYear.click();
                Thread.sleep(2000);
                WebElement chooseMonth = driver.findElement(By.cssSelector("td[aria-label='01-"
                        + prop.getProperty("Bills2U.Dashboard.ChooseDate.currentMonth") + "-"
                        + prop.getProperty("Bills2U.Dashboard.ChooseDate.currentDay") + "']"));
                if(chooseMonth.isDisplayed()) {
                    if(chooseMonth.isEnabled()) {
                        chooseMonth.click();
                        dateSelect.click();
                        Thread.sleep(1000);
                        yearSelect.click();
                        Thread.sleep(2000);
                        WebElement choosePastYear = driver.findElement(By.cssSelector("td[aria-label='"
                                + prop.getProperty("Bills2U.Dashboard.ChooseDate.pastYear") + "']"));
                        try{
                            choosePastYear.click();
                            Thread.sleep(1000);
                            WebElement choosePastMonth = driver.findElement(By.cssSelector("td[aria-label='01-"
                                    + prop.getProperty("Bills2U.Dashboard.ChooseDate.pastMonth") + "-"
                                    + prop.getProperty("Bills2U.Dashboard.ChooseDate.pastDay") + "']"));
                            if(choosePastMonth.isDisplayed()) {
                                if(choosePastMonth.isEnabled()) {
                                    choosePastMonth.click();
                                    dateSelect.click();
                                    yearSelect.click();
                                    Thread.sleep(1000);
                                    Thread.sleep(2000);
                                    WebElement chooseFutureYear = driver.findElement(By.cssSelector("td[aria-label='"
                                            + prop.getProperty("Bills2U.Dashboard.ChooseDate.futureYear") + "']"));
                                    try{
                                        chooseFutureYear.click();
                                        Thread.sleep(1000);
                                        WebElement chooseFutureMonth = driver.findElement(By.cssSelector("td[aria-label='01-"
                                                + prop.getProperty("Bills2U.Dashboard.ChooseDate.futureMonth") + "-"
                                                + prop.getProperty("Bills2U.Dashboard.ChooseDate.futureDay") + "']"));
                                        if(chooseFutureMonth.isDisplayed()) {
                                            if(!chooseFutureMonth.isEnabled()) {
                                                test.pass("Biller allowed to select the past or current date,future\n" +
                                                        "date has been disabled.");
                                            }else {
                                                test.fail("Future Month has enabled");
                                            }
                                        }else{
                                            test.fail("Future Month has not displayed");
                                        }
                                    }catch (Exception ex){
                                        test.pass("Future Year has not displayed");
                                    }
                                }else {
                                    test.fail("Past Month has not enabled");
                                }
                            }else{
                                test.fail("Past Month has not displayed");
                            }
                        }catch (Exception ex){
                            test.pass("Past Year has not displayed");
                        }
                    }else {
                        test.fail("Current Month has not enabled");
                    }
                }else{
                    test.fail("Current Month has not displayed");
                }
            }catch (Exception ex){
                test.fail("Current Year has not displayed");
            }
            dateSelect.sendKeys(Keys.ESCAPE);
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

    public static void selectTransactionTypeAsPayment() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            Actions act = new Actions(driver);
            Thread.sleep(3000);
            System.out.println(objInvoice.transactionTypeValue.getText());
            if (objInvoice.transactionTypeValue.getText().equals("Refund")) {
                act.moveToElement(objInvoice.transactionTypeValue).click().build().perform();
                act.moveToElement(objInvoice.transactionTypeValue).sendKeys(Keys.ARROW_UP).build().perform();
                Thread.sleep(2000);
                act.moveToElement(objInvoice.transactionTypeValue).sendKeys(Keys.ENTER).build().perform();
            }
            if (objInvoice.transactionTypeValue.getText().equals("Payment")) {
                test.pass("Biller has able to select the transaction type as '" + objInvoice.transactionTypeValue.getText() + "'");
                log.info("Biller has able to select the transaction type as '" + objInvoice.transactionTypeValue.getText() + "'");
            } else {
                test.fail("Biller unable to select the transaction type");
                log.info("Biller unable to select the transaction type");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/selectTransactionTypeAsPayment.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/selectTransactionTypeAsPayment.jpeg").build());
        }

    }

    public static void editAmount() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            log.info("Waiting till the Amount file has to be display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.amountValue));
            if (objInvoice.amountValue.isDisplayed()) {
                objInvoice.amountValue.clear();
                try {
                    objInvoice.amountValue.sendKeys(prop.getProperty("Bills2U.AddTransaction.Amount"));
                    log.info("Biller has able to edit the amount for Unpaid Invoices. ");
                    test.pass("Biller has able to edit the amount for Unpaid Invoices.");
                } catch (Exception ex) {
                    test.fail("Biller unable to edit the amount.  And it displayed the Exception as..." + ex.getMessage());
                    log.info("Biller unable to edit the amount.  And it displayed the Exception as..." + ex.getMessage());
                }
            } else {
                log.info("'Amount' text box has not displayed");
                test.fail("'Amount' text box has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/editAmount.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/editAmount.jpeg").build());
        }
    }

    public static void editRemarks() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            log.info("Waiting till the Remarks has to be display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.remarkValue));
            if (objInvoice.remarkValue.isDisplayed()) {
                objInvoice.remarkValue.clear();
                try {
                    objInvoice.remarkValue.sendKeys(prop.getProperty("Bills2U.AddTransaction.Remarks"));
                    log.info("Biller has able to enter the data in 'Remarks' field.");
                    test.pass("Biller has able to enter the data in 'Remarks' field.");
                } catch (Exception ex) {
                    test.fail("Biller unable to enter the data in 'Remarks' field.  And it displayed the Exception as..." + ex.getMessage());
                    log.info("Biller unable to enter the data in 'Remarks' field.  And it displayed the Exception as..." + ex.getMessage());
                }
            } else {
                log.info("'Remarks' text box has not displayed");
                test.fail("'Remarks' text box has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/editRemarks.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/editRemarks.jpeg").build());
        }
    }

    public static void clickOnAddBtn() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            if (objInvoice.addBtn.isDisplayed()) {
                if (objInvoice.addBtn.isEnabled()) {
                    log.info("Waiting till the Add button is click");
                    wait.until(ExpectedConditions.elementToBeClickable(objInvoice.addBtn));
                    act.moveToElement(objInvoice.addBtn).click().build().perform();
                    Thread.sleep(2000);
                    if (objInvoice.addedMsg.isDisplayed()) {
                        test.pass("Payment has been added.  It displayed the successful message as " + objInvoice.addedMsg.getText());
                        log.info("Payment has been added.  It displayed the successful message as " + objInvoice.addedMsg.getText());
                    } else {
                        test.fail("Successful message has not displayed");
                        log.info("Successful message has not displayed");
                    }

                } else {
                    test.fail("Add button has not enabled to click");
                    log.info("Add button has not enabled to click");
                }
            } else {
                log.info("Add button has not displayed");
                test.fail("Add button has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnAddBtn.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnAddBtn.jpeg").build());
        }
    }

    public static void checkAddBtn() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            if (objInvoice.addBtn.isDisplayed()) {
                if (objInvoice.addBtn.isEnabled()) {
                    test.pass("Biller has able to view the add transaction button is enabled when selected the item.");
                    test.pass("Biller has able to view the add transaction button is enabled when selected the item.");
                } else {
                    test.fail("Add button has not enabled to click");
                    log.info("Add button has not enabled to click");
                }
            } else {
                log.info("Add button has not displayed");
                test.fail("Add button has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/checkAddBtn.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/checkAddBtn.jpeg").build());
        }
    }

    public static void checkAmtErrorMsg() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);

            if (objInvoice.amtErrorMessage.isDisplayed()) {
                if (objInvoice.transactionTypeValue.getText().equals("Payment")) {
                    String text = prop.getProperty("Bills2U.AddTransaction.ErrorMsg");
                    String txt = objInvoice.amtErrorMessage.getText();
                    txt = txt.substring(0, 69);
                    System.out.println(txt);

                    if (txt.equals(text)) {
                        test.pass("Biller has able to enter the data and view  the error message as '" + txt + "'.");
                        log.info("Biller has able to enter the data and view the error message as '" + txt + "'.");
                    } else {
                        test.fail("Biller has able to enter the data and view  the error message as '" + txt + "'.");
                        log.info("Biller has able to enter the data and view the error message as '" + txt + "'.");
                    }
                } else {
                    String text = "Warning : Entered refund amount exceed more than amount paid.";
                    String txt = objInvoice.amtErrorMessage.getText();
                    txt = txt.substring(0, 61);
                    System.out.println(txt);

                    if (txt.equals(text)) {
                        test.pass("Biller has able to enter the data and view  the error message as '" + txt + "'.");
                        log.info("Biller has able to enter the data and view the error message as '" + txt + "'.");
                    } else {
                        test.fail("Biller has able to enter the data and view  the error message as '" + txt + "'.");
                        log.info("Biller has able to enter the data and view the error message as '" + txt + "'.");
                    }
                }
            } else {
                test.fail("Biller has able to enter the data and the error message has not displayed");
                log.info("Biller has able to enter the data and the error message has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/checkAmtErrorMsg.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/checkAmtErrorMsg.jpeg").build());
        }
    }

    public static void clickOnExternalTransactionLink() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            if (objInvoice.externalTransactionLink.isDisplayed()) {
                if (objInvoice.externalTransactionLink.isEnabled()) {
                    log.info("Waiting till the External Transaction is click");
                    wait.until(ExpectedConditions.elementToBeClickable(objInvoice.externalTransactionLink));
                    act.moveToElement(objInvoice.externalTransactionLink).click().build().perform();
                    Thread.sleep(2000);
                    if (objInvoice.updateTransactionHeader.isDisplayed()) {
                        test.pass("Biller has redirect to " + objInvoice.updateTransactionHeader.getText() + " page.");
                        log.info("Biller has redirect to " + objInvoice.updateTransactionHeader.getText() + " page.");
                    } else {
                        test.fail("Update Transaction page has not displayed");
                        log.info("Update Transaction page has not displayed");
                    }

                } else {
                    test.fail("External Transaction link has not enabled to click");
                    log.info("External Transaction link has not enabled to click");
                }
            } else {
                log.info("External Transaction link has not displayed");
                test.fail("External Transaction link has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnExternalTransactionLink.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnExternalTransactionLink.jpeg").build());
        }
    }

    public static void clickOnDeleteTransactionBtn() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            if (objInvoice.transactionDeleteButton.isDisplayed()) {
                if (objInvoice.transactionDeleteButton.isEnabled()) {
                    log.info("Waiting till the Delete button is click");
                    wait.until(ExpectedConditions.elementToBeClickable(objInvoice.transactionDeleteButton));
                    act.moveToElement(objInvoice.transactionDeleteButton).click().build().perform();
                    Thread.sleep(2000);
                    if (objInvoice.addedMsg.isDisplayed()) {
                        test.pass("Biller has able to delete  the transaction and view the message as " + objInvoice.addedMsg.getText());
                        log.info("Biller has able to delete  the transaction and view the message as " + objInvoice.addedMsg.getText());
                    } else {
                        test.fail("Successful message has not displayed");
                        log.info("Successful message has not displayed");
                    }

                } else {
                    test.fail("Add button has not enabled to click");
                    log.info("Add button has not enabled to click");
                }
            } else {
                log.info("Add button has not displayed");
                test.fail("Add button has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnDeleteTransactionBtn.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnDeleteTransactionBtn.jpeg").build());
        }
    }

    public static void placeTheCursorOnCloseIconPopup() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            log.info("Waiting till the 'Close' icon is display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.closeIcon));
            if (objInvoice.closeIcon.isDisplayed()) {
                if (objInvoice.closeIcon.isEnabled()) {
                    log.info("Waiting till the 'Close' is click");
                    wait.until(ExpectedConditions.elementToBeClickable(objInvoice.closeIcon));
                    try {
                        log.info("Placing the cursor on 'Close'");
                        act.moveToElement(objInvoice.closeIcon).build().perform();
                        Obj_Rep_Tooltip objTooltip = new Obj_Rep_Tooltip();
                        PageFactory.initElements(driver, objTooltip);
                        System.out.println(objInvoice.closeIcon.getAttribute("aria-describedby"));
                        System.out.println(objTooltip.closeTooltipUpdateTransaction.getAttribute("id"));

                        if (objInvoice.closeIcon.getAttribute("aria-describedby").equals(objTooltip.closeTooltipUpdateTransaction.getAttribute("id"))) {
                            JavascriptExecutor j = (JavascriptExecutor) driver;
                            j.executeScript("document.getElementById('cdk-describedby-message-51').value='Close';");
                            String s = (String) j.executeScript("return document.getElementById('cdk-describedby-message-51').value");
                            System.out.println(s);
                            if (s.equals("Close")) {
                                test.pass("Biller has able to view the " + s + " tooltip");
                                log.info("Biller has able to view the " + s + " tooltip");
                            } else {
                                test.fail("'Close Tooltip' has deviated from it's expected data.  But it displayed as " + s);
                                log.info("'Close Tooltip' has deviated from it's expected data.  But it displayed as " + s);
                            }
                        } else {
                            test.fail("Tooltip Locator has not matched");
                            log.info("Tooltip Locator has not matched");
                        }
                    } catch (Exception ex) {
                        test.fail("Close has not clicked.  But it displayed the Exception as..\n" + ex.getMessage());
                        log.info("Close has not clicked.  But it displayed the Exception as..\n" + ex.getMessage());
                    }
                } else {
                    test.fail("'Close' has not enabled to click");
                    log.info("'Close' has not enabled to click");
                }
            } else {
                test.fail("'Close' has not displayed");
                log.info("'Close' has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/placeTheCursorOnCloseIconPopup.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/placeTheCursorOnCloseIconPopup.jpeg").build());
        }
    }

    public static void clickOnCloseBtn() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            if (objInvoice.closeIcon.isDisplayed()) {
                if (objInvoice.closeIcon.isEnabled()) {
                    log.info("Waiting till the Close button is click");
                    wait.until(ExpectedConditions.elementToBeClickable(objInvoice.closeIcon));
                    act.moveToElement(objInvoice.closeIcon).click().build().perform();
                    Thread.sleep(2000);
                    if (objInvoice.addTransaction.isDisplayed()) {
                        test.pass("Biller has able to close the popup.");
                        log.info("Biller has able to close the popup.");
                    } else {
                        test.fail("Add Transaction button has not displayed");
                        log.info("Add Transaction button has not displayed");
                    }

                } else {
                    test.fail("Close button has not enabled to click");
                    log.info("Close button has not enabled to click");
                }
            } else {
                log.info("Close button has not displayed");
                test.fail("Close button has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnCloseBtn.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnCloseBtn.jpeg").build());
        }
    }

    public static void clickPauseIcon() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            if (objInvoice.pauseIcon.isDisplayed()) {
                if (objInvoice.pauseIcon.isEnabled()) {
                    try {
                        objInvoice.pauseIcon.click();
                        Thread.sleep(2000);
                        test.pass("Biller has able to click on '||' icon ");
                        log.info("Biller has able to click on '||' icon ");
                    } catch (Exception ex) {
                        test.fail("Biller unable to click on '||' icon ");
                        log.info("Biller unable to click on '||' icon ");
                    }
                } else {
                    test.fail("'||' icon has not enabled to click");
                    log.info("'||' icon has not enabled to click");
                }
            } else {
                log.info("'||' icon has not displayed");
                test.fail("'||' icon has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickPauseIcon.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickPauseIcon.jpeg").build());
        }
    }

    public static void placeTheCursorOnPauseIcon() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            log.info("Waiting till the 'Pause' icon is display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.pauseIcon));
            if (objInvoice.pauseIcon.isDisplayed()) {
                if (objInvoice.pauseIcon.isEnabled()) {
                    log.info("Waiting till the 'Pause' icon is click");
                    wait.until(ExpectedConditions.elementToBeClickable(objInvoice.pauseIcon));
                    try {
                        log.info("Placing the cursor on 'Pause' icon");
                        act.moveToElement(objInvoice.pauseIcon).click().build().perform();
                        act.moveToElement(objInvoice.pauseIcon).build().perform();
                        Obj_Rep_Tooltip objTooltip = new Obj_Rep_Tooltip();
                        PageFactory.initElements(driver, objTooltip);
                        System.out.println(objInvoice.pauseIcon.getAttribute("aria-describedby"));
                        System.out.println(objTooltip.pauseTooltip.getAttribute("id"));

                        if (objInvoice.pauseIcon.getAttribute("aria-describedby").equals(objTooltip.pauseTooltip.getAttribute("id"))) {
                            JavascriptExecutor j = (JavascriptExecutor) driver;
                            j.executeScript("document.getElementById('cdk-describedby-message-40').value='To change bill state';");
                            String s = (String) j.executeScript("return document.getElementById('cdk-describedby-message-40').value");
                            System.out.println(s);
                            if (s.equals("To change bill state")) {
                                test.pass("Biller has able to view the To change bill state tooltip");
                                log.info("Biller has able to view the To change bill state tooltip");
                                Thread.sleep(3000);
                                act.moveToElement(objInvoice.pauseIcon).click().build().perform();
                                Thread.sleep(3000);
                            } else {
                                test.fail("'To change bill state Tooltip' has deviated from it's expected data.  But it displayed as " + s);
                                log.info("'To change bill state Tooltip' has deviated from it's expected data.  But it displayed as " + s);
                            }
                        } else {
                            test.fail("Tooltip Locator has not matched");
                            log.info("Tooltip Locator has not matched");
                        }
                    } catch (Exception ex) {
                        test.fail("'Pause' icon  has not clicked.  But it displayed the Exception as..\n" + ex.getMessage());
                        log.info("'Pause' icon has not clicked.  But it displayed the Exception as..\n" + ex.getMessage());
                    }
                } else {
                    test.fail("'Pause' icon has not enabled to click");
                    log.info("'Pause' icon has not enabled to click");
                }
            } else {
                test.fail("'Pause' icon has not displayed");
                log.info("'Pause' icon has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/placeTheCursorOnPauseIcon.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/placeTheCursorOnPauseIcon.jpeg").build());
        }
    }

    public static void checkPopupMessage() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(objInvoice.popupMessage));
            Thread.sleep(3000);
            if (objInvoice.popupMessage.isDisplayed()) {
                String msg = objInvoice.popupMessage.getText();
                msg = msg.substring(0, 81);
                System.out.println(msg);
                if (msg.equals(prop.getProperty("Bills2U.Invoice.PopupMessageDisable"))) {
                    if (objInvoice.stopButton.isDisplayed() && objInvoice.cancelButton.isDisplayed()) {
                        test.pass("Biller has able to view the mentioned pop up message.");
                    } else {
                        test.fail("Biller has able to view the mentioned pop up message.  And Stop button displayed:"
                                + objInvoice.stopButton.isDisplayed() + ".  Then, Cancel button displayed:" + objInvoice.cancelButton.isDisplayed());
                    }
                } else if(msg.equals(prop.getProperty("Bills2U.Invoice.PopupMessageEnable"))){
                    if (objInvoice.stopButton.isDisplayed() && objInvoice.cancelButton.isDisplayed()) {
                        test.pass("Biller has able to view the mentioned pop up message.");
                    } else {
                        test.fail("Biller has able to view the mentioned pop up message.  And Stop button displayed:"
                                + objInvoice.stopButton.isDisplayed() + ".  Then, Cancel button displayed:" + objInvoice.cancelButton.isDisplayed());
                    }
                }
                else {
                    test.fail("Popup message has deviates from it's Expected data.  And it displayed the message as " + msg);
                }
            } else {
                test.fail("Popup Message has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/checkPopupMessage.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/checkPopupMessage.jpeg").build());
        }
    }

    public static void checkDeletePopupMessage() throws IOException {
        try {
            getTestData();
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(objInvoice.popupMessage));
            Thread.sleep(3000);
            if (objInvoice.popupMessage.isDisplayed()) {
                String msg = objInvoice.popupMessage.getText();
                msg = msg.substring(0, 47);
                System.out.println(msg);
                if (msg.equals(prop.getProperty("Bills2U.Invoice.PopupMessageDelete"))) {
                    if (objInvoice.stopButton.isDisplayed() && objInvoice.cancelButton.isDisplayed()) {
                        test.pass("Biller has able to view the mentioned pop up message.");
                    } else {
                        test.fail("Biller has able to view the mentioned pop up message.  And Stop button displayed:"
                                + objInvoice.stopButton.isDisplayed() + ".  Then, Cancel button displayed:" + objInvoice.cancelButton.isDisplayed());
                    }
                }
                else {
                    test.fail("Popup message has deviates from it's Expected data.  And it displayed the message as " + msg);
                }
            } else {
                test.fail("Popup Message has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/checkPopupMessage.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/checkPopupMessage.jpeg").build());
        }
    }

    public static void clickStopInPauseDialog() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            Actions act = new Actions(driver);
            if (objInvoice.stopButton.isDisplayed()) {
                if (objInvoice.stopButton.isEnabled()) {
                    try {
                        act.moveToElement(objInvoice.stopButton).click().build().perform();
                        Thread.sleep(3000);
                        if (objInvoice.stopAlertMessage.isDisplayed()) {
                            if (objInvoice.stopAlertMessage.getText().equals(prop.getProperty("Bills2U.Invoice.updatedMsg"))) {
                                test.pass("Biller has able to view the message as 'Bill state updated Successfully'");
                            } else {
                                test.fail("Successful message has deviates from it's expected data.  And displayed the message as " + objInvoice.stopAlertMessage.getText());
                            }
                        } else {
                            test.fail("Alert message has not displayed");
                        }
                        Thread.sleep(5000);
                    } catch (Exception ex) {
                        test.fail("Biller unable to click on cancel");
                        log.info("Biller unable to click on cancel");
                    }
                } else {
                    test.fail("Stop has not enabled to click");
                    log.info("Stop has not enabled to click");
                }
            } else {
                log.info("Stop has not displayed");
                test.fail("Stop has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickStopInPauseDialog.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickStopInPauseDialog.jpeg").build());
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
                        test.pass("Biller has able to cancel the corresponding Batch.");
                        Thread.sleep(5000);
                    } catch (Exception ex) {
                        test.fail("Biller unable to click on cancel.  And it displayed the exception as.."+ex.getMessage());
                        log.info("Biller unable to click on cancel.  And it displayed the exception as.."+ex.getMessage());
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
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickStopInPauseDialog.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickStopInPauseDialog.jpeg").build());
        }
    }

    public static void clickDeleteIcon() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            if (objInvoice.deleteInvoiceIcon.isDisplayed()) {
                if (objInvoice.deleteInvoiceIcon.isEnabled()) {
                    try {
                        objInvoice.deleteInvoiceIcon.click();
                        Thread.sleep(2000);
                        test.pass("Biller has able to click on 'Delete' icon ");
                        log.info("Biller has able to click on 'Delete' icon ");
                    } catch (Exception ex) {
                        test.fail("Biller unable to click on 'Delete' icon ");
                        log.info("Biller unable to click on 'Delete' icon ");
                    }
                }else if(!objInvoice.deleteInvoiceIcon.isEnabled()){
                    clickPauseIcon();
                    clickStopInPauseDialog();
                    try {
                        objInvoice.deleteInvoiceIcon.click();
                        Thread.sleep(2000);
                        test.pass("Biller has able to click on 'Delete' icon ");
                        log.info("Biller has able to click on 'Delete' icon ");
                    } catch (Exception ex) {
                        test.fail("Biller unable to click on 'Delete' icon ");
                        log.info("Biller unable to click on 'Delete' icon ");
                    }
                } else {
                    test.fail("'Delete' icon has not enabled to click");
                    log.info("'Delete' icon has not enabled to click");
                }
            } else {
                log.info("'Delete' icon has not displayed");
                test.fail("'Delete' icon has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickDeleteIcon.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickDeleteIcon.jpeg").build());
        }
    }

    public static void clickDeleteInDialog() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            Actions act = new Actions(driver);
            if (objInvoice.deleteAlertButton.isDisplayed()) {
                if (objInvoice.deleteAlertButton.isEnabled()) {
                    try {
                        act.moveToElement(objInvoice.deleteAlertButton).click().build().perform();
                        Thread.sleep(1000);
                        if (objInvoice.stopAlertMessage.isDisplayed()) {
                            if (objInvoice.stopAlertMessage.getText().equals(prop.getProperty("Bills2U.Invoice.deletedMsg"))) {
                                test.pass("Biller has able to view the message as 'Bill deleted Successfully'");
                            } else {
                                test.fail("Successful message has deviates from it's expected data.  And displayed the message as " + objInvoice.stopAlertMessage.getText());
                            }
                        } else {
                            test.fail("Alert message has not displayed");
                        }
                        Thread.sleep(5000);
                    } catch (Exception ex) {
                        test.fail("Biller unable to click on Delete");
                        log.info("Biller unable to click on Delete");
                    }
                } else {
                    test.fail("Delete has not enabled to click");
                    log.info("Delete has not enabled to click");
                }
            } else {
                log.info("Delete has not displayed");
                test.fail("Delete has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickStopInPauseDialog.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickStopInPauseDialog.jpeg").build());
        }
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

    public static void placeTheCursorOnDeleteIcon() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            log.info("Waiting till the 'Delete' icon is display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.deleteInvoiceIcon));
            if (objInvoice.deleteInvoiceIcon.isDisplayed()) {
                if (objInvoice.deleteInvoiceIcon.isEnabled()) {
                    log.info("Waiting till the 'Delete' icon is click");
                    wait.until(ExpectedConditions.elementToBeClickable(objInvoice.deleteInvoiceIcon));
                    try {
                        log.info("Placing the cursor on 'Delete' icon");
                        act.moveToElement(objInvoice.deleteInvoiceIcon).build().perform();
                        Thread.sleep(2000);
                        Obj_Rep_Tooltip objTooltip = new Obj_Rep_Tooltip();
                        PageFactory.initElements(driver, objTooltip);
                        System.out.println("Delete Attribute:"+objInvoice.deleteInvoiceIcon.getAttribute("aria-describedby"));
                        System.out.println("Delete Tooltip:"+objTooltip.deleteInvoiceTooltip.getAttribute("id"));
                   //     if (objInvoice.deleteInvoiceIcon.getAttribute("aria-describedby").equals(objTooltip.deleteInvoiceTooltip.getAttribute("id"))) {
                            JavascriptExecutor j = (JavascriptExecutor) driver;
                            j.executeScript("document.getElementById('cdk-describedby-message-36').value='Delete Invoice';");
                            String s = (String) j.executeScript("return document.getElementById('cdk-describedby-message-36').value");
                            System.out.println(s);
                            if (s.equals("Delete Invoice")) {
                                test.pass("Biller has able to view the Delete Invoice state tooltip");
                                log.info("Biller has able to view the Delete Invoice state tooltip");
                                Thread.sleep(3000);
                            } else {
                                test.fail("'Delete Invoice Tooltip' has deviated from it's expected data.  But it displayed as " + s);
                                log.info("'Delete Invoice Tooltip' has deviated from it's expected data.  But it displayed as " + s);
                            }
                     /*   } else {
                            test.fail("Tooltip Locator has not matched");
                            log.info("Tooltip Locator has not matched");
                        }*/
                    } catch (Exception ex) {
                        test.fail("'Delete' icon  has not clicked.  But it displayed the Exception as..\n" + ex.getMessage());
                        log.info("'Delete' icon has not clicked.  But it displayed the Exception as..\n" + ex.getMessage());
                    }
                }else if(!objInvoice.deleteInvoiceIcon.isEnabled()) {
                    clickPauseIcon();
                    clickStopInPauseDialog();
                    Thread.sleep(5000);
                    wait.until(ExpectedConditions.elementToBeClickable(objInvoice.deleteInvoiceIcon));
                    try {
                        log.info("Placing the cursor on 'Delete' icon");
                        act.moveToElement(objInvoice.deleteInvoiceIcon).build().perform();
                        Obj_Rep_Tooltip objTooltip = new Obj_Rep_Tooltip();
                        PageFactory.initElements(driver, objTooltip);
                        System.out.println("Delete Attribute:"+objInvoice.deleteInvoiceIcon.getAttribute("aria-describedby"));
                        System.out.println("Delete Tooltip:"+objTooltip.deleteInvoiceTooltip.getAttribute("id"));
                   //     if (objInvoice.deleteInvoiceIcon.getAttribute("aria-describedby").equals(objTooltip.deleteInvoiceTooltip.getAttribute("id"))) {
                            JavascriptExecutor j = (JavascriptExecutor) driver;
                            j.executeScript("document.getElementById('cdk-describedby-message-36').value='Delete Invoice';");
                            String s = (String) j.executeScript("return document.getElementById('cdk-describedby-message-36').value");
                            System.out.println(s);
                            if (s.equals("Delete Invoice")) {
                                test.pass("Biller has able to view the Delete Invoice state tooltip");
                                log.info("Biller has able to view the Delete Invoice state tooltip");
                                Thread.sleep(3000);
                            } else {
                                test.fail("'Delete Invoice Tooltip' has deviated from it's expected data.  But it displayed as " + s);
                                log.info("'Delete Invoice Tooltip' has deviated from it's expected data.  But it displayed as " + s);
                            }
                       /* } else {
                            test.fail("Tooltip Locator has not matched");
                            log.info("Tooltip Locator has not matched");
                        }*/
                    } catch (Exception ex) {
                        test.fail("'Delete' icon  has not clicked.  But it displayed the Exception as..\n" + ex.getMessage());
                        log.info("'Delete' icon has not clicked.  But it displayed the Exception as..\n" + ex.getMessage());
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
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/placeTheCursorOnDeleteIcon.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/placeTheCursorOnDeleteIcon.jpeg").build());
        }
    }

    public static void enterPaidAmount(){
        Obj_Rep_Invoice objInvoice=new Obj_Rep_Invoice();
        PageFactory.initElements(driver,objInvoice);
        objInvoice.paidAmount.sendKeys("MYR 0.00");
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

    public static void clickOnAddTransactionExportButton() throws IOException {
        try {
            File file = new File("D:\\RinggitPay\\Bills2U\\PROPERTY FILE\\fileUpload.properties");
            FileInputStream fileInput = null;
            try {
                fileInput = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            Properties prop = new Properties();
            try {
                prop.load(fileInput);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            log.info("Waiting till the 'Export' button has to be visible");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.addTransactionExportBtn));
            if (objInvoice.addTransactionExportBtn.isDisplayed()) {
                log.info("'Export' button has displayed");
                if (objInvoice.addTransactionExportBtn.isEnabled()) {
                    log.info("'Export' button has enabled to click");
                    log.info("Waiting till the 'Export' button has to be click");
                    wait.until(ExpectedConditions.elementToBeClickable(objInvoice.addTransactionExportBtn));
                    try {
                        act.moveToElement(objInvoice.addTransactionExportBtn).click().build().perform();
                        Thread.sleep(10000);
                        String downloadPath = prop.getProperty("downloadPath");
                        File getLatestFile = getLatestFilefromDir(downloadPath);
                        String fileName = getFileNameWithoutExtension(getLatestFile);
                        System.out.println("File Name :- " + fileName);

                        if (file.exists()) {
                            assert getLatestFile != null;
                            if (getLatestFile.getName().equals(fileName + ".csv")) {
                                test.pass("Biller has able to export the details ");
                                log.info("Biller has able to export the details ");
                            } else {
                                test.fail("The latest file not in .csv extension.  But it has the extension as " + getLatestFile.getName());
                                log.info("The latest file not in .csv extension.  But it has the extension as " + getLatestFile.getName());
                            }
                        } else {
                            assert getLatestFile != null;
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
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnAddTransactionExportButton.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnAddTransactionExportButton.jpeg").build());
        }
    }

    public static void checkDataInExportSheet() throws IOException {
        try {
            File file = new File("D:\\RinggitPay\\Bills2U\\PROPERTY FILE\\fileUpload.properties");
            FileInputStream fileInput = null;
            try {
                fileInput = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            Properties prop = new Properties();
            try {
                prop.load(fileInput);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            Actions act = new Actions(driver);
            act.moveToElement(objInvoice.numberOfEntries).build().perform();
            System.out.println(objInvoice.numberOfEntries.getText());
            int lineNumberCount = 0;
            try {

                String downloadPath = prop.getProperty("downloadPath");
                File getLatestFile = getLatestFilefromDir(downloadPath);
                assert getLatestFile != null;
                String fileName = getLatestFile.getName();
                System.out.println("File Name :- " + fileName);
                System.out.println(downloadPath + getLatestFile.getName());
                if (getLatestFile.exists()) {
                    System.out.println("File found :" + fileName);
                    FileReader fr = new FileReader(file);
                    LineNumberReader linenumberreader = new LineNumberReader(fr);
                    while (linenumberreader.readLine() != null) {
                        lineNumberCount++;
                    }
                    //To remove the header
                    lineNumberCount = lineNumberCount - 1;
                    if (objInvoice.numberOfEntries.getText().equals(String.valueOf(lineNumberCount))) {
                        test.pass("Biller has able to view  the data which are in UI page.");
                        log.info("Biller has able to view  the data which are in UI page.");
                    } else {
                        test.fail("Biller unable to view  the data which are in UI page.  And Number of Count is " + lineNumberCount);
                        log.info("Biller unable to view  the data which are in UI page.  And Number of Count is " + lineNumberCount);
                    }
                    linenumberreader.close();
                } else {
                    System.out.println("File does not exists");
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/checkDataInExportSheet.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/checkDataInExportSheet.jpeg").build());
        }
    }

}
