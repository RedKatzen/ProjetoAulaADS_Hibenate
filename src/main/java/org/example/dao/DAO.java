package org.example.dao;


import java.util.List;

// T (generico) -> entidade (ex. Aluno substituira o T)
// U (generico) -> o tipo de dado (ex. U id -> Integer id) - sera substituido
public interface DAO <T, U>{
    public T obterPorId(U id) throws Exception;
    public List<T> obterTodos() throws Exception;
    public void insere(T objeto) throws Exception;
    public void atualiza(T objeto) throws Exception;
    public void remove(T objeto) throws Exception;
}
