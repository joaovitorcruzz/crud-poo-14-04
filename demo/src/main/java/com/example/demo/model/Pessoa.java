package com.example.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;
    private double idade;
    private String working = "Pendente";

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Trabalho> trabalhos;


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getIdade() {
        return idade;
    }

    public String getStatus() {
        return working;
    }

    public void setWorking(String status) {
        this.working = status;
    }
}