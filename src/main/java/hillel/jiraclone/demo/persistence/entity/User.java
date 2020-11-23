package hillel.jiraclone.demo.persistence.entity;


import hillel.jiraclone.demo.persistence.common.CommonEntity;
import hillel.jiraclone.demo.persistence.entity.projectsHaveParticipants.UsersInProjects;
import hillel.jiraclone.demo.persistence.entity.usersHaveTasks.UsersWithTasks;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usr")
@SequenceGenerator(name = "seq_name", sequenceName = "seq_user", allocationSize = 1)
@DynamicUpdate
public class User extends CommonEntity {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Project> projects = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_id")
    private List<UsersInProjects> inProjects;

    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<UsersWithTasks> tasks;

    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private List<Comment> comments = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId() != null && getId().equals(user.getId()) &&
                getName().equals(user.getName()) &&
                getEmail().equals(user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCreationDate(), getName(), getEmail(),
                getPassword(), getFullname(), getProjects(), getInProjects(),
                getTasks(), getComments());
    }

    public User() {
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UsersInProjects> getInProjects() {
        return inProjects;
    }

    public void setInProjects(List<UsersInProjects> inProjects) {
        this.inProjects = inProjects;
    }

    public List<UsersWithTasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<UsersWithTasks> tasks) {
        this.tasks = tasks;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void addProject(Project project){
        this.getProjects().add(project);
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                '}';
    }
}
