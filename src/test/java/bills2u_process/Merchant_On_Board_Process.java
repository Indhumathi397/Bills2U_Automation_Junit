package bills2u_process;

import Config.PropertyClass;
import bills2u_constant.Obj_Rep_Home;
import bills2u_constant.Obj_Rep_Login;
import bills2u_constant.Obj_Rep_Setup;
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

public class Merchant_On_Board_Process extends Root_Class_TestNG {
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
    public static void clickOnSetupMenuProcess() throws IOException {
        try {
            Obj_Rep_Home objHome = new Obj_Rep_Home();
            PageFactory.initElements(driver, objHome);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            log.info("Waiting till the 'Setup' menu is visible");
            wait.until(ExpectedConditions.visibilityOf(objHome.setupMenu));
            if (objHome.setupMenu.isDisplayed()) {
                if (objHome.setupMenu.getText().equals("Setup")) {
                    if (objHome.setupMenu.isEnabled()) {
                        log.info("Waiting till the 'Setup' menu is click");
                        wait.until(ExpectedConditions.elementToBeClickable(objHome.setupMenu));
                        log.info("Clicking on the 'Setup' menu");
                        try {
                            act.moveToElement(objHome.setupMenu).build().perform();
                            log.info("'Setup' menu has clicked");
                        } catch (Exception ex) {
                            test.fail("'Setup' menu has not clicked.  But it displayed the exception as.." + ex.getMessage());
                            log.info("'Setup' menu has not clicked.  But it displayed the exception as.." + ex.getMessage());
                        }
                    } else {
                        test.fail("'Setup' menu has not enabled to click");
                        log.info("'Setup' menu has not enabled to click");
                    }
                } else {
                    test.fail("'Setup' label has deviated from it's expected data.  And, it displayed the label as '" + objHome.setupMenu.getText() + "'");
                    log.info("'Setup' label has deviated from it's expected data.  And, it displayed the label as '" + objHome.setupMenu.getText() + "'");
                }
            } else {
                log.info("'Setup' menu has not displayed");
                test.fail("'Setup' menu has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnSetupMenuProcess.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnSetupMenuProcess.jpeg").build());
        }
    }
    public static void clickOnMerchantMenuProcess() throws IOException {
        try {
            Obj_Rep_Home objHome = new Obj_Rep_Home();
            PageFactory.initElements(driver, objHome);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            log.info("Waiting till the 'Merchant' menu is visible");
            wait.until(ExpectedConditions.visibilityOf(objHome.merchantMenu));
            if (objHome.merchantMenu.isDisplayed()) {
                if (objHome.merchantMenu.getText().equals("Merchant")) {
                    if (objHome.merchantMenu.isEnabled()) {
                        log.info("Waiting till the 'Merchant' menu is click");
                        wait.until(ExpectedConditions.elementToBeClickable(objHome.merchantMenu));
                        log.info("Clicking on the 'Merchant' menu");
                        try {
                            act.moveToElement(objHome.merchantMenu).click().build().perform();
                            log.info("'Merchant' menu has clicked");
                            Thread.sleep(5000);
                            Obj_Rep_Setup objSetup = new Obj_Rep_Setup();
                            PageFactory.initElements(driver, objSetup);
                            log.info("Waiting till the 'Merchant' label is visible");
                            wait.until(ExpectedConditions.visibilityOf(objSetup.merchantHeader));
                            if (objSetup.merchantHeader.isDisplayed()) {
                                if (objSetup.merchantHeader.getText().equals("Merchant")) {
                                    test.pass("Biller has able to view the Biller Onboard List view screen");
                                    log.info("Biller has able to view the Biller Onboard List view screen");
                                } else {
                                    test.fail("'Merchant' label has deviated from it's expected data.  And, it displayed the label as '" + objSetup.merchantHeader.getText() + "'");
                                    log.info("'Merchant' label has deviated from it's expected data.  And, it displayed the label as '" + objSetup.merchantHeader.getText() + "'");
                                }
                            } else {
                                log.info("'Merchant' label has not displayed");
                                test.fail("'Merchant' label has not displayed");
                            }
                        } catch (Exception ex) {
                            test.fail("'Merchant' menu has not clicked.  But it displayed the exception as.." + ex.getMessage());
                            log.info("'Merchant' menu has not clicked.  But it displayed the exception as.." + ex.getMessage());
                        }
                    } else {
                        test.fail("'Merchant' menu has not enabled to click");
                        log.info("'Merchant' menu has not enabled to click");
                    }
                } else {
                    test.fail("'Merchant' label has deviated from it's expected data.  And, it displayed the label as '" + objHome.merchantMenu.getText() + "'");
                    log.info("'Merchant' label has deviated from it's expected data.  And, it displayed the label as '" + objHome.merchantMenu.getText() + "'");
                }
            } else {
                log.info("'Merchant' menu has not displayed");
                test.fail("'Merchant' menu has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnMerchantMenuProcess.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnMerchantMenuProcess.jpeg").build());
        }
    }
    public static void enterBusinessName() throws IOException {
        try {
            getTestData();
            Obj_Rep_Setup objSetup = new Obj_Rep_Setup();
            PageFactory.initElements(driver, objSetup);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(objSetup.businessName));
            if (objSetup.businessName.isDisplayed()) {
                objSetup.businessName.sendKeys(prop.getProperty("Bills2U.MerchantOnBoard.businessName"));
                if (objSetup.getBusinessName.getText().equals(prop.getProperty("Bills2U.MerchantOnBoard.businessName"))) {
                    test.pass("Biller has able to filter and view the records based on entered key word");
                    log.info("Biller has able to filter and view the records based on entered key word");
                } else {
                    test.fail("Biller has not able to filter and view the records based on entered key word");
                    log.info("Biller has not able to filter and view the records based on entered key word");
                }
            } else {
                test.fail("'Business Name' text box has not displayed");
                log.info("'Business Name' text box has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/enterBusinessName.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/enterBusinessName.jpeg").build());
        }
    }
    public static void enterContactName() throws IOException {
        try {
            getTestData();
            Obj_Rep_Setup objSetup = new Obj_Rep_Setup();
            PageFactory.initElements(driver, objSetup);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(objSetup.contactName));
            if (objSetup.contactName.isDisplayed()) {
                objSetup.contactName.sendKeys(prop.getProperty("Bills2U.MerchantOnBoard.contactName"));
                if (objSetup.getContactName.getText().equals(prop.getProperty("Bills2U.MerchantOnBoard.contactName"))) {
                    test.pass("Biller has able to filter and view the records based on entered key word");
                    log.info("Biller has able to filter and view the records based on entered key word");
                } else {
                    test.fail("Biller has not able to filter and view the records based on entered key word");
                    log.info("Biller has not able to filter and view the records based on entered key word");
                }
            } else {
                test.fail("'Contact Name' text box has not displayed");
                log.info("'Contact Name' text box has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/enterContactName.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/enterContactName.jpeg").build());
        }
    }
    public static void enterEmail() throws IOException {
        try {
            getTestData();
            Obj_Rep_Setup objSetup = new Obj_Rep_Setup();
            PageFactory.initElements(driver, objSetup);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(objSetup.email));
            if (objSetup.email.isDisplayed()) {
                objSetup.email.sendKeys(prop.getProperty("Bills2U.MerchantOnBoard.email"));
                if (objSetup.getEmail.getText().equals(prop.getProperty("Bills2U.MerchantOnBoard.email"))) {
                    test.pass("Biller has able to filter and view the records based on entered key word");
                    log.info("Biller has able to filter and view the records based on entered key word");
                } else {
                    test.fail("Biller has not able to filter and view the records based on entered key word");
                    log.info("Biller has not able to filter and view the records based on entered key word");
                }
            } else {
                test.fail("'Email' text box has not displayed");
                log.info("'Email' text box has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/enterEmail.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/enterEmail.jpeg").build());
        }
    }
    public static void enterPhone() throws IOException {
        try {
            getTestData();
            Obj_Rep_Setup objSetup = new Obj_Rep_Setup();
            PageFactory.initElements(driver, objSetup);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(objSetup.phone));
            if (objSetup.phone.isDisplayed()) {
                objSetup.phone.sendKeys(prop.getProperty("Bills2U.MerchantOnBoard.phone"));
                if (objSetup.getPhone.getText().equals(prop.getProperty("Bills2U.MerchantOnBoard.phone"))) {
                    test.pass("Biller has able to filter and view the records based on entered key word");
                    log.info("Biller has able to filter and view the records based on entered key word");
                } else {
                    test.fail("Biller has not able to filter and view the records based on entered key word");
                    log.info("Biller has not able to filter and view the records based on entered key word");
                }
            } else {
                test.fail("'Phone' text box has not displayed");
                log.info("'Phone' text box has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/enterPhone.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/enterPhone.jpeg").build());
        }
    }
    public static void selectActiveStatus() throws IOException {
        try {
            getTestData();
            Obj_Rep_Setup objSetup = new Obj_Rep_Setup();
            PageFactory.initElements(driver, objSetup);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(objSetup.isActive));
            if (objSetup.isActive.isDisplayed()) {

                objSetup.isActive.sendKeys(Keys.ENTER, prop.getProperty("Bills2U.MerchantOnBoard.isActive"));
                Thread.sleep(5000);
                objSetup.isActive.sendKeys(Keys.ENTER);
                Thread.sleep(5000);
                String s = objSetup.noResult.getText();
                try {
                    if (objSetup.getIsActive.getText().equals(prop.getProperty("Bills2U.MerchantOnBoard.isActive"))) {
                        test.pass("Biller has able to filter and view the records based on entered key word");
                        log.info("Biller has able to filter and view the records based on entered key word");
                    } else {
                        test.fail("Biller has not able to filter and view the records based on entered key word");
                        log.info("Biller has not able to filter and view the records based on entered key word");
                    }
                } catch (Exception e) {
                    if (s.equals(prop.getProperty("Bills2U.MerchantOnBoard.NoResult"))) {
                        test.pass("Biller has able to filter and view the records based on entered key word");
                        log.info("Biller has able to filter and view the records based on entered key word");
                    } else {
                        test.fail("Biller has not able to filter and view the records based on entered key word");
                        log.info("Biller has not able to filter and view the records based on entered key word");
                    }
                }
            } else {
                test.fail("'Is Active' text box has not displayed");
                log.info("'Is Active' text box has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/selectActiveStatus.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/selectActiveStatus.jpeg").build());
        }
    }
    public static void clickOnAddMerchant() throws IOException {
        try {
            Obj_Rep_Setup objSetup = new Obj_Rep_Setup();
            PageFactory.initElements(driver, objSetup);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Actions act = new Actions(driver);
            log.info("Waiting till the '+Add Merchant' button is display");
            wait.until(ExpectedConditions.visibilityOf(objSetup.addMerchantBtn));
            if (objSetup.addMerchantBtn.isDisplayed()) {
                log.info("'+Add Merchant' has displayed");
                log.info("Waiting till the '+Add Merchant' is click");
                wait.until(ExpectedConditions.elementToBeClickable(objSetup.addMerchantBtn));
                if (objSetup.addMerchantBtn.isEnabled()) {
                    log.info("'+Add Merchant' has enabled to click");
                    try {
                        log.info("Clicking on the '+Add Merchant'");
                        act.moveToElement(objSetup.addMerchantBtn).click().build().perform();
                        log.info("'+Add Merchant' has clicked");
                        log.info("Waiting till the page is loading");
                        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                        log.info("Waiting till the 'Contact Info' is display");
                        wait.until(ExpectedConditions.visibilityOf(objSetup.contactInfoBtn));
                        if (objSetup.contactInfoBtn.isDisplayed()) {
                            test.pass("Biller has able to view the Contact Info section");
                            log.info("Biller has able to view the Contact Info section");
                        } else {
                            test.fail("Biller unable to view the Contact Info section");
                            log.info("Biller unable to view the Contact Info section");
                        }

                    } catch (Exception ex) {
                        test.fail("+Add Merchant' button has not clicked.  And it displayed the Exception as.." + ex.getMessage());
                        log.info("+Add Merchant' button has not clicked.  And it displayed the Exception as.." + ex.getMessage());
                    }
                } else {
                    test.fail("'+Add Merchant' has not enabled to click");
                    log.info("'+Add Merchant' has not enabled to click");
                }
            } else {
                test.fail("'+Add Merchant' button has not displayed");
                log.info("'+Add Merchant' button has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnAddMerchant.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnAddMerchant.jpeg").build());
        }
    }
    public static void selectAnyOneRadioButton() throws IOException {
        try {
            Obj_Rep_Setup objSetup = new Obj_Rep_Setup();
            PageFactory.initElements(driver, objSetup);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            log.info("Waiting till all the radio button is display");
            wait.until(ExpectedConditions.visibilityOfAllElements(objSetup.contactInfoRadioBtn));
            int radioBtnSize = objSetup.contactInfoRadioBtn.size();
            for (int i = 0; i < radioBtnSize; i++) {
                log.info("Checking whether the radio button is displayed");
                if (objSetup.contactInfoRadioBtn.get(i).isDisplayed()) {
                    log.info("Checking whether the radio button is enabled to click");
                    if (objSetup.contactInfoRadioBtn.get(i).isEnabled()) {
                        try {
                            objSetup.contactInfoRadioBtn.get(i).click();
                            if (i == 0) {
                                test.pass("Biller has able to select the 'Company' radio button");
                                log.info("Biller has able to select the 'Company' radio button");
                            } else {
                                test.pass("Biller has able to select the 'Individual' radio button");
                                log.info("Biller has able to select the 'Individual' radio button");
                            }
                        } catch (Exception ex) {
                            if (i == 0) {
                                test.fail("Biller unable to select the 'Company' radio button.  And it displayed the Exception as.." + ex.getMessage());
                                log.info("Biller unable to select the 'Company' radio button.  And it displayed the Exception as.." + ex.getMessage());
                            } else {
                                test.fail("Biller unable to select the 'Individual' radio button.  And it displayed the Exception as.." + ex.getMessage());
                                log.info("Biller unable to select the 'Individual' radio button.  And it displayed the Exception as.." + ex.getMessage());
                            }
                        }
                    } else {
                        if (i == 0) {
                            test.fail("'Company radio button has not enabled");
                            log.info("'Company radio button has not enabled");
                        } else {
                            test.fail("Individual radio button has not enabled");
                            log.info("Individual radio button has not enabled");
                        }
                    }
                } else {
                    if (i == 0) {
                        test.fail("'Company radio button has not displayed");
                        log.info("'Company radio button has not displayed");
                    } else {
                        test.fail("Individual radio button has not displayed");
                        log.info("Individual radio button has not displayed");
                    }
                }

            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/selectAnyOneRadioButton.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/selectAnyOneRadioButton.jpeg").build());
        }
    }
    public static void verifyTheNoteMessage() throws IOException {
        try {
            getTestData();
            Obj_Rep_Setup objSetup = new Obj_Rep_Setup();
            PageFactory.initElements(driver, objSetup);
            if (objSetup.noteText.getText().equals(prop.getProperty("Bills2U.MerchantOnBoard.noteMessage"))) {
                test.pass("Biller has able to view the mentioned note message");
                log.info("Biller has able to view the mentioned note message");
            } else {
                test.fail("Biller has not able to view the mentioned note message.  And it displayed " + objSetup.noteText.getText());
                log.info("Biller has not able to view the mentioned note message.  And it displayed " + objSetup.noteText.getText());
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/verifyTheNoteMessage.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/verifyTheNoteMessage.jpeg").build());
        }
    }
    public static void fillMandatoryFieldInMerchant() throws IOException {
        try {
            getTestData();
            Obj_Rep_Setup objSetup = new Obj_Rep_Setup();
            PageFactory.initElements(driver, objSetup);

            try {
                objSetup.addBusinessName.sendKeys(prop.getProperty("Bills2U.MerchantOnBoard.businessName"));
                objSetup.addContactName.sendKeys(prop.getProperty("Bills2U.MerchantOnBoard.contactName"));
                objSetup.addEmail.sendKeys(prop.getProperty("Bills2U.MerchantOnBoard.email"));
                objSetup.addPhone.sendKeys(prop.getProperty("Bills2U.MerchantOnBoard.phone"));
                objSetup.addCity.sendKeys(prop.getProperty("Bills2U.MerchantOnBoard.city"));
                objSetup.addZipCode.sendKeys(prop.getProperty("Bills2U.MerchantOnBoard.zipcode"));
                objSetup.countrySelect.click();
                objSetup.addCountry.sendKeys(prop.getProperty("Bills2U.MerchantOnBoard.country"), Keys.ENTER);
                objSetup.addAddress.sendKeys(prop.getProperty("Bills2U.MerchantOnBoard.address"));
                objSetup.logo.sendKeys(prop.getProperty("Bills2U.MerchantOnBoard.logoPath"));

                test.pass("Biller has able to fill the mandatory fields");
                log.info("Biller has able to fill the mandatory fields");
            } catch (Exception ex) {
                test.fail("Biller unable to fill the mandatory fields.  And it displayed the Exception as..\n" + ex.getMessage());
                log.info("Biller unable to fill the mandatory fields.  And it displayed the Exception as..\n" + ex.getMessage());
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/fillMandatoryFieldInMerchant.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/fillMandatoryFieldInMerchant.jpeg").build());
        }
    }
    public static void fillOptionalFieldInMerchant() throws IOException {
        try {
            getTestData();
            Obj_Rep_Setup objSetup = new Obj_Rep_Setup();
            PageFactory.initElements(driver, objSetup);

            try {
                objSetup.addFax.sendKeys(prop.getProperty("Bills2U.MerchantOnBoard.fax"));
                objSetup.addWebsite.sendKeys(prop.getProperty("Bills2U.MerchantOnBoard.website"));
                objSetup.addAddress2.sendKeys(prop.getProperty("Bills2U.MerchantOnBoard.address2"));
                objSetup.addAddress3.sendKeys(prop.getProperty("Bills2U.MerchantOnBoard.address3"));

                test.pass("Biller has able to fill the optional fields");
                log.info("Biller has able to fill the optional fields");
            } catch (Exception ex) {
                test.fail("Biller unable to fill the optional fields.  And it displayed the Exception as..\n" + ex.getMessage());
                log.info("Biller unable to fill the optional fields.  And it displayed the Exception as..\n" + ex.getMessage());
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/fillOptionalFieldInMerchant.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/fillOptionalFieldInMerchant.jpeg").build());
        }
    }
    public static void checkSaveisEnable() throws IOException {
        try {
            Obj_Rep_Setup objSetup = new Obj_Rep_Setup();
            PageFactory.initElements(driver, objSetup);
            Actions act = new Actions(driver);
            act.moveToElement(objSetup.saveBtn).build().perform();
            if (objSetup.saveBtn.isDisplayed()) {
                log.info("Save button has displayed");
                if (objSetup.saveBtn.isEnabled()) {
                    test.pass("'Save' button has enabled");
                    log.info("'Save' button has enabled");
                } else {
                    test.fail("'Save' button has not enabled");
                    log.info("'Save' button has not enabled");
                }
            } else {
                test.fail("Save button has not displayed");
                log.info("Save button has not displayed");
            }
        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/checkSaveisEnable.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/checkSaveisEnable.jpeg").build());
        }
    }
    public static void clickOnSave() throws IOException {
        try {
            getTestData();
            Obj_Rep_Setup objSetup = new Obj_Rep_Setup();
            PageFactory.initElements(driver, objSetup);
            Actions act = new Actions(driver);
            act.moveToElement(objSetup.saveBtn).click().build().perform();
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(objSetup.messageBox));

            try {
                if (objSetup.messageBox.getText().equals(prop.getProperty("Bills2U.MerchantOnBoard.completeMessage"))) {
                    Thread.sleep(5000);
                    test.pass("'Biller Registration Completed Successfully' message has displayed ");
                    test.info(" Welcome email sent to registered email, you have to check " +
                            "manually, because email is secured application tools can't automate that.");
                } else {
                    Thread.sleep(5000);
                    test.fail("'Biller Registration Completed Successfully' message has not displayed. " +
                            " But it displayed the message as " + objSetup.messageBox.getText());
                }
            } catch (Exception ex) {
                test.fail(ex.getMessage());
            }

        } catch (Exception ex) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screen, new File(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnSave.jpeg"));
            log.info(ex.getMessage());
            test.fail(ex.getMessage());
            test.info("Here, the screenshot has been attached.\n", MediaEntityBuilder.createScreenCaptureFromPath(prop.getProperty("Bills2U.screenshot.Directory") + "/clickOnSave.jpeg").build());
        }
    }
    public static void checkGeneral_RP_Usersetting(){
        Obj_Rep_Setup objSetup=new Obj_Rep_Setup();
        PageFactory.initElements(driver,objSetup);
        if(objSetup.generalSettingBtn.isDisplayed()){
            if(objSetup.generalSettingBtn.isEnabled()){
                if(objSetup.usersBtn.isDisplayed()){
                    if(objSetup.usersBtn.isEnabled()){
                        test.pass("General Settings, Users buttons has get enabled");
                    }else {
                        test.fail("Users button has not enabled");
                    }
                }else {
                    test.fail("Users button has not displayed");
                }
            }else {
                test.fail("General settings button has not enabled");
            }
        }else {
            test.fail("General Setting button has not displayed");
        }
    }
}
