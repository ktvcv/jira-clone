package hillel.jiraclone.demo.persistence.common;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdate(T entity) {
        if(entity.isNew())
            iDao.save(entity);
        else iDao.update(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<T> getAll() {
        return iDao.getAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public T get(K id) {
        return iDao.find(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public T add(T entity) {
       return iDao.save(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(T entity) {
        iDao.update(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void remove(T entity) {
        iDao.remove(entity);
    }
}
