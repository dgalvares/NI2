/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unama.atividadeunama.dao;

import com.unama.atividadeunama.model.Usuario;
import com.unama.atividadeunama.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author douglas
 */
public class UsuarioDao {
    public static boolean salvar(Usuario usuario) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(usuario);
        transaction.commit();
        return true;
    }

    public static boolean update(Usuario usuario) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.update(usuario);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static List<Usuario> listarTodos() {
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Usuario.class);
        return criteria.list();
    }

    public static Usuario obterPorId(long id) {
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("id", id));
        List<Usuario> usuarios = criteria.list();
        if (usuarios.isEmpty()) {
            return null;
        }
        return usuarios.get(0);
    }

    public static Usuario obterPorNome(String nome) {
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("nome", nome));
        List<Usuario> usuarios = criteria.list();
        if (usuarios.isEmpty()) {
            return null;
        }
        return usuarios.get(0);
    }
}
