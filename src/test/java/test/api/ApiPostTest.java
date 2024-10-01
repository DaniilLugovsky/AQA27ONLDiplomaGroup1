package test.api;

import baseEntities.BaseApiTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;


public class ApiPostTest extends BaseApiTest {

    @Description("API Post Тест на проверку создания проекта")
    @Severity(SeverityLevel.CRITICAL)
    @Test(testName = "API Post проверка создания проекта", description = "API Post Тест на проверку создания проекта" )
    public void addProjectTest() {
        Project expectedProject = new Project();
        expectedProject.setName("API new project");
        expectedProject.setProjectKey("KEY");
        expectedProject.setDescription("API description");

        actualProject = projectService.addProject(expectedProject);
        Assert.assertEquals(actualProject, expectedProject);
    }

    @Description("API Post Тест на проверку создания проекта с некоректным количеством символов в имени")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "API Post проверка создания проекта с некоректным количеством символов в имени",
            description = "Тест на проверку создания проекта с некоректным количеством символов в имени")
    public void addInvalidNameProject() {
        Project expectedProject = new Project();
        expectedProject.setName("AP");
        Response invalidNameProject = projectService.addInvalidNameProject(expectedProject);
        invalidNameProject
                .then()
                .assertThat()
                .statusCode(400)
                .body("code", is("API_INVALID_INPUT_DATA"))
                .body("message", is("Input data was rejected:" +
                        " Validation errors: An instance of Project has failed the validation:" +
                        "\n - property name has failed the following constraints:" +
                        " Trimmed name must be longer than or equal to 3 characters" +
                        " \n\nAn instance of Project has failed the validation:" +
                        "\n - property description has failed the following constraints: description must be a string \n"));

        System.out.println("Статус код = " + invalidNameProject.getStatusCode());
    }
}
