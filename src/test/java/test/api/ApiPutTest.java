package test.api;

import baseEntities.BaseApiTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ApiPutTest extends BaseApiTest {

    @Description("API Post Тест на проверку обновления проекта")
    @Severity(SeverityLevel.CRITICAL)
    @Test(testName = "API Post проверка обновления проекта", description = "Тест на проверку обновления проекта")
    public void updateProjectTest() {
        int updateProjectID = 176;
        Project updateProject = new Project();
        updateProject.setName("update name");
        updateProject.setProjectKey("UPD");
        updateProject.setDescription("update description");

        Project actualProject = projectService.updateProject(updateProject, updateProjectID);
        Assert.assertEquals(actualProject, updateProject);
    }
}
