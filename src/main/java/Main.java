import cz.cvut.fel.dbs.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

// Z DŮVODU NEVHODNÝCN TABULKOVÝCH STRUKTUR JE ZDE UVEDENA JEN ČÁST ENTIT
public class Main {
    public static void main(String[] args){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("examplePU");
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction;


        // CREATE
        entityTransaction = manager.getTransaction();
        entityTransaction.begin();
        Navstevnik navstevnik = new Navstevnik().bind(manager);
        navstevnik.setEmail("novymail@novy.com");
        navstevnik.create();
        entityTransaction.commit();


        // READ & UPDATE
        entityTransaction = manager.getTransaction();
        entityTransaction.begin();
        Jmeno jmeno = new Jmeno().bind(manager).readOne("kralik007707@gmail.com");
        System.out.println(jmeno.getKrestni_jmeno());
        System.out.println(jmeno.getPrijmeni());
        jmeno.setKrestni_jmeno("Jana");
        jmeno.setPrijmeni("Králíková");
        jmeno.bind(manager);
        jmeno.update();
        System.out.println(jmeno.getKrestni_jmeno());
        System.out.println(jmeno.getPrijmeni());
        entityTransaction.commit();


        // READ & DELETE
        entityTransaction = manager.getTransaction();
        entityTransaction.begin();
        Navstevnik navstevnik1 = new Navstevnik().bind(manager).readOne("novymail@novy.com");
        navstevnik1.bind(manager);
        navstevnik1.delete();
        entityTransaction.commit();


        // REVERTED UPDATE
        entityTransaction = manager.getTransaction();
        entityTransaction.begin();
        Jmeno jmeno1 = new Jmeno().bind(manager).readOne("kralik007707@gmail.com");
        System.out.println(jmeno1.getKrestni_jmeno());
        System.out.println(jmeno1.getPrijmeni());
        jmeno1.setPrijmeni("Králík");
        jmeno1.bind(manager);
        jmeno1.update();
        System.out.println(jmeno1.getKrestni_jmeno());
        System.out.println(jmeno1.getPrijmeni());
        entityTransaction.commit();


        // CREATE & READ & UPDATE & DELETE
        entityTransaction = manager.getTransaction();
        entityTransaction.begin();
        Navstevnik navstevnik2 = new Navstevnik().bind(manager);
        navstevnik2.setEmail("jsemtunovy@faktzejo.com");
        navstevnik2.create();
        navstevnik2.update();
        System.out.println(navstevnik2.getEmail());

        Navstevnik navstevnik3 = new Navstevnik().bind(manager).readOne("jsemtunovy@faktzejo.com");
        navstevnik3.bind(manager);
        navstevnik3.setEmail("takuzne@faktzene.com");
        navstevnik3.update();
        System.out.println(navstevnik3.getEmail());

        Navstevnik navstevnik4 = new Navstevnik().bind(manager).readOne("takuzne@faktzene.com");
        navstevnik4.bind(manager);
        navstevnik4.delete();
        System.out.println("User was deleted");
        entityTransaction.commit();


        // TRANSACTION
        /*
        BEGIN ISOLATION LEVEL READ COMMITTED
        INSERT INTO navstevnik (email) VALUES ('bekeoluc@fel.cvut.cz');
        INSERT INTO listek (kod, typ, cena, festival, navstevnik)
        VALUES ('20240489', 'VIP', '1330', 'Fuji Rock', 'bekeoluc@fel.cvut.cz');
        COMMIT
         */

        entityTransaction = manager.getTransaction();
        entityTransaction.begin();

        Navstevnik tr_navstevnik = new Navstevnik().bind(manager);
        tr_navstevnik.setEmail("bekeoluc@fel.cvut.cz");
        tr_navstevnik.create();

        HudebniFestival hudebniFestival = new HudebniFestival().bind(manager).readOne("Fuji Rock");
        hudebniFestival.bind(manager);

        Listek tr_listek = new Listek().bind(manager);
        tr_listek.setId(20240489);
        tr_listek.setTyp("VIP");
        tr_listek.setCena(1330);
        tr_listek.setFestival(hudebniFestival);
        tr_listek.setNavstevnik(tr_navstevnik);
        tr_listek.create();

        tr_navstevnik.update();
        tr_listek.update();

        System.out.println(tr_navstevnik.getEmail());
        System.out.println(tr_listek.getId());
        System.out.println(tr_listek.getTyp());
        System.out.println(tr_listek.getCena());
        System.out.println(tr_listek.getFestival().getNazev());
        System.out.println(tr_listek.getNavstevnik().getEmail());
        entityTransaction.commit();

        // REVERTED TRANSACTION
        entityTransaction = manager.getTransaction();
        entityTransaction.begin();

        Listek listek = new Listek().bind(manager).readOne(20240489);
        listek.bind(manager);
        listek.delete();
        System.out.println("Ticket was deleted");

        Navstevnik navstevnik5 = new Navstevnik().bind(manager).readOne("bekeoluc@fel.cvut.cz");
        navstevnik5.bind(manager);
        navstevnik5.delete();
        System.out.println("User was deleted");
        entityTransaction.commit();

        // TEST DĚDIČNOSTI
        /*
        entityTransaction = manager.getTransaction();
        entityTransaction.begin();
        Sponzor sponzor = new Sponzor().bind(manager).readOne(690718);
        sponzor.bind(manager);
        System.out.println(sponzor.getOrganizator().getRodneCislo());
        entityTransaction.commit();
         */
    }
}
