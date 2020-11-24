package hillel.jiraclone.demo.persistence.common;

import java.util.List;

public interface ICommonService<T extends CommonEntity> {

    void saveOrUpdate(T entity);
    List<T> getAll();
    T get(Integer id);
    void remove(T entity);
}
