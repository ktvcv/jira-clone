package hillel.jiraclone.demo.persistence.entity;

import hillel.jiraclone.demo.persistence.common.CommonEntity;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "backlog")
@SequenceGenerator(name = "seq_name", sequenceName = "seq_backlog", allocationSize = 1)
@DynamicUpdate
public class Backlog extends CommonEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    public Backlog() {
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
