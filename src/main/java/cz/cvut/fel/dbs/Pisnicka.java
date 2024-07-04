package cz.cvut.fel.dbs;

import javax.persistence.*;

@Entity
@Table(name = "pisnicka")
public class Pisnicka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nazev", nullable = false, length = 60)
    private String nazev;

    @Column(name = "album", nullable = false, length = 40)
    private String album;

    @Column(name = "rok_vydani")
    private Integer rokVydani;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Integer getRokVydani() {
        return rokVydani;
    }

    public void setRokVydani(Integer rokVydani) {
        this.rokVydani = rokVydani;
    }

}