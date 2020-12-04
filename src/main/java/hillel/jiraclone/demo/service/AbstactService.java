package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.common.CommonEntity;
import hillel.jiraclone.demo.persistence.common.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstactService<E extends CommonEntity, R extends CommonRepository<E>>
        implements ICommonService<E> {

    protected final R repository;

    @Autowired
    public AbstactService(R repository) {
        this.repository = repository;
    }

    @Override
    public E saveOrUpdate(E entity) {
        return repository.save(entity);
    }

    @Override
    public List<E> getAll() {
        return repository.findAll();
    }

    @Override
    public E get(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public void remove(E entity) {
        repository.delete(entity);
    }
}