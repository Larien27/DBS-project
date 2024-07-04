package cz.cvut.fel.dbs;

import javax.persistence.*;

@Entity
@Table(name = "navstevnik")
public class Navstevnik extends DAO<Navstevnik> {

    @Id
    @Column(name = "email", nullable = false, length = 70)
    private String email;

    @OneToOne
    @PrimaryKeyJoinColumn(name="email", columnDefinition = "email", referencedColumnName = "navstevnik")
    private Jmeno jmeno;

    public Jmeno getJmeno() {
        return jmeno;
    }

    public void setJmeno(Jmeno jmeno) {
        this.jmeno = jmeno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Navstevnik() {
        super(Navstevnik.class);
    }
}