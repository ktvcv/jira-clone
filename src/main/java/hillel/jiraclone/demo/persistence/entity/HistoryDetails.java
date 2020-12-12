package hillel.jiraclone.demo.persistence.entity;

import hillel.jiraclone.demo.persistence.common.CommonEntity;

import javax.persistence.*;

@Entity
@Table(name = "history_details")
@SequenceGenerator(name = "seq_name", sequenceName = "seq_history_det", allocationSize = 1)
public class HistoryDetails extends CommonEntity{

    @ManyToOne
    @JoinColumn(name = "history_id", nullable = false)
    private History history;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "value", nullable = false)
    private String value;

    public HistoryDetails() {
    }

    public HistoryDetails(History history, String name, String value) {
        this.history = history;
        this.name = name;
        this.value = value;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
