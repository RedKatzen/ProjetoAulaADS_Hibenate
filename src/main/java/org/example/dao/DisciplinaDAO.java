package org.example.dao;

import jakarta.persistence.Query;
import org.example.entidades.Disciplina;

public class DisciplinaDAO extends DAOGenerics <Disciplina, Integer> {
    public DisciplinaDAO() throws Exception {
        super(Disciplina.class);
    }

    public Disciplina obterPorNome(String nome) {
        String consulta = "from Disciplina a where a.nome = '" + nome + "'";
        Query query = getEntityManager().createQuery(consulta);
        return (Disciplina) query.getSingleResult();
    }
}
