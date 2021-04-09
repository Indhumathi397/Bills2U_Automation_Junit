package bills2u_constant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Obj_Rep_Invoice {

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-breadcrumb/div/div/div/div[2]/span")
    public WebElement invoiceBatchText;
    @FindBy(xpath = "//*[@id=\"main-content\"]/app-invoice-batch/mat-card/mat-card-content/div[1]/div[2]/div[1]/button/span[1]/span")
    public WebElement batchUploadButton;

    @FindBy(xpath = "//*[@id=\"main-content\"]/app-invoice-batch-form/div/div[1]/mat-card/div/h2")
    public WebElement newInvoiceBatchText;

    @FindBy (xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[1]/form/div[1]/mat-form-field/div/div[1]/div/input")
    public WebElement nameTxtbox;

    @FindBy(xpath = "//*[@id=\"mat-chip-list-0\"]/div/mat-chip[2]")
    public WebElement addReminderBtn;

    @FindBy(id = "/html/body/app-root/div/div[2]/div[4]/div/div/div")
    public WebElement reminder;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-reminder-setup/form/mat-form-field/div/div[1]/div/mat-select")
    public WebElement selectOption;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-reminder-setup/form/mat-form-field[2]/div/div[1]/div/input")
    public WebElement daysTxtBox;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-reminder-setup/form/div/button[1]/span[1]")
    public WebElement doneBtn;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[1]/form/div[3]/mat-form-field/div/div[1]/div/mat-select")
    public WebElement feedDataTypeSelect;

    @FindBy(linkText = "click here")
    public WebElement clickHere;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[1]/form/div[4]/mat-checkbox")
    public WebElement checkNotify;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div/form/div[5]/div[2]/div/input")
    public WebElement uploadFile;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[1]/a")
    public WebElement batchNameInList;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-breadcrumb/div/div/div/div[3]/span")
    public WebElement batchDetailText;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-list/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[1]/a")
    public WebElement invoiceNoInList;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-view/div/mat-card/div[1]/h2")
    public WebElement invoiceSummaryHeader;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-view/div/mat-card/div[2]/div[1]/a[2]/span[1]")
    public WebElement paymentHistoryBtn;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-view/div/div/div[2]/invoice-payment-history/mat-card/div[1]/h3")
    public WebElement paymentHistoryHeader;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-view/div/div/div[2]/invoice-payment-history/mat-card/mat-table/mat-header-row/mat-header-cell[1]/mat-form-field/div/div[1]/div/input")
    public WebElement transactionReference;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-view/div/div/div[2]/invoice-payment-history/mat-card/mat-table/mat-header-row/mat-header-cell[2]/mat-form-field/div/div[1]/div/input")
    public WebElement itemName;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-view/div/div/div[2]/invoice-payment-history/mat-card/mat-table/mat-header-row/mat-header-cell[3]/mat-form-field/div/div[1]/div/input")
    public WebElement remarks;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-view/div/div/div[2]/invoice-payment-history/mat-card/mat-table/mat-header-row/mat-header-cell[4]/mat-form-field/div/div[1]/div/input")
    public WebElement paymentAmount;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-view/div/div/div[2]/invoice-payment-history/mat-card/mat-table/mat-header-row/mat-header-cell[5]/mat-form-field/div/div[1]/div/input")
    public WebElement paymentDate;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-view/div/div/div[2]/invoice-payment-history/mat-card/mat-table/mat-header-row/mat-header-cell[6]/mat-form-field/div/div[1]/div/input")
    public WebElement paidBy;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-view/div/div/div[2]/invoice-payment-history/mat-card/div[3]")
    public WebElement noResult;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-view/div/div/div[2]/invoice-payment-history/mat-card/div[2]/div[2]/button[1]/span[1]")
    public WebElement addTransaction;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-add-transaction/mat-dialog-content/div[2]/div/h2")
    public WebElement addTransactionHeader;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-add-transaction/mat-dialog-content/div[2]/div/form/div[1]/mat-form-field/div/div[1]/div/span/label")
    public WebElement itemStar;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-add-transaction/mat-dialog-content/div[2]/div/form/div[2]/mat-form-field/div/div[1]/div/span/label")
    //@FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-add-transaction/mat-dialog-content/div[2]/div/form/div[2]/mat-form-field/div/div[1]/div/span/label")
    public WebElement transactionTypeStar;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-add-transaction/mat-dialog-content/div[2]/div/form/div[3]/mat-form-field/div/div[1]/div[1]/span/label")
    public WebElement chooseDateStar;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-add-transaction/mat-dialog-content/div[2]/div/form/div[4]/div[2]/mat-form-field/div/div[1]/div/span/label")
    public WebElement amountStar;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-add-transaction/mat-dialog-content/div[2]/div/form/div[5]/mat-form-field/div/div[1]/div/span/label")
    public WebElement remarksStar;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-add-transaction/mat-dialog-content/div[2]/div/form/div[5]/mat-form-field/div/div[1]/div/textarea")
    public WebElement remarkValue;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-add-transaction/mat-dialog-content/div[2]/div/form/div[1]/mat-form-field/div/div[1]/div/mat-select/div/div[1]")
    public WebElement itemSelectedName;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-add-transaction/mat-dialog-content/div[2]/div/form/div[4]/div[2]/mat-form-field/div/div[1]/div/input")
    public WebElement amountValue;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-add-transaction/mat-dialog-content/div[2]/div/form/div[2]/mat-form-field/div/div[1]/div/mat-select/div/div[1]/span/span")
    public WebElement transactionTypeValue;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-add-transaction/mat-dialog-content/div[2]/div/form/div[6]/button[2]/span[1]")
    public WebElement addTransactionCancel;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-breadcrumb/div/div/div/div[2]/span")
    public WebElement invoiceListHeader;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/invoice-list/mat-card[1]/div/div/a/span")
    public WebElement showAndHideFilterInvoiceList;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/payment-listing/div/mat-card/div/div/a/span")
    public WebElement showAndHideFilterPayments;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/invoice-list/mat-card[1]/form/div[9]/mat-checkbox/label/div/input")
    public WebElement includeDraft;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-breadcrumb/div/div/div/div[2]/span")
    public WebElement paymentListingHeader;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/invoice-list/mat-card[1]/form/div[3]/mat-form-field/div/div[1]/div/mat-select/div/div[1]/span")
    public WebElement batchesDropDown;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/div/div/mat-option[1]")
    public WebElement selectAllCheckbox;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[2]/invoice-list-view/div/mat-table/mat-header-row/mat-header-cell[1]/div/div[1]")
    public WebElement invoiceNoInInvoiceList;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[2]/invoice-list-view/div/mat-table/mat-header-row/mat-header-cell[2]/div/div[1]")
    public WebElement recipientInInvoiceList;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[2]/invoice-list-view/div/mat-table/mat-header-row/mat-header-cell[3]/div/div[1]")
    public WebElement ref1InInvoiceList;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[2]/invoice-list-view/div/mat-table/mat-header-row/mat-header-cell[4]/div/div[1]")
    public WebElement invoiceAmtInInvoiceList;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[1]/form/div[6]/p")
    public WebElement uploadSuccessfullMsg;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[2]/invoice-list-view/div/mat-table/mat-row[1]/mat-cell[5]/button[1]/span[1]/mat-icon")
    public WebElement editRecipient;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-invoice-recipient/div/h2")
    public WebElement recipientHeader;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-invoice-recipient/div/button/span[1]/mat-icon")
    public WebElement recipientClose;

    @FindBy(id="mat-input-11")
    public WebElement emailRecipient;

    @FindBy(id="mat-input-12")
    public WebElement phoneRecipient;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-invoice-recipient/form/div[3]/button[1]/span[1]/mat-icon")
    public WebElement saveRecipient;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[3]/div/snack-bar-container/simple-snack-bar/span")
    public WebElement dialogMessage;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-invoice-recipient/mat-card/div/mat-table/mat-row/mat-cell[3]/button/span[1]/mat-icon")
    public WebElement deleteRecipient;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[2]/invoice-list-view/div/mat-table/mat-row[1]/mat-cell[5]/button[2]/span[1]/mat-icon")
    public WebElement deleteIcon;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-confirmation-dialog/div/div[1]/h3")
    public WebElement deleteHeader;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-confirmation-dialog/div/div[3]/button[1]/span[1]")
    public WebElement deleteButton;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[2]/invoice-list-view/div/div[1]/div[2]/mat-form-field/div/div[1]/div[1]/input")
    public WebElement findTxtbox;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[2]/invoice-list-view/div/div[2]")
    public WebElement getNoResult;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[2]/invoice-list-view/div/mat-table/mat-row/mat-cell[1]/a")
    public WebElement invoiceNumberInTable;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[2]/invoice-list-view/div/mat-table/mat-row/mat-cell[2]/p")
    public WebElement recipientInTable;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[2]/invoice-list-view/div/mat-table/mat-row[1]/mat-cell[3]/p")
    public WebElement ref1InTable;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[2]/invoice-list-view/div/mat-table/mat-row/mat-cell[4]")
    public WebElement invoiceAmountInTable;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[2]/invoice-list-view/div/div[1]/div[2]/button/span[1]")
    public WebElement exportBtn;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-invoice-recipient/mat-card/div/mat-table/mat-header-row/mat-header-cell[1]/mat-form-field/div/div[1]/div/input")
    public WebElement emailColumnFilter;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-invoice-recipient/mat-card/div/div")
    public WebElement noResultEditRecipient;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-invoice-recipient/mat-card/div/mat-table/mat-row/mat-cell[1]")
    public WebElement filteredEmail;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-invoice-recipient/mat-card/div/mat-table/mat-header-row/mat-header-cell[2]/mat-form-field/div/div[1]/div/input")
    public WebElement phoneColumnFilter;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-invoice-recipient/mat-card/div/mat-table/mat-row/mat-cell[2]")
    public WebElement filteredPhone;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-invoice-recipient/mat-card/div/mat-table/mat-header-row/mat-header-cell[1]/div/div/div[2]/div[1]")
    public WebElement upwardArrow;

    @FindAll(@FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-invoice-recipient/mat-card/div/mat-table/mat-row[1]/mat-cell[1]"))
    public List<WebElement> getCellFromTable;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[8]/mat-form-field/div/div[1]/div/input")
    public WebElement batchProgressTxtbox;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-view/div/div/div[2]/invoice-payment-history/mat-card/div[3]")
    public WebElement noResultInPaymentHistory;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-view/div/div/div[2]/invoice-payment-history/mat-card/mat-table/mat-row[1]/mat-cell[1]/a")
    public WebElement filteredTransactionRef;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-view/div/div/div[2]/invoice-payment-history/mat-card/mat-table/mat-row[1]/mat-cell[2]/p")
    public WebElement filteredItemName;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-view/div/div/div[2]/invoice-payment-history/mat-card/mat-table/mat-row[1]/mat-cell[3]/p")
    public WebElement filteredRemarks;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-view/div/div/div[2]/invoice-payment-history/mat-card/mat-table/mat-row[1]/mat-cell[4]")
    public WebElement filteredPaymentAmount;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-view/div/div/div[2]/invoice-payment-history/mat-card/mat-table/mat-row[1]/mat-cell[5]")
    public WebElement filteredPaymentDate;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-view/div/div/div[2]/invoice-payment-history/mat-card/mat-table/mat-row[1]/mat-cell[6]/p")
    public WebElement filteredPaidBy;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/invoice-list/mat-card[1]/form/div[1]/mat-form-field/div/div[1]/div[1]/input")
    public WebElement fromDate;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/invoice-list/mat-card[1]/form/div[2]/mat-form-field/div/div[1]/div[1]/input")
    public WebElement toDate;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-add-transaction/mat-dialog-content/div[2]/div/form/div[6]/button[1]")
    public WebElement addBtn;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-view/div/div/div[2]/invoice-payment-history/mat-card/div[2]/div[2]/button[2]")
    public WebElement addTransactionExportBtn;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div/div/snack-bar-container/simple-snack-bar/span")
    public WebElement addedMsg;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-view/div/div/div[2]/invoice-payment-history/mat-card/mat-paginator/div/div/div[1]/mat-form-field/div/div[1]/div/mat-select/div/div[1]/span/span")
    public WebElement numberOfEntries;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-add-transaction/mat-dialog-content/div[2]/div/form/div[4]/div[2]/div")
    public WebElement amtErrorMessage;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-view/div/div/div[2]/invoice-payment-history/mat-card/mat-table/mat-row[1]/mat-cell[1]/a")
    public WebElement externalTransactionLink;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-add-transaction/mat-dialog-content/div[2]/div/h2")
    public WebElement updateTransactionHeader;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-add-transaction/mat-dialog-content/div[2]/div/form/div[6]/button[2]/span[1]")
    public WebElement transactionDeleteButton;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-add-transaction/mat-dialog-content/div[1]/button")
    public WebElement closeIcon;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-view/div/mat-card/div[2]/div[2]/button[2]")
    public WebElement pauseIcon;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-confirmation-dialog/div/div[3]/button[2]/span[1]")
    public WebElement cancelButton;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-confirmation-dialog/div/div[3]/button[1]/span[1]")
    public WebElement stopButton;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div/div/snack-bar-container/simple-snack-bar/span")
    public WebElement stopAlertMessage;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-confirmation-dialog/div/div[2]/div/div")
    public WebElement popupMessage;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-view/div/mat-card/div[2]/div[2]/button[3]/span[1]/mat-icon")
    public WebElement clickDeleteInvoice;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-edit/invoice-view/div/mat-card/div[2]/div[2]/button[3]")
    public WebElement deleteInvoiceIcon;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[5]/mat-form-field/div/div[1]/div/input")
    public WebElement paidAmount;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/app-confirmation-dialog/div/div[3]/button[1]/span[1]")
    public WebElement deleteAlertButton;

}