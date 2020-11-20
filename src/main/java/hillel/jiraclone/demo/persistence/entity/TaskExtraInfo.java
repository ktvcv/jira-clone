package hillel.jiraclone.demo.persistence.entity;

import hillel.jiraclone.demo.persistence.common.CommonEntity;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "extra_task_info")
@SequenceGenerator(name = "seq_name", sequenceName = "seq_task_extra", allocationSize = 1)
@DynamicUpdate
public class TaskExtraInfo extends CommonEntity {

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "file", nullable = false)
    private byte[] file;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    public TaskExtraInfo() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskExtraInfo that = (TaskExtraInfo) o;
        return getId() != null && getId().equals(that.getId()) &&
                getTask().equals(this.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFile());
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
