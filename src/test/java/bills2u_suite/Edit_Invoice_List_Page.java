package bills2u_suite;

import bills2u_process.Edit_Invoice_List_Process;

import java.io.IOException;

public class Edit_Invoice_List_Page extends Edit_Invoice_List_Process {

    public  Edit_Invoice_List_Page TC_EIL_001() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.EditInvoiceBatchList.TC1"));
        loginProcess();
        GotToInVoiceBatch();
        FindFilterInvoiceBatch(prop.getProperty("Bills2U.EditBatchList.BatchName.Filter"));
        GoToEditInvoiceBatchList();
        VerifyEnteredInvoiceNumber();
        ClickSearchBtnInvoiceNumber();
        logoutProcess();
        return this;
    }

    public  Edit_Invoice_List_Page TC_EIL_002() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.EditInvoiceBatchList.TC2"));
        loginProcess();
        GotToInVoiceBatch();
        FindFilterInvoiceBatch(prop.getProperty("Bills2U.EditBatchList.BatchName.Filter"));
        GoToEditInvoiceBatchList();
        VerifyEnteredRef1Number();
        ClickSearchBtnRef1();
        logoutProcess();
        return this;
    }

    public  Edit_Invoice_List_Page TC_EIL_003() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.EditInvoiceBatchList.TC3"));
        loginProcess();
        GotToInVoiceBatch();
        FindFilterInvoiceBatch(prop.getProperty("Bills2U.EditBatchList.BatchName.Filter"));
        GoToEditInvoiceBatchList();
        VerifyEnteredRef2Number();
        ClickSearchBtnRef2();
        logoutProcess();
        return this;
    }

    public  Edit_Invoice_List_Page TC_EIL_004() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.EditInvoiceBatchList.TC4"));
        loginProcess();
        GotToInVoiceBatch();
        FindFilterInvoiceBatch(prop.getProperty("Bills2U.EditBatchList.BatchName.Filter"));
        GoToEditInvoiceBatchList();
        VerifyEnteredInvoiceNumber();
        VerifyEnteredRef1Number();
        VerifyEnteredRef2Number();
        ClickSearchBtnInvoiceBatchList();
        logoutProcess();
        return this;
    }

}
