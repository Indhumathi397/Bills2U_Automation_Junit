package bills2u_constant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Obj_Rep_BatchUpload {


    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[1]/form/div[1]/mat-form-field/div/div[1]/div/input")
    public WebElement iptBatchName;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[1]/form/div[3]/mat-form-field/div/div[1]/div/mat-select")
    public WebElement chooseFeedType;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[1]/form/div[3]/div[2]/a")
    public WebElement txtLinkClickHere;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[1]/form/div[4]/mat-checkbox")
    public WebElement chkNotifyOnPublish;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[1]/form/div[5]/div[2]/div/input")
    public WebElement uploadBatchFeedFile;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[1]/form/div[8]/div[2]/mat-checkbox/label/div")
    public WebElement chkVerifyBillGenerateBox;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[1]/form/div[8]/div[2]/div/button[3]/span[1]")
    public WebElement btnPublish;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-confirmation-dialog/div/div[3]/button[1]/span[1]")
    public WebElement btnPublishAnyway;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[1]/form/div[8]/div[2]/div/button[1]/span[1]")
    public WebElement btnBatchUploadBack;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[1]/form/div[8]/div[2]/div/button[2]/span[1]")
    public WebElement btnBatchUploadDraft;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-confirmation-dialog/div/div[3]/button[1]/span[1]")
    public WebElement btnSaveDraftAnyway;
}
