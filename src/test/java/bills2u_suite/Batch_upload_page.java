package bills2u_suite;

import bills2u_process.Batch_Upload_Process;

import java.io.IOException;

public class Batch_upload_page extends Batch_Upload_Process {

    public Batch_upload_page TC_BU_001() throws IOException {
        getTestData();
        test = report.createTest(prop.getProperty("Bills2U.BatchUpload.TC1"));
        loginProcess();
        GotToInVoiceBatch();
        ClickBatchUpload();
        CheckBatchName();
        EnterBatchName();
        ReminderSetup();
        ChooseFeedType();
        clickHereProcess();
        editExcelFile();
        NotifyOnPublishCheckboxClick();
        uploadFile();
        logoutProcess();
        return this;
    }

    public Batch_upload_page TC_BU_002() throws IOException {
        getTestData();
        test = report.createTest(prop.getProperty("Bills2U.BatchUpload.TC2"));
        loginProcess();
        GotToInVoiceBatch();
        ClickBatchUpload();
        CheckBatchName();
        EnterBatchName();
        DownloadBatchFeedTemplate();
        NotifyOnPublishCheckboxClick();
        uploadFile();
        VerifyBillGeanratedCheckBoxClick();
        ClickPublishButton();
        logoutProcess();
        return this;
    }

    public Batch_upload_page TC_BU_003() throws IOException {
        getTestData();
        test = report.createTest(prop.getProperty("Bills2U.BatchUpload.TC3"));
        loginProcess();
        GotToInVoiceBatch();
        ClickBatchUpload();
        uploadFile();
        VerifyBillGeanratedCheckBoxClick();
        ClickBatchUploadDraftButton();
        logoutProcess();
        return this;
    }

    public Batch_upload_page TC_BU_004() throws IOException {
        getTestData();
        test = report.createTest(prop.getProperty("Bills2U.BatchUpload.TC4"));
        loginProcess();
        GotToInVoiceBatch();
        ClickBatchUpload();
        uploadFile();
        ClickBatchUploadBackButton();
        logoutProcess();
        return this;
    }

}
