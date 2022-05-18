/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreweb.model.dao;

import bookstoreweb.model.bean.User;
import connection.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author devsys-b
 */
public class UserDAO {
    
    private static final String SQL_INSERT = "INSERT INTO user(email, "
            + "password, fullname) "
            + "VALUES (?, ?, ?)";
    
    private static final String SQL_SELECT_ALL = "SELECT * FROM user";
    private static final String SQL_SELECT_ID = "SELECT * FROM user "
            + "WHERE id = ?";
    
    
    private static final String SQL_UPDATE = "UPDATE user SET email = ?,"
            + "password = ?, fullname = ? "
            + "WHERE id = ?";
    
    
    public static final String SQL_DELETE = "DELETE FROM user WHERE id = ?";
    
    public static final String SELECT = "SELECT fullname FROM user WHERE email = ? AND password = ?";
    
    public void create(User b){
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, b.getEmail());
            stmt.setString(2, b.getPassword());
            stmt.setString(3, b.getFullname());

            
            
            //Executa a query
            int auxRetorno = stmt.executeUpdate();
            
            Logger.getLogger(UserDAO.class.getName()).log(Level.INFO, null,
                    "Inclusao: " + auxRetorno);
          } catch (SQLException sQLException) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null,
                    sQLException);
          } finally {
                //Encerra a conexão com o banco e o statement.
                MySQLConnection.closeConnection(conn, stmt);
          }
    }
    
    
    public List<User> getResults(){
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User b = null;
        List<User> listaUsers = null;
        
        try {
            // Prepara a String de SLEECT e executa a query.
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            
            // Carrega os dados do ResultSet rs, converte em Produto e adiciona na lista de retorno
            
            listaUsers = new ArrayList<>();
            
            while (rs.next()) {
                b = new User();
                b.setId(rs.getInt("id"));
                b.setEmail(rs.getString("email"));
                b.setPassword(rs.getString("password"));
                b.setFullname(rs.getString("fullname"));
                listaUsers.add(b);
            }
        } catch (SQLException ex){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaUsers;
    }
    
    public User getResultById(int id){
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement  stmt = null;
        ResultSet rs = null;
        User b = null;
        
        
        try {
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            
            if (rs.next()){
                b = new User();
                b.setId(rs.getInt("id"));
                b.setEmail(rs.getString("email"));
                b.setPassword(rs.getString("password"));
                b.setFullname(rs.getString("fullname"));
            }
        } catch (SQLException sQLException) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, 
                    sQLException);
        } finally {
        
            MySQLConnection.closeConnection(conn, stmt, rs);
        }
        
        return b;
    }    
        
    
    public void update(User b){
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, b.getEmail());
            stmt.setString(2, b.getPassword());
            stmt.setString(3, b.getFullname());
            stmt.setInt(4, b.getId());
        
            int auxRetorno = stmt.executeUpdate();
            
            Logger.getLogger(UserDAO.class.getName()).log(Level.INFO, null, 
                    "Update: " + auxRetorno);
            
        }catch (SQLException sQLException){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null,
                    sQLException);
        } finally {
            MySQLConnection.closeConnection(conn, stmt);
        }
    
    }
    
    
    public void delete(int id){
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
     
        try {
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            
            int auxRetorno = stmt.executeUpdate();
            
            Logger.getLogger(UserDAO.class.getName()).log(Level.INFO, null,
                    "Delete: " + auxRetorno);
        } catch (SQLException sQLException) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null,
            sQLException);
        
        } finally {
            MySQLConnection.closeConnection(conn, stmt);
        }
        
    }
    
    public User checkLogin(String email, String password) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User b = null;
        
        try {

            stmt = conn.prepareStatement(SELECT);
            stmt.setString(1, email);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            
            if (rs.next()) {
                b = new User();
                b.setFullname(rs.getString("fullname"));
                b.setEmail(email);
            }
        } catch (SQLException ex){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            MySQLConnection.closeConnection(conn, stmt, rs);
        }
        
        return b;
    }

    
}
