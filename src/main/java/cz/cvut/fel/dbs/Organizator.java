package cz.cvut.fel.dbs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organizator")
public class Organizator {
    @Id
    @Column(name = "rodne_cislo", nullable = false)
    private Integer rodneCislo;

    @Column(name = "jmeno", length = 30)
    private String jmeno;

    @Column(name = "prijmeni", length = 40)
    private String prijmeni;

    @Column(name = "role", length = 30)
    private String role;

    public Integer getRodneCislo() {
        return rodneCislo;
    }

    public void setRodneCislo(Integer rodneCislo) {
        this.rodneCislo = rodneCislo;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}