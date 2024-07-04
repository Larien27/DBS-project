package cz.cvut.fel.dbs;

import javax.persistence.*;

@Entity
@Table(name = "predvadi")
public class Predvadi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_pisnicka", nullable = false)
    private Pisnicka idPisnicka;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_vystoupeni", nullable = false)
    private Vystoupeni idVystoupeni;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pisnicka getIdPisnicka() {
        return idPisnicka;
    }

    public void setIdPisnicka(Pisnicka idPisnicka) {
        this.idPisnicka = idPisnicka;
    }

    public Vystoupeni getIdVystoupeni() {
        return idVystoupeni;
    }

    public void setIdVystoupeni(Vystoupeni idVystoupeni) {
        this.idVystoupeni = idVystoupeni;
    }

}