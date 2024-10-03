package servises;

import io.restassured.response.Response;
import models.Project;

public interface IProjectService {
    Project getProject(int id);
    Response getProjects();
    Response getInvalidProject(int id);
    Project addProject(Project project);
    Response deleteProject(int id);
    Project updateProject(Project project, int id);
    Response addInvalidNameProject(Project project);


}
