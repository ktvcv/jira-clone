package hillel.jiraclone.demo.persistence.common;

import java.util.List;

public interface IGenericDao<T extends CommonEntity> {

    void setClazz(Class<T> clazzToSet);

    T findById(final Integer id);

    T create(final T entity);

    void update(final T entity);

    void delete(final T entity);
}
