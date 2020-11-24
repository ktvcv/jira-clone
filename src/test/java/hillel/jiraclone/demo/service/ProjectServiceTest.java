package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.entity.Backlog;
import hillel.jiraclone.demo.persistence.entity.Project;
import hillel.jiraclone.demo.persistence.entity.User;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RunWith(MockitoJUnitRunner.class)
class ProjectServiceTest {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/default_beans.xml");

    UserService userService = applicationContext.getBean(UserService.class);
    ProjectService projectService = applicationContext.getBean(ProjectService.class);
    SprintService sprintService = applicationContext.getBean(SprintService.class);
    BacklogService backlogService = applicationContext.getBean(BacklogService.class);


    @BeforeEach
    void setUp() {
        User user1 = new User();
        user1.setName("name1");
        user1.setPassword("pass1");
        user1.setEmail("mail1");

        User user2 = new User();
        user1.setName("name2");
        user1.setPassword("pass2");
        user1.setEmail("mail2");

        Project project1 = new Project();
        project1.setTitle("title1");

        user1.addProject(project1);

        project1.setUser(user1);
        userService.saveOrUpdate(user1);
        userService.saveOrUpdate(user2);




    }

    @AfterEach
    void tearDown() {
        userService.removeAll();
    }

    @Test
    public void testUserCRUDMethods() {


    }
}