package bills2u_process;

import Config.PropertyClass;
import bills2u_constant.*;
import bills2u_root.Root_Class;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Batch_Entry_Process extends Root_Class {
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

    public static void GotToInVoiceBatch() {
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
        } catch (InterruptedException e) {
            test.fail(e.getMessage());
        }


    }

    public static void ClickBatchEntry() {
        try {
            Obj_Rep_InvoiceBatchList bList = new Obj_Rep_InvoiceBatchList();
            PageFactory.initElements(driver, bList);
            bList.btnBatchEntry.click();
            Thread.sleep(2000);
            if (bList.txtNewInvoiceBatch.isDisplayed() && bList.txtNewInvoiceBatch.getText().equals("New Invoice Batch")) {
                test.pass("Biller able to view New Invoice Batch page");
            } else {
                test.fail("Biller not able to view New Invoice Batch page");
            }
        } catch (InterruptedException e) {
            test.fail(e.getMessage());
        }


    }

    public static void ClickAddInvoice() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);
            bEntry.btnAddInvoice.click();
            Thread.sleep(3000);
            if (bEntry.txtNewAddInvoice.getText().contains("New Invoice Batch")) {
                test.pass("Biller able to view the new invoice creation page");
            } else {
                test.fail("Biller not able to view the new invoice creation page");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }
        
    }

    public static void VerifyBillsToData() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);

            bEntry.iptPayerName.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.PayerName"));
            bEntry.iptEmail.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Email"));
            bEntry.iptAddress.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Address"));
            bEntry.iptCity.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.City"));
            bEntry.iptState.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.State"));
            bEntry.iptCountry.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Country"));
            bEntry.iptPhoneNo.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.PhoneNo"));
            bEntry.iptPostalCode.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.PostalCode"));
            bEntry.iptInvoiceNumber.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.InvoiceNo"));
            IssueDateSelect();
            DueDateSelect();
            bEntry.iptRef1.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Ref1"));
            bEntry.iptRef2.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Ref2"));
            Thread.sleep(3000);
            if (bEntry.iptPayerName.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.PayerName"))
                    && bEntry.iptEmail.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Email"))
                    && bEntry.iptAddress.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Address"))
                    && bEntry.iptCity.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.City"))
                    && bEntry.iptState.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.State"))
                    && bEntry.iptCountry.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Country"))
                    && bEntry.iptPhoneNo.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.PhoneNo"))
                    && bEntry.iptPostalCode.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.PostalCode"))
                    && bEntry.iptInvoiceNumber.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.InvoiceNo"))
                    && !bEntry.iptIssueDate.getAttribute("value").isEmpty()
                    && !bEntry.iptDueDate.getAttribute("value").isEmpty()
                    && bEntry.iptRef1.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Ref1"))
                    && bEntry.iptRef2.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Ref2"))) {
                test.pass("Biller able to enter the BillsTo data");
            } else {
                test.fail("Biller not able to enter the BillsTo data");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }
        
    }

    public static void IssueDateSelect() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);
            bEntry.iptIssueDate.click();
            Thread.sleep(1000);
            WebElement yearSelect = driver.findElement(By.xpath("/html/body/app-root/div/div[2]/div[4]/div/mat-datepicker-content/mat-calendar/mat-calendar-header/div/div/button[1]"));
            yearSelect.click();
            Thread.sleep(1000);
            WebElement chooseYear = driver.findElement(By.cssSelector("td[aria-label='"
                    + prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.IssueDate.Year") + "']"));
            chooseYear.click();
            Thread.sleep(1000);
            WebElement chooseMonth = driver.findElement(By.cssSelector("td[aria-label='01-"
                    + prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.IssueDate.Month") + "-"
                    + prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.IssueDate.Year") + "']"));
            chooseMonth.click();
            Thread.sleep(1000);
            WebElement chooseDay = driver.findElement(By.cssSelector("td[aria-label='"
                    + prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.IssueDate.Day") + "-"
                    + prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.IssueDate.Month") + "-"
                    + prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.IssueDate.Year")
                    + "']"));
            chooseDay.click();
        } catch (InterruptedException e) {
            test.fail(e.getMessage());
        }
    }

    public static void DueDateSelect() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);
            bEntry.iptDueDate.click();
            Thread.sleep(1000);
            WebElement yearSelect = driver.findElement(By.xpath("/html/body/app-root/div/div[2]/div[4]/div/mat-datepicker-content/mat-calendar/mat-calendar-header/div/div/button[1]"));
            yearSelect.click();
            Thread.sleep(1000);
            WebElement chooseYear = driver.findElement(By.cssSelector("td[aria-label='"
                    + prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.DueDate.Year") + "']"));
            chooseYear.click();
            Thread.sleep(1000);
            WebElement chooseMonth = driver.findElement(By.cssSelector("td[aria-label='01-"
                    + prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.DueDate.Month") + "-"
                    + prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.DueDate.Year") + "']"));
            chooseMonth.click();
            Thread.sleep(1000);
            WebElement chooseDay = driver.findElement(By.cssSelector("td[aria-label='"
                    + prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.DueDate.Day") + "-"
                    + prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.DueDate.Month") + "-"
                    + prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.DueDate.Year")
                    + "']"));
            chooseDay.click();
        } catch (InterruptedException e) {
            test.fail(e.getMessage());
        }
    }

    public static void ClickSVGIcon() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);
            bEntry.filterSvgIcon.click();

            Thread.sleep(3000);
            if (bEntry.chkBoxUnitPrice.isDisplayed() && bEntry.chkBoxDescription.isDisplayed()) {
                test.pass("Biller should able to view the \"Show field\" tooltip");
            } else {
                test.fail("Biller should able to view the \"Show field\" tooltip");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }
        
    }

    public static void ClickCheckboxUnitPrice() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);
            Thread.sleep(3000);
            bEntry.chkBoxUnitPrice.click();

            Thread.sleep(3000);
            if (!bEntry.chkBoxUnitPrice.isSelected()) {
                test.pass("Biller able to select unit price");
            } else {
                test.fail("Biller not able to select unit price");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }
        
    }

    public static void ClickCheckboxDescription() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);
            bEntry.chkBoxDescription.click();

            Thread.sleep(3000);
            if (!bEntry.chkBoxUnitPrice.isSelected()) {
                test.pass("Biller able to select Description");
            } else {
                test.fail("Biller not able to select Description");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }
        
    }

    public static void VerifyAddItem() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);

            bEntry.iptItem.clear();
            bEntry.iptItem.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.name1"));
            bEntry.iptDescription.clear();
            bEntry.iptDescription.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Description1"));
            bEntry.iptQuantity.clear();
            bEntry.iptQuantity.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Quantity1"));
            for (int i = 0; i <= 15; i++) {
                bEntry.iptUnitPrice.sendKeys(Keys.BACK_SPACE);
            }
            bEntry.iptUnitPrice.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.UnitPrice1"));
            for (int i = 0; i <= 15; i++) {
                bEntry.iptTotalTax.sendKeys(Keys.BACK_SPACE);
            }
            bEntry.iptTotalTax.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.TotalTax1"));
            for (int i = 0; i <= 15; i++) {
                bEntry.iptAmount.sendKeys(Keys.BACK_SPACE);
            }
            bEntry.iptAmount.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Amount1"));


            Thread.sleep(3000);
            if (bEntry.iptItem.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.name1"))
                    && bEntry.iptDescription.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Description1"))
                    && bEntry.iptQuantity.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Quantity1"))
                    && bEntry.iptUnitPrice.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.UnitPrice1"))
                    && bEntry.iptTotalTax.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.TotalTax1"))
                    && bEntry.iptAmount.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Amount1"))
            ) {
                test.pass("Biller able to enter the Item data");
            } else {
                test.fail("Biller not able to enter the Item data");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }
        
    }

    public static void VerifyAddItemWithoutUnitPrice() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);

            bEntry.iptItem.clear();
            bEntry.iptItem.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.name1"));
            bEntry.iptDescription.clear();
            bEntry.iptDescription.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Description1"));
            for (int i = 0; i <= 15; i++) {
                bEntry.filterUnitAmount.sendKeys(Keys.BACK_SPACE);
            }
            bEntry.filterUnitAmount.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Amount1"));


            Thread.sleep(3000);
            if (bEntry.iptItem.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.name1"))
                    && bEntry.iptDescription.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Description1"))
                    && bEntry.filterUnitAmount.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Amount1"))
            ) {
                test.pass("Biller able to enter the Item data");
            } else {
                test.fail("Biller not able to enter the Item data");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }
        
    }

    public static void VerifyAddItemWithoutDescription() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);

            bEntry.iptItem.clear();
            bEntry.iptItem.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.name1"));
            bEntry.iptQuantity.clear();
            bEntry.iptQuantity.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Quantity1"));
            for (int i = 0; i <= 15; i++) {
                bEntry.iptUnitPrice.sendKeys(Keys.BACK_SPACE);
            }
            bEntry.iptUnitPrice.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.UnitPrice1"));
            for (int i = 0; i <= 15; i++) {
                bEntry.getFilterDescriptionTotalTax.sendKeys(Keys.BACK_SPACE);
            }
            bEntry.getFilterDescriptionTotalTax.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.TotalTax1"));
            for (int i = 0; i <= 15; i++) {
                bEntry.filterDescriptionAmount.sendKeys(Keys.BACK_SPACE);
            }
            bEntry.filterDescriptionAmount.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Amount1"));

            Thread.sleep(3000);
            if (bEntry.iptItem.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.name1"))
                    && bEntry.iptQuantity.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Quantity1"))
                    && bEntry.iptUnitPrice.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.UnitPrice1"))
                    && bEntry.getFilterDescriptionTotalTax.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.TotalTax1"))
                    && bEntry.filterDescriptionAmount.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Amount1"))
            ) {
                test.pass("Biller able to enter the Item data");
            } else {
                test.fail("Biller not able to enter the Item data");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }
        
    }

    public static void ClickNewInvoiceBatchCloseIcon() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);
            bEntry.newBatchInvoiceCloseIcon.click();
            Thread.sleep(3000);

        } catch (Exception e) {
            test.fail(e.getMessage());
        }
        
    }

    public static void ClickItemSaveIcon() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);
            bEntry.btnSaveItem.click();
            Thread.sleep(3000);
            if (bEntry.iptItem.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.name1"))
                    && bEntry.iptDescription.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Description1"))
                    && bEntry.iptQuantity.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Quantity1"))
                    && bEntry.iptUnitPrice.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.UnitPrice1"))
                    && bEntry.iptTotalTax.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.TotalTax1"))
                    && bEntry.iptAmount.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Amount1"))
            ) {
                test.pass("Biller able to view the item in item list");
            } else {
                test.fail("Biller not able to view the item in item list");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }
        
    }

    public static void ClickItemSaveIconWithoutUnitPrice() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);
            Thread.sleep(3000);
            bEntry.filterUnitSaveItem.click();
            Thread.sleep(3000);
            if (bEntry.iptItem.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.name1"))
                    && bEntry.iptDescription.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Description1"))
                    && bEntry.filterUnitAmount.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Amount1"))
            ) {
                test.pass("Biller able to save the item in item list");
            } else {
                test.fail("Biller not able to save the item in item list");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }
        
    }

    public static void ClickItemSaveIconWithoutDescription() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);
            bEntry.filterDescriptionSaveItem.click();
            Thread.sleep(3000);
            if (bEntry.iptItem.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.name1"))
                    && bEntry.iptQuantity.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Quantity1"))
                    && bEntry.iptUnitPrice.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.UnitPrice1"))
                    && bEntry.getFilterDescriptionTotalTax.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.TotalTax1"))
                    && bEntry.filterDescriptionAmount.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Amount1"))
            ) {
                test.pass("Biller able to view the item in item list");
            } else {
                test.fail("Biller not able to view the item in item list");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }
        
    }

    public static void ClickNewBatchSaveIcon() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);
            bEntry.btnSaveNewBatch.click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
          JavascriptExecutor js=(JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", bEntry.txtVerifyNewInvoiceBatch);
            if (bEntry.txtVerifyNewInvoiceBatch.getText().contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.InvoiceNo"))) {
                test.pass("Biller able to save the New Invoice Batch and should Redirect to New Invoice Batch publish page");
            } else {
                test.fail("Biller not able to save the New Invoice Batch and should Redirect to New Invoice Batch publish page");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }
        
    }

    public static void ClickItemDeleteIcon() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);
            bEntry.btnDeleteItem.click();
            Thread.sleep(3000);
            if (bEntry.btnAddItem.isEnabled()) {
                test.pass("Biller able deleted the item");
            } else {
                test.fail("Biller not able deleted the item");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }
        
    }

    public static void VerifyEditItem() {
        try {
            Obj_Rep_BatchEntry bEntry = new Obj_Rep_BatchEntry();
            PageFactory.initElements(driver, bEntry);

            bEntry.btnSaveItem.click();
            Thread.sleep(5000);
            bEntry.iptItem.clear();
            bEntry.iptItem.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.name1"));
            bEntry.iptDescription.clear();
            bEntry.iptDescription.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Description1"));
            bEntry.iptQuantity.clear();
            bEntry.iptQuantity.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Quantity1"));
            for (int i = 0; i <= 15; i++) {
                bEntry.iptUnitPrice.sendKeys(Keys.BACK_SPACE);
            }
            bEntry.iptUnitPrice.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.UnitPrice1"));
            for (int i = 0; i <= 15; i++) {
                bEntry.iptTotalTax.sendKeys(Keys.BACK_SPACE);
            }
            bEntry.iptTotalTax.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.TotalTax1"));

            for (int i = 0; i <= 15; i++) {
                bEntry.iptAmount.sendKeys(Keys.BACK_SPACE);
            }
            bEntry.iptAmount.sendKeys(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Amount2"));

            bEntry.btnSaveItem.click();
            Thread.sleep(5000);
            if (bEntry.iptItem.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.name1"))
                    && bEntry.iptDescription.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Description1"))
                    && bEntry.iptQuantity.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Quantity1"))
                    && bEntry.iptUnitPrice.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.UnitPrice1"))
                    && bEntry.iptTotalTax.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.TotalTax1"))
                    && bEntry.iptAmount.getAttribute("value").contains(prop.getProperty("Bills2U.InvoiceBatch.BatchEntry.Item.Amount2"))
            ) {
                test.pass("Biller able to edited the particular item");
            } else {
                test.fail("Biller not able to edited the particular item");
            }
        } catch (Exception e) {
            test.fail(e.getMessage());
        }
        
    }

}
