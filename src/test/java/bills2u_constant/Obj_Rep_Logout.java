package bills2u_constant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Obj_Rep_Logout {

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-toolbar/div/div[3]/app-user-menu/button/span[1]/mat-icon")
    public WebElement personIcon;

    @FindBy(linkText = "Log Out")
    public WebElement logOut;
    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-toolbar/div/div[3]/app-user-menu/button/span[1]/mat-icon")
    public WebElement iconProfile;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/div/div/a[3]")
    public WebElement btnLogout;
}
