package baseEntities;

import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Project;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;
import servises.IProjectService;
import servises.ProjectService;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected Project actualProject;
    protected IProjectService projectService;

    public BaseApiTest() {
        this.projectService = new ProjectService();
    }

    @BeforeTest
    public void setupApiClient() {
        RestAssured.baseURI = ReadProperties.getUri();

        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .header(ReadProperties.key(),ReadProperties.keyValue());
    }
}
