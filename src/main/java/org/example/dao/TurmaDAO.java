package org.example.dao;

import org.example.entidades.Turma;

import jakarta.persistence.Query;

import java.util.List;

public class TurmaDAO extends DAOGenerics <Turma, Integer>{
    public TurmaDAO() throws Exception {
        super(Turma.class);
    }

    public List<Turma> obterPorSemestre(String semestre) {
        String consulta = "from Turma a where a.semestre = '" + semestre + "'";
        Query query = getEntityManager().createQuery(consulta);
        return query.getResultList();
    }
}
