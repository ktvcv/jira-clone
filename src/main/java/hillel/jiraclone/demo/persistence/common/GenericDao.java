package hillel.jiraclone.demo.persistence.common;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericDao<T extends CommonEntity> extends CommonDao<T> implements IGenericDao<T> {

    @Override
    public void setClazz(Class<T> clazzToSet) {
    }
}
