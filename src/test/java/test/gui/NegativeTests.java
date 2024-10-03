package test.gui;

import baseEntities.BaseGuiTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests extends BaseGuiTest {

    @Description("Тест на проверку всплывающего сообщения при невалидном логине")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "Тест на проверку всплывающего сообщения при невалидном логине", description = "Тест на проверку всплывающего сообщения при невалидном логине")
    public void popUpMessageTest() {
        userStep.invalidLogin();

        Assert.assertTrue(loginPage.isPopUpMessageWindowDisplayed());
        Assert.assertEquals(loginPage.textInvalidPopUpMessageWindow(),
                "Either your email address or your password is wrong. Please try again or recover your password.\n" +
                        "Create a new user, if you are not registered yet.");
    }

    @Description("Тест на ввод данных превышающих допустимые")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "Тест на ввод данных превышающих допустимые", description = "Тест на ввод данных превышающих допустимые")
    public void dataExceedsTheLimitTest() {
        userStep.successfulLogin();
        dashboardPage.chooseSettingsDropDown();
        myProfilePage.writeDisplayName(new String(new char[1000]).replace('\0', '1'));
        myProfilePage.clickSaveButton();
        myProfilePage.clickBackToTestinyButton();

        Assert.assertEquals(myProfilePage.getUnsavedDataPopUp().getText(), "Unsaved data\n" +
                "your settings has unsaved data but is not valid and therefore cannot be saved. Do you want to discard the changes?\n" +
                "Discard\n" +
                "Cancel");

    }

    @Description("Тест воспроизводящий любой дефект для формирования скриншота в allure report")
    @Severity(SeverityLevel.MINOR)
    @Test(testName = "Тест воспроизводящий любой дефект", description = "Тест воспроизводящий любой дефект")
    public void invalidTest() {
        userStep.invalidLogin();

        Assert.assertFalse(loginPage.isPopUpMessageWindowDisplayed());
    }
}
