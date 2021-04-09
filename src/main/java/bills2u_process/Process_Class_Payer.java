package bills2u_process;

import bills2u_constant.*;
import bills2u_root.Root_Class_Payers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Process_Class_Payer extends Root_Class_Payers {

    public static void payerLoginProcess() throws InterruptedException {
        File file = new File("D:\\RinggitPay\\Bills2U\\PROPERTY FILE\\datafile.properties");
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
        Obj_Rep_Home_Payer objHome = new Obj_Rep_Home_Payer();
        PageFactory.initElements(driver, objHome);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Actions act = new Actions(driver);
        Thread.sleep(2000);
        //Click on Login Now
        try {
            log.info("Waiting till the 'Login Now' button is display");
            wait.until(ExpectedConditions.visibilityOf(objHome.payerLoginNowButton));
            log.info("Waiting till the 'Login Now' button is click");
            wait.until(ExpectedConditions.elementToBeClickable(objHome.payerLoginNowButton));
            String loginNowText = objHome.payerLoginNowButton.getText();
            log.info("Clicking on the 'Login now' button");
            objHome.payerLoginNowButton.click();
            log.info(loginNowText + " has clicked");

            //Login page
            Obj_Rep_Login objLogin = new Obj_Rep_Login();
            PageFactory.initElements(driver, objLogin);

            //Enter the username
            log.info("Waiting till the Username text box is display");
            wait.until(ExpectedConditions.visibilityOf(objLogin.username));
            try {
                log.info("Entering username");
                objLogin.username.sendKeys(prop.getProperty("payersUsername"));
                log.info("Username has entered.");
            } catch (Exception ex) {
                log.info("Username has not entered, but it displayed the Exception as.." + ex.getMessage());
                testPayer.fail("Username has not entered, but it displayed the Exception as.." + ex.getMessage());
            }

            //Enter the Password
            log.info("Waiting till the 'Password' is display");
            wait.until(ExpectedConditions.visibilityOf(objLogin.password));
            try {
                log.info("Entering password");
                objLogin.password.sendKeys(prop.getProperty("payersPassword"));
                log.info("Password has entered");
            } catch (Exception ex) {
                log.info("Password has not entered, but it displayed the Exception as.." + ex.getMessage());
                testPayer.fail("Password has not entered, but it displayed the Exception as.." + ex.getMessage());
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
                Thread.sleep(5000);
                log.info("Waiting till the 'Invoices' menu is display");
                wait.until(ExpectedConditions.visibilityOf(objHome.invoicesMenu));
                if (objHome.invoicesMenu.isDisplayed()) {
                    if (objHome.invoicesMenu.getText().equals("Invoices")) {
                        log.info("Waiting till the 'My Direct Debit' menu is display");
                        wait.until(ExpectedConditions.visibilityOf(objHome.myDirectDebitMenu));
                        if (objHome.myDirectDebitMenu.isDisplayed()) {
                            if (objHome.myDirectDebitMenu.getText().equals("My Direct Debit")) {
                                testPayer.pass("Payer has able to navigate to the payer site");
                                log.info("Payer has able to navigate to the payer site");

                                driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                            } else {
                                testPayer.fail("'My Direct Debit' menu has deviated from it's expected result.  But it displayed " + objHome.myDirectDebitMenu.getText());
                                log.info("'My Direct Debit' menu has deviated from it's expected result.  But it displayed " + objHome.myDirectDebitMenu.getText());
                            }
                        } else {
                            log.info("'My Direct Debit' menu has not displayed");
                            testPayer.fail("'My Direct Debit' menu has not displayed");
                        }
                    } else {
                        testPayer.fail("'Invoices' menu has deviated from it's expected result.  But it displayed " + objHome.invoicesMenu.getText());
                        log.info("'Invoices' menu has deviated from it's expected result.  But it displayed " + objHome.invoicesMenu.getText());
                    }
                } else {
                    log.info("'Invoices' menu has not displayed");
                    testPayer.fail("'Invoices' menu has not displayed");
                }
            } catch (Exception ex) {
                log.info("'Login' button has not clicked, but it displayed the Exception as.." + ex.getMessage());
                testPayer.fail("'Login' button has not clicked, but it displayed the Exception as.." + ex.getMessage());
            }
            log.info("Waiting till the Page is loading");
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        } catch (Exception ex) {
            log.info("Login process has not completed.  But it displayed the Exception as..\n" + ex.getMessage());
            testPayer.fail("Login process has not completed.  But it displayed the Exception as..\n" + ex.getMessage());
        }
    }

    public static void logoutProcess() {
        Obj_Rep_Logout_Payer objLogout = new Obj_Rep_Logout_Payer();
        PageFactory.initElements(driver, objLogout);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Actions act = new Actions(driver);
        log.info("Waiting till the logged username is display");
        wait.until(ExpectedConditions.visibilityOf(objLogout.loggedUsername));
        if (objLogout.loggedUsername.isDisplayed()) {
            if (objLogout.loggedUsername.isEnabled()) {
                try {
                    Thread.sleep(5000);
                    log.info("Waiting till the Logged username is click");
                    wait.until(ExpectedConditions.elementToBeClickable(objLogout.loggedUsername));
                    log.info("Clicking on the Logged username");
                    act.moveToElement(objLogout.loggedUsername).click().build().perform();
                    log.info("Logged username has clicked");
                    log.info("Waiting till the Logout is display");
                    wait.until(ExpectedConditions.visibilityOf(objLogout.logOut));
                    if (objLogout.logOut.isDisplayed() == true) {
                        if (objLogout.logOut.isEnabled() == true) {
                            try {
                                log.info("Waiting till the Logout is click");
                                wait.until(ExpectedConditions.elementToBeClickable(objLogout.logOut));
                                log.info("Clicking on the Logout");
                                act.moveToElement(objLogout.logOut).click().build().perform();
                                log.info("Logout has clicked");
                                driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                                Thread.sleep(2000);
                            } catch (Exception e) {
                                log.info("Logout has not clicked.  But it displayed the Exception as " + e.getMessage());
                                testPayer.fail("Logout has not clicked.  But it displayed the Exception as " + e.getMessage());
                            }
                        } else {
                            log.info("Logout has not enabled to click");
                            testPayer.fail("Logout has not enabled to click");
                        }
                    }
                } catch (Exception e) {
                    log.info("Person icon has not clicked.  But it displayed the Exception as " + e.getMessage());
                    testPayer.fail("Person icon has not clicked.  But it displayed the Exception as " + e.getMessage());
                }
            } else {
                log.info("Person Icon has not enabled to click");
                testPayer.fail("Person Icon has not enabled to click");
            }
        } else {
            testPayer.fail("Person Icon has not displayed");
            log.info("Person Icon has not displayed");
        }
    }

    public static void checkDisplayedItems() throws InterruptedException {
        Obj_Rep_Payments_Payer objPayments = new Obj_Rep_Payments_Payer();
        PageFactory.initElements(driver, objPayments);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Actions act = new Actions(driver);
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(objPayments.invoicesHeader));
        if (objPayments.invoicesHeader.isDisplayed() && objPayments.invoicesHeader.getText().equals("Invoices")) {
            wait.until(ExpectedConditions.visibilityOf(objPayments.payForSelectedInvoice));
            if (objPayments.payForSelectedInvoice.isDisplayed() && objPayments.payForSelectedInvoice.getText().equals("PAY")) {
                wait.until(ExpectedConditions.visibilityOf(objPayments.payForAllInvoice));
                if (objPayments.payForAllInvoice.isDisplayed() && objPayments.payForAllInvoice.getText().equals("PAY")) {
                    wait.until(ExpectedConditions.visibilityOf(objPayments.invoiceHashClm));
                    if (objPayments.invoiceHashClm.isDisplayed() && objPayments.invoiceHashClm.getText().equals("Invoice #")) {
                        if (objPayments.dueAmount.isDisplayed() && objPayments.dueAmount.getText().equals("Due Amount")) {
                            if (objPayments.dueDate.isDisplayed() && objPayments.dueDate.getText().equals("Due Date")) {
                                if (objPayments.statusIcon.isDisplayed()) {
                                    if (objPayments.filter.isDisplayed()) {
                                        for (int i = 1; i <= 10; i++) {
                                            WebElement e = driver.findElement(By.xpath("/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/invoices/mat-sidenav-container/mat-sidenav-content/div[2]/invoice-list/mat-card/mat-card-content/mat-table/mat-row[" + i + "]/mat-cell[5]/button/span[1]"));
                                            act.moveToElement(e).build().perform();
                                        }
                                        if (objPayments.footerRights.isDisplayed()) {
                                            if (objPayments.upwardArrow.isDisplayed()) {
                                                testPayer.pass("Payer has able to view this particulars in 'Invoices' page");
                                            } else {
                                                testPayer.fail("'Footer' displayed as " + objPayments.upwardArrow.isDisplayed() + ".");
                                            }

                                        } else {
                                            testPayer.fail("'Footer' displayed as " + objPayments.footerRights.isDisplayed() + ".");
                                        }
                                    } else {
                                        testPayer.fail("'Filter' Icon displayed as " + objPayments.filter.isDisplayed() + ".");
                                    }
                                } else {
                                    testPayer.fail("'Status' Icon displayed as " + objPayments.statusIcon.isDisplayed() + ".");
                                }
                            } else {
                                testPayer.fail("'Due Date' Column displayed as " + objPayments.dueDate.isDisplayed() + ".  Text displayed as " + objPayments.dueDate.getText());
                            }
                        } else {
                            testPayer.fail("'Due Amount' Column displayed as " + objPayments.dueAmount.isDisplayed() + ".  Text displayed as " + objPayments.dueAmount.getText());
                        }
                    } else {
                        testPayer.fail("'Invoices #' Column displayed as " + objPayments.invoiceHashClm.isDisplayed() + ".  Text displayed as " + objPayments.invoiceHashClm.getText());
                    }
                } else {
                    testPayer.fail("'Pay' button for All Invoices displayed as " + objPayments.payForAllInvoice.isDisplayed() + ".  Text displayed as " + objPayments.payForAllInvoice.getText());
                }
            } else {
                testPayer.fail("'Pay' button for selected Invoice displayed as " + objPayments.payForSelectedInvoice.isDisplayed() + ".  Text displayed as " + objPayments.payForSelectedInvoice.getText());
            }
        } else {
            testPayer.fail("'Invoices' title displayed as " + objPayments.invoicesHeader.isDisplayed() + ".  Text displayed as " + objPayments.invoicesHeader.getText());
        }

    }

    public static void checkDisplayedItemsInID() throws InterruptedException {
        Obj_Rep_Payments_Payer objPayments = new Obj_Rep_Payments_Payer();
        PageFactory.initElements(driver, objPayments);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Actions act = new Actions(driver);
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(objPayments.correspondingInvoice));
        if (objPayments.correspondingInvoice.isDisplayed()) {
            wait.until(ExpectedConditions.visibilityOf(objPayments.issueDate));
            if (objPayments.issueDate.isDisplayed() && objPayments.issueDate.getText().equals("Issued Date")) {
                wait.until(ExpectedConditions.visibilityOf(objPayments.dueDateId));
                if (objPayments.dueDateId.isDisplayed() && objPayments.dueDateId.getText().equals("Due Date")) {
                    wait.until(ExpectedConditions.visibilityOf(objPayments.invAmt));
                    if (objPayments.invAmt.isDisplayed() && objPayments.invAmt.getText().equals("Invoice Amount")) {
                        if (objPayments.outAmt.isDisplayed() && objPayments.outAmt.getText().equals("Outstanding Amount")) {
                            if (objPayments.makePayment.isDisplayed() && objPayments.makePayment.getText().equals("Make Payment")) {
                                if (objPayments.payBtn.isDisplayed() && objPayments.payBtn.getText().equals("PAY")) {
                                    if (objPayments.InvoiceLink.isDisplayed()&& objPayments.InvoiceLink.getText().equals("Invoice")) {
                                        if (objPayments.paymentHistoryLink.isDisplayed()&& objPayments.paymentHistoryLink.getText().equals("Payment History")) {
                                            if (objPayments.backLink.isDisplayed()&& objPayments.backLink.getText().equals("Back")) {
                                                if (objPayments.statusIconId.isDisplayed()) {
                                                    testPayer.pass("Payer has able to view this particulars in 'Invoice in detail' page");
                                                } else {
                                                    testPayer.fail("'Status' icon has displayed.");
                                                }
                                            } else {
                                                testPayer.fail("'Back' link displayed as " + objPayments.backLink.isDisplayed() + ".  Text displayed as " + objPayments.backLink.getText());
                                            }

                                        } else {
                                            testPayer.fail("'Payment History' link displayed as " + objPayments.paymentHistoryLink.isDisplayed() + ".  Text displayed as " + objPayments.paymentHistoryLink.getText());
                                        }
                                    } else {
                                        testPayer.fail("'Invoice' Link displayed as " + objPayments.InvoiceLink.isDisplayed() + ".  Text displayed as " + objPayments.InvoiceLink.getText());
                                    }
                                } else {
                                    testPayer.fail("'Pay' button displayed as " + objPayments.payBtn.isDisplayed() + ".  Text displayed as " + objPayments.payBtn.getText());
                                }
                            } else {
                                testPayer.fail("'Make Payment' header displayed as " + objPayments.makePayment.isDisplayed() + ".  Text displayed as " + objPayments.makePayment.getText());
                            }
                        } else {
                            testPayer.fail("'Outstanding Amount' displayed as " + objPayments.outAmt.isDisplayed() + ".  Text displayed as " + objPayments.outAmt.getText());
                        }
                    } else {
                        testPayer.fail("'Invoices Amount' Column displayed as " + objPayments.invAmt.isDisplayed() + ".  Text displayed as " + objPayments.invAmt.getText());
                    }
                } else {
                    testPayer.fail("'Due Date' displayed as " + objPayments.dueDateId.isDisplayed() + ".  Text displayed as " + objPayments.dueDateId.getText());
                }
            } else {
                testPayer.fail("'Issued Date' displayed as " + objPayments.issueDate.isDisplayed() + ".  Text displayed as " + objPayments.issueDate.getText());
            }
        } else {
            testPayer.fail("'Respective Invoices' title displayed as " + objPayments.correspondingInvoice.isDisplayed() + ". " );
        }

    }

    public static void checkDisplayedItemsInInvoice() throws InterruptedException {
        Obj_Rep_Payments_Payer objPayments = new Obj_Rep_Payments_Payer();
        PageFactory.initElements(driver, objPayments);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Actions act = new Actions(driver);
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(objPayments.InvoiceLink));
        act.moveToElement(objPayments.InvoiceLink).build().perform();
        if (objPayments.InvoiceLink.isDisplayed()) {
            wait.until(ExpectedConditions.visibilityOf(objPayments.merchantLogo));
            act.moveToElement(objPayments.merchantLogo).build().perform();
            if (objPayments.merchantLogo.isDisplayed()) {

                wait.until(ExpectedConditions.visibilityOf(objPayments.InvDetailTable));
                act.moveToElement(objPayments.InvDetailTable).build().perform();
                if (objPayments.InvDetailTable.isDisplayed()) {

                    wait.until(ExpectedConditions.visibilityOf(objPayments.InvIssueDate));
                    act.moveToElement(objPayments.InvIssueDate).build().perform();
                    if (objPayments.InvIssueDate.isDisplayed()) {
                        if (objPayments.outAmt.isDisplayed() && objPayments.outAmt.getText().equals("Outstanding Amount")) {
                            if (objPayments.makePayment.isDisplayed() && objPayments.makePayment.getText().equals("Make Payment")) {
                                if (objPayments.payBtn.isDisplayed() && objPayments.payBtn.getText().equals("PAY")) {
                                    if (objPayments.InvoiceLink.isDisplayed()&& objPayments.InvoiceLink.getText().equals("Invoice")) {
                                        if (objPayments.paymentHistoryLink.isDisplayed()&& objPayments.paymentHistoryLink.getText().equals("Payment History")) {
                                            if (objPayments.backLink.isDisplayed()&& objPayments.backLink.getText().equals("Back")) {
                                                if (objPayments.statusIconId.isDisplayed()) {
                                                    testPayer.pass("Payer has able to view this particulars in 'Invoice in detail' page");
                                                } else {
                                                    testPayer.fail("'Status' icon has displayed.");
                                                }
                                            } else {
                                                testPayer.fail("'Back' link displayed as " + objPayments.backLink.isDisplayed() + ".  Text displayed as " + objPayments.backLink.getText());
                                            }

                                        } else {
                                            testPayer.fail("'Payment History' link displayed as " + objPayments.paymentHistoryLink.isDisplayed() + ".  Text displayed as " + objPayments.paymentHistoryLink.getText());
                                        }
                                    } else {
                                        testPayer.fail("'Invoice' Link displayed as " + objPayments.InvoiceLink.isDisplayed() + ".  Text displayed as " + objPayments.InvoiceLink.getText());
                                    }
                                } else {
                                    testPayer.fail("'Pay' button displayed as " + objPayments.payBtn.isDisplayed() + ".  Text displayed as " + objPayments.payBtn.getText());
                                }
                            } else {
                                testPayer.fail("'Make Payment' header displayed as " + objPayments.makePayment.isDisplayed() + ".  Text displayed as " + objPayments.makePayment.getText());
                            }
                        } else {
                            testPayer.fail("'Outstanding Amount' displayed as " + objPayments.outAmt.isDisplayed() + ".  Text displayed as " + objPayments.outAmt.getText());
                        }
                    } else {
                        testPayer.fail("'Invoices Amount' Column displayed as " + objPayments.invAmt.isDisplayed() + ".  Text displayed as " + objPayments.invAmt.getText());
                    }
                } else {
                    testPayer.fail("'Due Date' displayed as " + objPayments.dueDateId.isDisplayed() + ".  Text displayed as " + objPayments.dueDateId.getText());
                }
            } else {
                testPayer.fail("'Issued Date' displayed as " + objPayments.issueDate.isDisplayed() + ".  Text displayed as " + objPayments.issueDate.getText());
            }
        } else {
            testPayer.fail("'Respective Invoices' title displayed as " + objPayments.correspondingInvoice.isDisplayed() + ". " );
        }

    }

    public static void checkOutstandingAmt(){
        Obj_Rep_Payments_Payer objPayments = new Obj_Rep_Payments_Payer();
        PageFactory.initElements(driver, objPayments);
        if (objPayments.outAmt.isDisplayed() && objPayments.outAmt.getText().equals("Outstanding Amount")) {
            testPayer.pass("Payer has able to view the Outstanding Amount in Make Payment");
        } else {
            testPayer.fail("'Outstanding Amount' displayed as " + objPayments.outAmt.isDisplayed() + ".  Text displayed as " + objPayments.outAmt.getText());
        }
    }

    public static void checkDueAmtAndDate() throws InterruptedException {
        Obj_Rep_Payments_Payer objPayments = new Obj_Rep_Payments_Payer();
        PageFactory.initElements(driver, objPayments);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Actions act = new Actions(driver);
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(objPayments.invoicesHeader));
        if (objPayments.dueAmtValue.isDisplayed()) {
            if (objPayments.dueDateValue.isDisplayed()) {
                testPayer.pass("payer has able to view the due date and Due Amount of the invoice");
            } else {
                testPayer.fail("'Due Date' Column displayed as " + objPayments.dueDate.isDisplayed() + ".  Text displayed as " + objPayments.dueDate.getText());
            }
        } else {
            testPayer.fail("'Due Amount' Column displayed as " + objPayments.dueAmount.isDisplayed() + ".  Text displayed as " + objPayments.dueAmount.getText());
        }
    }

    public static void checkOnPayforSelected() throws InterruptedException {
        Obj_Rep_Payments_Payer objPayment = new Obj_Rep_Payments_Payer();
        PageFactory.initElements(driver, objPayment);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        log.info("Waiting till the 'Pay' button is display");
        wait.until(ExpectedConditions.visibilityOf(objPayment.payForSelectedInvoice));
        if (objPayment.payForSelectedInvoice.isDisplayed() == true) {
            if (objPayment.payForSelectedInvoice.isEnabled() == true) {
                testPayer.pass("Payer has able to view the 'Pay' button ");
            } else {
                testPayer.fail("'Payment' menu has not enabled");
                log.info("'Payment' menu has not enabled");
            }
        } else {
            testPayer.fail("'Payment' menu has not displayed");
            log.info("'Payment' menu has not displayed");
        }
    }

    public static void clickOnPayforSelected() throws InterruptedException {
        Obj_Rep_Payments_Payer objPayment = new Obj_Rep_Payments_Payer();
        PageFactory.initElements(driver, objPayment);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        log.info("Waiting till the 'Pay' button is display");
        wait.until(ExpectedConditions.visibilityOf(objPayment.payForSelectedInvoice));
        if (objPayment.payForSelectedInvoice.isDisplayed() == true) {
            if (objPayment.payForSelectedInvoice.isEnabled() == true) {
                Actions act = new Actions(driver);
                act.moveToElement(objPayment.payForSelectedInvoice).click().build().perform();
                Thread.sleep(5000);
                log.info("Waiting till the 'Confirm Payment' title is display");
                wait.until(ExpectedConditions.visibilityOf(objPayment.confirmPaymentHeader));
                if (objPayment.confirmPaymentHeader.isDisplayed()) {
                    if (objPayment.confirmPaymentHeader.getText().equals("Confirm Payment")) {
                        testPayer.pass("Payer has able to view the payments details of the invoice in 'Confirm payment' pop-up");
                    } else {
                        testPayer.fail("'Confirm Payment' has deviate from it's expected data.  And it displayed the title as '" + objPayment.confirmPaymentHeader.getText() + "'.");
                        log.info("'Confirm Payment' has deviate from it's expected data.  And it displayed the title as '" + objPayment.confirmPaymentHeader.getText() + "'.");
                    }
                } else {
                    testPayer.fail("'Confirm Payment' header has not displayed");
                    log.info("'Confirm Payment' header has not displayed");
                }
            } else {
                testPayer.fail("'Payment' menu has not enabled");
                log.info("'Payment' menu has not enabled");
            }
        } else {
            testPayer.fail("'Payment' menu has not displayed");
            log.info("'Payment' menu has not displayed");
        }
    }

    public static void clickOnPayInID() throws InterruptedException {
        Obj_Rep_Payments_Payer objPayment = new Obj_Rep_Payments_Payer();
        PageFactory.initElements(driver, objPayment);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        log.info("Waiting till the 'Pay' button is display");
        wait.until(ExpectedConditions.visibilityOf(objPayment.payBtn));
        if (objPayment.payBtn.isDisplayed() == true) {
            if (objPayment.payBtn.isEnabled() == true) {
                Actions act = new Actions(driver);
                act.moveToElement(objPayment.payBtn).click().build().perform();
                Thread.sleep(5000);
                log.info("Waiting till the 'Confirm Payment' title is display");
                wait.until(ExpectedConditions.visibilityOf(objPayment.confirmPaymentHeader));
                if (objPayment.confirmPaymentHeader.isDisplayed()) {
                    if (objPayment.confirmPaymentHeader.getText().equals("Confirm Payment")) {
                        testPayer.pass("Payer has able to view the payments details of the invoice in 'Confirm payment' pop-up");
                    } else {
                        testPayer.fail("'Confirm Payment' has deviate from it's expected data.  And it displayed the title as '" + objPayment.confirmPaymentHeader.getText() + "'.");
                        log.info("'Confirm Payment' has deviate from it's expected data.  And it displayed the title as '" + objPayment.confirmPaymentHeader.getText() + "'.");
                    }
                } else {
                    testPayer.fail("'Confirm Payment' header has not displayed");
                    log.info("'Confirm Payment' header has not displayed");
                }
            } else {
                testPayer.fail("'Payment' menu has not enabled");
                log.info("'Payment' menu has not enabled");
            }
        } else {
            testPayer.fail("'Payment' menu has not displayed");
            log.info("'Payment' menu has not displayed");
        }
    }

    public static void clickOnRespectiveInvNo() throws InterruptedException {
        Obj_Rep_Payments_Payer objPayment = new Obj_Rep_Payments_Payer();
        PageFactory.initElements(driver, objPayment);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        log.info("Waiting till the 'Invoice number' is display");
        wait.until(ExpectedConditions.visibilityOf(objPayment.respectiveInvoice));
        if (objPayment.respectiveInvoice.isDisplayed() == true) {
            if (objPayment.respectiveInvoice.isEnabled() == true) {
                String s=objPayment.respectiveInvoice.getText();
                Actions act = new Actions(driver);
                act.moveToElement(objPayment.respectiveInvoice).click().build().perform();
                Thread.sleep(5000);
                log.info("Waiting till the 'Corresponding Invoice number' title is display");
                wait.until(ExpectedConditions.visibilityOf(objPayment.correspondingInvoice));
                if (objPayment.correspondingInvoice.isDisplayed()) {
                    if (objPayment.correspondingInvoice.getText().equals(s)) {
                        testPayer.pass("Payer has able to navigate to the 'Invoice in detail' page");
                    } else {
                        testPayer.fail("'Corresponding Invoice number' has deviate from it's expected data.  And it displayed the title as '" + objPayment.correspondingInvoice.getText() + "'.");
                        log.info("'Corresponding Invoice number' has deviate from it's expected data.  And it displayed the title as '" + objPayment.correspondingInvoice.getText() + "'.");
                    }
                } else {
                    testPayer.fail("'Corresponding Invoice number' header has not displayed");
                    log.info("'Corresponding Invoice number' header has not displayed");
                }
            } else {
                testPayer.fail("'Respective Invoice' menu has not enabled");
                log.info("'Respective Invoice' menu has not enabled");
            }
        } else {
            testPayer.fail("'Respective Invoice' menu has not displayed");
            log.info("'Respective Invoice' menu has not displayed");
        }
    }

    public static void clickOnSelectAllChkBox() throws InterruptedException {
        Obj_Rep_Payments_Payer objPayment = new Obj_Rep_Payments_Payer();
        PageFactory.initElements(driver, objPayment);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        log.info("Waiting till the 'Select all' button is display");
        wait.until(ExpectedConditions.visibilityOf(objPayment.selectAllCheckBox));
        if (objPayment.selectAllCheckBox.isDisplayed() == true) {
            if (objPayment.selectAllCheckBox.isEnabled() == true) {
                Actions act = new Actions(driver);
                act.moveToElement(objPayment.selectAllCheckBox).click().build().perform();
                Thread.sleep(5000);
                if (objPayment.checkSelectedSelectAllCheckBox.getAttribute("aria-checked").equals("true")) {
                    testPayer.pass("Payer has able to select the respective invoices");
                } else {
                    testPayer.fail("'Select' has deviate from it's expected data.  And it displayed the title as '" + objPayment.checkSelectedSelectAllCheckBox.getAttribute("aria-checked") + "'.");
                }
            } else {
                testPayer.fail("'Select All' checkbox has not enabled");
            }
        } else {
            testPayer.fail("'Select All' checkbox has not displayed");
        }
    }

    public static void checkTotalOutstanding(){
        Obj_Rep_Payments_Payer objPayment=new Obj_Rep_Payments_Payer();
        PageFactory.initElements(driver,objPayment);
        try{
            String amt=objPayment.totalOutstandingAmt.getText();
            testPayer.pass("Payer has able to view the correct 'Total Outstanding' Amount as "+amt+" of the selected invoices");
        }catch (Exception ex){
            testPayer.fail("Payer has not view the 'Total Outstanding' Amount.  but it displayed the exception as.."+ex.getMessage());
        }
    }

    public static void closeButton(){
        Obj_Rep_Payments_Payer objPayment=new Obj_Rep_Payments_Payer();
        PageFactory.initElements(driver,objPayment);
        objPayment.closeIcon.click();
    }

    public static void clickOnPayments() {
        Obj_Rep_Home_Payer objHome = new Obj_Rep_Home_Payer();
        PageFactory.initElements(driver, objHome);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        log.info("Waiting till the 'Payments' menu is display");
        wait.until(ExpectedConditions.visibilityOf(objHome.paymentsMenu));
        if (objHome.paymentsMenu.isDisplayed() == true)
        {
            if(objHome.paymentsMenu.isEnabled()==true)
            {
                try {
                    Actions act=new Actions(driver);
                    act.moveToElement(objHome.paymentsMenu).click().build().perform();
                    Thread.sleep(5000);
                    Obj_Rep_Payments_Payer objPayments=new Obj_Rep_Payments_Payer();
                    PageFactory.initElements(driver,objPayments);
                    log.info("Waiting till the 'Payment History' title is display");
                    wait.until(ExpectedConditions.visibilityOf(objPayments.paymentsHeader));
                    if(objPayments.paymentsHeader.isDisplayed()==true)
                    {
                        if(objPayments.paymentsHeader.getText().equals("Payment History"))
                        {
                            testPayer.pass("Payer has able to navigate to the Payments page");
                            log.info("Payer has able to navigate to the Payments page");
                        }
                        else
                        {
                            testPayer.fail("'Payment History' has deviate from it's expected data.  And it displayed the title as '"+objPayments.paymentsHeader.getText()+"'.");
                            log.info("'Payment History' has deviate from it's expected data.  And it displayed the title as '"+objPayments.paymentsHeader.getText()+"'.");
                        }
                    }
                    else
                    {
                        testPayer.fail("'Payment History' header has not displayed");
                        log.info("'Payment History' header has not displayed");
                    }

                }catch (Exception ex)
                {

                }
            }
            else
            {
                testPayer.fail("'Payment' menu has not enabled");
                log.info("'Payment' menu has not enabled");
            }
        }
        else
        {
            testPayer.fail("'Payment' menu has not displayed");
            log.info("'Payment' menu has not displayed");
        }
    }

    public static void placeTheCursorOnShowFilter()
    {
        Obj_Rep_Payments_Payer objPayments=new Obj_Rep_Payments_Payer();
        PageFactory.initElements(driver,objPayments);
        Obj_Rep_Tooltip_Payer objTooltip=new Obj_Rep_Tooltip_Payer();
        PageFactory.initElements(driver,objTooltip);
        WebDriverWait wait=new WebDriverWait(driver,30);
        Actions act=new Actions(driver);
        log.info("Waiting till the 'Filter' is display");
        wait.until(ExpectedConditions.visibilityOf(objPayments.filter));
        if(objPayments.filter.isDisplayed()==true){
            if (objPayments.filter.isEnabled()==true){
                log.info("Waiting till the 'Filter' is click");
                wait.until(ExpectedConditions.elementToBeClickable(objPayments.filter));
                try {
                    log.info("Placing the cursor on 'Filter'");
                    act.moveToElement(objPayments.filter).build().perform();
                    Thread.sleep(5000);

                    if(objTooltip.filter.getAttribute("aria-describedby").equals(objTooltip.filterTooltip.getAttribute("id"))){
                        JavascriptExecutor j=(JavascriptExecutor) driver;
                        j.executeScript("document.getElementById('cdk-describedby-message-10').value='Filter';");
                        String s=(String) j.executeScript("return document.getElementById('cdk-describedby-message-10').value");
                        System.out.println(s);
                        if(s.equals("Filter"))
                        {
                            testPayer.pass("Payer has able to view the tooltip as 'Filter'");
                            log.info("Payer has able to view the tooltip as 'Filter'");
                        }
                        else
                        {
                            testPayer.fail("'Filter Tooltip' has deviated from it's expected data.  But it displayed as "+s);
                            log.info("'Filter Tooltip' has deviated from it's expected data.  But it displayed as "+s);
                        }
                    } else {
                        testPayer.fail("Tooltip Locator has not matched");
                        log.info("Tooltip Locator has not matched");
                    }
                }catch (Exception ex){
                    testPayer.fail("Filter has not clicked.  But it displayed the Exception as..\n"+ex.getMessage());
                    log.info("Filter has not clicked.  But it displayed the Exception as..\n"+ex.getMessage());
                }
            }else {
                testPayer.fail("'Filter' has not enabled to click");
                log.info("'Filter' has not enabled to click");
            }
        }else {
            testPayer.fail("'Filter' has not displayed");
            log.info("'Filter' has not displayed");
        }
    }

}
