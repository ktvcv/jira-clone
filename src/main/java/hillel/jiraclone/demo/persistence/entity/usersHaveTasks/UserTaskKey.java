package hillel.jiraclone.demo.persistence.entity.usersHaveTasks;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserTaskKey implements Serializable {

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "task_id")
    private Integer taskId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTaskID() {
        return taskId;
    }

    public void setTaskID(Integer taskID) {
        this.taskId = taskID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserTaskKey)) return false;
        UserTaskKey that = (UserTaskKey) o;
        return getUserId().equals(that.getUserId()) &&
                getTaskID().equals(that.getTaskID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getTaskID());
    }

    public UserTaskKey() {
    }


}
