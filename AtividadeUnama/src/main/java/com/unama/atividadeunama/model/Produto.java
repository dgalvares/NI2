/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unama.atividadeunama.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author douglas
 */
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    private String nome;

    private String descricao;

    private String img;

    private double valor;

    private boolean status;

    private int quantidade;
    
    private Timestamp datacad;
    
    private Timestamp lastupdate;

    public Produto() {

    }

    public Produto(String nome, String descricao, double valor, int quantidade, Timestamp datacad) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
        this.datacad = datacad;
    }

    public Produto(String nome, String descricao, double valor, int quantidade, Timestamp datacad, String img) {
        this.nome = nome;
        this.descricao = descricao;
        this.img = img;
        this.valor = valor;
        this.quantidade = quantidade;
        this.datacad = datacad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Timestamp getDatacad() {
        return datacad;
    }

    public void setDatacad(Timestamp datacad) {
        this.datacad = datacad;
    }

    public Timestamp getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Timestamp lastupdate) {
        this.lastupdate = lastupdate;
    }

}
