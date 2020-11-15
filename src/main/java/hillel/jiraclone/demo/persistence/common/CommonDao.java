package hillel.jiraclone.demo.persistence.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class CommonDao<T extends CommonEntity> {

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

    public Page<T> listPageable(Pageable pageable) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(aClass);
        criteriaQuery.from(aClass);

        return getTs(pageable, criteriaBuilder, criteriaQuery);
    }

    public Page<T> getAllInCreationDatePageable(Long dateToFind, Pageable pageable) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(aClass);
        Root<T> root = criteriaQuery.from(aClass);

        criteriaQuery.select(root)
                .where(criteriaBuilder
                        .equal(root
                                .get(CommonEntity_.CREATION_DATE), dateToFind));

        return getTs(pageable, criteriaBuilder, criteriaQuery);
    }

    public Page<T> getAllAfterCreationDatePageable(Long dateToFind, Pageable pageable) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(aClass);
        Root<T> root = criteriaQuery.from(aClass);

        criteriaQuery.select(root)
                .where(criteriaBuilder.gt(root
                        .get(CommonEntity_.CREATION_DATE), dateToFind))
                .orderBy(criteriaBuilder.desc(root.get(CommonEntity_.CREATION_DATE)));

        return getTs(pageable, criteriaBuilder, criteriaQuery);
    }

    public Page<T> getAllBeforeCreationDatePageable(Long dateToFind, Pageable pageable) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(aClass);
        Root<T> root = criteriaQuery.from(aClass);

        criteriaQuery.select(root)
                .where(criteriaBuilder.lt(root
                        .get(CommonEntity_.CREATION_DATE), dateToFind));

        return getTs(pageable, criteriaBuilder, criteriaQuery);
    }

    private Page<T> getTs(Pageable pageable, CriteriaBuilder criteriaBuilder, CriteriaQuery<T> criteriaQuery) {
        List<T> result = getResult(criteriaQuery,
                (int) pageable.getOffset(),
                pageable.getPageSize());

        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        countQuery.from(aClass);

        Long count = entityManager.createQuery(countQuery).getSingleResult();

        return new PageImpl<>(result, pageable, count);
    }

    private List<T> getResult(CriteriaQuery<T> query, int offset, int pageSize) {
        return entityManager.createQuery(query)
                .setFirstResult(offset)
                .setMaxResults(pageSize).getResultList();
    }

    public T getEntityByField(String field, Object param) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(aClass);
        Root<T> root = criteriaQuery.from(aClass);

        criteriaQuery.select(root)
                .where(criteriaBuilder.equal(root.get(field), param));

        return entityManager.createQuery(criteriaQuery)
                .setMaxResults(1)
                .getSingleResult();
    }

    public Page<T> getEntitiesByField(String field, Object param, Pageable pageable) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(aClass);
        Root<T> root = criteriaQuery.from(aClass);

        criteriaQuery.select(root)
                .where(criteriaBuilder
                        .equal(root.get(field), param));

        return getTs(pageable, criteriaBuilder, criteriaQuery);
    }

}
