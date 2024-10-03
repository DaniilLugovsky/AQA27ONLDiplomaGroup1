package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.Input;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyProfilePage extends BasePage {

    private final By PAGE_LOCATOR = By.xpath("//h3[text() = 'My profile']");
    private final By UPLOAD_AVATAR_BUTTON_LOCATOR = By.xpath("//div[text()='Upload avatar']");
    private final By SAVE_BUTTON_LOCATOR = By.xpath("//*[@data-testid='button-save-entity']");
    private final By IMAGE_AVATAR_LOCATOR = By.xpath("//img[@alt='Avatar']");
    private final By DISPLAY_NAME_FIELD_LOCATOR = By.xpath("//input[@class='inputbox-basecomp']");
    private final By BACK_TO_TESTINY_BUTTON = By.xpath("//*[text()='Back to Testiny']");
    private final By UNSAVED_DATA_POP_UP=By.xpath("//div[@class='sc-eOzmre sc-eauhAA bRIKoh lhDIqG']");

    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return PAGE_LOCATOR;
    }

    public UIElement getImageAvatarLocator() {
        return new UIElement(pageDriver, IMAGE_AVATAR_LOCATOR);
    }

    public UIElement getUnsavedDataPopUp(){
        return new UIElement(pageDriver,UNSAVED_DATA_POP_UP);
    }

    public Button getBackToTestinyButton() {
        return new Button(pageDriver, BACK_TO_TESTINY_BUTTON);
    }

    public Input getDisplayName() {
        return new Input(pageDriver, DISPLAY_NAME_FIELD_LOCATOR);
    }

    public Button getSaveButton() {
        return new Button(pageDriver, SAVE_BUTTON_LOCATOR);
    }

    public void clickSaveButton() {
        getSaveButton().click();
    }

    public void writeDisplayName(String inputValue) {
        getDisplayName().clearAndWrite(inputValue);
    }

    public boolean isAvatarFileDisplayedOnScreen() {
        if (getImageAvatarLocator().isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSaveButtonEnabledOnScreen() {
        if (getSaveButton().isEnabled()) {
            return true;
        } else {
            return false;
        }
    }

    public void clickBackToTestinyButton(){
        getBackToTestinyButton().click();
    }
}
