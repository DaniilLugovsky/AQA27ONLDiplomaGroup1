package servises;


import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;
import utils.endpoints.Endpoints;

import static io.restassured.RestAssured.given;


public class ProjectService implements IProjectService {

    @Override
    public Project getProject(int id) {
        return given()
                .pathParam("id", id)
                .log().all()
                .when()
                .get(Endpoints.GET_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Project.class, ObjectMapperType.GSON);
    }

    @Override
    public Response getProjects() {
        return given()
                .when()
                .get(Endpoints.GET_PROJECTS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
    }

    @Override
    public Response getInvalidProject(int id) {
        return given()
                .pathParam("id", id)
                .log().all()
                .when()
                .get(Endpoints.GET_PROJECT)
                .then()
                .log().body()
                .extract()
                .response();
    }

    @Override
    public Project addProject(Project project) {
        return given()
                .body(project)
                .log().body()
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract().as(Project.class, ObjectMapperType.GSON);
    }

    @Override
    public Response deleteProject(int id) {
        return given()
                .pathParam("id", id)
                .when()
                .delete(Endpoints.DELETE_PROJECT);
    }

    @Override
    public Project updateProject(Project project, int id) {
        return given()
                .body(project)
                .log().body()
                .log().all()
                .pathParam("id", id)
                .queryParam("force","true")
                .when()
                .put(Endpoints.UPDATE_PROJECT)
                .then()
                .log().body()
                .extract().as(Project.class, ObjectMapperType.GSON);
    }

    @Override
    public Response addInvalidNameProject(Project project) {
        return given()
                .body(project)
                .log().body()
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().all()
                .extract()
                .response();
    }
}

