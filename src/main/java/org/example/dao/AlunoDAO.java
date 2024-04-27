package org.example.dao;

import org.example.entidades.Aluno;

import jakarta.persistence.Query;

public class AlunoDAO extends DAOGenerics <Aluno, Integer>{
    public AlunoDAO() throws Exception{
        super(Aluno.class);
    }

    public Aluno obterPorCpf(String cpf){
        String consulta = "from Aluno a where a.cpf = '" + cpf + "'";
        Query query = getEntityManager().createQuery(consulta);
        return (Aluno) query.getSingleResult();
    }
}
