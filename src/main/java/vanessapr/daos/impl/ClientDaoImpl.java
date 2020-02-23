package vanessapr.daos.impl;


import vanessapr.daos.AbstractEntity;
import vanessapr.daos.ClientDao;
import vanessapr.entities.Client;

import javax.persistence.Query;

public class ClientDaoImpl extends AbstractEntity<Client> implements ClientDao {

    public ClientDaoImpl() {
        super(Client.class);
    }

    public Client findByName(String name) {
        Query query = getEntityManager().createNamedQuery("Client.findByName");
        query.setParameter("name", name);

        return (Client) query.getSingleResult();
    }

    public Client findByLastName(String lastName) {
        Query query = getEntityManager().createNamedQuery("Client.findByLastName");
        query.setParameter("lastName", lastName);

        return (Client) query.getSingleResult();
    }
}
