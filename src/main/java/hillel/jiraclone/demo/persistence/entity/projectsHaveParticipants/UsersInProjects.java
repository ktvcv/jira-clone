package hillel.jiraclone.demo.persistence.entity.projectsHaveParticipants;

import hillel.jiraclone.demo.persistence.entity.Project;
import hillel.jiraclone.demo.persistence.entity.User;
import hillel.jiraclone.demo.persistence.enumeration.Affiliation;
import hillel.jiraclone.demo.persistence.enumeration.Role;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "project_has_participants")
@DynamicUpdate
public class UsersInProjects {

    @EmbeddedId
    UserProjectKey id;

    @ManyToOne
    @MapsId("projectId")
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @MapsId("participantId")
    @JoinColumn(name = "participant_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    public UsersInProjects(Project project, User user, Role role) {
        this.project = project;
        this.user = user;
        this.role = role;
    }

    public UserProjectKey getId() {
        return id;
    }

    public void setId(UserProjectKey id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UsersInProjects() {
    }
}
