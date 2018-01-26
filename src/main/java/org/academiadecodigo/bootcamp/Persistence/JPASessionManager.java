package org.academiadecodigo.bootcamp.Persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public class JPASessionManager {


    @PersistenceUnit(unitName = "unit")
    private EntityManagerFactory emf;//= ServiceRegistry.getInstance().getEmf();
    private EntityManager em;

    public JPASessionManager(EntityManagerFactory emf) {
        this.emf = emf;

    }

    public JPASessionManager(){}

    public void startSession() {

        if (em == null) {
            em = emf.createEntityManager();
        }
    }

    public void stopSession() {

        if (em != null) {
            em.close();
        }

        em = null;
    }

    public EntityManager getCurrentSession() {
        startSession();
        return em;
    }


}
