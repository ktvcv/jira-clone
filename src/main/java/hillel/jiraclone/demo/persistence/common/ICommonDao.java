package hillel.jiraclone.demo.persistence.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICommonDao<T extends CommonEntity, K> {
    public T save(T entity) ;
    public void update(T entity) ;
    public void remove(T entity);
    public T find(K key);
    public Page<T> listPageable(Pageable pageable);
    public List<T> getAll() ;
}
