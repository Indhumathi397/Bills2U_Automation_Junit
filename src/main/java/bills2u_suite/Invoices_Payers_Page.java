package bills2u_suite;

import bills2u_process.ProcessClass;
import bills2u_process.Process_Class_Payer;

public class Invoices_Payers_Page extends Process_Class_Payer {

    public Invoices_Payers_Page TC_IN_001() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_168_Invoices page_Display details");
        payerLoginProcess();
        checkDisplayedItems();
        logoutProcess();
        return this;
    }

    public Invoices_Payers_Page TC_IN_002() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_169_Invoices page_Pay for Individual invoice");
        payerLoginProcess();
        checkDueAmtAndDate();
        clickOnPayforSelected();
        closeButton();
        logoutProcess();
        return this;
    }

    public Invoices_Payers_Page TC_IN_003() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_170_Invoices page_Pay for Multiple invoice");
        payerLoginProcess();
        clickOnSelectAllChkBox();
        checkTotalOutstanding();
        clickOnPayforSelected();
        closeButton();
        logoutProcess();
        return this;
    }

    public Invoices_Payers_Page TC_IN_004() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_171_Invoices page_Pay button_Fully paid invoice");
        payerLoginProcess();
        logoutProcess();
        return this;
    }

    public Invoices_Payers_Page TC_IN_005() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_172_Invoices page_Pay button_Individual invoice_Partially paid invoice");
        payerLoginProcess();
        checkOnPayforSelected();
        clickOnPayforSelected();
        closeButton();
        logoutProcess();
        return this;
    }

    public Invoices_Payers_Page TC_IN_006() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_173_Invoices page_Invoice in detail_Display details");
        payerLoginProcess();
        clickOnRespectiveInvNo();
        checkDisplayedItemsInID();
        logoutProcess();
        return this;
    }

    public Invoices_Payers_Page TC_IN_007() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_174_Invoices page_Invoice in detail_Pay button");
        payerLoginProcess();
        clickOnRespectiveInvNo();
        checkOutstandingAmt();
        clickOnPayInID();
        closeButton();
        logoutProcess();
        return this;
    }

    public Invoices_Payers_Page TC_IN_008() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_175_Invoices page_Invoice in detail_Invoice_Display details");
        payerLoginProcess();
        clickOnRespectiveInvNo();
        logoutProcess();
        return this;
    }

    public Invoices_Payers_Page TC_IN_009() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_176_Invoices page_Invoice in detail_Payment History_Display details");
        payerLoginProcess();
        clickOnRespectiveInvNo();
        logoutProcess();
        return this;
    }

    public Invoices_Payers_Page TC_IN_010() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_177_Invoices page_Invoice in detail_Payment History_Payment Receipt_Display details");
        payerLoginProcess();
        logoutProcess();
        return this;
    }

    public Invoices_Payers_Page TC_IN_011() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_178_Invoices page_Filter_Display details");
        payerLoginProcess();
        logoutProcess();
        return this;
    }

    public Invoices_Payers_Page TC_IN_012() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_179_Invoices page_Filter_Invoice Number");
        payerLoginProcess();
        logoutProcess();
        return this;
    }

    public Invoices_Payers_Page TC_IN_013() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_180_Invoices page_Filter_Due Date filter");
        payerLoginProcess();
        logoutProcess();
        return this;
    }

    public Invoices_Payers_Page TC_IN_014() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_181_Invoices page_Filter_Status filter_All");
        payerLoginProcess();
        logoutProcess();
        return this;
    }

    public Invoices_Payers_Page TC_IN_015() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_182_Invoices page_Filter_Status filter_Unpaid invoice");
        payerLoginProcess();
        logoutProcess();
        return this;
    }

    public Invoices_Payers_Page TC_IN_016() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_183_Invoices page_Filter_Status filter_Paid invoice");
        payerLoginProcess();
        logoutProcess();
        return this;
    }

    public Invoices_Payers_Page TC_IN_017() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_184_Invoices page_Filter_Status filter_None");
        payerLoginProcess();
        logoutProcess();
        return this;
    }

    public Invoices_Payers_Page TC_IN_018() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_185_Invoices page_Filter_Issuing Merchant filter_Selective merchants");
        payerLoginProcess();
        logoutProcess();
        return this;
    }

    public Invoices_Payers_Page TC_IN_019() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_186_Invoices page_Filter_Issuing Merchant filter_All");
        payerLoginProcess();
        logoutProcess();
        return this;
    }

    public Invoices_Payers_Page TC_IN_020() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_187_Invoices page_Filter_Issuing Merchant filter_None");
        payerLoginProcess();
        logoutProcess();
        return this;
    }

    public Invoices_Payers_Page TC_IN_021() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_188_Invoices page_Confirm payment pop-up_Display details");
        payerLoginProcess();
        logoutProcess();
        return this;
    }

    public Invoices_Payers_Page TC_IN_022() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_189_Invoices page_Confirm payment pop-up_Full payment");
        payerLoginProcess();
        logoutProcess();
        return this;
    }

    public Invoices_Payers_Page TC_IN_023() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_190_Invoices page_Confirm payment pop-up_Partial payment");
        payerLoginProcess();
        logoutProcess();
        return this;
    }

    public Invoices_Payers_Page TC_IN_024() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payer_191_Invoices page_Confirm payment pop-up_Partial payment disabled invoice");
        payerLoginProcess();
        logoutProcess();
        return this;
    }

    public Invoices_Payers_Page TC_IN_025() throws InterruptedException {
        testPayer=reportPayer.createTest("TC_BILLS2U_Payers_192_Invoices page_Tool tip");
        payerLoginProcess();
        logoutProcess();
        return this;
    }
}
