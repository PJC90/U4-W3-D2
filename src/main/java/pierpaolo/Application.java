package pierpaolo;

import pierpaolo.dao.EventoDAO;
import pierpaolo.entities.Evento;
import pierpaolo.entities.EventoType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d2jpa");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO ed = new EventoDAO(em);

        Evento battesimo = new Evento("Pippo","02-05-2024","Battesimo", EventoType.PUBBLICO,200);
//----------------------------------------------SAVE
//        ed.save(battesimo);
// ---------------------------------------------FIND BY ID
        long id = 1;
        Evento battesimoFindById = ed.findById(id);
        if(battesimoFindById != null){
            System.out.println(battesimoFindById);
        } else {
            System.out.println("Evento di ID " + id + " non trovato");
        }

    }
}
