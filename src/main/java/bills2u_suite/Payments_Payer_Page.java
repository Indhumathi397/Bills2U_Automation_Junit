package bills2u_suite;

import bills2u_process.Process_Class_Payer;

public class Payments_Payer_Page extends Process_Class_Payer {

    public Payments_Payer_Page TC_Pay_001() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_193_Payment Page_detailed view");
        payerLoginProcess();
        clickOnPayments();
        checkDisplayedItems();
        logoutProcess();
        return this;
    }

    public Payments_Payer_Page TC_Pay_002() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_194_Payments_Filter_detailed view");
        payerLoginProcess();
        clickOnPayments();
        placeTheCursorOnShowFilter();
        logoutProcess();
        return this;
    }

    public Payments_Payer_Page TC_Pay_003() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_195_Payments_Filter_Search TRN Reference");
        payerLoginProcess();
        clickOnPayments();
        placeTheCursorOnShowFilter();
        logoutProcess();
        return this;
    }

    public Payments_Payer_Page TC_Pay_004() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_196_Payments_Filter_Issuing merchant_Selecting Merchant");
        payerLoginProcess();
        clickOnPayments();
        placeTheCursorOnShowFilter();
        logoutProcess();
        return this;
    }

    public Payments_Payer_Page TC_Pay_005() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_197_Payments_Filter_Issuing merchant_All");
        payerLoginProcess();
        clickOnPayments();
        placeTheCursorOnShowFilter();
        logoutProcess();
        return this;
    }

    public Payments_Payer_Page TC_Pay_006() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_198_Payments_Filter_Issuing Merchant_None Option");
        payerLoginProcess();
        clickOnPayments();
        placeTheCursorOnShowFilter();
        logoutProcess();
        return this;
    }

    public Payments_Payer_Page TC_Pay_007() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_199_Payments_Filter_Issuing Merchant_Multiple Merchant selection");
        payerLoginProcess();
        clickOnPayments();
        placeTheCursorOnShowFilter();
        logoutProcess();
        return this;
    }

    public Payments_Payer_Page TC_Pay_008() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_200_Payments_Filter_Payment Date");
        payerLoginProcess();
        clickOnPayments();
        placeTheCursorOnShowFilter();
        logoutProcess();
        return this;
    }

    public Payments_Payer_Page TC_Pay_009() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_201_Payments_Filter_Invoice status_Pending");
        payerLoginProcess();
        clickOnPayments();
        placeTheCursorOnShowFilter();
        logoutProcess();
        return this;
    }

    public Payments_Payer_Page TC_Pay_010() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_202_Payments_Filter_Invoice status_Failed");
        payerLoginProcess();
        clickOnPayments();
        placeTheCursorOnShowFilter();
        logoutProcess();
        return this;
    }

    public Payments_Payer_Page TC_Pay_011() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_203_Payments_Filter_Invoice status_Success");
        payerLoginProcess();
        clickOnPayments();
        placeTheCursorOnShowFilter();
        logoutProcess();
        return this;
    }

    public Payments_Payer_Page TC_Pay_012() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_204_Payments_Filter_Invoice status_Pending and Failed");
        payerLoginProcess();
        clickOnPayments();
        placeTheCursorOnShowFilter();
        logoutProcess();
        return this;
    }

    public Payments_Payer_Page TC_Pay_013() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_205_Payments_Filter_Invoice status_Pending and Success");
        payerLoginProcess();
        clickOnPayments();
        placeTheCursorOnShowFilter();
        logoutProcess();
        return this;
    }

    public Payments_Payer_Page TC_Pay_014() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_206_Payments_Filter_Invoice status_Failed and Success");
        payerLoginProcess();
        clickOnPayments();
        placeTheCursorOnShowFilter();
        logoutProcess();
        return this;
    }

    public Payments_Payer_Page TC_Pay_015() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_207_Payments_Filter_Invoice status_All");
        payerLoginProcess();
        clickOnPayments();
        placeTheCursorOnShowFilter();
        logoutProcess();
        return this;
    }

    public Payments_Payer_Page TC_Pay_016() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_208_Payments_Filter_Invoice status_None");
        payerLoginProcess();
        clickOnPayments();
        placeTheCursorOnShowFilter();
        logoutProcess();
        return this;
    }

    public Payments_Payer_Page TC_Pay_017() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_209_Payments_Filter_All filter");
        payerLoginProcess();
        clickOnPayments();
        placeTheCursorOnShowFilter();
        logoutProcess();
        return this;
    }

    public Payments_Payer_Page TC_Pay_018() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_210_Payments_Filter_Search TRN Reference_ existing data");
        payerLoginProcess();
        clickOnPayments();
        placeTheCursorOnShowFilter();
        logoutProcess();
        return this;
    }

    public Payments_Payer_Page TC_Pay_019() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_211_Payments_Acknowledgement View_Detailed View");
        payerLoginProcess();
        clickOnPayments();
        logoutProcess();
        return this;
    }

    public Payments_Payer_Page TC_Pay_020() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_212_Payments_Acknowledgement View_Failed Status");
        payerLoginProcess();
        clickOnPayments();
        logoutProcess();
        return this;
    }

    public Payments_Payer_Page TC_Pay_021() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_213_Payments_Acknowledgement View_Pending Status");
        payerLoginProcess();
        clickOnPayments();
        logoutProcess();
        return this;
    }

    public Payments_Payer_Page TC_Pay_022() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_214_Payments_Acknowledgement View_Success Status");
        payerLoginProcess();
        clickOnPayments();
        logoutProcess();
        return this;
    }
}
