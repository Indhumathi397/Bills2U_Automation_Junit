package bills2u_constant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Obj_Rep_Invoices_Payer {

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/invoices/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/h3")
    public WebElement invoicesHeader;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/invoices/mat-sidenav-container/mat-sidenav-content/div[2]/invoice-list/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell/div/div[2]/button/span[1]")
    public WebElement payButtonForSelectedItem;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/invoices/mat-sidenav-container/mat-sidenav-content/div[2]/invoice-list/mat-card/mat-card-content/div[2]/button")
    public WebElement payButtonForSingleInvoice;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/invoices/mat-sidenav-container/mat-sidenav-content/div[2]/invoice-list/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[2]")
    public WebElement invoiceHashColumn;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/invoices/mat-sidenav-container/mat-sidenav-content/div[2]/invoice-list/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[3]")
    public WebElement dueAmountColumn;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/invoices/mat-sidenav-container/mat-sidenav-content/div[2]/invoice-list/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[4]")
    public WebElement dueDateColumn;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/invoices/mat-sidenav-container/mat-sidenav-content/div[2]/invoice-list/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell/div/div[1]/div[1]/span")
    public WebElement statusIcon;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/invoices/mat-sidenav-container/mat-sidenav-content/div[1]/div[2]/a/mat-icon")
    public WebElement filterIcon;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[2]/span")
    public WebElement footer;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[3]/mat-icon")
    public WebElement backToTop;
}
