package integration.contextConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
import integration.impl.DefaultCompanyGatewayImpl;
import integration.impl.DefaultDeveloperGatewayImpl;
import integration.impl.DefaultEmployeeGatewayImpl;
import integration.impl.DefaultLoginGatewayImpl;
import integration.impl.DefaultProjectGatewayImpl;
import integration.impl.DefaultProjectManagerGatewayImpl;
import integration.impl.DefaultRegularUserGatewayImpl;
import integration.impl.DefaultStoryCardGatewayImpl;
import integration.impl.DefaultTagGatewayImpl;
import integration.impl.DefaultTaskBoardGatewayImpl;
import integration.impl.DefaultTaskCardGatewayImpl;
import integration.impl.DefaultTaskPanelGatewayImpl;

/**
 * Spring context config for integration module.
 *
 * @author Stefan Pamparau
 */
@Configuration
public class IntegrationContextConfig {

    @Bean(name = "companyGateway")
    public CompanyGateway getCompanyGateway() {
        return new DefaultCompanyGatewayImpl();
    }

    @Bean(name = "developerGateway")
    public DeveloperGateway getDeveloperGateway() {
        return new DefaultDeveloperGatewayImpl();
    }

    @Bean(name = "employeeGateway")
    public EmployeeGateway getEmployeeGateway() {
        return new DefaultEmployeeGatewayImpl();
    }

    @Bean(name = "projectGateway")
    public ProjectGateway getProjectGateway() {
        return new DefaultProjectGatewayImpl();
    }

    @Bean(name = "projectManagerGateway")
    public ProjectManagerGateway getProjectManagerGateway() {
        return new DefaultProjectManagerGatewayImpl();
    }

    @Bean(name = "regularUserGateway")
    public RegularUserGateway getRegularUserGateway() {
        return new DefaultRegularUserGatewayImpl();
    }

    @Bean(name = "storyCardGateway")
    public StoryCardGateway getStoryCardGateway() {
        return new DefaultStoryCardGatewayImpl();
    }

    @Bean(name = "tagGateway")
    public TagGateway getTagGateway() {
        return new DefaultTagGatewayImpl();
    }

    @Bean(name = "taskBoardGateway")
    public TaskBoardGateway getTaskBoardGateway() {
        return new DefaultTaskBoardGatewayImpl();
    }

    @Bean(name = "taskCardGateway")
    public TaskCardGateway getTaskCardGateway() {
        return new DefaultTaskCardGatewayImpl();
    }

    @Bean(name = "taskPanelGateway")
    public TaskPanelGateway getTaskPanelGateway() {
        return new DefaultTaskPanelGatewayImpl();
    }

    @Bean(name = "loginGateway")
    public LoginGateway getUserGateway() {
        return new DefaultLoginGatewayImpl();
    }
}
