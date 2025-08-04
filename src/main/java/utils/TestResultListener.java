package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;

public class TestResultListener implements ITestListener {

    private int success = 0;
    private int failure = 0;
    private int skipped = 0;
    String resultErrorMessege;

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Запуск теста: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        success++;
    }

    @Override
    public void onTestFailure(ITestResult result){
        resultErrorMessege = "ОШИБКА В ТЕСТЕ [" +  result.getName() + "]" +
                " | Причина падения: " + "{" + result.getThrowable() + "}";
        failure++;
    }

    @Override
    public void onTestSkipped(ITestResult result){
        skipped++;
    }

    @AfterTest
    public void finish(ITestContext context) {
        showResults();
    }

    public void showResults() {
        System.out.println("\n=== РЕЗУЛЬТАТЫ ТЕСТОВ ===");
        System.out.printf("Успешные: %d\n" +
                "Проваленные: %d | Причина падения: " + resultErrorMessege +
                "\nПропущенные: %d\n", success, failure, skipped);
    }
}
