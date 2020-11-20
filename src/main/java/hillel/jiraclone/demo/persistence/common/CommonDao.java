package hillel.jiraclone.demo.persistence.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@SuppressWarnings("unchecked")
@Repository
public abstract class CommonDao<T extends CommonEntity, K> implements ICommonDao<T, K> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<T> aClass;

    @Override
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void remove(T entity) {
        entityManager.remove(entity);
    }

    @Override
    public T find(K key) {
        return entityManager.find(aClass, key);
    }


    public void setAClass(Class<T> aClass) {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        this.aClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public List<T> getAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(aClass);
        Root<T> rootEntry = cq.from(aClass);
        CriteriaQuery<T> all = cq.select(rootEntry);

        TypedQuery<T> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
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

}
