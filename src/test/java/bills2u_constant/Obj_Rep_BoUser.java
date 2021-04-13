package bills2u_constant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Obj_Rep_BoUser {

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-breadcrumb/div/div/div/div[2]/span")
    public WebElement verifyBoUserPage;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-user/div[1]/mat-card/div/div[2]/button")
    public WebElement btnAddNew;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-user/div[1]/mat-card/form/div/div[1]/mat-form-field/div/div[1]/div/input")
    public WebElement iptName;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-user/div[1]/mat-card/form/div/div[2]/mat-form-field/div/div[1]/div/input")
    public WebElement iptEmail;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-user/div[1]/mat-card/form/div/div[3]/mat-form-field/div/div[1]/div/input")
    public WebElement iptPhoneNumber;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-user/div[1]/mat-card/form/div/div[4]/mat-checkbox")
    public WebElement chkIsActive;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-user/div[1]/mat-card/form/div/div[4]/mat-checkbox/label/div/input")
    public WebElement verifyChkIsActive;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-user/div[1]/mat-card/form/div/div[5]/button[1]/span[1]/mat-icon")
    public WebElement btnSave;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-user/div[1]/mat-card/form/div/div[5]/button[2]/span[1]/mat-icon")
    public WebElement btnCancel;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-user/div[1]/mat-card/div/div[2]/button/span[1]/mat-icon")
    public WebElement btnClose;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-user/div[2]/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[1]/mat-form-field/div/div[1]/div/input")
    public WebElement clmFilterName;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-user/div[2]/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[2]/div[1]/mat-form-field/div/div[1]/div/input")
    public WebElement clmFilterEmail;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-user/div[2]/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[3]/mat-form-field/div/div[1]/div/input")
    public WebElement clmFilterPhoneNumber;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-user/div[2]/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[4]/mat-form-field/div/div[1]/div/mat-select")
    public WebElement clmFilterActive;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-user/div[2]/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[5]/mat-form-field/div/div[1]/div/input")
    public WebElement clmFilterModifiedBy;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-user/div[2]/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[6]/mat-form-field/div/div[1]/div/input")
    public WebElement clmFilterModifiedOn;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-user/div[2]/mat-card/mat-card-content/mat-table/mat-row/mat-cell[1]/span")
    public WebElement rowVerifyName;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-user/div[2]/mat-card/mat-card-content/mat-table/mat-row/mat-cell[2]/span")
    public WebElement rowVerifyEmail;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-user/div[2]/mat-card/mat-card-content/mat-table/mat-row/mat-cell[3]/span")
    public WebElement rowVerifyPhoneNumber;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-user/div[2]/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[4]")
    public WebElement rowVerifyIsActive;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-user/div[2]/mat-card/mat-card-content/mat-table/mat-row/mat-cell[5]/span")
    public WebElement rowVerifyModifiedBy;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-user/div[2]/mat-card/mat-card-content/mat-table/mat-row/mat-cell[6]/span")
    public WebElement rowVerifyModifiedOn;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-user/div[2]/mat-card/mat-card-content/mat-table/mat-row/mat-cell[7]/button[2]")
    public WebElement rowUserDelete;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-confirmation-dialog/div/div[3]/div/div")
    public WebElement verifyPopupUser;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-confirmation-dialog/div/div[4]/button[1]")
    public WebElement btnPopupDelete;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-confirmation-dialog/div/div[4]/button[2]")
    public WebElement btnPopupCancel;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-user/div[2]/mat-card/mat-card-content/div")
    public WebElement noRecordFound;
}
