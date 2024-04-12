package org.example.banco;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Conexao {
    private static EntityManager entityManager;

    private Conexao(){}

    public static EntityManager getEntityManager(){
        if(entityManager == null) {
            entityManager = Persistence.createEntityManagerFactory("Escola").createEntityManager();
        }
        return entityManager;
    }
}
