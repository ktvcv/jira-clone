package hillel.jiraclone.demo.persistence.common;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class CommonDao<T extends CommonEntity> {

    //TODO: переделать селекты на Page<> 11/15/2020
    private Class<T> aClass;

    @PersistenceContext
    private EntityManager entityManager;

    public void setAClass(Class<T> aClass) {
        this.aClass = aClass;
    }


    public void persist(final T entity) {
        Assert.notNull(entity, "entity must be a set");
        entityManager.persist(entity);
    }

    public void update(final T entity) {
        Assert.notNull(entity, "entity must be a set");
        entityManager.merge(entity);
    }

    public T findById(Integer id) {
        return entityManager.find(aClass, id);
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public List<T> listPageable(int start, int pageSize) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(aClass);
        criteriaQuery.from(aClass);

        return entityManager.createQuery(criteriaQuery)
                .setFirstResult(start)
                .setMaxResults(pageSize)
                .getResultList();
    }

    public List<T> getAllInCreationDatePageable(Long dateToFind, int start, int pageSize) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(aClass);
        Root<T> root = criteriaQuery.from(aClass);

        criteriaQuery.select(root)
                .where(criteriaBuilder.equal(root
                        .get(CommonEntity_.CREATION_DATE), dateToFind));

        return entityManager.createQuery(criteriaQuery)
                .setFirstResult(start)
                .setMaxResults(pageSize)
                .getResultList();

    }

    public List<T> getAllAfterCreationDatePageable(Long dateToFind, int start, int pageSize) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(aClass);
        Root<T> root = criteriaQuery.from(aClass);

        criteriaQuery.select(root)
                .where(criteriaBuilder.gt(root
                        .get(CommonEntity_.CREATION_DATE), dateToFind));

        return entityManager.createQuery(criteriaQuery)
                .setFirstResult(start)
                .setMaxResults(pageSize)
                .getResultList();
    }

    public List<T> getAllBeforeCreationDatePageable(Long dateToFind, int start, int pageSize) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(aClass);
        Root<T> root = criteriaQuery.from(aClass);

        criteriaQuery.select(root)
                .where(criteriaBuilder.lt(root
                        .get(CommonEntity_.CREATION_DATE), dateToFind));

        return entityManager.createQuery(criteriaQuery)
                .setFirstResult(start)
                .setMaxResults(pageSize)
                .getResultList();
    }

}
