package bills2u_constant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Obj_Rep_BatchEntry {

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[1]/form/div[6]/div[2]/div/button[2]")
    public WebElement btnAddInvoice;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/div/mat-card/table/tr/td[1]/h2")
    public WebElement txtNewAddInvoice;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td/div/div/table[2]/tr[2]/td[1]/form/table/tr[1]/td/div/input")
    public WebElement iptPayerName;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td/div/div/table[2]/tr[2]/td[1]/form/table/tr[2]/td[1]/div/input")
    public WebElement iptEmail;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td/div/div/table[2]/tr[2]/td[1]/form/table/tr[3]/td/div/input")
    public WebElement iptAddress;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td/div/div/table[2]/tr[2]/td[1]/form/table/tr[4]/td[1]/div/input")
    public WebElement iptCity;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td/div/div/table[2]/tr[2]/td[1]/form/table/tr[5]/td[1]/div/input")
    public WebElement iptState;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td/div/div/table[2]/tr[2]/td[1]/form/table/tr[6]/td[1]/div/input")
    public WebElement iptCountry;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td/div/div/table[2]/tr[2]/td[1]/form/table/tr[2]/td[2]/div/input")
    public WebElement iptPhoneNo;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td/div/div/table[2]/tr[2]/td[1]/form/table/tr[4]/td[2]/div/input")
    public WebElement iptPostalCode;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td/div/div/table[2]/tr[2]/td[2]/form/table/tr[1]/td[2]/input")
    public WebElement iptInvoiceNumber;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td/div/div/table[2]/tr[2]/td[2]/form/table/tr[2]/td[2]/mat-form-field/div/div[1]/div[1]/input")
    public WebElement iptIssueDate;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td/div/div/table[2]/tr[2]/td[2]/form/table/tr[3]/td[2]/mat-form-field/div/div[1]/div[1]/input")
    public WebElement iptDueDate;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td/div/div/table[2]/tr[2]/td[2]/form/table/tr[4]/td[2]/input")
    public WebElement iptRef1;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td/div/div/table[2]/tr[2]/td[2]/form/table/tr[5]/td[2]/input")
    public WebElement iptRef2;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td/div/div/table[3]/tr/td/table/tr[3]/td[1]/input")
    public WebElement iptItem;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td/div/div/table[3]/tr/td/table/tr[3]/td[2]/input")
    public WebElement iptDescription;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td/div/div/table[3]/tr/td/table/tr[3]/td[3]/input")
    public WebElement iptQuantity;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td/div/div/table[3]/tr/td/table/tr[3]/td[4]/input")
    public WebElement iptUnitPrice;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td/div/div/table[3]/tr/td/table/tr[3]/td[5]/input")
    public WebElement iptTotalTax;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td/div/div/table[3]/tr/td/table/tr[3]/td[6]/input")
    public WebElement iptAmount;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td/div/div/table[3]/tr/td/table/tr[3]/td[7]/button[1]/span[1]/mat-icon")
    public WebElement btnSaveItem;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/div/mat-card/table/tr/td[2]/button[1]/span[1]/mat-icon")
    public WebElement btnSaveNewBatch;

    @FindBy(xpath = "/html/body/app-root/div/app-layout/mat-sidenav-container/mat-sidenav-content/div[1]/app-invoice-batch-form/div/div[2]/mat-card/div[2]/invoice-list-view/div/mat-table/mat-row/mat-cell[1]/a")
    public WebElement txtVerifyNewInvoiceBatch;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td/div/div/table[3]/tr/td/table/tr[3]/td[7]/button[2]/span[1]/mat-icon")
    public WebElement btnDeleteItem;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td/div/div/table[3]/tr/td/table/tr[3]/td/a")
    public WebElement btnAddItem;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td/div/div/table[1]/tr[1]/td/button/span[1]/mat-icon")
    public WebElement filterSvgIcon;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td[1]/table/tr[2]/td/div/div/section/mat-checkbox[1]/label/span")
    public WebElement chkBoxDescription;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td[1]/table/tr[2]/td/div/div/section/mat-checkbox[2]/label/span")
    public WebElement chkBoxUnitPrice;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td[2]/div/div/table[3]/tr/td/table/tr[3]/td[3]/input")
    public WebElement filterUnitAmount;

@FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td[2]/div/div/table[3]/tr/td/table/tr[3]/td[4]/input")
public WebElement getFilterDescriptionTotalTax;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td[2]/div/div/table[3]/tr/td/table/tr[3]/td[5]/input")
    public WebElement filterDescriptionAmount;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td[2]/div/div/table[3]/tr/td/table/tr[3]/td[4]/button[1]/span[1]/mat-icon")
    public WebElement filterUnitSaveItem;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/table/tr/td[2]/div/div/table[3]/tr/td/table/tr[3]/td[6]/button[1]/span[1]/mat-icon")
    public WebElement filterDescriptionSaveItem;

    @FindBy(xpath = "/html/body/app-root/div/div[2]/div[2]/div/mat-dialog-container/invoice-entry/div/div/mat-card/table/tr/td[2]/button[2]/span[1]/mat-icon")
    public WebElement newBatchInvoiceCloseIcon;
}
