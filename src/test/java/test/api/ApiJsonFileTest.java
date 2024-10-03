package test.api;

import baseEntities.BaseApiTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.endpoints.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ApiJsonFileTest extends BaseApiTest {

    @Description("API Post Тест на проверку создания проекта c использованием данных из JSON")
    @Severity(SeverityLevel.CRITICAL)
    @Test(testName = "API Post создание проекта c использованием данных из JSON", description = "API Post создание проекта c использованием данных из JSON")
    public void addProjectUsingJsonFileTest() {

        given()
                .body(ApiJsonFileTest.class.getClassLoader().getResourceAsStream("data/dataForApiTest/dataForApiTest.json"))
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .body("name", is("project data from file JSON"))
                .body("project_key", is("JSON"))
                .body("description", is("description data from file JSON"));
    }
}
