package cz.cvut.fel.dbs;

import javax.persistence.*;

@Entity
@Table(name = "sponzor")
public class Sponzor extends DAO<Sponzor> {
    @Id
    @Column(name = "rodne_cislo", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rodne_cislo", nullable = false)
    private Organizator organizator;

    @Column(name = "celkova_castka")
    private Integer celkovaCastka;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Organizator getOrganizator() {
        return organizator;
    }

    public void setOrganizator(Organizator organizator) {
        this.organizator = organizator;
    }

    public Integer getCelkovaCastka() {
        return celkovaCastka;
    }

    public void setCelkovaCastka(Integer celkovaCastka) {
        this.celkovaCastka = celkovaCastka;
    }

    public Sponzor() {
        super(Sponzor.class);
    }
}