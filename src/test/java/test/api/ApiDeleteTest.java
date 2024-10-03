package test.api;

import baseEntities.BaseApiTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ApiDeleteTest extends BaseApiTest {

    @Description("API DELETE тест на проверку удаления проекта")
    @Severity(SeverityLevel.CRITICAL)
    @Test(testName = "API DELETE удаление проекта", description = "Тест на проверку удаления проекта")
    public void deleteProjectTest() {
        int projectID = 226;
        Response deleteProject = projectService.deleteProject(projectID);
        deleteProject
                .then()
                .assertThat()
                .statusCode(200)
                .log().status();

        System.out.println("Статус код = " + deleteProject.getStatusCode());
    }
}
