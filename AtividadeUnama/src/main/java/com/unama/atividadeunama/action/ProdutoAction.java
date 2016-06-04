/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unama.atividadeunama.action;

import com.opensymphony.xwork2.ActionSupport;
import com.unama.atividadeunama.dao.ProdutoDao;
import com.unama.atividadeunama.model.Produto;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author douglas
 */
@Namespace("/Produto")
@Result(name = "success", type = "json")
@ParentPackage("json-default")
public class ProdutoAction extends ActionSupport {

    private String nome;
    private String descricao;
    private String img;
    private double valor;
    private int quantidade;
    private int code;
    private String msg;
    private List<Produto> produtos = new ArrayList<>();
    /*code=0 -> no erro
     code=10 -> produto nao existe no sistema
     code=11 -> produto ja existe no sistema*/

    @Action("salvar")
    public String salvar() {
        if (ProdutoDao.obterPorNome(nome) != null) {
            code = 11;
            msg = "produto já existe no sistema";
        } else {
            Timestamp timestamp = Timestamp.from(Instant.now());
            Produto produto = new Produto(nome, descricao, valor, quantidade,timestamp);
            produto.setStatus(true);
            produto.setLastupdate(timestamp);
            ProdutoDao.salvar(produto);
            code = 0;
        }
        return SUCCESS;
    }

    @Action("excluir")
    public String excluir() {
        Produto produto = ProdutoDao.obterPorNome(nome);
        if (produto != null) {
            produto.setStatus(false);
            ProdutoDao.update(produto);
            code = 0;
        } else {
            code = 10;
            msg = "produto não existe no sistema";
        }
        return SUCCESS;
    }

    @Action("atualizar")
    public String atualizar() {
        Produto produto = ProdutoDao.obterPorNome(nome);
        if (produto != null) {
            produto.setDescricao(descricao);
            produto.setImg(img);
            produto.setQuantidade(quantidade);
            produto.setValor(valor);
            produto.setLastupdate(Timestamp.from(Instant.now()));
            ProdutoDao.update(produto);
            code = 0;
        } else {
            code = 10;
            msg = "produto não existe no sistema";
        }
        return SUCCESS;
    }

    @Action("listarTodos")
    public String listarTodos() {
        produtos = ProdutoDao.listarTodos();
        code = 0;
        return SUCCESS;
    }

    @Action("listarDisponiveis")
    public String listarDisponiveis() {
        List<Produto> list = ProdutoDao.listarTodos();
        for (Produto produto : list) {
            if (produto.getStatus()) {
                produtos.add(produto);
            }
        }
        code = 0;
        return SUCCESS;
    }

    @Action("listarExcluidos")
    public String listarExcluidos() {
        List<Produto> list = ProdutoDao.listarTodos();
        for (Produto produto : list) {
            if (!produto.getStatus()) {
                produtos.add(produto);
            }
        }
        code = 0;
        return SUCCESS;
    }

    public void setNome(String nome) {
        System.out.println("executou metodo setNome");
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getCode() {
        return code;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public String getMsg() {
        return msg;
    }

}
