/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unama.atividadeunama.teste;

import com.unama.atividadeunama.dao.ProdutoDao;
import com.unama.atividadeunama.model.Produto;
import java.sql.Timestamp;
import java.time.Instant;

/**
 *
 * @author douglas
 */
public class TesteConexao {
    public static void main(String[] args) {
        Produto produto;
        produto = new Produto("teste", "teste", 10, 10, Timestamp.from(Instant.now()));
        ProdutoDao.salvar(produto);
    }
            
}
