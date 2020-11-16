package hillel.jiraclone.demo.persistence.entity;


import hillel.jiraclone.demo.persistence.common.CommonEntity;
import hillel.jiraclone.demo.persistence.entity.projectsHaveParticipants.UsersInProjects;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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


    @OneToOne( cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Backlog backlog;

    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Sprint> sprints = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private List<UsersInProjects> participants;


    public Project() {
    }

    public Backlog getBacklog() {
        return backlog;
    }

    public void setBacklog(Backlog backlog) {
        this.backlog = backlog;
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

