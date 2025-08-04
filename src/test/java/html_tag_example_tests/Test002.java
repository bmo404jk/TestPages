package html_tag_example_tests;

import org.testng.annotations.Test;
import utils.BaseTest;
import utils.TestData;

public class Test002 extends BaseTest {

    @Test(description = "Тест динамической таблицы",
            dataProvider = "dataForDynamicTableTest",
            dataProviderClass = TestData.class)
    public void test(String tableData) {
        fabricManager.getHtmlPageFactory()
                .createDynamicTablePage()
                .initPage()
                .fillTableData(tableData)
                .checkFillTable(tableData);
    }
}
