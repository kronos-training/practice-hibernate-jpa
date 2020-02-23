package vanessapr.tests;

import vanessapr.entities.Client;
import vanessapr.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TestClients {

    public static void main(String[] args) {
        {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("rfclients");
            EntityManager em = emf.createEntityManager();

            List<Client> clientList = (List<Client>) em.createQuery("FROM Client").getResultList();
            System.out.println("Total: " + clientList.size());

            for (Client client: clientList) {
                System.out.println(client);
            }
        }

        // using HQL
        {
            Session session = HibernateUtil.currentSession();
            Query query = session.createQuery("FROM Client");
            List<Client> clientList = query.getResultList();

            for (Client client: clientList) {
                System.out.println(client);
            }
        }
    }
}
