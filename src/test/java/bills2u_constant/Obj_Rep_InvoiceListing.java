package bills2u_constant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Obj_Rep_InvoiceListing {

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-breadcrumb/div/div/div/div[2]/span")
    public WebElement verifyInvoiceListingPage;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/invoice-list/mat-card[1]/div/div/a/span")
    public WebElement clickShowFilter;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/invoice-list/mat-card[1]/form/div[6]/mat-form-field/div/div[1]/div/input")
    public WebElement iptInvoiceNumber;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/invoice-list/mat-card[1]/form/div[10]/button")
    public WebElement btnSearchListing;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/invoice-list/mat-card[2]/mat-card-content/mat-table/mat-row/mat-cell[1]/a")
    public WebElement rowInvoiceNumber;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/invoice-view/div/mat-card/div[1]/h2")
    public WebElement verifyInvoiceNumber;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/invoice-view/div/mat-card/div[2]/div[1]/a[3]")
    public WebElement btnNotificationHistory;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/invoice-view/div/div/div[2]/invoice-notification-history/mat-card/h3")
    public WebElement txtNotificationHistoryVerify;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/invoice-view/div/div/div[2]/invoice-notification-history/mat-card/mat-table/mat-header-row/mat-header-cell[1]/mat-form-field/div/div[1]/div/input")
    public WebElement clmFilterDispatchDate;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/invoice-view/div/div/div[2]/invoice-notification-history/mat-card/mat-table/mat-header-row/mat-header-cell[2]/mat-form-field/div/div[1]/div/input")
    public WebElement clmFilterEmail;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/invoice-view/div/div/div[2]/invoice-notification-history/mat-card/mat-table/mat-header-row/mat-header-cell[3]/mat-form-field/div/div[1]/div/input")
    public WebElement clmFilterStatus;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/invoice-view/div/div/div[2]/invoice-notification-history/mat-card/mat-table/mat-header-row/mat-header-cell[4]/mat-form-field/div/div[1]/div/input")
    public WebElement clmFilterType;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/invoice-view/div/div/div[2]/invoice-notification-history/mat-card/mat-table/mat-header-row/mat-header-cell[5]/div/div[1]")
    public WebElement clmFilterError;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/invoice-view/div/div/div[2]/invoice-notification-history/mat-card/mat-table/mat-row/mat-cell[1]")
    public WebElement rowFilterDispatchDate;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/invoice-view/div/div/div[2]/invoice-notification-history/mat-card/mat-table/mat-row/mat-cell[2]/p")
    public WebElement rowFilterEmail;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/invoice-view/div/div/div[2]/invoice-notification-history/mat-card/mat-table/mat-row/mat-cell[3]")
    public WebElement rowFilterStatus;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/invoice-view/div/div/div[2]/invoice-notification-history/mat-card/mat-table/mat-row/mat-cell[4]")
    public WebElement rowFilterType;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/invoice-view/div/div/div[2]/invoice-notification-history/mat-card/div[2]")
    public WebElement noResult;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/invoice-view/div/div/div[2]/invoice-notification-history/mat-card/div[1]/mat-form-field/div/div[1]/div[1]/input")
    public WebElement findFilter;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/invoice-view/div/div/div[2]/invoice-notification-history/mat-card/div[1]/button")
    public WebElement exportButton;
}
