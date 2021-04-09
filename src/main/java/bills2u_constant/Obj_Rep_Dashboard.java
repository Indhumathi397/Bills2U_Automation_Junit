package bills2u_constant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Obj_Rep_Dashboard {

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-breadcrumb/div/div/div/div/span")
    public WebElement txtDashBoard;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-dashboard/div/div[1]/mat-card/form/mat-form-field[1]/div/div[1]/div[1]/input")
    public WebElement dashFromDate;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-dashboard/div/div[1]/mat-card/form/mat-form-field[2]/div/div[1]/div[1]/input")
    public WebElement dashToDate;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-dashboard/div/div[2]/div[1]/app-invoice-count/mat-card/div[2]/div/div[2]/div[1]/div[2]/span")
    public WebElement dInvoiceCountPaid;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-dashboard/div/div[2]/div[1]/app-invoice-count/mat-card/div[2]/div/div[2]/div[2]/div[2]/span")
    public WebElement dInvoiceCountUnPaid;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-dashboard/div/div[2]/div[1]/app-invoice-count/mat-card/div[2]/div/div[2]/div[3]/div[2]/span")
    public WebElement dInvoiceCountOverDue;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-dashboard/div/div[2]/div[2]/app-outstanding-amount/mat-card/div[2]/div/div[2]/div[1]/div[2]/span[2]")
    public WebElement dOutstandAmtPaid;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-dashboard/div/div[2]/div[2]/app-outstanding-amount/mat-card/div[2]/div/div[2]/div[2]/div[2]/span[2]")
    public WebElement dOutstandAmtUnPaid;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-dashboard/div/div[2]/div[2]/app-outstanding-amount/mat-card/div[2]/div/div[2]/div[3]/div[2]/span[2]")
    public WebElement dOutstandAmtOverDue;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-dashboard/div/div[3]/app-aging-trend/mat-card/div[2]/div/table/tr[2]/td[3]/span[2]")
    public WebElement dAgeTrendVerify;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-dashboard/div/div[4]/app-payment-trend/mat-card/div[2]/div/div[2]/div[1]/div[2]/span[2]")
    public WebElement dPayTrendReceivableAsOfFrom;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-dashboard/div/div[4]/app-payment-trend/mat-card/div[2]/div/div[2]/div[2]/div[2]/span[2]")
    public WebElement dPayTrendOverDueAsOfFrom;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-dashboard/div/div[4]/app-payment-trend/mat-card/div[2]/div/div[2]/div[3]/div[2]/span[2]")
    public WebElement dPayTrendTotalCollectedBtw;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-dashboard/div/div[4]/app-payment-trend/mat-card/div[2]/div/div[2]/div[4]/div[2]/span[2]")
    public WebElement dPayTrendReceivableAsOfTo;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-dashboard/div/div[4]/app-payment-trend/mat-card/div[2]/div/div[2]/div[5]/div[2]/span[2]")
    public WebElement dPayTrendOverDueAsOfTo;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-dashboard/div/div[4]/app-payment-trend/mat-card/div[2]/div/div[2]/div[1]/div[1]")
    public WebElement dPayTrendReceivableAsOfFromDate;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-dashboard/div/div[4]/app-payment-trend/mat-card/div[2]/div/div[2]/div[2]/div[1]")
    public WebElement dPayTrendOverDueAsOfFromDate;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-dashboard/div/div[4]/app-payment-trend/mat-card/div[2]/div/div[2]/div[3]/div[1]")
    public WebElement dPayTrendTotalCollectedBtwDate;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-dashboard/div/div[4]/app-payment-trend/mat-card/div[2]/div/div[2]/div[4]/div[1]")
    public WebElement dPayTrendReceivableAsOfToDate;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-dashboard/div/div[4]/app-payment-trend/mat-card/div[2]/div/div[2]/div[5]/div[1]")
    public WebElement dPayTrendOverDueAsOfToDate;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-dashboard/div/div[1]/mat-card/form/mat-form-field[3]/div/div[1]/div/mat-select")
    public WebElement dBatchSelect;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/div/div/ngx-mat-select-search/div/input")
    public WebElement dBatchSearchFilter;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/div/div/ngx-mat-select-search/div/button/span[1]/mat-icon")
    public WebElement dBatchSearchFilterClose;
}
