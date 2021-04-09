package bills2u_suite;
import bills2u_process.Dashboard_Process;
import java.io.IOException;

public class Dashboard_Page extends Dashboard_Process {

    public Dashboard_Page TC_Dash_001() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.Dashboard.TC1"));
        loginProcess();
        ClickDashboardMenu();
        DashFromDate();
        DashToDate();
        VerifyInvoiceCount();
        VerifyOutStandingAmount();
        VerifyInvoiceAgingTrend();
        VerifyPaymentTrend();
        logoutProcess();
        return this;
    }

    public Dashboard_Page TC_Dash_002() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.Dashboard.TC2"));
        loginProcess();
        ClickDashboardMenu();
        ClickBatchNameSelect();
        EnterBatchNameInSearch();
        SelectBatchName();
        VerifyUpdatedData();
        logoutProcess();
        return this;
    }
    public Dashboard_Page TC_Dash_003() throws IOException {
        getTestData();
        test=report.createTest(prop.getProperty("Bills2U.Dashboard.TC3"));
        loginProcess();
        ClickDashboardMenu();
        TxtPTrendReceiveToDate();
        TxtPTrendOverDueToAmt();
        TxtPTrendTotalCollected();
        TxtPTrendReceiveFromDate();
        TxtPTrendOverDueFromAmt();
        logoutProcess();
        return this;
    }
}
