package pages;

import baseEntities.BasePage;
import elements.*;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasePage extends BasePage {
    private final By TESTCASE_PAGE_LOCATOR = By.xpath("//h2[@data-testid='text-title']");
    private final By ADD_TESTCASE_BUTTON_LOCATOR = By.xpath("//button[@data-testid='button-add_TC']");
    private final By ADD_TITLE_TESTCASE_INPUT_LOCATOR = By.xpath("//input[@data-testid='textbox-prop-title']");
    private final By ADD_OWNER_TESTCASE_DROPDOWN_LOCATOR = By.xpath("//div[@data-testid = 'selectbox-prop-owner_user_id']//button[@data-testid='button-open' and @title = 'Open dropdown']");
    private final By ADD_TEMPLATE_TESTCASE_DROPDOWN_LOCATOR = By.xpath("//div[@data-testid = 'selectbox-prop-template']//button[@data-testid='button-open' and @title = 'Open dropdown']");
    private final By ADD_PRIORITY_TESTCASE_DROPDOWN_LOCATOR = By.xpath("//div[@data-testid = 'selectbox-prop-priority']//button[@data-testid='button-open' and @title = 'Open dropdown']");
    private final By ADD_TYPE_TESTCASE_DROPDOWN_LOCATOR = By.xpath("//div[@data-testid = 'selectbox-prop-testcase_type']//button[@data-testid='button-open' and @title = 'Open dropdown']");
    private final By ADD_PRECONDITION_TESTCASE_INPUT_LOCATOR = By.xpath("//div[@data-testid = 'section-precondition']//div[@data-testid = 'textbox-edit']");
    private final By ADD_STEPS_TESTCASE_INPUT_LOCATOR = By.xpath("//div[@data-testid = 'section-steps']//div[@data-testid = 'textbox-edit']");
    private final By ADD_EXPECTED_RESULTS_INPUT_LOCATOR = By.xpath("//div[@data-testid = 'section-expected_result']//div[@data-testid = 'textbox-edit']");
    private final By SAVE_TESTCASE_BUTTON_LOCATOR = By.xpath("//button[@data-testid = 'button-save-entity']");
    private final By TESTCASE_MORE_DROPDOWN_LOCATOR = By.xpath(".//button[@title='More…']");
    private final By DELETE_TESTCASE_FOR_DELETE_LOCATOR = By.xpath("//td//span[text() = 'TestCaseForDelete']");
    private final By DELETE_CONFIRMATION_TESTCASE_BUTTON_LOCATOR = By.xpath("//button[@data-testid = 'button-affirm']");
    private final By TABLE_LOCATOR = By.tagName("table");

    public TestCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return TESTCASE_PAGE_LOCATOR;
    }


    public Button getAddTestCasesButton() {
        return new Button(pageDriver, ADD_TESTCASE_BUTTON_LOCATOR);
    }

    public Input getAddTitleInput() {
        return new Input(pageDriver, ADD_TITLE_TESTCASE_INPUT_LOCATOR);
    }

    public DropDown getAddOwnerDropDown() {
        return new DropDown(pageDriver, ADD_OWNER_TESTCASE_DROPDOWN_LOCATOR);
    }

    public DropDown getAddTemplateDropDown() {
        return new DropDown(pageDriver, ADD_TEMPLATE_TESTCASE_DROPDOWN_LOCATOR);
    }

    public DropDown getAddPriorityDropDown() {
        return new DropDown(pageDriver, ADD_PRIORITY_TESTCASE_DROPDOWN_LOCATOR);
    }

    public DropDown getAddTypeDropDown() {
        return new DropDown(pageDriver, ADD_TYPE_TESTCASE_DROPDOWN_LOCATOR);
    }

    public Input getAddPreconditionInput() {
        return new Input(pageDriver, ADD_PRECONDITION_TESTCASE_INPUT_LOCATOR);
    }

    public Input getAddStepsInput() {
        return new Input(pageDriver, ADD_STEPS_TESTCASE_INPUT_LOCATOR);
    }

    public Input getAddExpectedresultsInput() {
        return new Input(pageDriver, ADD_EXPECTED_RESULTS_INPUT_LOCATOR);
    }

    public Button getSaveTestCaseButton() {
        return new Button(pageDriver, SAVE_TESTCASE_BUTTON_LOCATOR);
    }

    public Table getTableElement() {
        return new Table(pageDriver, TABLE_LOCATOR);
    }

    public DropDown getMoreDropDown() {
        getTableElement().getRow(0).click();
        return new DropDown(pageDriver, getTableElement().getCell(0, 7).findElement(TESTCASE_MORE_DROPDOWN_LOCATOR));
    }

    public Button getDeleteTestCaseButton() {
        return new Button(pageDriver, DELETE_CONFIRMATION_TESTCASE_BUTTON_LOCATOR);
    }

    public Button getDeleteTestCaseForDelete() {
        return new Button(pageDriver, DELETE_TESTCASE_FOR_DELETE_LOCATOR);
    }

    public UIElement getTitleCell() {
        return new UIElement(pageDriver, getTableElement().getCell(0, 4));
    }

    public void clickAddTestCaseButton() {
        getAddTestCasesButton().click();
    }

    public void setAddTitleTestCaseInput(String title) {
        getAddTitleInput().write(title);
    }

    public void setAddPreconditionTestCaseInput(String precondition) {
        getAddPreconditionInput().write(precondition);
    }

    public void setAddStepsTestCaseInput(String steps) {
        getAddStepsInput().write(steps);
    }

    public void setAddExpectedResultsInput(String results) {
        getAddExpectedresultsInput().write(results);
    }

    public void clickSaveTestCase() {
        getSaveTestCaseButton().click();
    }

    public void clickDeleteTestCase() {
        getDeleteTestCaseButton().click();
    }

    public void clickDeleteTestCaseForDelete() {
        getDeleteTestCaseForDelete().click();
    }

    public void addTestCase(TestCase testCase) {
        clickAddTestCaseButton();
        setAddTitleTestCaseInput(testCase.getTitle());
        getAddOwnerDropDown().selectByText(testCase.getOwner());
        getAddTemplateDropDown().selectByText(testCase.getTemplate());
        getAddPriorityDropDown().selectByText(testCase.getPriority());
        getAddTypeDropDown().selectByText(testCase.getType());
        setAddPreconditionTestCaseInput(testCase.getPrecondition());
        setAddStepsTestCaseInput(testCase.getSteps());
        setAddExpectedResultsInput(testCase.getExpectedResults());
        clickSaveTestCase();
    }
}
