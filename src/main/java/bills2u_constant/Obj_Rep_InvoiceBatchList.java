package bills2u_constant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Obj_Rep_InvoiceBatchList {

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-breadcrumb/div/div/div/div[2]/span")
    public WebElement txtInvoiceBatch;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/div/mat-card/div/div/a/span")
    public WebElement lnkShowFilter;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/div/mat-card/form/mat-form-field[1]/div/div[1]/div[1]/input")
    public WebElement dateFrom;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/div/mat-card/form/mat-form-field[2]/div/div[1]/div[1]/input")
    public WebElement dateTo;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/div/mat-card/form/mat-form-field[3]/div/div[1]/div/mat-select")
    public WebElement selectStatus;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/div[1]/div[2]/div[2]/button")
    public WebElement btnBatchEntry;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/div[1]/div[2]/div[1]/button")
    public WebElement btnBatchUpload;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[1]/mat-card/div/h2")
    public WebElement txtNewInvoiceBatch;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[1]/mat-card/div/h2")
    public WebElement txtNewBatchInvoice;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/div/mat-card/div/h2")
    public WebElement txtInvoiceBatchList;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/div/mat-card/form/div/button")
    public WebElement btnBListSearchFilter;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[1]/mat-form-field/div/div[1]/div/input")
    public WebElement clmFilterBatchName;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[2]/mat-form-field/div/div[1]/div/input")
    public WebElement clmFilterBatchAmount;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[3]/mat-form-field/div/div[1]/div/input")
    public WebElement clmFilterOverDue;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[4]/mat-form-field/div/div[1]/div/input")
    public WebElement clmFilterUnPaid;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[5]/mat-form-field/div/div[1]/div/input")
    public WebElement clmFilterPaid;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[6]/mat-form-field/div/div[1]/div/mat-select")
    public WebElement clmStatusSelect;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/div/div/mat-option[1]/span")
    public WebElement clmFilterStatusAll;

//    @FindBy(id = "mat-option-3")
    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/div/div/mat-option[2]/span")
    public WebElement clmFilterPublished;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/div/div/mat-option[3]/span")
    public WebElement clmFilterStopped;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/div/div/mat-option[4]/span")
    public WebElement clmFilterDraft;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[7]/mat-form-field/div/div[1]/div/input")
    public WebElement clmFilterCreatedon;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[8]/mat-form-field/div/div[1]/div/input")
    public WebElement clmFilterBatchProgress;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[9]/button")
    public WebElement rowDeleteButton;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-confirmation-dialog/div/div[1]/h3")
    public WebElement txtDeletePopup;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-confirmation-dialog/div/div[2]/div/div")
    public WebElement txtMessagePopup;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-confirmation-dialog/div/div[3]/button[1]")
    public WebElement btnDeletePopup;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-confirmation-dialog/div/div[3]/button[2]")
    public WebElement btnCancelPopup;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/div[1]/div[2]/div[3]/button")
    public WebElement btnExportInvoiceBatchList;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/div[1]/div[1]/mat-form-field/div/div[1]/div[1]/input")
    public WebElement iptFindFilter;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/div[2]")
    public WebElement txtNoResultInTable;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row/mat-cell[1]/a")
    public WebElement goToEditInvoiceBatch;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/div/div/mat-card/div/div[1]/h2")
    public WebElement txtVerifyEditBatchInvoice;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row/mat-cell[6]")
    public WebElement txtVerifyPublishedEditBatchInvoice;
}
