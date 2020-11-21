package hillel.jiraclone.demo;


import hillel.jiraclone.demo.persistence.entity.Project;
import hillel.jiraclone.demo.persistence.entity.User;
import hillel.jiraclone.demo.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/default_beans.xml");

        UserService userService = applicationContext.getBean(UserService.class);

        ProjectService projectService = applicationContext.getBean(ProjectService.class);

        BacklogService backlogService = applicationContext.getBean(BacklogService.class);

        SprintService sprintService = applicationContext.getBean(SprintService.class);

        TaskService taskService = applicationContext.getBean(TaskService.class);

        CommentService commentService = applicationContext.getBean(CommentService.class);

        User user = new User();

        user.setEmail("email");
        user.setName("name");
        user.setPassword("password");
        userService.saveOrUpdate(user);

        System.out.println(userService.getAll());

        Project project = new Project();
        User userFromDB = userService.getUserByEmail("email");
        userFromDB.getProjects().add(project);

    }

}
