package bills2u_suite;

import bills2u_process.Invoice_Detail_Process;

import java.io.IOException;

public class Invoice_Detail_Page extends Invoice_Detail_Process {

    public Invoice_Detail_Page TC_ID_001() throws IOException {
        getTestData();
        test = report.createTest(prop.getProperty("Bills2U.InvoiceDetail.TC1"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        clickOnBatchName();
        clickOnInvoiceNumber();
        clickOnPaymentHistory();
        enterTransactionReference();
        placeTheCursorOnTransactionRef();
        logoutProcess();
        return this;
    }

    public Invoice_Detail_Page TC_ID_002() throws IOException {
        getTestData();
        test = report.createTest(prop.getProperty("Bills2U.InvoiceDetail.TC2"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        clickOnBatchName();
        clickOnInvoiceNumber();
        clickOnPaymentHistory();
        enterItemName();
        placeTheCursorOnItemName();
        logoutProcess();
        return this;
    }

    public Invoice_Detail_Page TC_ID_003() throws IOException {
        getTestData();
        test = report.createTest(prop.getProperty("Bills2U.InvoiceDetail.TC3"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        clickOnBatchName();
        clickOnInvoiceNumber();
        clickOnPaymentHistory();
        enterRemarks();
        placeTheCursorOnRemarks();
        logoutProcess();
        return this;
    }

    public Invoice_Detail_Page TC_ID_004() throws IOException {
        getTestData();
        test = report.createTest(prop.getProperty("Bills2U.InvoiceDetail.TC4"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        clickOnBatchName();
        clickOnInvoiceNumber();
        clickOnPaymentHistory();
        enterPaymentAmount();
        placeTheCursorOnPaymentAmount();
        logoutProcess();
        return this;
    }

    public Invoice_Detail_Page TC_ID_005() throws IOException {
        getTestData();
        test = report.createTest(prop.getProperty("Bills2U.InvoiceDetail.TC5"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        clickOnBatchName();
        clickOnInvoiceNumber();
        clickOnPaymentHistory();
        enterPaymentDate();
        placeTheCursorOnPaymentDate();
        logoutProcess();
        return this;
    }

    public Invoice_Detail_Page TC_ID_006() throws IOException {
        getTestData();
        test = report.createTest(prop.getProperty("Bills2U.InvoiceDetail.TC6"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        clickOnBatchName();
        clickOnInvoiceNumber();
        clickOnPaymentHistory();
        enterPaidBy();
        placeTheCursorOnPaidBy();
        logoutProcess();
        return this;
    }

    public Invoice_Detail_Page TC_ID_007() throws IOException {
        getTestData();
        test = report.createTest(prop.getProperty("Bills2U.InvoiceDetail.TC7"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        clickOnBatchName();
        clickOnInvoiceNumber();
        clickOnPaymentHistory();
        enterTransactionReference();
        enterItemName();
        enterRemarks();
        enterPaymentAmount();
        enterPaymentDate();
        enterPaidBy();
        logoutProcess();
        return this;
    }

    public Invoice_Detail_Page TC_ID_008() throws IOException {
        getTestData();
        test = report.createTest(prop.getProperty("Bills2U.InvoiceDetail.TC8"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        clickOnBatchName();
        clickOnInvoiceNumber();
        clickOnPaymentHistory();
        clickOnAddTransaction();
        checkMantatorySymbolInAddTransaction();
        selectItemName();
        checkAmount();
        selectTransactionTypeAsRefund();
        selectPaymentDate();
        editAmount();
        editRemarks();
        clickOnAddBtn();
        logoutProcess();
        return this;
    }

    public Invoice_Detail_Page TC_ID_009() throws IOException {
        getTestData();
        test = report.createTest(prop.getProperty("Bills2U.InvoiceDetail.TC9"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        clickOnBatchName();
        clickOnInvoiceNumber();
        clickOnPaymentHistory();
        clickOnAddTransactionExportButton();
        checkDataInExportSheet();
        logoutProcess();
        return this;
    }

    public Invoice_Detail_Page TC_ID_010() throws IOException {
        getTestData();
        test = report.createTest(prop.getProperty("Bills2U.InvoiceDetail.TC10"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        clickOnBatchName();
        clickOnInvoiceNumber();
        clickOnPaymentHistory();
        clickOnAddTransaction();
        checkMantatorySymbolInAddTransaction();
        selectItemName();
        checkAmount();
        checkAddBtn();
        selectTransactionTypeAsPayment();
        selectPaymentDate();
        editAmount();
        checkAmtErrorMsg();
        editRemarks();
        clickOnAddBtn();
        logoutProcess();
        return this;
    }

    public Invoice_Detail_Page TC_ID_011() throws IOException {
        getTestData();
        test = report.createTest(prop.getProperty("Bills2U.InvoiceDetail.TC11"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        clickOnBatchName();
        clickOnInvoiceNumber();
        clickOnPaymentHistory();
        clickOnAddTransaction();
        checkMantatorySymbolInAddTransaction();
        selectItemName();
        checkAmount();
        checkAddBtn();
        selectTransactionTypeAsRefund();
        selectPaymentDate();
        editAmount();
        checkAmtErrorMsg();
        checkAddBtn();
        editRemarks();
        clickOnAddBtn();
        logoutProcess();
        return this;
    }

    public Invoice_Detail_Page TC_ID_012() throws IOException {
        getTestData();
        test = report.createTest(prop.getProperty("Bills2U.InvoiceDetail.TC12"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        clickOnBatchName();
        clickOnInvoiceNumber();
        clickOnPaymentHistory();
        clickOnExternalTransactionLink();
        clickOnDeleteTransactionBtn();
        logoutProcess();
        return this;
    }

    public Invoice_Detail_Page TC_ID_013() throws IOException {
        getTestData();
        test = report.createTest(prop.getProperty("Bills2U.InvoiceDetail.TC13"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        clickOnBatchName();
        clickOnInvoiceNumber();
        clickOnPaymentHistory();
        clickOnExternalTransactionLink();
        placeTheCursorOnCloseIconPopup();
        clickOnCloseBtn();
        logoutProcess();
        return this;
    }

    public Invoice_Detail_Page TC_ID_014() throws IOException {
        getTestData();
        test = report.createTest(prop.getProperty("Bills2U.InvoiceDetail.TC14"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        clickOnBatchName();
        clickOnInvoiceNumber();
        clickPauseIcon();
        placeTheCursorOnPauseIcon();
        checkPopupMessage();
        clickStopInPauseDialog();
        logoutProcess();
        return this;
    }


    public Invoice_Detail_Page TC_ID_015() throws IOException {
        getTestData();
        test = report.createTest(prop.getProperty("Bills2U.InvoiceDetail.TC15"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        clickOnBatchName();
        clickOnInvoiceNumber();
        clickPauseIcon();
        placeTheCursorOnPauseIcon();
        checkPopupMessage();
        clickCancelInPauseDialog();
        logoutProcess();
        return this;
    }

    public Invoice_Detail_Page TC_ID_016() throws IOException {
        getTestData();
        test = report.createTest(prop.getProperty("Bills2U.InvoiceDetail.TC16"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        clickOnBatchName();
        clickOnInvoiceNumber();
        clickPauseIcon();
        placeTheCursorOnPauseIcon();
        checkPopupMessage();
        clickStopInPauseDialog();
        logoutProcess();
        return this;
    }

    public Invoice_Detail_Page TC_ID_017() throws IOException {
        getTestData();
        test = report.createTest(prop.getProperty("Bills2U.InvoiceDetail.TC17"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        clickOnBatchName();
        clickOnInvoiceNumber();
        clickPauseIcon();
        placeTheCursorOnPauseIcon();
        checkPopupMessage();
        clickCancelInPauseDialog();
        logoutProcess();
        return this;
    }

    public Invoice_Detail_Page TC_ID_018() throws IOException {
        getTestData();
        test = report.createTest(prop.getProperty("Bills2U.InvoiceDetail.TC18"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        enterPaidAmount();
        clickOnBatchName();
        clickOnInvoiceNumber();
        placeTheCursorOnDeleteIcon();
        clickDeleteIcon();
        checkDeletePopupMessage();
        clickDeleteInDialog();
        logoutProcess();
        return this;
    }

    public Invoice_Detail_Page TC_ID_019() throws IOException {
        getTestData();
        test = report.createTest(prop.getProperty("Bills2U.InvoiceDetail.TC19"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        clickOnBatchName();
        clickOnInvoiceNumber();
        placeTheCursorOnDeleteIcon();
        clickDeleteIcon();
        checkDeletePopupMessage();
        clickCancelInPauseDialog();
        logoutProcess();
        return this;
    }
}
