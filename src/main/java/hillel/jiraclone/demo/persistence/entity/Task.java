package hillel.jiraclone.demo.persistence.entity;

import hillel.jiraclone.demo.persistence.common.CommonEntity;
import hillel.jiraclone.demo.persistence.enumeration.TaskStatusApproved;
import hillel.jiraclone.demo.persistence.enumeration.TaskStatusWork;
import hillel.jiraclone.demo.persistence.enumeration.TaskType;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "task")
@SequenceGenerator(name = "seq_name", sequenceName = "seq_task", allocationSize = 1)
@DynamicUpdate
public class Task extends CommonEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "duration")
    private Integer duration;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_work", nullable = false)
    private TaskStatusWork statusWork;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_approval", nullable = false)
    private TaskStatusApproved statusApproved;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TaskType type;

    @ManyToOne(optional = false)
    @JoinColumn(name = "backlog_id", nullable = false)
    private Backlog backlog;

    @ManyToOne()
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;

}
