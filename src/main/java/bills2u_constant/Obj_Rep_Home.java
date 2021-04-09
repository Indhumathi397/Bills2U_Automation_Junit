package bills2u_constant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class Obj_Rep_Home {

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-landing/div[1]/div/div[2]/div/button/span[1]")
    public WebElement loginNowButton;

    @FindBy(xpath = "//*[@id=\"main-content\"]/app-breadcrumb/div/div/mat-card/a/span")
    public WebElement homeText;

    @FindBy(xpath = "//*[@id=\"main-content\"]/app-breadcrumb/div/div/mat-card/div/span")
    public WebElement boUserText;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-toolbar/div/div[1]/div/app-horizontal-menu/div/div[1]/a/span[1]/span")
    public WebElement setupMenu;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-toolbar/div/div[1]/div/app-horizontal-menu/div/div[2]/a/span[1]/span")
    public WebElement invoiceMenu;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-toolbar/div/div[1]/div/app-horizontal-menu/div/div[2]/div/div/div[1]/a/span[1]/span")
    public WebElement invoiceBatchMenu;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-toolbar/div/div[1]/div/app-horizontal-menu/div/div[2]/div/div/div[2]/a/span[1]/span")
    public WebElement invoiceListMenu;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-toolbar/div/div[1]/div/app-horizontal-menu/div/div[2]/div/div/div[3]/a/span[1]/span")
    public WebElement paymentsMenu;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-toolbar/div/div[1]/div/app-horizontal-menu/div/div[1]/div/div/div[2]/a/span[1]/span")
    public WebElement merchantMenu;

}
