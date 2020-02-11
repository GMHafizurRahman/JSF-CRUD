package com.model;
import java.io.Serializable;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

@ManagedBean(name = "u")
@RequestScoped
@Entity
@Table(name = "users", catalog = "test")
@Access(value = AccessType.FIELD)
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @OneToOne(mappedBy = "Users")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    int id;
    @Column(name = "name", length = 100)
    String name;
    @Column(name = "email", length = 50)
    String email;
    @Column(name = "password", length = 20)
    String password;
    @Column(name = "gender", length = 1)
    String gender;
    @Column(name = "address", length = 65535)
    String address;

//     private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

    public Users() {
    }

    public Users(String name, String email, String password, String gender, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.address = address;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//  public String update(Users u){
//        //int result = 0;
//        try{
//            con =db.getConnection();  
//            PreparedStatement ptmt=con.prepareStatement("update users set name=?,email=?,password=?,gender=?,address=? where id=?");  
//            ptmt.setString(1,u.getName());  
//            ptmt.setString(2,u.getEmail());  
//            ptmt.setString(3,u.getPassword());  
//            ptmt.setString(4,u.getGender());  
//            ptmt.setString(5,u.getAddress());  
//            ptmt.setInt   (6,u.getId());  
//            ptmt.executeUpdate();
//            
//        }catch(Exception e){
//            System.out.println(e);
//        }finally{
//        db.close(con, stmt, rs);
//        }
//        return "/index.xhtml?faces-redirect=true";      
//    }  
    
    
    
//    public String update(Users u) {
//          Transaction tx=null;
//        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            tx=session.beginTransaction();
////          Query qu = session.createQuery("update Users a where a.id="+u.id);
////          int i= qu.executeUpdate();
////          session.merge(u);
//            session.update(u);
//            tx.commit();
//        } catch (HibernateException e) {
//            System.out.println(e);
//            e.printStackTrace();
//            if(tx !=null){tx.rollback();}
//            
//        }
//        return "/index.xhtml?faces-redirect=true";
//    }

    
    
//public String edit(int id){
//         Users user = new Users();
//        System.out.println("edit  \t id="+id);
//    try { 
//        
//        con=db.getConnection();
//        stmt=con.createStatement();
//        rs=stmt.executeQuery("select * from users where id="+id);
//        rs.next();
//        
//        
//        user.setId(rs.getInt("id"));
//        user.setName(rs.getString("name"));
//        user.setAddress(rs.getString("address"));
//        user.setEmail(rs.getString("email"));
//        user.setGender(rs.getString("gender"));
//        user.setPassword(rs.getString("password"));
//        
//        sessionMap.put("editUser", user);
//        
//        
//        
//    } catch (Exception e) {
//        System.out.println(e);
//    } finally{
//              db.close(con, stmt, rs);
//    }
//    
//
//return "edit.xhtml?faces-redirect=true";
//} 
    
    
//    public String edit(int id) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Users user;// = new Users();  
//          Transaction tx=null;
//        try {
//            tx = session.beginTransaction();
//            Query qu = session.createQuery("From  Users u where u.id=" + id); //from u
//            user = (Users) qu.uniqueResult();
//            sessionMap.put("editUser", user);
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        }
//
////sessionMap.put("editUser", user);
//        return "edit.xhtml?faces-redirect=true";
//    }

//    public ArrayList usersList(){
//     Users m;
//        
//        try{ 
//            
//            usersList = new ArrayList();
//            con  = db.getConnection();
//            stmt = con.createStatement();  
//            rs   = stmt.executeQuery("select * from users");  
//            while(rs.next()){
//                m = new Users();
//                m.setId(rs.getInt("id"));
//                m.setName(rs.getString("name"));
//                m.setEmail(rs.getString("email"));
//                m.setPassword(rs.getString("password"));
//                m.setGender(rs.getString("gender"));
//                m.setAddress(rs.getString("address"));
//                usersList.add(m);
//            }
//            
//        }catch(Exception e){
//            System.out.println(e);
//        }finally{
//          db.close(con, stmt, rs);
//        }
//        return usersList;
//    }   
    // *********************************************************
   
    
    
    
    
    
    
//    public List<Users> usersList() {
//
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        List<Users> list = new ArrayList<>();
//        Transaction tx=null;
//        try {
//              tx   = session.beginTransaction();
//            Query qu = session.createQuery("From Users");                                               //User is the entity not the table  
//            //qu.setParameter("recordNo", RecordNo);  
//            list = (ArrayList) qu.list();
//            int count = list.size();
//            } catch (Exception e) {
//            e.printStackTrace();
//            if( tx !=null){
//               tx.commit();
//            }
//        } finally {
//            session.close();
//        }
//        return list;
//    }

    
    
    
    
//         Transaction tx = null;
//       List< Users> list = new ArrayList<>();
//        try {
//            Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
//            tx = session.beginTransaction();
//            Query q = session.createQuery("select  a from Emp a ");
//
//            list = q.list();
//            tx.commit();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            
//        } finally {
//            
//        }
//    return list;
//         }
//       public void delete(int id){
//        try{
//              con = db.getConnection();  
//              stmt = con.createStatement();  
//              stmt.execute("delete from users where id ="+id);  
//        }catch(Exception e){
//            System.out.println(e);
//        }
//    }
    
    
//    
//    public String delete( int id) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = null;
//        Users user = null;
//        try {
//            tx = session.beginTransaction();
//           // Query q = session.createQuery( "delete from users u where u.id=" + id);
//           Users us = (Users) session.load(Users.class, new Integer(id));
//
//            session.delete(us);
//            tx.commit();
//        } catch (Exception e) {
//            System.out.println(e);
//            if (tx != null) {
//                tx.rollback();
//            }
//        } finally {
//            session.close();
//        }
//        return "/index.xhtml?faces-redirect=true";
//    }

//    public String getGenderName(char gender) {
//        if (gender == 'M') {
//            return "Male";
//        } else {
//            return "Female";
//        }
//    }

//public String save(){
//        int result = 0;
//        try{
//            con =db.getConnection();
//            PreparedStatement stmt = con.prepareStatement("insert into users(name, email, password, gender, address) values(?, ?, ?, ?, ?)");
//            stmt.setString(1, name);
//            stmt.setString(2, email);
//            stmt.setString(3, password);
//            stmt.setString(4, gender);
//            stmt.setString(5, address);
//            result = stmt.executeUpdate();
//            
//        }catch(Exception e){
//            System.out.println(e);
//        }finally{
//        db.close(con, stmt, rs);
//        }
//        if(result !=0)
//            return "index.xhtml?faces-redirect=true";
//        else {
//            return "create.xhtml?faces-redirect=true";
//        }
//    }
//    public String save(Users user) {
//        int result = 0;
//
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            // do some work
//            session.merge(user);
//            tx.commit();
//        } catch (Exception e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }

////    Session session = HibernateUtil.getSessionFactory().openSession();
//    Session session = NewHibernateUtil.getSessionFactory().openSession();
//    try{
//        session.beginTransaction();
//        session.merge(user);
//        //SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
//	//result =  (int) session.save(user);
//            System.out.println("1. Employee save called without transaction, id="+id);
//                session.flush(); //address will not get saved without this
//		System.out.println("*****");
//                 
//         
//    }catch(HibernateException e){
//    
//    e.printStackTrace();
//    }
//        if (result == 0) {
//            return "index.xhtml?faces-redirect=true";
//        } else {
//            return "create.xhtml?faces-redirect=true";
//        }
//    }

    

}
