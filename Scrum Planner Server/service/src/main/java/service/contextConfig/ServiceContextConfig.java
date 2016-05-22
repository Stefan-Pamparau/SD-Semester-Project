package service.contextConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import dao.contextConfig.DaoContextConfig;
import service.CompanyService;
import service.EmployeeService;
import service.ProjectService;
import service.RegularUserService;
import service.StoryCardService;
import service.StoryPanelService;
import service.TaskBoardService;
import service.TaskCardService;
import service.TaskPanelService;
import service.UserService;
import service.impl.DefaultCompanyServiceImpl;
import service.impl.DefaultEmployeeServiceImpl;
import service.impl.DefaultProjectServiceImpl;
import service.impl.DefaultRegularUserServiceImpl;
import service.impl.DefaultStoryCardServiceImpl;
import service.impl.DefaultStoryPanelServiceImpl;
import service.impl.DefaultTaskBoardServiceImpl;
import service.impl.DefaultTaskCardServiceImpl;
import service.impl.DefaultTaskPanelServiceImpl;
import service.impl.DefaultUserServiceImpl;

/**
 * Spring bean configuration class for the service layer.
 *
 * @author Stefan Pamparau
 */
@Configuration
@Import(DaoContextConfig.class)
public class ServiceContextConfig {

    @Bean(name = "companyService")
    public CompanyService getCompanyService() {
        return new DefaultCompanyServiceImpl();
    }

    @Bean(name = "employeeService")
    public EmployeeService getEmployeeService() {
        return new DefaultEmployeeServiceImpl();
    }

    @Bean(name = "projectService")
    public ProjectService getProjectService() {
        return new DefaultProjectServiceImpl();
    }

    @Bean(name = "regularUserService")
    public RegularUserService getRegularUserService() {
        return new DefaultRegularUserServiceImpl();
    }

    @Bean(name = "storyCardService")
    public StoryCardService getStoryCardService() {
        return new DefaultStoryCardServiceImpl();
    }

    @Bean(name = "storyPanelService")
    public StoryPanelService getStoryPanelService() {
        return new DefaultStoryPanelServiceImpl();
    }

    @Bean(name = "taskBoardService")
    public TaskBoardService getTaskBoardService() {
        return new DefaultTaskBoardServiceImpl();
    }

    @Bean(name = "taskCardService")
    public TaskCardService getTaskCardService() {
        return new DefaultTaskCardServiceImpl();
    }

    @Bean(name = "taskPanelService")
    public TaskPanelService getTaskPanelService() {
        return new DefaultTaskPanelServiceImpl();
    }

    @Bean(name = "userService")
    public UserService getUserService() {
        return new DefaultUserServiceImpl();
    }
}
