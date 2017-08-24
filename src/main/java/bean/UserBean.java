package bean;

import entity.ReferenceJeneral;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class UserBean {

    // Будет инициализирован контейнером Glassfish
    // unitName = "DEVMODE" - это имя persistence-unit
    // EntityManager дает возможность выполнять CRUD запросы в БД
    @PersistenceContext(unitName = "DEVMODE")
    private EntityManager em;

    // Добавляем User-а В базу данных
    public ReferenceJeneral add(ReferenceJeneral user){
        return em.merge(user);
    }

    // Получаем пользователя по id
    public ReferenceJeneral get(long id){
        return em.find(ReferenceJeneral.class, id);
    }

    // обновляем пользователя
    // если User которого мыпытаемся обновить нет,
    // то запишется он как новый
    public void update(ReferenceJeneral user){
        add(user);
    }

    // удаляем User по id
    public void delete(long id){
        em.remove(get(id));
    }

    // Получаем все пользователей с БД
    public List<ReferenceJeneral> getAll(){
        /*
        TypedQuery<ReferenceJeneral> namedQuery = em.createNamedQuery("ReferenceJeneral.getAll", ReferenceJeneral.class);
        return namedQuery.getResultList();*/

        Query q = em.createQuery("SELECT u FROM ReferenceJeneral u");
        return q.getResultList();
    }

}
