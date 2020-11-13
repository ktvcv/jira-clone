package hillel.jiraclone.demo.persistence.entity;

import hillel.jiraclone.demo.persistence.common.CommonEntity;
import hillel.jiraclone.demo.persistence.util.CustomLongTimeConverter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sprint")
@SequenceGenerator(name = "seq_name", sequenceName = "seq_sprint", allocationSize = 1)
@DynamicUpdate
public class Sprint extends CommonEntity {

    @Column(name = "date_of_beginning", nullable = false)
    @Convert(converter = CustomLongTimeConverter.class)
    private Long dateOfBeginning;

    @Column(name = "duration")
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private List<Task> tasks = new ArrayList<>();

    public Sprint() {
    }

    public Long getDateOfBeginning() {
        return dateOfBeginning;
    }

    public void setDateOfBeginning(Long dateOfBeginning) {
        this.dateOfBeginning = dateOfBeginning;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
