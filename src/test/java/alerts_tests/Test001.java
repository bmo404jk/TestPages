package alerts_tests;

import org.testng.annotations.Test;
import utils.BaseTest;
import utils.TestData;

public class Test001 extends BaseTest {

    @Test(description = "Проверка разных оповещений на сайте")
    public void test(){
        fabricManager.getAlertsPagesFactory()
                .createAlertsJavaScriptPage()
                .initPage()
                .checkAlertBox()
                .checkConfirmBox(true)
                .checkConfirmBox(false);
    }

    @Test(description = "Проверка prompt box alert",
            dataProvider = "dataForPromptBox",
            dataProviderClass = TestData.class)
    public  void test(String textForPromt){
        fabricManager.getAlertsPagesFactory()
                .createAlertsJavaScriptPage()
                .initPage()
                .checkPromptBox(textForPromt, true)
                .checkPromptBox(textForPromt, false);
    }
}
