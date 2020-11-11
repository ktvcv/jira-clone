package hillel.jiraclone.demo.persistence.entity;


import hillel.jiraclone.demo.persistence.common.CommonEntity;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "project")
@SequenceGenerator(name = "seq_name", sequenceName = "seq_proj", allocationSize = 1)
@DynamicUpdate
public class Project extends CommonEntity {

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User user;

    @OneToOne( cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Backlog backlog;

    public Project() {
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
}

