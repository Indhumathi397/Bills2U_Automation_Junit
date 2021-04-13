package bills2u_suite;

import bills2u_process.File_Upload_Process;

import java.io.IOException;

public class File_Upload_Page extends File_Upload_Process {
    
    public File_Upload_Page TC_FU_001() throws IOException {
        
        test = report.createTest(prop.getProperty("Bills2U.FileUpload.TC1"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        clickOnBatchUpload();
        checkName();
        enterDataInName();
        setTheReminder();
        selectFeedType();
        clickHereProcess();
        editExcelFile();
        selectOrUnselectNotify();
        uploadFile();
        logoutProcess();
        return this;
    }

    public File_Upload_Page TC_FU_002() throws IOException {
        
        test = report.createTest(prop.getProperty("Bills2U.FileUpload.TC2"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        placeTheCursorOnBatchUpload();
        clickOnBatchUpload();
        editExcelFile();
        uploadFile();
        checkInvoiceList();
        clickOnEditRecipient();
        enterEmailAndPhoneInRecipient();
        clickOnSaveInRecipient();
        closeRecipient();
        logoutProcess();
        return this;
    }

    public File_Upload_Page TC_FU_003() throws IOException {
        
        test = report.createTest(prop.getProperty("Bills2U.FileUpload.TC3"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        placeTheCursorOnBatchUpload();
        clickOnBatchUpload();
        editExcelFile();
        uploadFile();
        checkInvoiceList();
        clickOnEditRecipient();
        clickOnDeleteInRecipient();
        closeRecipient();
        logoutProcess();
        return this;
    }

    public File_Upload_Page TC_FU_004() throws IOException {
        
        test = report.createTest(prop.getProperty("Bills2U.FileUpload.TC4"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        placeTheCursorOnBatchUpload();
        clickOnBatchUpload();
        editExcelFile();
        uploadFile();
        checkInvoiceList();
        clickOnDelete();
        clickOnDeleteButton();
        logoutProcess();
        return this;
    }

    public File_Upload_Page TC_FU_005() throws IOException {
        
        test = report.createTest(prop.getProperty("Bills2U.FileUpload.TC5"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        placeTheCursorOnBatchUpload();
        clickOnBatchUpload();
        editExcelFile();
        uploadFile();
        checkInvoiceList();
        enterInvoiceNumberInFind();
        enterRecipientInFind();
        enterRef1InFind();
        enterInvoiceAmount();
        enterEmptyData();
        logoutProcess();
        return this;
    }

    public File_Upload_Page TC_FU_006() throws IOException {
        
        test = report.createTest(prop.getProperty("Bills2U.FileUpload.TC6"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        placeTheCursorOnBatchUpload();
        clickOnBatchUpload();
        clickHereProcess();
        editExcelFile();
        uploadFile();
        checkInvoiceList();
        clickOnExportButton();
        logoutProcess();
        return this;
    }

    public File_Upload_Page TC_FU_007() throws IOException {
        
        test = report.createTest(prop.getProperty("Bills2U.FileUpload.TC7"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        placeTheCursorOnBatchUpload();
        clickOnBatchUpload();
        clickHereProcess();
        editExcelFile();
        uploadFile();
        checkInvoiceList();
        clickOnEditRecipient();
        enterEmailInColumnFilter();
        enterEmptySpaceInEmail();
        closeRecipient();
        logoutProcess();
        return this;
    }

    public File_Upload_Page TC_FU_008() throws IOException {
        
        test = report.createTest(prop.getProperty("Bills2U.FileUpload.TC8"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        placeTheCursorOnBatchUpload();
        clickOnBatchUpload();
        editExcelFile();
        uploadFile();
        checkInvoiceList();
        clickOnEditRecipient();
        enterPhoneInColumnFilter();
        enterEmptySpaceInPhone();
        closeRecipient();
        logoutProcess();
        return this;
    }

    public File_Upload_Page TC_FU_009() throws IOException {
        
        test = report.createTest(prop.getProperty("Bills2U.FileUpload.TC9"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        placeTheCursorOnBatchUpload();
        clickOnBatchUpload();
        editExcelFile();
        uploadFile();
        checkInvoiceList();
        clickOnEditRecipient();
        enterEmailAndPhoneForUpwardTesting();
        upwardAero();
        downwardAero();
        closeRecipient();
        logoutProcess();
        return this;
    }

    public File_Upload_Page TC_FU_010() throws IOException {
        
        test = report.createTest(prop.getProperty("Bills2U.FileUpload.TC10"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceBatch();
        clickOnBatchUpload();
        checkName();
        enterDataInName();
        setTheReminder();
        selectFeedTypeAsKdu();
        clickHereProcess();
        selectOrUnselectNotify();
        uploadFile();
        logoutProcess();
        return this;
    }
}
