package org.example.dao;

import jakarta.persistence.Query;
import org.example.entidades.Disciplina;
import org.example.entidades.Responsavel;

public class ResponsavelDAO extends DAOGenerics <Responsavel, Integer> {
    public ResponsavelDAO() throws Exception{
        super(Responsavel.class);
    }

    public Responsavel obterPorEndereco(String endereco) {
        String consulta = "from Responsavel a where a.endereco = '" + endereco + "'";
        Query query = getEntityManager().createQuery(consulta);
        return (Responsavel) query.getSingleResult();
    }
}
