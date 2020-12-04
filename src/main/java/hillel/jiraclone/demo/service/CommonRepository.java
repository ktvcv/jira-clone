package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.common.CommonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonRepository<E extends CommonEntity> extends JpaRepository<E, Integer> {
}
