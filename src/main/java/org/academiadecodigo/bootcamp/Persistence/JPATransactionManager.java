package org.academiadecodigo.bootcamp.Persistence;


public class JPATransactionManager implements TransactionManager {

    //It's not being used right now
    private JPASessionManager sm;

    public JPATransactionManager(JPASessionManager session) {
        this.sm=session;
    }


    @Override
    public void beginRead() {
        sm.startSession();
    }

    @Override
    public void beginWrite() {
        sm.getCurrentSession().getTransaction().begin();
    }

    @Override
    public void commit() {
        if (sm.getCurrentSession().getTransaction().isActive()) {
            sm.getCurrentSession().getTransaction().commit();
        }

        sm.stopSession();
    }

    @Override
    public void rollback() {
        if (sm.getCurrentSession().getTransaction().isActive()) {
            sm.getCurrentSession().getTransaction().rollback();
        }

        sm.stopSession();
    }



}
