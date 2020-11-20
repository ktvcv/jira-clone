package hillel.jiraclone.demo.persistence.common;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class CommonService<T extends CommonEntity, K>
                implements ICommonService<T, K>{

    private ICommonDao<T, K> iDao;

    public CommonService(ICommonDao<T, K> iDao) {
        this.iDao = iDao;
    }

    public CommonService() {
    }

    @Override
    public void saveOrUpdate(T entity) {
        if(entity.isNew())
            iDao.save(entity);
        else iDao.update(entity);
    }

    @Override
    public List<T> getAll() {
        return iDao.getAll();
    }

    @Override
    public T get(K id) {
        return iDao.find(id);
    }

    @Override
    public void add(T entity) {
        iDao.save(entity);
    }

    @Override
    public void update(T entity) {
        iDao.update(entity);
    }

    @Override
    public void remove(T entity) {
        iDao.remove(entity);
    }
}
