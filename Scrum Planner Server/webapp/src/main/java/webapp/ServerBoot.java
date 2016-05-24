package webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import service.contextConfig.ServiceContextConfig;

/**
 * Class whihc boots up the tomcat server.
 *
 * @author Stefan Pamparau
 */
@SpringBootApplication(scanBasePackages = "webapp")
@Import(ServiceContextConfig.class)
public class ServerBoot {
    public static void main(String[] args) {
        SpringApplication.run(ServerBoot.class, args);
    }
}
