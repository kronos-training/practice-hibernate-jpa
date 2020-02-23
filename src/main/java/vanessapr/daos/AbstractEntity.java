package vanessapr.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class AbstractEntity<T> {
    private EntityManagerFactory emf;
    private EntityManager em;
    Class<T> object;

    public AbstractEntity(Class<T> object) {
        emf = Persistence.createEntityManagerFactory("rfclients");
        em = emf.createEntityManager();
        this.object = object;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public void create(T o) {
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
    }

    public void update(T o) {
        em.getTransaction().begin();
        em.merge(o);
        em.getTransaction().commit();
    }

    public void delete(long id) {
        T o = find(id);

        if (o != null) {
            em.getTransaction().begin();
            em.remove(o);
            em.getTransaction().commit();
        }
    }

    public List<T> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(object);
        Root<T> s = cq.from(object);
        cq.select(s);
        TypedQuery<T> q = em.createQuery(cq);
        return q.getResultList();
    }

    public T find(long id) {
        return em.find(object, id);
    }

}
