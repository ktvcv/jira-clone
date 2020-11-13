package hillel.jiraclone.demo.persistence.entity;

import hillel.jiraclone.demo.persistence.common.CommonEntity;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "extra_task_info")
@SequenceGenerator(name = "seq_name", sequenceName = "seq_task_extra", allocationSize = 1)
@DynamicUpdate
public class TaskExtraInfo extends CommonEntity {

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "file", nullable = false)
    private byte[] file;

    public TaskExtraInfo() {
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
