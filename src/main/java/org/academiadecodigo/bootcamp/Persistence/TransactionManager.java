package org.academiadecodigo.bootcamp.Persistence;

public interface TransactionManager {


    void beginRead();

    void beginWrite();

    void commit();

    void rollback();
    

}
