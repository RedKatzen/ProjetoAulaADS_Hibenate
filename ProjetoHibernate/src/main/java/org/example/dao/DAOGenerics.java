package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.banco.Conexao;

import java.util.List;

// Classe generica que implementa o DAO (interface)
// Esta classe implementa comandos do hibernate
// Se trocar de hibernate, apenas esta classe sera modificada

// T (generico) -> entidade (ex. Aluno substituira o T)
// U (generico) -> o tipo de dado (ex. U id -> Integer id) - sera substituido
public class DAOGenerics <T, U> implements DAO <T, U>{

    private EntityManager entityManager;
    private Class<T> entityType;

    public DAOGenerics(Class<T> persistedClass) throws Exception {
        entityManager = Conexao.getEntityManager();
        entityType = persistedClass;
    }

    @Override
    public T obterPorId(U id) throws Exception {
        T objeto = entityManager.find(entityType, id);
        return objeto;
    }

    @Override
    public List<T> obterTodos() throws Exception {
        String consulta = "from Aluno";
        Query query = entityManager.createQuery(consulta);
        return query.getResultList();
    }

    @Override
    public void insere(T objeto) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.persist(objeto);
        entityManager.getTransaction().commit();
    }

    @Override
    public void atualiza(T objeto) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.merge(objeto);
        entityManager.getTransaction().commit();
    }

    @Override
    public void remove(T objeto) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.remove(objeto);
        entityManager.getTransaction().commit();
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }
}
