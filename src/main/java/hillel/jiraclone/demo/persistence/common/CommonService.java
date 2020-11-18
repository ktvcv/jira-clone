package hillel.jiraclone.demo.persistence.common;

import java.util.List;

public abstract class CommonService<T extends CommonEntity, K>
                implements ICommonService<T, K>{

    private ICommonDao<T, K> dao;

    public CommonService(ICommonDao<T, K> dao) {
        this.dao = dao;
    }

    public CommonService() {
    }

    @Override
    public void saveOrUpdate(T entity) {

    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public T get(K id) {
        return null;
    }

    @Override
    public void add(T entity) {

    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void remove(T entity) {

    }
}
