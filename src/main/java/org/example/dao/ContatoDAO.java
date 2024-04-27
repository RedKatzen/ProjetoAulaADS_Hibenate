package org.example.dao;

import jakarta.persistence.Query;
import org.example.entidades.Contato;

import java.util.List;

public class ContatoDAO extends DAOGenerics <Contato, Integer> {
    public ContatoDAO() throws Exception {
        super(Contato.class);
    }

    public List<Contato> obterListaPorTipo(String tipo) {
        String consulta = "from Contato a where a.tipo = '" + tipo + "'";
        Query query = getEntityManager().createQuery(consulta);
        return query.getResultList();
    }
}
