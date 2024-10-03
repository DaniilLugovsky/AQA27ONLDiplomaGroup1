package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.Input;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By EMAIL_INPUT_LOCATOR = By.id(":r0:");
    private final By PASSWORD_INPUT_LOCATOR = By.id(":r2:");
    private final By LOGIN_BUTTON_LOCATOR = By.xpath("//button[@data-testid = 'button-login']");
    private final By POP_UP_WINDOW_LOCATOR = By.xpath("//div[@data-testid='text-login-error:login-error-invalid']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return LOGIN_BUTTON_LOCATOR;
    }

    public UIElement getPpoUpWindowLocator() {
        return new UIElement(pageDriver, POP_UP_WINDOW_LOCATOR);
    }

    public Input getEmailInput() {
        return new Input(pageDriver, EMAIL_INPUT_LOCATOR);
    }

    public Input getPasswordInput() {
        return new Input(pageDriver, PASSWORD_INPUT_LOCATOR);
    }

    public Button getLoginButton() {
        return new Button(pageDriver, LOGIN_BUTTON_LOCATOR);
    }

    public void setEmailValue(String value) {
        getEmailInput().write(value);
    }

    public void setPasswordValue(String value) {
        getPasswordInput().write(value);
    }

    public void clickLogin() {
        getLoginButton().click();
    }

    public boolean isPopUpMessageWindowDisplayed() {
        if (getPpoUpWindowLocator().isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public String textInvalidPopUpMessageWindow() {
        return getPpoUpWindowLocator().getText();
    }
}
