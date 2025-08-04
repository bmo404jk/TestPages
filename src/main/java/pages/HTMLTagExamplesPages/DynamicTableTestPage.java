package pages.HTMLTagExamplesPages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import custom_annotations.CustomAnnotation.*;
import org.testng.Assert;
import pages.interfaces.Pages;

import static com.codeborne.selenide.Selenide.$x;

public class DynamicTableTestPage implements Pages <DynamicTableTestPage> {

    String name;
    String age;

    private final SelenideElement
            tableDataButton = $x("//summary"),
            textareaInput = $x("//textarea"),
            buttonRefreshTable = $x("//button");

    @Override
    public DynamicTableTestPage initPage() {
        Selenide.open("tag/dynamic-table.html");
        return this;
    }

    @MyStep("Заполняет данными поле для таблицы." +
            "Данные берутся из класса [TestData] -> [name = 'dataForDynamicTableTest]'")
    public DynamicTableTestPage fillTableData(String tableDataToFillInTable) {
        tableDataButton.click();
        textareaInput.click();
        textareaInput.clear();
        textareaInput.append(tableDataToFillInTable);
        buttonRefreshTable.click();
        return this;
    }

    @MyStep("Проверяет заполнение таблицы" +
            "данными, которы были взяты из класса [TestData] -> [name = 'dataForDynamicTableTest]'")
    public void checkFillTable(String tableData) {
        int i = 2;
        while($x("//table/tr[" + i + "]").exists()) {
            name = $x("//table/tr[" + i + "]/td[1]").getText();
            age = $x("//table/tr[" + i + "]/td[2]").getText();
            i++;
            if(!(tableData.contains(name) && tableData.contains(age))) {
                Assert.fail("ОШИБКА - [Не найдена запись в таблице: имя ='" + name + "', возраст ='" + age + "']");
            }
        }
    }
}
