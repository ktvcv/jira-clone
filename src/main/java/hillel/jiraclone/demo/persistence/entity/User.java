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
@Table(name = "usr")
@SequenceGenerator(name = "seq_name", sequenceName = "seq_user", allocationSize = 1)
@DynamicUpdate
public class User extends CommonEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    @Convert(disableConversion = true)
    private String password;

    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Project> projects = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_id")
    private List<UsersInProjects> inProjects;

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


}
