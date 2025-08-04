package pages.alertsPages;

public class AlertsPagesFactory {

    public AlertsJavaScriptPage createAlertsJavaScriptPage(){
        return new AlertsJavaScriptPage();
    }

    public FakeAlertPage createFakeAlertPage(){
        return new FakeAlertPage();
    }
}
