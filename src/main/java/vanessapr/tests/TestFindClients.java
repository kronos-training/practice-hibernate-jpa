package vanessapr.tests;


import vanessapr.daos.ClientDao;
import vanessapr.daos.impl.ClientDaoImpl;
import vanessapr.entities.Client;

public class TestFindClients {

    public static void main(String[] args) {
        ClientDao dao = new ClientDaoImpl();
        // by id
        Client client1 = dao.find(1);
        System.out.println(client1);
        // by name
        Client client2 = dao.findByName("Walter");
        System.out.println(client2);
        // by last name
        Client client3 = dao.findByLastName("Rios");
        System.out.println(client3);
    }

}
