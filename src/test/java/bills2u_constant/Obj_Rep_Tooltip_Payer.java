package bills2u_constant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Obj_Rep_Tooltip_Payer {

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/div[1]/payment-listing/mat-sidenav-container/mat-sidenav-content/div/div[2]/a/mat-icon")
    public WebElement filter;

    @FindBy(xpath = "//*[@id=\"cdk-describedby-message-10\"]")
    public WebElement filterTooltip;
}
