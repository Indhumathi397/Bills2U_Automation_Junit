package bills2u_constant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Obj_Rep_Auth {

    @FindBy(id = "Username")
    public WebElement iptUserName;

    @FindBy(id = "Password")
    public WebElement iptPassword;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div[2]/div[2]/form/fieldset/div[4]/button")
    public WebElement btnAuthLogin;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-toolbar/div/div[3]/app-user-menu/button/span[1]/mat-icon")
    public WebElement txtHome;

}
