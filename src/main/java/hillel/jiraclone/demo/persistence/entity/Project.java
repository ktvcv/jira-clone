package hillel.jiraclone.demo.persistence.entity;


import hillel.jiraclone.demo.persistence.common.CommonEntity;
import hillel.jiraclone.demo.persistence.entity.projectsHaveParticipants.UsersInProjects;
import hillel.jiraclone.demo.persistence.enumeration.Affiliation;
import hillel.jiraclone.demo.persistence.enumeration.Role;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "project")
@SequenceGenerator(name = "seq_name", sequenceName = "seq_proj", allocationSize = 1)
@DynamicUpdate
public class Project extends CommonEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    private User user;

    @OneToOne( cascade = CascadeType.MERGE, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "id")
    private Backlog backlog;

    @OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "id")
    private List<Sprint> sprints = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "project_id")
    private List<UsersInProjects> participants = new ArrayList<>();


    public void addParticipant(User user, Role role){
        UsersInProjects newParticipant = new UsersInProjects(this, user, role);
        participants.add(newParticipant);
        user.getInProjects().add(newParticipant);
    }

    public void removeParticipant(User user)
    {
        for (Iterator<UsersInProjects> iterator = participants.iterator();
             iterator.hasNext(); ) {
            UsersInProjects users = iterator.next();

            if (users.getProject().equals(this) &&
                    users.getUser().equals(user)) {
                iterator.remove();
                users.getProject().getParticipants().remove(users);
                users.setUser(null);
                users.setProject(null);
            }
        }
    }

    public void addSprint(Sprint sprint){
        getSprints().add(sprint);
        sprint.setProject(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return getId() != null && getId().equals(project.getId()) &&
                getUser().equals(project.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getId());
    }

    public Project() {
    }

    public Backlog getBacklog() {
        return backlog;
    }

    public void setBacklog(Backlog backlog) {
        this.backlog = backlog;
        backlog.setProject(this);
    }

    public List<Sprint> getSprints() {
        return sprints;
    }

    public void setSprints(List<Sprint> sprints) {
        this.sprints = sprints;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<UsersInProjects> getParticipants() {
        return participants;
    }

    public void setParticipants(List<UsersInProjects> participants) {
        this.participants = participants;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", backlog=" + backlog +
                '}';
    }
}

