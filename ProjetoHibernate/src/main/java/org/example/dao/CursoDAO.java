package org.example.dao;

import jakarta.persistence.Query;
import org.example.entidades.Curso;

public class CursoDAO extends DAOGenerics <Curso, Integer> {
    public CursoDAO() throws Exception {
        super(Curso.class);
    }

    public Curso obterPeloCoordenador(String coordenador){
        String consulta = "from Curso a where a.coordenador = '" + coordenador + "'";
        Query query = getEntityManager().createQuery(consulta);
        return (Curso) query.getSingleResult();
    }
}
