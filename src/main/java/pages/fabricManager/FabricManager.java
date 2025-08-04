package pages.fabricManager;

import pages.HTMLTagExamplesPages.HTMLTagExamplesPageFactory;
import pages.alertsPages.AlertsPagesFactory;

public class FabricManager {
    public HTMLTagExamplesPageFactory getHtmlPageFactory() {
        return new HTMLTagExamplesPageFactory();
    }

    public AlertsPagesFactory getAlertsPagesFactory() {
        return new AlertsPagesFactory();
    }
}
