package hillel.jiraclone.demo.persistence.entity;

import hillel.jiraclone.demo.persistence.common.CommonEntity;
import hillel.jiraclone.demo.persistence.entity.projectsHaveParticipants.UsersInProjects;
import hillel.jiraclone.demo.persistence.entity.usersHaveTasks.UsersWithTasks;
import hillel.jiraclone.demo.persistence.enumeration.TaskStatusApproved;
import hillel.jiraclone.demo.persistence.enumeration.TaskStatusWork;
import hillel.jiraclone.demo.persistence.enumeration.TaskType;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "task")
@SequenceGenerator(name = "seq_name", sequenceName = "seq_task", allocationSize = 1)
@DynamicUpdate
public class Task extends CommonEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "duration")
    private Integer duration;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_work", nullable = false)
    private TaskStatusWork statusWork;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_approval", nullable = false)
    private TaskStatusApproved statusApproved;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TaskType type;

    @ManyToOne(optional = false)
    @JoinColumn(name = "backlog_id", nullable = false)
    private Backlog backlog;

    @ManyToOne()
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;

    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private List<UsersWithTasks> users;

    public Task() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public TaskStatusWork getStatusWork() {
        return statusWork;
    }

    public void setStatusWork(TaskStatusWork statusWork) {
        this.statusWork = statusWork;
    }

    public TaskStatusApproved getStatusApproved() {
        return statusApproved;
    }

    public void setStatusApproved(TaskStatusApproved statusApproved) {
        this.statusApproved = statusApproved;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public Backlog getBacklog() {
        return backlog;
    }

    public void setBacklog(Backlog backlog) {
        this.backlog = backlog;
    }

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    public List<UsersWithTasks> getUsers() {
        return users;
    }

    public void setUsers(List<UsersWithTasks> users) {
        this.users = users;
    }


}
