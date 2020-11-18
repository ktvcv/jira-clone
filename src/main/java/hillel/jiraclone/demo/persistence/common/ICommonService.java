package hillel.jiraclone.demo.persistence.common;

import java.util.List;

public interface ICommonService<T extends CommonEntity, K> {

    void saveOrUpdate(T entity);
    List<T> getAll();
    T get(K id);
    void add(T entity);
    void update(T entity);
     void remove(T entity);
}
