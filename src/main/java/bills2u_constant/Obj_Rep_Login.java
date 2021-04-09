package bills2u_constant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Obj_Rep_Login {
    @FindBy(id="Username")
    public WebElement username;

    @FindBy(id="Password")
    public WebElement password;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div[2]/div[2]/form/fieldset/div[4]/button")
    public WebElement loginButton;
}
