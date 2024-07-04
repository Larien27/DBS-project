package cz.cvut.fel.dbs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hudebni_festival")
public class HudebniFestival extends DAO<HudebniFestival> {
    @Id
    @Column(name = "nazev", nullable = false, length = 50)
    private String nazev;

    @Column(name = "misto", nullable = false, length = 50)
    private String misto;

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String id) {
        this.nazev = id;
    }

    public String getMisto() {
        return misto;
    }

    public void setMisto(String misto) {
        this.misto = misto;
    }

    public HudebniFestival() {
        super(HudebniFestival.class);
    }
}