package hillel.jiraclone.demo.persistence.entity;


import hillel.jiraclone.demo.persistence.common.CommonEntity;
import hillel.jiraclone.demo.persistence.util.CipherConverter;
import hillel.jiraclone.demo.service.CipheringService;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

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

//    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "usr")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private List<Project> projects = new ArrayList<>();



}
