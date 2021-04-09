package bills2u_constant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Obj_Rep_Payments_Payer {

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/payment-listing/mat-sidenav-container/mat-sidenav-content/div/div[1]/h3")
    public WebElement paymentsHeader;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/invoices/mat-sidenav-container/mat-sidenav-content/div[1]/div[2]/a/mat-icon")
    public WebElement filter;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/payment-listing/mat-sidenav-container/mat-sidenav-content/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[1]")
    public WebElement reference;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/payment-listing/mat-sidenav-container/mat-sidenav-content/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[2]")
    public WebElement receipt;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/payment-listing/mat-sidenav-container/mat-sidenav-content/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[3]")
    public WebElement dateAndTime;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/payment-listing/mat-sidenav-container/mat-sidenav-content/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[4]")
    public WebElement amount;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/payment-listing/mat-sidenav-container/mat-sidenav-content/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[5]")
    public WebElement status;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[3]/mat-icon")
    public WebElement upwardArrow;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[2]/span")
    public WebElement footerRights;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/invoices/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/h3")
    public WebElement invoicesHeader;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/invoices/mat-sidenav-container/mat-sidenav-content/div[2]/invoice-list/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[5]/button")
    public WebElement payForSelectedInvoice;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/invoices/mat-sidenav-container/mat-sidenav-content/div[2]/invoice-list/mat-card/mat-card-content/div[1]/div[2]/button")
    public WebElement payForAllInvoice;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/invoices/mat-sidenav-container/mat-sidenav-content/div[2]/invoice-list/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[2]")
    public WebElement invoiceHashClm;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/invoices/mat-sidenav-container/mat-sidenav-content/div[2]/invoice-list/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[3]")
    public WebElement dueAmount;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/invoices/mat-sidenav-container/mat-sidenav-content/div[2]/invoice-list/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[4]")
    public WebElement dueDate;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/invoices/mat-sidenav-container/mat-sidenav-content/div[2]/invoice-list/mat-card/mat-card-content/mat-table/mat-row/mat-cell[4]/span")
    public WebElement statusIcon;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/invoices/mat-sidenav-container/mat-sidenav-content/div[2]/invoice-list/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[3]")
    public WebElement dueAmtValue;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/invoices/mat-sidenav-container/mat-sidenav-content/div[2]/invoice-list/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[4]")
    public WebElement dueDateValue;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/bill-payment/div[1]/div[1]/h3")
    public WebElement confirmPaymentHeader;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/bill-payment/div[1]/div[3]/button/span[1]/mat-icon")
    public WebElement closeIcon;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/invoices/mat-sidenav-container/mat-sidenav-content/div[2]/invoice-list/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[1]/mat-checkbox/label/div")
    public WebElement selectAllCheckBox;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/invoices/mat-sidenav-container/mat-sidenav-content/div[2]/invoice-list/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[1]/mat-checkbox/label/div/input")
    public WebElement checkSelectedSelectAllCheckBox;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/invoices/mat-sidenav-container/mat-sidenav-content/div[2]/invoice-list/mat-card/mat-card-content/div[1]/div[2]/span")
    public WebElement totalOutstandingAmt;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/invoices/mat-sidenav-container/mat-sidenav-content/div[2]/invoice-list/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[2]/a")
    public WebElement respectiveInvoice;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/bill-view/div/div[3]/mat-card/h3")
    public WebElement correspondingInvoice;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/bill-view/div/div[3]/mat-card/div[1]/div[1]/div")
    public WebElement issueDate;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/bill-view/div/div[3]/mat-card/div[1]/div[2]/div[1]")
    public WebElement dueDateId;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/bill-view/div/div[3]/mat-card/div[2]/div[2]/div[1]")
    public WebElement invAmt;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/bill-view/div/div[3]/mat-card/div[2]/div[2]/div[3]")
    public WebElement outAmt;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/bill-view/div/div[4]/mat-card/h3")
    public WebElement makePayment;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/bill-view/div/div[4]/mat-card/button")
    public WebElement payBtn;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/bill-view/div/div[5]/nav/div[2]/div/div/a[1]")
    public WebElement InvoiceLink;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/bill-view/div/div[5]/nav/div[2]/div/div/a[2]")
    public WebElement paymentHistoryLink;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/bill-view/div/div[1]/button/span[1]/span")
    public WebElement backLink;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/bill-view/div/div[3]/mat-card/div[1]/div[2]/div[2]/span[2]")
    public WebElement statusIconId;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/bill-view/div/div[5]/invoice/div/div/table[1]/tr[2]/td[1]/div[2]/img")
    public WebElement merchantLogo;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/bill-view/div/div[5]/invoice/div/div/table[2]")
    public WebElement InvDetailTable;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/bill-view/div/div[5]/invoice/div/div/table[2]/tr/td[2]/table/tr[2]/td[2]")
    public WebElement InvIssueDate;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/bill-view/div/div[5]/invoice/div/div/table[2]/tr/td[2]/table/tr[3]/td[2]")
    public WebElement InvDueDate;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/bill-view/div/div[5]/invoice/div/div/table[2]/tr/td[2]/table/tr[1]/td[2]")
    public WebElement InvNo;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/bill-view/div/div[5]/invoice/div/div/table[2]/tr/td[2]/table/tr[4]/td[2]")
    public WebElement ref1;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/bill-view/div/div[5]/invoice/div/div/table[3]/tr[1]/td[1]")
    public WebElement itemColumn;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/bill-view/div/div[5]/invoice/div/div/table[3]/tr[1]/td[2]")
    public WebElement amountColumn;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/bill-view/div/div[5]/invoice/div/div/table[3]/tr[2]/td[1]/div[1]")
    public WebElement invParticular;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/bill-view/div/div[5]/invoice/div/div/table[4]/tr[1]/td/strong")
    public WebElement noteSection;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/bill-view/div/div[5]/invoice/div/div/table[3]/tr[3]")
    public WebElement total;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/bill-view/div/div[5]/invoice/div/div/table[1]/tr[1]/td/button/span[1]/mat-icon")
    public WebElement printIcon;
}