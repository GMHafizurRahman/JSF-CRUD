package com.controller;

import com.hibernatUtil.HibernateUtil;
import com.hibernatUtil.NewHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import com.model.Users;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean(name = "c")
@RequestScoped
public class Controller {

    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

    public String save(Users user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();                     //.openSession();
       
        Transaction tx = null;
        int result = 0;
       try {
            tx = session.beginTransaction();
            session.merge(user);
            tx.commit();
            result=1;
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();}            
        } finally {
            //session.close();
        }

        if (result != 0) {
            return "index.xhtml?faces-redirect=true";
        } else {
            return "create.xhtml?faces-redirect=true";
        }
    }

    public List<Users> usersList() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();//.openSession();
        List<Users> list = new ArrayList<>();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query qu = session.createQuery("From Users");                                               //User is the entity not the table  
            list = (ArrayList) qu.list();
            int count = list.size();
        } catch (Exception e) {
            System.out.println("UserList Exception found = "+e);
            e.printStackTrace();
            if (tx != null) {
                tx.commit();}
        } finally {
            session.close();
        }
        return list;
    }

    public String edit(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession(); //.openSession();
        Users user;// = new Users();  
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query qu = session.createQuery("From  Users u where u.id=" + id); //from u
            user = (Users) qu.uniqueResult();
            sessionMap.put("editUser", user);
//           Users o = (Users) sessionMap.get("editUser");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }

        return "edit.xhtml?faces-redirect=true";
    }

    public String update(Users  u) {
        Transaction tx = null;
        try {
            Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();//.openSession();
            tx = session.beginTransaction();

            session.update(u);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }

        }
        return "/index.xhtml?faces-redirect=true";
    }

    public String delete(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();//.openSession();
        Transaction tx = null;
        Users user = null;
        try {
            tx = session.beginTransaction();
            // Query q = session.createQuery( "delete from users u where u.id=" + id);
            Users us = (Users) session.load(Users.class, new Integer(id));

            session.delete(us);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            //session.close();
        }
        return "/index.xhtml?faces-redirect=true";
    }

}
