package cz.cvut.fel.dbs;

import javax.persistence.*;

@Entity
@Table(name = "podium")
public class Podium {
    @Id
    @Column(name = "oznaceni", nullable = false, length = 30)
    private String oznaceni;

    @Column(name = "misto", nullable = false, length = 30)
    private String misto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "festival", nullable = false)
    private HudebniFestival festival;

    public String getOznaceni() {
        return oznaceni;
    }

    public void setOznaceni(String oznaceni) {
        this.oznaceni = oznaceni;
    }

    public String getMisto() {
        return misto;
    }

    public void setMisto(String misto) {
        this.misto = misto;
    }

    public HudebniFestival getFestival() {
        return festival;
    }

    public void setFestival(HudebniFestival festival) {
        this.festival = festival;
    }

}