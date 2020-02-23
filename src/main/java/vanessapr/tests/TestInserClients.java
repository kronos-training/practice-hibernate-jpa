package vanessapr.tests;

import vanessapr.daos.ClientDao;
import vanessapr.daos.impl.ClientDaoImpl;
import vanessapr.entities.Client;

public class TestInserClients {

    public static void main(String[] args) {
        ClientDao dao = new ClientDaoImpl();
        // creating new clients...
        Client client = new Client();
        client.setName("Luis");
        client.setLastName("Perez");
        client.setEmail("lperez@mail.com");
        client.setPhoneNumber("940503903");

        dao.create(client);
    }
}
