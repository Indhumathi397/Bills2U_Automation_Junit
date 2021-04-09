package bills2u_constant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Obj_Rep_Logout_Payer {

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/mat-toolbar/div/div[2]/app-user-menu/a")
    public WebElement loggedUsername;

    @FindBy(linkText = "Log Out")
    public WebElement logOut;

}
