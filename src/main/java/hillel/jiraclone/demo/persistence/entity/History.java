package hillel.jiraclone.demo.persistence.entity;

import hillel.jiraclone.demo.persistence.common.CommonEntity;
import hillel.jiraclone.demo.persistence.enumeration.Level;
import hillel.jiraclone.demo.persistence.util.CustomLongTimeConverter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "history")
@NamedStoredProcedureQuery(name = "History.deleteAllByDate",
                           procedureName = "delete_all_by_date",
                            parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_date", type = Calendar.class)})
@SequenceGenerator(name = "seq_name", sequenceName = "seq_history", allocationSize = 1)
public class History extends CommonEntity {
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "level", nullable = false)
    private Level level;

    @Column(name = "history_type")
    private String historyType;

    @OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "id")
    private Set<HistoryDetails> historyDetails = new HashSet<>();

    @Column(name = "delete_date")
    @Convert(converter = CustomLongTimeConverter.class)
    private Long deleteDate;

    public History(User user, Level level, String historyType, Set<HistoryDetails> historyDetails) {
        this.user = user;
        this.level = level;
        this.historyType = historyType;
        this.historyDetails = historyDetails;
    }

    public History() {
    }

    public void addHistoryDetails(HistoryDetails historyDetails){
        this.historyDetails.add(historyDetails);
        historyDetails.setHistory(this);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getHistoryType() {
        return historyType;
    }

    public void setHistoryType(String historyType) {
        this.historyType = historyType;
    }

    public Set<HistoryDetails> getHistoryDetails() {
        return historyDetails;
    }

    public void setHistoryDetails(Set<HistoryDetails> historyDetails) {
        this.historyDetails = historyDetails;
    }
}
