package vanessapr.daos;

import vanessapr.entities.Client;

import java.util.List;

public interface ClientDao {
    void create(Client client);
    void update(Client client);
    void delete(long id);
    Client find(long id);
    Client findByName(String name);
    Client findByLastName(String lastName);
    List<Client> findAll();
}
