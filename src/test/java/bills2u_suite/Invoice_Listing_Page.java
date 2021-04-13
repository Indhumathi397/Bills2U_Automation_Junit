package bills2u_suite;

import bills2u_process.Invoice_Listing_Process;

import java.io.IOException;

public class Invoice_Listing_Page extends Invoice_Listing_Process {

    public Invoice_Listing_Page TC_IL_001() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceListing.TC1"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceListMenuProcess();
        clickOnShowFilter();
        checkIncludeDraft();
        logoutProcess();
        return this;
    }

    public Invoice_Listing_Page TC_IL_002() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceListing.TC2"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceListMenuProcess();
        clickOnShowFilter();
        uncheckIncludeDraft();
        logoutProcess();
        return this;
    }

    public Invoice_Listing_Page TC_IL_003() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceListing.TC3"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceListMenuProcess();
        clickOnShowFilter();
        logoutProcess();
        return this;
    }

    public Invoice_Listing_Page TC_IL_004() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceListing.TC4"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceListMenuProcess();
        clickOnShowFilter();
        logoutProcess();
        return this;
    }
    public Invoice_Listing_Page TC_IL_005() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceListing.TC5"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceListMenuProcess();
        clickOnShowFilter();
        selectAllFromBatches();
        logoutProcess();
        return this;
    }

    public Invoice_Listing_Page TC_IL_006() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceListing.TC6"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceListMenuProcess();
        clickOnShowFilter();
        logoutProcess();
        return this;
    }

    public Invoice_Listing_Page TC_IL_007() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceListing.TC7"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceListMenuProcess();
        clickOnShowFilter();
        logoutProcess();
        return this;
    }

    public Invoice_Listing_Page TC_IL_008() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceListing.TC8"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceListMenuProcess();
        clickOnShowFilter();
        logoutProcess();
        return this;
    }

    public Invoice_Listing_Page TC_IL_009() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceListing.TC9"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceListMenuProcess();
        clickOnShowFilter();
        logoutProcess();
        return this;
    }

    public Invoice_Listing_Page TC_IL_010() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceListing.TC10"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceListMenuProcess();
        clickOnShowFilter();
        logoutProcess();
        return this;
    }

    public Invoice_Listing_Page TC_IL_011() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceListing.TC11"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceListMenuProcess();
        clickOnShowFilter();
        logoutProcess();
        return this;
    }

    public Invoice_Listing_Page TC_IL_012() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceListing.TC12"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceListMenuProcess();
        clickOnShowFilter();
        logoutProcess();
        return this;
    }

    public Invoice_Listing_Page TC_IL_013() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceListing.TC13"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceListMenuProcess();
        clickOnShowFilter();
        logoutProcess();
        return this;
    }

    public Invoice_Listing_Page TC_IL_014() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceListing.TC14"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceListMenuProcess();
        clickOnShowFilter();
        logoutProcess();
        return this;
    }

    public Invoice_Listing_Page TC_IL_015() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceListing.TC15"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceListMenuProcess();
        clickOnShowFilter();
        selectAllFromBatches();
        logoutProcess();
        return this;
    }

    public Invoice_Listing_Page TC_IL_016() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceListing.TC16"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceListMenuProcess();
        clickOnShowFilter();
        logoutProcess();
        return this;
    }

    public Invoice_Listing_Page TC_IL_017() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.InvoiceListing.TC17"));
        loginProcess();
        clickOnInvoiceMenuProcess();
        clickOnInvoiceListMenuProcess();
        clickOnShowFilter();
        logoutProcess();
        return this;
    }
}
