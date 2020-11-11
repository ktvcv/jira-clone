package hillel.jiraclone.demo.persistence.entity;


import hillel.jiraclone.demo.persistence.common.CommonEntity;
import org.hibernate.annotations.DynamicUpdate;

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

    public Project() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

