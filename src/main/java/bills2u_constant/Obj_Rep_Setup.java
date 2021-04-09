package bills2u_constant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Obj_Rep_Setup {

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-breadcrumb/div/div/div/div[2]/span")
    public WebElement merchantHeader;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant/div/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[1]/mat-form-field/div/div[1]/div/input")
    public WebElement businessName;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant/div/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[1]/span")
    public WebElement getBusinessName;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant/div/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[2]/mat-form-field/div/div[1]/div/input")
    public WebElement contactName;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant/div/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[2]/span")
    public WebElement getContactName;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant/div/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[3]/mat-form-field/div/div[1]/div/input")
    public WebElement email;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant/div/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[3]/span")
    public WebElement getEmail;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant/div/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[4]/mat-form-field/div/div[1]/div/input")
    public WebElement phone;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant/div/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[4]/span")
    public WebElement getPhone;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant/div/mat-card/mat-card-content/mat-table/mat-header-row/mat-header-cell[5]/mat-form-field/div/div[1]/div/mat-select")
    public WebElement isActive;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant/div/mat-card/mat-card-content/mat-table/mat-row[1]/mat-cell[5]")
    public WebElement getIsActive;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant/div/mat-card/mat-card-content/div")
    public WebElement noResult;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant/div/mat-card/div/div[3]/button/span[1]/div")
    public WebElement addMerchantBtn;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant-onboard/div/mat-card/div[2]/div/button[1]/span[1]")
    public WebElement contactInfoBtn;

    @FindAll (@FindBy(className = "mat-radio-container"))
    public List<WebElement> contactInfoRadioBtn;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant-onboard/div/div/contact-info/mat-card/div/form/div/div[1]/div/div[3]/div/div")
    public WebElement noteText;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant-onboard/div/div/contact-info/mat-card/div/form/div/div[1]/div/div[2]/mat-form-field/div/div[1]/div/input")
    public WebElement addBusinessName;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant-onboard/div/div/contact-info/mat-card/div/form/div/div[1]/div/div[4]/mat-form-field/div/div[1]/div/input")
    public WebElement addContactName;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant-onboard/div/div/contact-info/mat-card/div/form/div/div[1]/div/div[5]/mat-form-field/div/div[1]/div/input")
    public WebElement addEmail;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant-onboard/div/div/contact-info/mat-card/div/form/div/div[1]/div/div[6]/mat-form-field/div/div[1]/div/input")
    public WebElement addPhone;


    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant-onboard/div/div/contact-info/mat-card/div/form/div/div[1]/div/div[8]/mat-form-field/div/div[1]/div/input")
    public WebElement addCity;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant-onboard/div/div/contact-info/mat-card/div/form/div/div[1]/div/div[9]/mat-form-field/div/div[1]/div/input")
    public WebElement addZipCode;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant-onboard/div/div/contact-info/mat-card/div/form/div/div[1]/div/div[10]/mat-form-field/div/div[1]/div/mat-select")
    public WebElement countrySelect;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/div/div/ngx-mat-select-search/div/input")
    public WebElement addCountry;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant-onboard/div/div/contact-info/mat-card/div/form/div/div[1]/div/div[12]/mat-form-field/div/div[1]/div/textarea")
    public WebElement addAddress;

    @FindBy(name = "input")
    public WebElement logo;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant-onboard/div/div/contact-info/mat-card/div/form/div/div[1]/div/div[7]/mat-form-field/div/div[1]/div/input")
    public WebElement addFax;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant-onboard/div/div/contact-info/mat-card/div/form/div/div[1]/div/div[11]/mat-form-field/div/div[1]/div/input")
    public WebElement addWebsite;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant-onboard/div/div/contact-info/mat-card/div/form/div/div[1]/div/div[13]/mat-form-field/div/div[1]/div/textarea")
    public WebElement addAddress2;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant-onboard/div/div/contact-info/mat-card/div/form/div/div[1]/div/div[14]/mat-form-field/div/div[1]/div/textarea")
    public WebElement addAddress3;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant-onboard/div/div/contact-info/mat-card/div/form/div/div[1]/div/div[15]/mat-checkbox")
    public WebElement checkIsActive;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant-onboard/div/div/contact-info/mat-card/div/form/div/div[1]/div/div[16]/button[1]/span[1]")
    public WebElement saveBtn;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div/div/snack-bar-container/simple-snack-bar/span")
    public WebElement messageBox;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant-onboard/div/mat-card/div[2]/div/button[2]/span[1]")
    public WebElement generalSettingBtn;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant-onboard/div/mat-card/div[2]/div/button[5]/span[1]")
    public WebElement usersBtn;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant-onboard/div/div/general-settings/mat-card/h4")
    public WebElement generalSettingHeader;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/merchant-onboard/div/div/general-settings/mat-card/div/form/div/div/div/div[1]/mat-form-field/div/div[1]/div/mat-select/div/div[1]/span/span")
    public WebElement feedType;

}
