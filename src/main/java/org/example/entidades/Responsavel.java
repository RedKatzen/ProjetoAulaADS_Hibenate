package org.example.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "responsavel")
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "endereco")
    private String endereco;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "aluno_responsavel", joinColumns = @JoinColumn(name = "responsavel_id"),
                                        inverseJoinColumns = @JoinColumn(name = "aluno_id"))
    private List<Aluno> alunos;
}
