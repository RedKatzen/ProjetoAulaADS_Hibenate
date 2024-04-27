package org.example.entidades;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "numero_matricula")
    private String numeroMatricula;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "nascimento")
    private LocalDate nascimento;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "aluno_turma", joinColumns = @JoinColumn(name="aluno_id"),
                                    inverseJoinColumns = @JoinColumn(name="turma_id"))
    private List<Turma> turmas;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<Contato> contatos;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "aluno_responsavel", joinColumns = @JoinColumn(name = "aluno_id"),
                                            inverseJoinColumns = @JoinColumn(name = "responsavel_id"))
    private Responsavel responsavel;

    public Aluno(String nome, String numeroMatricula, String cpf, String endereco, LocalDate nascimento) {
        this.nome = nome;
        this.numeroMatricula = numeroMatricula;
        this.cpf = cpf;
        this.endereco = endereco;
        this.nascimento = nascimento;
    }

    public Aluno() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void addTurma(Turma turma) {
        if(this.turmas == null) {
            this.turmas = new ArrayList<>();
        }
        this.turmas.add(turma);
        turma.addAluno(this);
    }
//    public void setTurmas(List<Turma> turmas) {
//        this.turmas = turmas;
//    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", numeroMatricula='" + numeroMatricula + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                ", nascimento=" + nascimento +
                '}';
    }
}