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


public class ApiGetTests extends BaseApiTest {

    @Description("API GET Тест на проверку имеющихся проектов")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "API GET проверка имеющихся проектов", description = "Тест на проверку имеющихся проектов")
    public void getAllProjects() {
        Response response = projectService.getProjects();

        System.out.println("Статус код = " + response.getStatusCode());
    }

    @Description("API GET проверка проекта по id")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "API GET проверка проекта по id", description = "API GET проверка проекта по id")
    public void getSingleProject() {
        int projectID = 177;
        Project project = projectService.getProject(projectID);

        Assert.assertEquals(project.getName(), "project for review");
    }

    @Description("API GET проверка несуществующего проекта")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "API GET проверка несуществующего проекта", description = "API GET проверка несуществующего проекта")
    public void getInvalidProjectTest() {
        int nonExistentID = 1000;
        Response response = projectService.getInvalidProject(nonExistentID);
        response
                .then()
                .assertThat()
                .statusCode(404)
                .body("type", is("ApiError"))
                .body("code", is("API_DATA_NOT_FOUND"))
                .body("message", is("The entity with id " + nonExistentID + " was not found."));

        System.out.println("Статус код = " + response.getStatusCode());
    }
}
