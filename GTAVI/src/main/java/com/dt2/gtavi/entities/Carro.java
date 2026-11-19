package com.dt2.gtavi.entities;

import jakarta.persistence.*;

@Entity
public class Carro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String marca;
    private String categoria;
    @Column(columnDefinition = "TEXT")
    private String imagem;
    private String descricao;

    public Carro(int id, String nome, String marca, String categoria, String imagem, String descricao) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.categoria = categoria;
        this.imagem = imagem;
        this.descricao = descricao;
    }

    public Carro(String nome, String marca, String categoria, String imagem, String descricao) {
        this.nome = nome;
        this.marca = marca;
        this.categoria = categoria;
        this.imagem = imagem;
        this.descricao = descricao;
    }

    public Carro(){}

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
