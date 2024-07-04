package cz.cvut.fel.dbs;

import javax.persistence.*;

@Entity
@Table(name = "je_organizovan")
public class JeOrganizovan {
    @Id
    @Column(name = "organizator", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "organizator", nullable = false)
    private Organizator organizator;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "festival", nullable = false)
    private HudebniFestival festival;

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

    public HudebniFestival getFestival() {
        return festival;
    }

    public void setFestival(HudebniFestival festival) {
        this.festival = festival;
    }

}