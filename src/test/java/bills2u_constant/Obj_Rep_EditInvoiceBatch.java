package bills2u_constant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Obj_Rep_EditInvoiceBatch {

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-list/mat-card/mat-card-content/form/div[1]/mat-form-field/div/div[1]/div[3]/input")
    public WebElement filterInvoiceNumber;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-list/mat-card/mat-card-content/form/div[2]/mat-form-field/div/div[1]/div[3]/input")
    public WebElement filterRef1;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-list/mat-card/mat-card-content/form/div[3]/mat-form-field/div/div[1]/div[3]/input")
    public WebElement filterRef2;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-list/mat-card/mat-card-content/form/div[4]/button")
    public WebElement btnSearchInBatchInvoices;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-list/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[1]/a")
    public WebElement rowVerifyInvoiceNumber;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-list/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[2]/p")
    public WebElement rowVerifyRef1;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-list/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[3]")
    public WebElement rowVerifyRef2;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/div/div/mat-card/div/div[2]/button")
    public WebElement btnStop;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/div/div/mat-card/div/div[2]/button")
    public WebElement btnResume;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/div/div/mat-card/div/div[2]/div[2]/h3")
    public WebElement txtInvoiceStatus;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-list/mat-card/mat-card-content/mat-table/mat-row/mat-cell[9]")
    public List<WebElement> RowBatchInvoiceStatus;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-confirmation-dialog/div/div[1]/h3")
    public WebElement popupStopTitle;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-confirmation-dialog/div/div[2]/div/div")
    public WebElement popupStopMessage;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-confirmation-dialog/div/div[3]/button[1]")
    public WebElement popupStopButton;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-confirmation-dialog/div/div[3]/button[2]")
    public WebElement popupStopCancelButton ;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-confirmation-dialog/div/div[1]/h3")
    public WebElement popupResumeTitle;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-confirmation-dialog/div/div[2]/div/div")
    public WebElement popupResumeMessage;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-confirmation-dialog/div/div[3]/button[1]")
    public WebElement popupResumeButton;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-confirmation-dialog/div/div[3]/button[2]")
    public WebElement popupResumeCancelButton;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-list/mat-card/div/div[2]/button")
    public WebElement editInvoiceExportButton;
}
