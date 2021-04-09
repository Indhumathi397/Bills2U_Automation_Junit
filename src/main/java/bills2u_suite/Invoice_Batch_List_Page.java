package bills2u_suite;

import Config.PropertyClass;
import bills2u_process.Invoice_Batch_List_Process;
import bills2u_process.ProcessClass;

import java.io.IOException;

public class Invoice_Batch_List_Page extends Invoice_Batch_List_Process {

    public Invoice_Batch_List_Page TC_IBL_001() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceBatchList.TC1"));
        loginProcess();
        GotToInVoiceBatch();
        ClickShowFilter();
        SelectFromDate();
        SelectToDate();
        ClickStatusInInvoiceBatchList();
        ClickPublishStatusInInvoiceBatchList();
        ClickSearchFilterPInvoiceBatchList();
        logoutProcess();
        return this;
    }

    public Invoice_Batch_List_Page TC_IBL_002() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceBatchList.TC2"));
        loginProcess();
        GotToInVoiceBatch();
        ClickShowFilter();
        SelectFromDate();
        SelectToDate();
        ClickStatusInInvoiceBatchList();
        ClickStoppedStatusInInvoiceBatchList();
        ClickSearchFilterSInvoiceBatchList();
        logoutProcess();
        return this;
    }
    public Invoice_Batch_List_Page TC_IBL_003() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceBatchList.TC3"));
        loginProcess();
        GotToInVoiceBatch();
        ClickShowFilter();
        SelectFromDate();
        SelectToDate();
        ClickStatusInInvoiceBatchList();
        ClickDraftStatusInInvoiceBatchList();
        ClickSearchFilterDInvoiceBatchList();
        logoutProcess();
        return this;
    }
    public Invoice_Batch_List_Page TC_IBL_004() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceBatchList.TC4"));
        loginProcess();
        GotToInVoiceBatch();
        ClickShowFilter();
        SelectFromDate();
        SelectToDate();
        ClickSearchFilterInvoiceBatchList();
        logoutProcess();
        return this;
    }

    public Invoice_Batch_List_Page TC_IBL_005() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceBatchList.TC5"));
        loginProcess();
        GotToInVoiceBatch();
        FindFilterInvoiceBatch("RPINVB-RPM-3-28-09-2020-6");
        VerifyColumnFilterBatchName("RPINVB-RPM-3-28-09-2020-6");
        FindFilterInvoiceBatch("MYR 41,695.00");
        VerifyColumnFilterBatchAmount("MYR 41,695.00");
        FindFilterInvoiceBatch("MYR 41,695.00");
        VerifyColumnFilterOverDue("MYR 41,695.00");
        FindFilterInvoiceBatch("MYR 41,695.00");
        VerifyColumnFilterUnpaid("MYR 41,695.00");
        FindFilterInvoiceBatch("MYR 250.00");
        VerifyColumnFilterPaid("MYR 250.00");
        ColumnStatusFilter();
        ColumnStatusFilterPublished();
        FindFilterInvoiceBatch("30-Nov-2020");
        VerifyColumnFilterCreatedOnDate("30-Nov-2020");
        FindFilterInvoiceBatch("5:56:31 PM");
        VerifyColumnFilterCreatedOnTime("5:56:31 PM");
        FindFilterInvoiceBatch("30-Nov-2020 5:56:31 PM");
        VerifyColumnFilterCreatedOnDateTime("30-Nov-2020 5:56:31 PM");
        FindFilterInvoiceBatch("0.01");
        VerifyColumnFilterBatchProgress("0.01");
        logoutProcess();
        return this;
    }

    public Invoice_Batch_List_Page TC_IBL_006() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceBatchList.TC6"));
        loginProcess();
        GotToInVoiceBatch();
        ColumnFilterBatchName();
        logoutProcess();
        return this;
    }

    public Invoice_Batch_List_Page TC_IBL_007() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceBatchList.TC7"));
        loginProcess();
        GotToInVoiceBatch();
        ColumnFilterBatchAmount();
        logoutProcess();
        return this;
    }

    public Invoice_Batch_List_Page TC_IBL_008() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceBatchList.TC8"));
        loginProcess();
        GotToInVoiceBatch();
        ColumnFilterOverDue();
        logoutProcess();
        return this;
    }

    public Invoice_Batch_List_Page TC_IBL_009() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceBatchList.TC9"));
        loginProcess();
        GotToInVoiceBatch();
        ColumnFilterUnpaid();
        logoutProcess();
        return this;
    }

    public Invoice_Batch_List_Page TC_IBL_010() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceBatchList.TC10"));
        loginProcess();
        GotToInVoiceBatch();
        ColumnFilterPaid();
        logoutProcess();
        return this;
    }
    public Invoice_Batch_List_Page TC_IBL_011() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceBatchList.TC11"));
        loginProcess();
        GotToInVoiceBatch();
        ColumnFilterPublished();
        logoutProcess();
        return this;
    }
    public Invoice_Batch_List_Page TC_IBL_012() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceBatchList.TC12"));
        loginProcess();
        GotToInVoiceBatch();
        ColumnFilterStopped();
        logoutProcess();
        return this;
    }
    public Invoice_Batch_List_Page TC_IBL_013() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceBatchList.TC13"));
        loginProcess();
        GotToInVoiceBatch();
        ColumnFilterDraft();
        logoutProcess();
        return this;
    }
    public Invoice_Batch_List_Page TC_IBL_014() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceBatchList.TC14"));
        loginProcess();
        GotToInVoiceBatch();
        ColumnFilterALlOption();
        logoutProcess();
        return this;
    }
    public Invoice_Batch_List_Page TC_IBL_015() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceBatchList.TC15"));
        loginProcess();
        GotToInVoiceBatch();
        ColumnFilterCreatedOnDate();
        logoutProcess();
        return this;
    }
    public Invoice_Batch_List_Page TC_IBL_016() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceBatchList.TC16"));
        loginProcess();
        GotToInVoiceBatch();
        ColumnFilterCreatedOnTime();
        logoutProcess();
        return this;
    }
    public Invoice_Batch_List_Page TC_IBL_017() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceBatchList.TC17"));
        loginProcess();
        GotToInVoiceBatch();
        ColumnFilterCreatedOnDateTime();
        logoutProcess();
        return this;
    }
    public Invoice_Batch_List_Page TC_IBL_018() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceBatchList.TC18"));
        loginProcess();
        GotToInVoiceBatch();
        ColumnFilterBatchProgress();
        logoutProcess();
        return this;
    }
    public Invoice_Batch_List_Page TC_IBL_019() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceBatchList.TC19"));
        loginProcess();
        GotToInVoiceBatch();
        ColumnFilterDraft();
        ColumnStatusFilterDraftClick();
        ClickRowDeleteButton();
        CheckRowDeletePopup();
        ClickButtonDeleteInPopupFromTable();
        logoutProcess();
        return this;
    }
    public Invoice_Batch_List_Page TC_IBL_020() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceBatchList.TC20"));
        loginProcess();
        GotToInVoiceBatch();
        VerifyBatchProgressCalculation();
        logoutProcess();
        return this;
    }
    public Invoice_Batch_List_Page TC_IBL_021() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceBatchList.TC21"));
        loginProcess();
        GotToInVoiceBatch();
        clickOnExportButton();
        logoutProcess();
        return this;
    }
}
