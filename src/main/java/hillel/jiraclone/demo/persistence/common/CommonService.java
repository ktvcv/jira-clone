package hillel.jiraclone.demo.persistence.common;

import hillel.jiraclone.demo.persistence.repos.CommentRepo;
import hillel.jiraclone.demo.persistence.repos.CommonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class CommonService<T extends CommonEntity> implements ICommonService<T>{

    private final CommonRepo<T> repository;

    public CommonService(CommonRepo<T> repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdate(T entity) {
        repository.save(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public T get(Integer id) {
        return repository.getOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void remove(T entity) {
        repository.delete(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void removeAll(){
        repository.deleteAll();
    }

}
