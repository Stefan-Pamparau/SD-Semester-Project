package integration.databaseDummyData;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import integration.CompanyGateway;
import integration.DeveloperGateway;
import integration.EmployeeGateway;
import integration.LoginGateway;
import integration.ProjectGateway;
import integration.ProjectManagerGateway;
import integration.RegularUserGateway;
import integration.StoryCardGateway;
import integration.TagGateway;
import integration.TaskBoardGateway;
import integration.TaskCardGateway;
import integration.TaskPanelGateway;
import integration.contextConfig.IntegrationContextConfig;
import integration.exception.IntegrationException;
import model.planner.project.PermissionType;
import model.planner.project.Project;
import model.planner.taskboard.TaskBoard;
import model.planner.user.Company;
import model.planner.user.Developer;
import model.planner.user.Employee;
import model.planner.user.ProjectManager;
import model.planner.user.RegularUser;
import model.planner.user.User;
import model.planner.user.UserType;

/**
 * Class used to populate the database with dummy data.
 *
 * @author Stefan Pamparau
 */
public class DatabaseDummyData {
    public static void main(String[] args) throws IntegrationException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(IntegrationContextConfig.class);
        CompanyGateway companyGateway = (CompanyGateway) applicationContext.getBean("companyGateway");
        DeveloperGateway developerGateway = (DeveloperGateway) applicationContext.getBean("developerGateway");
        EmployeeGateway employeeGateway = (EmployeeGateway) applicationContext.getBean("employeeGateway");
        ProjectGateway projectGateway = (ProjectGateway) applicationContext.getBean("projectGateway");
        ProjectManagerGateway projectManagerGateway = (ProjectManagerGateway) applicationContext.getBean("projectManagerGateway");
        RegularUserGateway regularUserGateway = (RegularUserGateway) applicationContext.getBean("regularUserGateway");
        StoryCardGateway storyCardGateway = (StoryCardGateway) applicationContext.getBean("storyCardGateway");
        TagGateway tagGateway = (TagGateway) applicationContext.getBean("tagGateway");
        TaskBoardGateway taskBoardGateway = (TaskBoardGateway) applicationContext.getBean("taskBoardGateway");
        TaskCardGateway taskCardGateway = (TaskCardGateway) applicationContext.getBean("taskCardGateway");
        TaskPanelGateway taskPanelGateway = (TaskPanelGateway) applicationContext.getBean("taskPanelGateway");
        LoginGateway loginGateway = (LoginGateway) applicationContext.getBean("loginGateway");

        Company company1 = new Company();
        company1.setName("Company 1");
        company1.setRegistrationNumber("12345F");
        company1.setCreationDate(new Timestamp(1232141244));

        company1 = companyGateway.insertCompany(company1);

        RegularUser regularUser = new RegularUser();
        regularUser.setName("Regular User Name");
        regularUser.setCNP("12345");
        regularUser.setAge(25);
        regularUser.setEmail("regularUser@gmail.com");
        regularUser.setPassword("123");
        regularUser.setProjects(null);
        regularUser.setUserType(UserType.REGULAR_USER);

        regularUser = regularUserGateway.insertRegularUser(regularUser);

        Developer developer1 = new Developer();
        developer1.setName("Developer Name 1");
        developer1.setCNP("1");
        developer1.setAge(25);
        developer1.setEmail("developer1@gmail.com");
        developer1.setPassword("123");
        developer1.setProjects(null);
        developer1.setUserType(UserType.DEVELOPER);
        developer1.setCompany(company1);

        developer1 = developerGateway.insertDeveloper(developer1);

        Developer developer2 = new Developer();
        developer2.setName("Developer Name 2");
        developer2.setCNP("12");
        developer2.setAge(25);
        developer2.setEmail("developer2@gmail.com");
        developer2.setPassword("123");
        developer2.setProjects(null);
        developer2.setUserType(UserType.DEVELOPER);
        developer2.setCompany(company1);

        developer2 = developerGateway.insertDeveloper(developer2);

        Developer developer3 = new Developer();
        developer3.setName("Developer Name 3");
        developer3.setCNP("123");
        developer3.setAge(25);
        developer3.setEmail("developer3@gmail.com");
        developer3.setPassword("123");
        developer3.setProjects(null);
        developer3.setUserType(UserType.DEVELOPER);
        developer3.setCompany(company1);

        developer3 = developerGateway.insertDeveloper(developer3);

        ProjectManager projectManager = new ProjectManager();
        projectManager.setName("Project manager Name");
        projectManager.setCNP("1234");
        projectManager.setAge(25);
        projectManager.setEmail("projectManager@gmail.com");
        projectManager.setPassword("123");
        projectManager.setProjects(null);
        projectManager.setUserType(UserType.PROJECT_MANAGER);
        Set<Developer> developers = new HashSet<>();
        developers.add(developer1);
        developers.add(developer2);
        projectManager.setDevelopers(developers);
        projectManager.setCompany(company1);

        projectManager = projectManagerGateway.insertProjectManager(projectManager);

        Set<Employee> employees1 = new HashSet<>();
        employees1.add(developer1);
        employees1.add(developer2);
        employees1.add(developer3);
        employees1.add(projectManager);
        company1.setEmployees(employees1);

        companyGateway.updateCompany(company1);

        TaskBoard taskBoard1 = new TaskBoard();
        TaskBoard taskBoard2 = new TaskBoard();
        TaskBoard taskBoard3 = new TaskBoard();
        TaskBoard taskBoard4 = new TaskBoard();

        taskBoard1.setPanels(null);
        taskBoard2.setPanels(null);
        taskBoard3.setPanels(null);
        taskBoard4.setPanels(null);

        taskBoard1 = taskBoardGateway.insertTaskBoard(taskBoard1);
        taskBoard2 = taskBoardGateway.insertTaskBoard(taskBoard2);
        taskBoard3 = taskBoardGateway.insertTaskBoard(taskBoard3);
        taskBoard4 = taskBoardGateway.insertTaskBoard(taskBoard4);

        Project project1 = new Project();
        project1.setName("Project 1");
        project1.setPermissionType(PermissionType.PUBLIC);
        project1.setTaskBoard(taskBoard1);
        Set<User> users1 = new HashSet<>();
        users1.add(regularUser);
        project1.setUsers(users1);

        Project project2 = new Project();
        project2.setName("Project 2");
        project2.setPermissionType(PermissionType.PUBLIC);
        project2.setTaskBoard(taskBoard2);
        Set<User> users2 = new HashSet<>();
        users2.add(developer1);
        users2.add(developer2);
        users2.add(projectManager);
        project2.setUsers(users2);

        Project project3 = new Project();
        project3.setName("Project 3");
        project3.setPermissionType(PermissionType.PUBLIC);
        project3.setTaskBoard(taskBoard3);
        Set<User> users3 = new HashSet<>();
        users3.add(developer1);
        project3.setUsers(users3);

        Project project4 = new Project();
        project4.setName("Project 4");
        project4.setPermissionType(PermissionType.PUBLIC);
        project4.setTaskBoard(taskBoard4);
        Set<User> users4 = new HashSet<>();
        users4.add(developer2);
        project4.setUsers(users4);

        project1 = projectGateway.insertProject(project1);
        project2 = projectGateway.insertProject(project2);
        project3 = projectGateway.insertProject(project3);
        project4 = projectGateway.insertProject(project4);

        Set<Project> projects1 = new HashSet<>();
        projects1.add(project1);
        regularUser.setProjects(projects1);

        Set<Project> projects2 = new HashSet<>();
        projects2.add(project2);
        developer1.setProjects(projects2);
        developer2.setProjects(projects2);
        projectManager.setProjects(projects2);

        developer1.getProjects().add(project3);
        developer2.getProjects().add(project4);

        developer1.setProjectManager(projectManager);
        developer2.setProjectManager(projectManager);

        developerGateway.updateDeveloper(developer1);
        developerGateway.updateDeveloper(developer2);
        developerGateway.updateDeveloper(developer3);
    }
}