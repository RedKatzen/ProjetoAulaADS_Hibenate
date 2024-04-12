package org.example.entidades;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "coordenador")
    private String coordenador;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "curso_disciplina", joinColumns = @JoinColumn(name = "curso_id"),
                                        inverseJoinColumns = @JoinColumn(name = "disciplina_id"))
    private List<Disciplina> disciplinas;

    public Curso(int id, String nome, String coordenador) {
        this.id = id;
        this.nome = nome;
        this.coordenador = coordenador;
    }

    public Curso() {}

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void addDisciplinas(Disciplina disciplina) {
        if(this.disciplinas == null) {
            disciplinas = new ArrayList<>();
        }
        this.disciplinas.add(disciplina);
        disciplina.setCurso(this);
    }

//    public void setDisciplinas(List<Disciplina> disciplinas) {
//        this.disciplinas = disciplinas;
//    }
}
