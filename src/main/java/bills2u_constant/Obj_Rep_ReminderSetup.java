package bills2u_constant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Obj_Rep_ReminderSetup {

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[1]/form/div[2]/mat-chip-list/div/mat-chip")
    public WebElement btnAddReminder;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-reminder-setup/div[2]/h2")
    public WebElement txtReminderSetupVerify;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-reminder-setup/form/mat-form-field/div/div[1]/div/mat-select")
    public WebElement chooseReminder;

    @FindBy(xpath = "//mat-option/span[contains(.,'Before Due')]")
    public WebElement chooseReminderOptionBeforeDue;

    @FindBy(xpath = "//mat-option/span[contains(.,'On Due')]")
    public WebElement chooseReminderOptionOnDue;

    @FindBy(xpath = "//mat-option/span[contains(.,'After Due')]")
    public WebElement chooseReminderOptionAfterDue;

    @FindBy(xpath = "//mat-option/span[contains(.,'On Date')]")
    public WebElement chooseReminderOptionOnDate;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-reminder-setup/form/mat-form-field[2]/div/div[1]/div/input")
    public WebElement iptDaysOrDate;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-reminder-setup/form/mat-form-field[2]/div/div[1]/div[1]/input")
    public WebElement selectDate;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-reminder-setup/form/div/button[1]/span[1]")
    public WebElement btnReminderSetupDone;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[1]/form/div[2]/mat-chip-list/div/mat-chip[1]/span")
    public WebElement txtChipVerifyReminder;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[1]/form/div[2]/mat-chip-list/div/mat-chip[2]/span")
    public WebElement txtChipVerifyReminderAfterDue;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[1]/form/div[2]/mat-chip-list/div/mat-chip[1]/button/span[1]/mat-icon")
    public WebElement closeChip;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-reminder-setup/form/div/button[2]/span[1]")
    public WebElement btnReminderPopupCancel;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-reminder-setup/div[1]/button/span[1]/mat-icon")
    public WebElement btnReminderPopupClose;
}
