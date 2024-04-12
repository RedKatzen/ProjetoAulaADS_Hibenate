package org.example.dao;

import org.example.entidades.Professor;

public class ProfessorDAO extends DAOGenerics <Professor, Integer> {

    public ProfessorDAO() throws Exception{
        super(Professor.class);
    }


}
