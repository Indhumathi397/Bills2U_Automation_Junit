package bills2u_process;

import Config.PropertyClass;
import bills2u_constant.Obj_Rep_Home;
import bills2u_constant.Obj_Rep_Invoice;
import bills2u_constant.Obj_Rep_Login;
import bills2u_root.Root_Class_TestNG;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.io.Files;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Invoice_Listing_Process extends Root_Class_TestNG {
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
    public static void clickOnInvoiceListMenuProcess() throws IOException {
        try {
            Obj_Rep_Home objHome = new Obj_Rep_Home();
            PageFactory.initElements(driver, objHome);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            log.info("Waiting till the 'Invoice List' menu is display");
            wait.until(ExpectedConditions.visibilityOf(objHome.invoiceListMenu));
            log.info("Waiting till the 'Invoice List' menu is click");
            wait.until(ExpectedConditions.elementToBeClickable(objHome.invoiceListMenu));
            try {
                log.info("Clicking on the 'Invoice List' menu");
                act.moveToElement(objHome.invoiceListMenu).click().build().perform();
                log.info("'Invoice List' menu has clicked");
                Thread.sleep(5000);
                log.info("Waiting till the Page is loading");
                driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
                PageFactory.initElements(driver, objInvoice);
                log.info("Waiting till the 'Invoice List' label is display");
                if (objInvoice.invoiceListHeader.isDisplayed()) {
                    test.pass("Biller has able click and view the Invoice listing page.");
                    log.info("Biller has able click and view the Invoice listing page.");
                } else {
                    test.fail("Biller has not able click and view the Invoice listing page.");
                    log.info("Biller has not able click and view the Invoice listing page.");
                }
            } catch (Exception ex) {
                log.info("'Invoice List' menu has not clicked.   But it displayed the exception as...\n" + ex.getMessage());
                test.fail("'Invoice List' menu has not clicked.   But it displayed the exception as...\n" + ex.getMessage());
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnInvoiceListMenuProcess.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnInvoiceListMenuProcess.jpeg").build());
        }
    }
    public static void clickOnShowFilter() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            log.info("Waiting till the 'Show Filter' label is display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.showAndHideFilterInvoiceList));
            if (objInvoice.showAndHideFilterInvoiceList.isDisplayed()) {
                if (objInvoice.showAndHideFilterInvoiceList.isEnabled()) {
                    log.info("Waiting till the 'Show Filter' is click");
                    wait.until(ExpectedConditions.elementToBeClickable(objInvoice.showAndHideFilterInvoiceList));
                    try {
                        log.info("Clicking on the 'Show Filter'");
                        act.moveToElement(objInvoice.showAndHideFilterInvoiceList).click().build().perform();
                        log.info("'Show Filter' has clicked");
                        if (objInvoice.showAndHideFilterInvoiceList.getText().equals("Hide Filter")) {
                            test.pass("Biller has able to click and expand the filter section.");
                            log.info("Biller has able to click and expand the filter section.");
                        } else {
                            test.fail("'Hide Filter' has deviated from it's expected data.  But it displayed as " + objInvoice.showAndHideFilterPayments.getText());
                            log.info("'Hide Filter' has deviated from it's expected data.  But it displayed as " + objInvoice.showAndHideFilterPayments.getText());
                        }
                    } catch (Exception ex) {
                        test.fail("Show Filter has not clicked.  But it displayed the Exception as..\n" + ex.getMessage());
                        log.info("Show Filter has not clicked.  But it displayed the Exception as..\n" + ex.getMessage());
                    }
                } else {
                    test.fail("'Show Filter' has not enabled to click");
                    log.info("'Show Filter' has not enabled to click");
                }
            } else {
                test.fail("'Show Filter' has not displayed");
                log.info("'Show Filter' has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnShowFilter.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnShowFilter.jpeg").build());
        }
    }
    public static void checkIncludeDraft() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            log.info("Waiting till the 'Include Draft' check box is display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.includeDraft));
            if (objInvoice.includeDraft.isDisplayed()) {
                log.info("'Include Draft' has displayed");
                if (objInvoice.includeDraft.isEnabled()) {
                    log.info("'Include Draft' has Enabled to click");
                    log.info("Waiting till the 'Include Draft' is click");
                    wait.until(ExpectedConditions.elementToBeClickable(objInvoice.includeDraft));
                    try {
                        log.info("Clicking on the 'Include Draft'");
                        act.moveToElement(objInvoice.includeDraft).click().build().perform();
                        log.info("'Invoice Draft' has clicked");
                        if (objInvoice.includeDraft.getAttribute("aria-checked").equals("true")) {
                            test.pass("Biller has able to select the checkbox of 'Include Draft' field");
                            log.info("Biller has able to select the checkbox of 'Include Draft' field");
                        } else {
                            test.fail("Biller has not able to click.  It has been selected:" + objInvoice.includeDraft.getAttribute("aria-checked"));
                            log.info("Biller has not able to click.  It has been selected:" + objInvoice.includeDraft.getAttribute("aria-checked"));
                        }
                    } catch (Exception ex) {
                        test.fail("'Include Draft' checkbox has not clicked.  But it displayed the Exception as...\n" + ex.getMessage());
                        log.info("'Include Draft' checkbox has not clicked.  But it displayed the Exception as...\n" + ex.getMessage());
                    }
                } else {
                    log.info("'Include Draft' has not Enabled to click");
                    test.fail("'Include Draft' has not Enabled to click");
                }
            } else {
                test.fail("'Include Draft' has not displayed");
                log.info("'Include Draft' has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/checkIncludeDraft.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/checkIncludeDraft.jpeg").build());
        }
    }
    public static void uncheckIncludeDraft() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            log.info("Waiting till the 'Include Draft' check box is display");
            wait.until(ExpectedConditions.visibilityOf(objInvoice.includeDraft));
            if (objInvoice.includeDraft.isDisplayed()) {
                log.info("'Include Draft' has displayed");
                if (objInvoice.includeDraft.isEnabled()) {
                    log.info("'Include Draft' has Enabled to click");
                    log.info("Waiting till the 'Include Draft' is click");
                    wait.until(ExpectedConditions.elementToBeClickable(objInvoice.includeDraft));
                    try {
                        log.info("Clicking on the 'Include Draft'");
                        act.moveToElement(objInvoice.includeDraft).click().build().perform();
                        act.moveToElement(objInvoice.includeDraft).click().build().perform();
                        log.info("'Invoice Draft' has clicked");
                        if (objInvoice.includeDraft.getAttribute("aria-checked").equals("false")) {
                            test.pass("Biller has able to unselect the checkbox of 'Include Draft' field");
                            log.info("Biller has able to unselect the checkbox of 'Include Draft' field");
                        } else {
                            test.fail("Biller has not able to click.  It has been selected:" + objInvoice.includeDraft.getAttribute("aria-checked"));
                            log.info("Biller has not able to click.  It has been selected:" + objInvoice.includeDraft.getAttribute("aria-checked"));
                        }
                    } catch (Exception ex) {
                        test.fail("'Include Draft' checkbox has not clicked.  But it displayed the Exception as...\n" + ex.getMessage());
                        log.info("'Include Draft' checkbox has not clicked.  But it displayed the Exception as...\n" + ex.getMessage());
                    }
                } else {
                    log.info("'Include Draft' has not Enabled to click");
                    test.fail("'Include Draft' has not Enabled to click");
                }
            } else {
                test.fail("'Include Draft' has not displayed");
                log.info("'Include Draft' has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/uncheckIncludeDraft.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/uncheckIncludeDraft.jpeg").build());
        }
    }
    public static void selectAllFromBatches() throws IOException {
        try {
            Obj_Rep_Invoice objInvoice = new Obj_Rep_Invoice();
            PageFactory.initElements(driver, objInvoice);
            objInvoice.batchesDropDown.click();
            Thread.sleep(5000);
            try {
                Actions act = new Actions(driver);
                act.moveToElement(objInvoice.selectAllCheckbox).click().build().perform();
                Thread.sleep(5000);
                test.pass("Biller has able to select the 'select all' option by using drop down.");
            } catch (Exception ex) {
                test.fail("Biller has not able to select the 'select all' option by using drop down.  And it displayed the Exception as.." + ex.getMessage());
            }
            objInvoice.selectAllCheckbox.sendKeys(Keys.ESCAPE);
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/selectAllFromBatches.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/selectAllFromBatches.jpeg").build());
        }
    }

}
