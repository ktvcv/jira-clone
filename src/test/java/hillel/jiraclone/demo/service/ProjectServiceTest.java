package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.entity.Project;
import hillel.jiraclone.demo.persistence.entity.User;
import hillel.jiraclone.demo.persistence.entity.User_;
import hillel.jiraclone.demo.persistence.enumeration.Role;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;

import static org.junit.Assert.assertEquals;


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
        user2.setName("name2");
        user2.setPassword("pass2");
        user2.setEmail("mail2");

        User user3 = new User();
        user3.setName("name3");
        user3.setPassword("pass3");
        user3.setEmail("mail3");

        userService.saveOrUpdate(user1);
        userService.saveOrUpdate(user2);

        Project project1 = new Project();
        project1.setTitle("title1");

        user1.addProject(project1);

        userService.saveOrUpdate(user1);

        project1.addParticipant(user2, Role.REGULAR_PARTICIPANT);
        projectService.saveOrUpdate(project1);

    }

    @AfterEach
    void tearDown() {
       userService.removeAll();
    }

    @Test
    void testAllUsersInProject(){
        Assertions.assertEquals(userService.getAllUsersInProject(1, null, PageRequest.of(1, 5)).getSize(), 1);

    }

    @Test
    void testAllUsersInProjectWithRole(){
        Assertions.assertEquals(userService.getAllUsersInProject(1, Role.REGULAR_PARTICIPANT, PageRequest.of(1, 5)).getSize(), 1);

    }

}