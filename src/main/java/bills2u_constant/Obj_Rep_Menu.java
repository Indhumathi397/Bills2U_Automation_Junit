package bills2u_constant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Obj_Rep_Menu {

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-toolbar/div/div[1]/div/app-horizontal-menu/div/div[2]/a/span[1]/span")
    public WebElement menuInvoice;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-toolbar/div/div[1]/div/app-horizontal-menu/div/div[2]/div/div/div[1]/a/span[1]/span")
    public WebElement menuInvoiceBatch;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-toolbar/div/div[1]/div/app-horizontal-menu/div/div[4]/a")
    public WebElement menuDashboard;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-toolbar/div/div[1]/div/app-horizontal-menu/div/div[2]/div/div/div[2]/a/span[1]/span")
    public WebElement menuInvoiceListing;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-toolbar/div/div[1]/div/app-horizontal-menu/div/div[1]/a")
    public WebElement menuSetup;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-toolbar/div/div[1]/div/app-horizontal-menu/div/div[1]/div/div/div[1]/a")
    public WebElement menuBoUser;
}
