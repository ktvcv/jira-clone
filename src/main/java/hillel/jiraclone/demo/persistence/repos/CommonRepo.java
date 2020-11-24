package hillel.jiraclone.demo.persistence.repos;

import hillel.jiraclone.demo.persistence.common.CommonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonRepo<T extends CommonEntity>
        extends JpaRepository<T, Integer>, JpaSpecificationExecutor<T> {
}
