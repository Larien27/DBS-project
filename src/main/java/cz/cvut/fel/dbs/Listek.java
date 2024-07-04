package cz.cvut.fel.dbs;

import javax.persistence.*;

@Entity
@Table(name = "listek")
public class Listek extends DAO<Listek> {
    @Id
    @Column(name = "kod", nullable = false)
    private Integer id;

    @Column(name = "typ", length = 20)
    private String typ;

    @Column(name = "cena", nullable = false)
    private Integer cena;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "festival", nullable = false)
    private HudebniFestival festival;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "navstevnik", nullable = false)
    private Navstevnik navstevnik;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }

    public HudebniFestival getFestival() {
        return festival;
    }

    public void setFestival(HudebniFestival festival) {
        this.festival = festival;
    }

    public Navstevnik getNavstevnik() {
        return navstevnik;
    }

    public void setNavstevnik(Navstevnik navstevnik) {
        this.navstevnik = navstevnik;
    }

    public Listek() {
        super(Listek.class);
    }
}