package bills2u_constant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Obj_Rep_Home_Payer {

    @FindBy(xpath = "/html/body/app-root/div/app-landing/div[1]/div/div[2]/div/button/span[1]")
    public WebElement payerLoginNowButton;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/mat-toolbar/div/div[1]/div[2]/app-horizontal-menu/div/div[1]/a/span[1]/span")
    public WebElement invoicesMenu;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/mat-toolbar/div/div[1]/div[2]/app-horizontal-menu/div/div[2]/a/span[1]/span")
    public WebElement myDirectDebitMenu;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/mat-toolbar/div/div[1]/div[2]/app-horizontal-menu/div/div[3]/a/span[1]/span")
    public WebElement paymentsMenu;



}
