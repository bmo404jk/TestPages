package utils;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "dataForDynamicTableTest")
    public Object[][] provideDynamicTableData() {
       return new  Object[][]{
            {"[{\"name\" : \"Tom\", \"age\" : 34}, {\"name\": \"Bob\", \"age\" : 21}]"},
            {"[{\"name\" : \"Tom\", \"age\" : 34}]"},
            {"[{\"name\" : \"Tom\", \"age\" : 34}, {\"name\": \"Bob\", \"age\" : 21}, {\"name\": \"Grace\", \"age\" : 51}]"}
        };
    }

    @DataProvider(name = "dataForPromptBox")
    public Object[][] providePromptBox() {
        return new  Object[][]{
                {"!@#$%^&*()_+|\"?>:~"},
                {"TextTextText"},
                {"Q"},
                {"A".repeat(40)},
        };
    }
}
