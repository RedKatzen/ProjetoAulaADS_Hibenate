package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.example.dao.AlunoDAO;
import org.example.dao.ProfessorDAO;
import org.example.dao.TurmaDAO;
import org.example.entidades.Aluno;
import org.example.entidades.Professor;
import org.example.entidades.Turma;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public class App {
    public static void main( String[] args ) throws Exception{
        criarAluno();
        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno aluno = alunoDAO.obterPorId(2);

        System.out.println(aluno.getNome());
        System.out.println(aluno.getCpf());
        System.out.println(aluno.getNumeroMatricula());

        List<Turma> turmas = aluno.getTurmas();


        turmas.forEach(turma -> {
            System.out.println("-----------------");
            System.out.println(turma.getSemestre());
            System.out.println(turma.getProfessor().getNome());
        });
    }

    public static void criarAluno() throws Exception {
        TurmaDAO turmaDao = new TurmaDAO();
        Turma turma = turmaDao.obterPorId(2);

        AlunoDAO alunoDAO = new AlunoDAO();
        //Aluno aluno = new Aluno();
        Aluno aluno = alunoDAO.obterPorId(2);

//        aluno.setNome("Jilson");
//        aluno.setCpf("01571224");
//        aluno.setNumeroMatricula("00189");
//        aluno.setEndereco("Rua Manilda");
//        aluno.setNascimento(LocalDate.of(2001, 10, 4));
//
//
//        alunoDAO.insere(aluno);
        aluno.addTurma(turma);
    }

    public static void operacoesAluno() throws Exception {
        AlunoDAO alunoDAO = new AlunoDAO();
        List<Aluno> alunos = alunoDAO.obterTodos();

        alunos.forEach(aluno -> {
            System.out.println(aluno.getNome());
        });
    }

    public static Professor criarProfessor() throws Exception {
        ProfessorDAO professorDAO = new ProfessorDAO();
        Professor professor = new Professor();

        professor.setNome("Wilson");
        professorDAO.insere(professor);
        return professor;
    }

    public static void criarTurma() throws Exception {
        TurmaDAO turmaDAO = new TurmaDAO();
        Turma turma = new Turma();
        Turma turma1 = new Turma();
        Turma turma2 = new Turma();

        turma.setSemestre("2/2024");
        turma.setProfessor(criarProfessor());
        turmaDAO.insere(turma);

        turma1.setSemestre("1/2024");
        turma1.setProfessor(criarProfessor());
        turmaDAO.insere(turma1);

        turma2.setSemestre("2/2024");
        turma2.setProfessor(criarProfessor());
        turmaDAO.insere(turma2);
    }

    public static void teste2() throws Exception {
        //criarTurma();
        TurmaDAO turmaDAO = new TurmaDAO();
        List<Turma> turmas = turmaDAO.obterPorSemestre("1/2024");

        turmas.forEach(turma -> {
            System.out.println(turma.getId());
            System.out.println(turma.getSemestre());
            System.out.println(turma.getProfessor().getNome());
            System.out.println("----------------------");
        });
    }
}
