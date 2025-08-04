package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;
import pages.fabricManager.FabricManager;

public class BaseTest {

    protected FabricManager fabricManager = new FabricManager();

    @BeforeSuite
    public static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }

    @BeforeTest
    public void initTests() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "900x900";
        Configuration.baseUrl = "https://testpages.eviltester.com/styled/";
    }
}