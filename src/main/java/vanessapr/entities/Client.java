package vanessapr.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "clientes")
@NamedQueries({
        @NamedQuery(name = "Client.findByName", query = "SELECT c FROM Client c WHERE nombres LIKE :name"),
        @NamedQuery(name = "Client.findByLastName", query = "SELECT c FROM Client c WHERE apellidos LIKE :lastName")
})
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    private long id;
    @Column(name = "apellidos")
    private String lastName;
    @Column(name = "nombres")
    private String name;
    @Column(name = "correo")
    private String email;
    @Column(name = "telefono")
    private String phoneNumber;

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Client: name: " + name + ", lastname = " + lastName + ", email = " + email;
    }
}
