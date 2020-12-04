package hillel.jiraclone.demo;


import hillel.jiraclone.demo.persistence.repos.UserRepo;
import hillel.jiraclone.demo.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/default_beans.xml");



        UserService userService = applicationContext.getBean(UserService.class);
    }

}
