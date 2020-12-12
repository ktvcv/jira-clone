package hillel.jiraclone.demo.persistence.repos.common;

import hillel.jiraclone.demo.persistence.common.CommonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonRepository<E extends CommonEntity> extends JpaRepository<E, Integer>,
        JpaSpecificationExecutor<E> {

}
