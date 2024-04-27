package org.example.entidades;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "semestre") // 1/2024 ou 2/2024
    private String semestre;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="aluno_turma", joinColumns = @JoinColumn(name="turma_id"),
                                    inverseJoinColumns = @JoinColumn(name="aluno_id"))
    private List<Aluno> alunos;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="professor_id")
    private Professor professor;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "disciplina_turma", joinColumns = @JoinColumn(name = "turma_id"),
                                        inverseJoinColumns = @JoinColumn(name = "disciplina_id"))
    private List<Disciplina> disciplinas;

    public Turma(String semestre) {
        this.semestre = semestre;
    }

    public Turma() {}

    public int getId() {
        return id;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void addAluno(Aluno aluno) {
        if(this.alunos == null) {
            alunos = new ArrayList<>();
        }
        alunos.add(aluno);
    }

//    public void setAlunos(List<Aluno> alunos) {
//        this.alunos = alunos;
//    }

    public Professor getProfessor() {
        return this.professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
        professor.addTurma(this);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void addDisciplina(Disciplina disciplina) {
        if(this.disciplinas == null) {
            disciplinas = new ArrayList<>();
        }
        disciplinas.add(disciplina);
    }

    @Override
    public String toString() {
        return "Turma{" +
                "id=" + id +
                ", semestre='" + semestre + '\'' +
                ", alunos=" + alunos +
                ", professor=" + professor +
                ", disciplinas=" + disciplinas +
                '}';
    }
}
