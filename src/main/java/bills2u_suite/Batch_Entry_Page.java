package bills2u_suite;

import Config.PropertyClass;
import bills2u_process.Batch_Entry_Process;
import bills2u_process.ProcessClass;

import java.io.IOException;

public class Batch_Entry_Page extends Batch_Entry_Process {


    public  Batch_Entry_Page TC_BE_001() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.BatchEntry.TC1"));
        loginProcess();
        GotToInVoiceBatch();
        ClickBatchEntry();
        ClickAddInvoice();
        VerifyBillsToData();
        VerifyAddItem();
        ClickItemSaveIcon();
        ClickNewInvoiceBatchCloseIcon();
        logoutProcess();
        return this;
    }

    public  Batch_Entry_Page TC_BE_002() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.BatchEntry.TC2"));
        loginProcess();
        GotToInVoiceBatch();
        ClickBatchEntry();
        ClickAddInvoice();
        VerifyBillsToData();
        VerifyAddItem();
        ClickItemSaveIcon();
        ClickItemDeleteIcon();
        ClickNewInvoiceBatchCloseIcon();
        logoutProcess();
        return this;
    }

    public  Batch_Entry_Page TC_BE_003() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.BatchEntry.TC3"));
        loginProcess();
        GotToInVoiceBatch();
        ClickBatchEntry();
        ClickAddInvoice();
        VerifyBillsToData();
        VerifyAddItem();
        ClickItemSaveIcon();
        VerifyEditItem();
        ClickNewInvoiceBatchCloseIcon();
        logoutProcess();
        return this;
    }

    public  Batch_Entry_Page TC_BE_004() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.BatchEntry.TC4"));
        loginProcess();
        GotToInVoiceBatch();
        ClickBatchEntry();
        ClickAddInvoice();
        ClickSVGIcon();
        ClickCheckboxUnitPrice();
        VerifyBillsToData();
        VerifyAddItemWithoutUnitPrice();
        ClickItemSaveIconWithoutUnitPrice();
        ClickNewBatchSaveIcon();
        logoutProcess();
        return this;
    }

    public  Batch_Entry_Page TC_BE_005() throws IOException {
        getTestData();
        test = report.createTest(prop.getProperty("Bills2U.BatchEntry.TC5"));
        loginProcess();
        GotToInVoiceBatch();
        ClickBatchEntry();
        ClickAddInvoice();
        ClickSVGIcon();
        ClickCheckboxDescription();
        VerifyBillsToData();
        VerifyAddItemWithoutDescription();
        ClickItemSaveIconWithoutDescription();
        ClickNewBatchSaveIcon();
        logoutProcess();
        return this;
    }
}
