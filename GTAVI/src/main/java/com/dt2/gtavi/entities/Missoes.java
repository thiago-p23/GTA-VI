package com.dt2.gtavi.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.EmbeddedColumnNaming;

@Entity
public class Missoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String local;
    private String difculdade;
    @Column(columnDefinition = "TEXT")
    private String imagem;
    private String descricao;

    public Missoes(int id, String nome, String local, String difculdade, String imagem, String descricao) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.difculdade = difculdade;
        this.imagem = imagem;
        this.descricao = descricao;
    }

    public Missoes(String nome, String local, String difculdade, String imagem, String descricao) {
        this.nome = nome;
        this.local = local;
        this.difculdade = difculdade;
        this.imagem = imagem;
        this.descricao = descricao;
    }
    public Missoes(){}

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDifculdade() {
        return difculdade;
    }

    public void setDifculdade(String difculdade) {
        this.difculdade = difculdade;
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
