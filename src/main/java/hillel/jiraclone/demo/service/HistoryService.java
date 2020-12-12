package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.entity.History;
import hillel.jiraclone.demo.persistence.entity.HistoryDetails;
import hillel.jiraclone.demo.persistence.entity.User;
import hillel.jiraclone.demo.persistence.enumeration.Level;
import hillel.jiraclone.demo.persistence.repos.HistoryDetailRepo;
import hillel.jiraclone.demo.persistence.repos.HistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Objects;

@Service
public class HistoryService {

    private HistoryRepo historyRepo;
    private HistoryDetailRepo historyDetailRepo;

    public HistoryService(@Autowired HistoryRepo historyRepo, @Autowired HistoryDetailRepo historyDetailRepo) {
        this.historyRepo = historyRepo;
        this.historyDetailRepo = historyDetailRepo;
    }

    @Transactional
    public void writeHistoryAction(User user, Level level, String action, String result) {

        History history = new History();
        history.setUser(user);
        history.setLevel(level);

        HistoryDetails historyDetails1 = new HistoryDetails();
        historyDetails1.setName("AUTHOR_NAME");
        historyDetails1.setValue(user.getName().toUpperCase());

        HistoryDetails historyDetails2 = new HistoryDetails();
        historyDetails2.setName(action.toUpperCase());
        historyDetails2.setValue(result.toUpperCase());

        history.addHistoryDetails(historyDetails1);
        history.addHistoryDetails(historyDetails2);

        historyRepo.save(history);
    }

    public Page<History> getAll(Pageable pageable) {
        Objects.requireNonNull(pageable, "Pageable can't be null");

        Page<History> historyPage = historyRepo.findAllWhereDeleteDateIsNull(pageable);

        if (historyPage.hasContent())
            return historyPage;

        return Page.empty();
    }

    public void softDelete(Calendar calendar) {
        historyRepo.softDeleteHistory(calendar);
    }
}
