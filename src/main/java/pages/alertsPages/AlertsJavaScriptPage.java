package pages.alertsPages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import custom_annotations.CustomAnnotation.MyStep;
import org.testng.Assert;
import pages.interfaces.Pages;

import static com.codeborne.selenide.Selenide.*;

public class AlertsJavaScriptPage implements Pages <AlertsJavaScriptPage> {

    private final SelenideElement
            alertBoxButton = $x("(//input)[1]"),
            confirmBoxButton = $x("(//input)[2]"),
            promptBoxButton = $x("(//input)[3]"),

            messageAlertBox = $x("(//div[@class='centered']/p[2])[1]"),
            messageConfirmBox = $x("(//div[@class='centered']/p[2])[2]"),
            messagePromptBox = $x("(//div[@class='centered']/p[2])[3]/span");


    @Override
    public AlertsJavaScriptPage initPage() {
        Selenide.open("alerts/alert-test.html");
        return this;
    }

    @MyStep("Метод, который проверяет обычное alert - оповещение")
    public AlertsJavaScriptPage checkAlertBox() {
        alertBoxButton.click();
        String textAlertBox = Selenide.switchTo().alert().getText();
        Assert.assertEquals(textAlertBox, "I am an alert box!");
        confirm();

        Assert.assertEquals(messageAlertBox.getText(), "You triggered and handled the alert dialog");
        return this;
    }

    @MyStep("Метод проверяет confirm - alert [отмену и принятие]")
    public AlertsJavaScriptPage checkConfirmBox(boolean confirmOrDismiss) {
        confirmBoxButton.click();
        String textAlertBox = Selenide.switchTo().alert().getText();
        Assert.assertEquals(textAlertBox,"I am a confirm alert");

        if(confirmOrDismiss) {
            confirm();
            Assert.assertEquals(messageConfirmBox.getText(),"You clicked OK, confirm returned true.");
        } else {
            dismiss();
            Assert.assertEquals(messageConfirmBox.getText(),"You clicked Cancel, confirm returned false.");
        }
        return this;
    }

    @MyStep("Метод проверяет prompt - alert [отмену и принятие], ввод нескольких варинатов текста" +
            "Данные берутся из класса [TestData] -> [name = 'dataForPromptBox]'")
    public AlertsJavaScriptPage checkPromptBox(String textForPromt, boolean confirmOrDismiss) {
        promptBoxButton.click();

        if(confirmOrDismiss) {
            prompt(textForPromt);
            Assert.assertEquals(messagePromptBox.getText(), textForPromt);
        } else {
            dismiss();
            Assert.assertEquals($x("(//div[@class='centered']/p[2])[3]").getText(),
                    "You clicked Cancel. 'prompt' returned null");
        }
        return this;
    }
}
