package pierpaolo.dao;

import pierpaolo.entities.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDAO {
    private final EntityManager em; // Tutti i metodi qua sotto avranno bisogno dell'EntityManager poichè dovranno interagire col DB

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("Evento " + evento.getTitolo() + " generato!");
    }

    public Evento findById(long id){
        // SELECT * FROM students WHERE id = 1
        return em.find(Evento.class, id);
        // Primo parametro è l'Entity, secondo l'id da ricercare
    }
}
