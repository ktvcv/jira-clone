package hillel.jiraclone.demo.persistence.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICommonDao<T extends CommonEntity, K> {
    T save(T entity) ;
    void update(T entity) ;
    void remove(T entity);
    T find(K key);
    Page<T> listPageable(Pageable pageable);
    List<T> getAll() ;
}
