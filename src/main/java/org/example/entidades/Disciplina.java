package org.example.entidades;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "disciplina")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "codigo")
    private int codigo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "curso_disciplina", joinColumns = @JoinColumn(name = "disciplina_id"),
                                        inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private Curso curso;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "disciplina_turma", joinColumns = @JoinColumn(name = "disciplina_id"),
                                        inverseJoinColumns = @JoinColumn(name = "turma_id"))
    private List<Turma> turmas;

    public Disciplina(int id, String nome, int codigo) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
    }

    public Disciplina() {}

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void addTurma(Turma turma) {
        if(this.turmas == null) {
            turmas = new ArrayList<>();
        }
        turmas.add(turma);
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", codigo=" + codigo +
                ", curso=" + curso +
                ", turmas=" + turmas +
                '}';
    }
}