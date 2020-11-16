package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.entity.Project;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
class ProjectServiceTest {

    @InjectMocks
    ProjectService projectService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

}