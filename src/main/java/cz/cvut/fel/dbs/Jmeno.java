package cz.cvut.fel.dbs;

import org.eclipse.persistence.annotations.ReadOnly;

import javax.persistence.*;

@Entity(name = "jmeno")
public class Jmeno extends DAO<Jmeno> {
    @Id
    @Column(name="navstevnik")
    private String navstevnik_email;

    @Column(name = "krestni_jmeno", length = 30)
    private String krestni_jmeno;

    @Column(name = "prijmeni", length = 40)
    private String prijmeni;

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getKrestni_jmeno() {
        return krestni_jmeno;
    }

    public void setKrestni_jmeno(String krestni_jmeno) {
        this.krestni_jmeno = krestni_jmeno;
    }

    public String getNavstevnik_email() {
        return navstevnik_email;
    }

    public void setNavstevnik_email(String navstevnik_email) {
        this.navstevnik_email = navstevnik_email;
    }

    public Jmeno() {
        super(Jmeno.class);
    }
}
