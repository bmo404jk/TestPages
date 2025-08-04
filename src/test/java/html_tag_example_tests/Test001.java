package html_tag_example_tests;

import org.testng.annotations.Test;
import utils.BaseTest;

public class Test001 extends BaseTest {

    @Test(description = "Проверка соответствия данных из таблицы")
    public void test() {
        fabricManager.getHtmlPageFactory()
                .createTableTestPage()
                .initPage()
                .checkTable();
    }
}
