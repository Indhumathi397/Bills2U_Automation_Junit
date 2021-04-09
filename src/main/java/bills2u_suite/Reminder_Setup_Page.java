package bills2u_suite;

import Config.PropertyClass;
import bills2u_process.ProcessClass;
import bills2u_process.Reminder_Setup_Process;

import java.io.IOException;

public class Reminder_Setup_Page extends Reminder_Setup_Process {

    public Reminder_Setup_Page TC_RS_001() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.ReminderSetup.TC1"));
        loginProcess();
        GotToInVoiceBatch();
        ClickBatchUpload();
        ClickAddReminder();
        VerifyReminderSetupOption();
        ClickOptionBeforeDue();
        EnterDaysValue();
        ClickSetupDoneButton();
        ClickPublishButton();
        logoutProcess();
        return this;
    }

    public Reminder_Setup_Page TC_RS_002() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.ReminderSetup.TC2"));
        loginProcess();
        GotToInVoiceBatch();
        ClickBatchUpload();
        ClickAddReminder();
        VerifyReminderSetupOption();
        ClickOptionAfterDue();
        EnterDaysValue();
        ClickSetupDoneButton();
        ClickPublishButton();
        logoutProcess();
        return this;
    }

    public Reminder_Setup_Page TC_RS_003() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.ReminderSetup.TC3"));
        loginProcess();
        GotToInVoiceBatch();
        ClickBatchUpload();
        ClickAddReminder();
        VerifyReminderSetupOption();
        ClickOptionOnDue();
        EnterDaysValue();
        ClickSetupDoneButton();
        ClickPublishButton();
        logoutProcess();
        return this;
    }

    public Reminder_Setup_Page TC_RS_004() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.ReminderSetup.TC4"));
        loginProcess();
        GotToInVoiceBatch();
        ClickBatchUpload();
        ClickAddReminder();
        VerifyReminderSetupOption();
        ClickOptionOnDate();
        SelectDateValue();
        ClickSetupDoneButton();
        ClickPublishButton();
        logoutProcess();
        return this;
    }

    public Reminder_Setup_Page TC_RS_005() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.ReminderSetup.TC5"));
        loginProcess();
        GotToInVoiceBatch();
        ClickBatchUpload();
        ClickAddReminder();
        VerifyReminderSetupOption();
        VerifySetupCancelButton();
        ClickSetupCancelButton();
        logoutProcess();
        return this;
    }

    public Reminder_Setup_Page TC_RS_006() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.ReminderSetup.TC6"));
        loginProcess();
        GotToInVoiceBatch();
        ClickBatchUpload();
        ClickAddReminder();
        VerifyReminderSetupOption();
        VerifySetupCancelButton();
        ClickSetupCloseButton();
        logoutProcess();
        return this;
    }
}
