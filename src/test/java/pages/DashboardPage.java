package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.DropDown;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {

    private final By DASHBOARD_PAGE_LOCATOR = By.xpath("//h1[@data-testid = 'text-dashboard-header-content']");
    private final By TEST_CASES_BUTTON_LOCATOR = By.xpath("//li[@data-testid = 'item-testcases']");
    private final By USER_SETTINGS_DROPDOWN_LOCATOR = By.xpath("//button[@data-testid = 'button-account']");
    private final By FEEDBACK_BUTTON_LOCATOR = By.xpath("//button[@data-testid = 'button-feedback']");
    private final By FEEDBACK_DIALOG_WINDOW_LOCATOR = By.xpath("//div[@data-testid='section-modal-dialog:dialog']");
    private final By NAME_CONTAINER_LOCATOR=By.xpath("//span[@class='shown-name-container']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return DASHBOARD_PAGE_LOCATOR;
    }

    public WebElement getFeedbackDialogWindow() {
        return new UIElement(pageDriver, FEEDBACK_DIALOG_WINDOW_LOCATOR);
    }

    public Button getFeedbackButton() {
        return new Button(pageDriver, FEEDBACK_BUTTON_LOCATOR);
    }

    public Button getTestCasesButton() {
        return new Button(pageDriver, TEST_CASES_BUTTON_LOCATOR);
    }

    public DropDown getUserDropDown() {
        return new DropDown(pageDriver, USER_SETTINGS_DROPDOWN_LOCATOR);
    }

    public void clickTestCasesButton() {
        getTestCasesButton().click();
    }

    public void clickFeedbackButton() {
        getFeedbackButton().click();
    }

    public void chooseSettingsDropDown() {
        getUserDropDown().selectByText("Settings");
    }

    public boolean isFeedbackDialogWindowDisplayed() {
        if (getFeedbackDialogWindow().isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
}
