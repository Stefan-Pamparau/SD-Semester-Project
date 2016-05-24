package dao.contextConfig;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ListFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.smartcardio.Card;
import javax.sql.DataSource;

import dao.CompanyDao;
import dao.EmployeeDao;
import dao.ProjectDao;
import dao.RegularUserDao;
import dao.StoryCardDao;
import dao.StoryPanelDao;
import dao.TaskBoardDao;
import dao.TaskCardDao;
import dao.TaskPanelDao;
import dao.UserDao;
import dao.impl.DefaultCompanyDaoImpl;
import dao.impl.DefaultEmployeeDaoImpl;
import dao.impl.DefaultProjectDaoImpl;
import dao.impl.DefaultRegularUserDaoImpl;
import dao.impl.DefaultStoryCardDaoImpl;
import dao.impl.DefaultStoryPanelDaoImpl;
import dao.impl.DefaultTaskBoardDaoImpl;
import dao.impl.DefaultTaskCardDaoImpl;
import dao.impl.DefaultTaskPanelDaoImpl;
import dao.impl.DefaultUserDaoImpl;
import model.planner.card.StoryCard;
import model.planner.card.Tag;
import model.planner.card.TaskCard;
import model.planner.project.Project;
import model.planner.taskboard.Panel;
import model.planner.taskboard.StoryPanel;
import model.planner.taskboard.TaskBoard;
import model.planner.taskboard.TaskPanel;
import model.planner.user.Company;
import model.planner.user.Employee;
import model.planner.user.RegularUser;
import model.planner.user.User;


/**
 * Class which contains the beans definitions for the dao layer of the application.
 *
 * @author Stefan Pamparau
 */
@Configuration
@ComponentScan("dao")
@EnableTransactionManagement
public class DaoContextConfig {

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/scrumPlannerDb?createDatabaseIfNotExist=true");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);

        sessionBuilder.scanPackages("model.planner");
        sessionBuilder.addProperties(getHibernateProperties());
        return sessionBuilder.buildSessionFactory();
    }

    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

    @Autowired
    @Bean(name = "companyDao")
    public CompanyDao getCompanyDao(SessionFactory sessionFactory) {
        return new DefaultCompanyDaoImpl(sessionFactory);
    }

    @Autowired
    @Bean(name = "employeeDao")
    public EmployeeDao getEmployeeDao(SessionFactory sessionFactory) {
        return new DefaultEmployeeDaoImpl(sessionFactory);
    }

    @Autowired
    @Bean(name = "projectDao")
    public ProjectDao getProjectDao(SessionFactory sessionFactory) {
        return new DefaultProjectDaoImpl(sessionFactory);
    }

    @Autowired
    @Bean(name = "regularUserDao")
    public RegularUserDao getRegularUserDao(SessionFactory sessionFactory) {
        return new DefaultRegularUserDaoImpl(sessionFactory);
    }

    @Autowired
    @Bean(name = "storyCardDao")
    public StoryCardDao getStoryCardDao(SessionFactory sessionFactory) {
        return new DefaultStoryCardDaoImpl(sessionFactory);
    }

    @Autowired
    @Bean(name = "storyPanelDao")
    public StoryPanelDao getStoryPanelDao(SessionFactory sessionFactory) {
        return new DefaultStoryPanelDaoImpl(sessionFactory);
    }

    @Autowired
    @Bean(name = "taskBoardDao")
    public TaskBoardDao getTaskBoardDao(SessionFactory sessionFactory) {
        return new DefaultTaskBoardDaoImpl(sessionFactory);
    }

    @Autowired
    @Bean(name = "taskCardDao")
    public TaskCardDao getTaskCardDao(SessionFactory sessionFactory) {
        return new DefaultTaskCardDaoImpl(sessionFactory);
    }

    @Autowired
    @Bean(name = "taskPanelDao")
    public TaskPanelDao getTaskPanelDao(SessionFactory sessionFactory) {
        return new DefaultTaskPanelDaoImpl(sessionFactory);
    }

    @Autowired
    @Bean(name = "userDao")
    public UserDao getUserDao(SessionFactory sessionFactory) {
        return new DefaultUserDaoImpl(sessionFactory);
    }

    @Bean(name = "hibernateAnnotatedClasses")
    public ListFactoryBean getListFactory() {
        List<Class<?>> classes = new ArrayList<>();
        classes.add(Card.class);
//        classes.add(CardType.class);
        classes.add(StoryCard.class);
        classes.add(Tag.class);
        classes.add(TaskCard.class);
//        classes.add(PermissionType.class);
        classes.add(Project.class);
        classes.add(Panel.class);
//        classes.add(PanelType.class);
        classes.add(StoryPanel.class);
        classes.add(TaskBoard.class);
        classes.add(TaskPanel.class);
        classes.add(Company.class);
        classes.add(Employee.class);
//        classes.add(EmployeeType.class);
        classes.add(RegularUser.class);
        classes.add(User.class);
//        classes.add(UserType.class);

        ListFactoryBean annotatedClasses = new ListFactoryBean();
        annotatedClasses.setSourceList(classes);
        return annotatedClasses;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.generate_statistics", "true");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        return properties;
    }
}
