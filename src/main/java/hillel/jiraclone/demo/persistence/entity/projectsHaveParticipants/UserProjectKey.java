package hillel.jiraclone.demo.persistence.entity.projectsHaveParticipants;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserProjectKey implements Serializable {

    @Column(name = "participant_id")
    private Integer participantId;

    @Column(name = "project_id")
    private Integer projectId;

    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserProjectKey)) return false;
        UserProjectKey that = (UserProjectKey) o;
        return getParticipantId().equals(that.getParticipantId()) &&
                getProjectId().equals(that.getProjectId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getParticipantId(), getProjectId());
    }

    public UserProjectKey() {
    }


}
