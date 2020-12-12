package hillel.jiraclone.demo.persistence.repos;

import hillel.jiraclone.demo.persistence.entity.History;
import hillel.jiraclone.demo.persistence.repos.common.CommonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

@Repository
public interface HistoryRepo extends CommonRepository<History> {
    @Query("FROM History WHERE deleteDate is null")
    Page<History> findAllWhereDeleteDateIsNull(Pageable pageable);

    @Procedure(name = "History.deleteAllByDate")
    void softDeleteHistory(@Param("p_date") Calendar calendar);
}
