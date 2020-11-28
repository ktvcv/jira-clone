package hillel.jiraclone.demo.persistence.repos.common;

import hillel.jiraclone.demo.persistence.common.CommonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CommonRepo<T extends CommonEntity, Integer> extends JpaRepository<T, Integer>, JpaSpecificationExecutor<T> {

}
