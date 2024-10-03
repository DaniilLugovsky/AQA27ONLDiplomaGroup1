package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class BaseStep {

    protected WebDriver driver;
    protected LoginPage loginPage;

    public BaseStep(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
    }
}
