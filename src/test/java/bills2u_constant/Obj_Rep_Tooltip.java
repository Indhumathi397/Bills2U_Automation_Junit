package bills2u_constant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Obj_Rep_Tooltip {

    @FindBy(xpath = "cdk-describedby-message-0")
    public WebElement backToTop;
    @FindBy(xpath = "cdk-describedby-message-1")
    public WebElement viewFullscreen;
    @FindBy(xpath = "cdk-describedby-message-2")
    public WebElement Profile;
    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/payment-listing/div/mat-card/div/div/a")
    public WebElement expand;
    @FindBy(xpath="//*[@id=\"cdk-describedby-message-14\"]")
    public WebElement expandTooltip;
    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch/mat-card/mat-card-content/div[1]/div[2]/div[1]/button")
    public WebElement batchUpload;
    @FindBy(id="cdk-describedby-message-15")
    public WebElement batchUploadTooltip;
    @FindBy(id = "cdk-describedby-message-51")
    public WebElement closeTooltipUpdateTransaction;
    @FindBy(id = "cdk-describedby-message-40")
    public WebElement pauseTooltip;
    @FindBy(id = "cdk-describedby-message-44")
    public WebElement transactionTooltip;
    @FindBy(id = "cdk-describedby-message-45")
    public WebElement itemNameTooltip;
    @FindBy(id = "cdk-describedby-message-46")
    public WebElement remarksTooltip;
    @FindBy(id = "cdk-describedby-message-47")
    public WebElement paymentAmountTooltip;
    @FindBy(id = "cdk-describedby-message-48")
    public WebElement paymentDateTooltip;
    @FindBy(id = "cdk-describedby-message-49")
    public WebElement paidByTooltip;
    @FindBy(xpath = "/html/body/div[1]/div[17]")
    public WebElement deleteInvoiceTooltip;
}
