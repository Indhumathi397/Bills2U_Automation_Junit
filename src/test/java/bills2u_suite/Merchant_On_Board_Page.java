package bills2u_suite;

import bills2u_process.Merchant_On_Board_Process;

import java.io.IOException;

public class Merchant_On_Board_Page extends Merchant_On_Board_Process {

    public Merchant_On_Board_Page TC_MOB_001() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.MerchantOnBoard.TC1"));
        loginProcess();
        clickOnSetupMenuProcess();
        clickOnMerchantMenuProcess();
        enterBusinessName();
        enterContactName();
        enterEmail();
        enterPhone();
        selectActiveStatus();
        logoutProcess();
        return this;
    }

    public Merchant_On_Board_Page TC_MOB_002() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.MerchantOnBoard.TC2"));
        loginProcess();
        clickOnSetupMenuProcess();
        clickOnMerchantMenuProcess();
        logoutProcess();
        return this;
    }

    public Merchant_On_Board_Page TC_MOB_003() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.MerchantOnBoard.TC3"));
        loginProcess();
        clickOnSetupMenuProcess();
        clickOnMerchantMenuProcess();
        enterBusinessName();
        enterContactName();
        enterEmail();
        enterPhone();
        selectActiveStatus();
        logoutProcess();
        return this;
    }

    public Merchant_On_Board_Page TC_MOB_004() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.MerchantOnBoard.TC4"));
        loginProcess();
        clickOnSetupMenuProcess();
        clickOnMerchantMenuProcess();
        clickOnAddMerchant();
        selectAnyOneRadioButton();
        verifyTheNoteMessage();
        fillMandatoryFieldInMerchant();
        fillOptionalFieldInMerchant();
        checkSaveisEnable();
        clickOnSave();
        checkGeneral_RP_Usersetting();
        logoutProcess();
        return this;
    }

    public Merchant_On_Board_Page TC_MOB_005() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.MerchantOnBoard.TC5"));
        loginProcess();
        clickOnSetupMenuProcess();
        clickOnMerchantMenuProcess();
        logoutProcess();
        return this;
    }

    public Merchant_On_Board_Page TC_MOB_006() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.MerchantOnBoard.TC6"));
        loginProcess();
        clickOnSetupMenuProcess();
        clickOnMerchantMenuProcess();
        logoutProcess();
        return this;
    }

    public Merchant_On_Board_Page TC_MOB_007() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.MerchantOnBoard.TC7"));
        loginProcess();
        clickOnSetupMenuProcess();
        clickOnMerchantMenuProcess();
        logoutProcess();
        return this;
    }

    public Merchant_On_Board_Page TC_MOB_008() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.MerchantOnBoard.TC8"));
        loginProcess();
        clickOnSetupMenuProcess();
        clickOnMerchantMenuProcess();
        logoutProcess();
        return this;
    }

    public Merchant_On_Board_Page TC_MOB_009() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.MerchantOnBoard.TC9"));
        loginProcess();
        clickOnSetupMenuProcess();
        clickOnMerchantMenuProcess();
        logoutProcess();
        return this;
    }

}
