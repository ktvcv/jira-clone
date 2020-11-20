package hillel.jiraclone.demo.persistence.entity;

import hillel.jiraclone.demo.persistence.common.CommonEntity;
import hillel.jiraclone.demo.persistence.util.CustomLongTimeConverter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private List<Task> tasks = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sprint sprint = (Sprint) o;
        return getId() != null && getId().equals(sprint.getId()) &&
                getProject().equals(sprint.getProject());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProject());
    }

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
