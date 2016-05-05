/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unama.atividadeunama.dao;

import com.unama.atividadeunama.model.Produto;
import com.unama.atividadeunama.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author douglas
 */
public class ProdutoDao {

    public static boolean salvar(Produto produto) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(produto);
        transaction.commit();
        return true;
    }

    public static boolean update(Produto produto) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.update(produto);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static List<Produto> listarTodos() {
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Produto.class);
        return criteria.list();
    }

    public static Produto obterPorId(long id) {
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Produto.class);
        criteria.add(Restrictions.eq("id", id));
        List<Produto> produtos = criteria.list();
        if (produtos.isEmpty()) {
            return null;
        }
        return produtos.get(0);
    }

    public static Produto obterPorNome(String nome) {
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Produto.class);
        criteria.add(Restrictions.eq("nome", nome));
        List<Produto> produtos = criteria.list();
        if (produtos.isEmpty()) {
            return null;
        }
        return produtos.get(0);
    }
}
