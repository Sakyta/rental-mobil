/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentalmobil.Package;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nurka
 */
public class UsersModel {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String db = "jdbc:mysql://localhost:3306/db_momobilan";
    private String user = "root";
    private String password = "";
    private Connection conn = null;
    private Statement state = null;
    private ResultSet rs = null;
    
    public void UsersModel()
    {
        try
        {
            Class.forName(driver);
        }
        catch (Exception e)
        {
            System.out.println("Driver Error");
        }                
        
        try 
        {
            conn = (Connection) DriverManager.getConnection(db, user, password);
            state = (Statement) conn.createStatement();
        } 
        catch (Exception e) 
        {
            System.out.println("Connection Error");
        }
    }
    
    public boolean insert(String username, String pass, String id)
    {
        String query = "INSERT INTO users VALUES (?, ?, ?, 1)";
        
        try 
        {
            conn = (Connection) DriverManager.getConnection(db, user, password);
            state = (Statement) conn.createStatement();
        } 
        catch (Exception e) 
        {
            System.out.println("Connection Error");
        }
        
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) 
        {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, pass);
            preparedStatement.setString(3, id);            

            preparedStatement.executeUpdate();
            
            return true;
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public void update(String id, String username, String pass)
    {
        String query = "UPDATE users SET username = ?, password = ? WHERE id_pegawai = ?";
        
        try 
        {
            conn = (Connection) DriverManager.getConnection(db, user, password);
            state = (Statement) conn.createStatement();
        } 
        catch (Exception e) 
        {
            System.out.println("Connection Error");
        }
        
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) 
        {            
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, pass);                        
            preparedStatement.setString(3, id);

            preparedStatement.executeUpdate();            
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();            
        }
    }
    
    public void delete(String id)
    {
        String query = "DELETE FROM users WHERE id_pegawai = ?";
        
        try 
        {
            conn = (Connection) DriverManager.getConnection(db, user, password);
            state = (Statement) conn.createStatement();
        } 
        catch (Exception e) 
        {
            System.out.println("Connection Error");
        }
        
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) 
        {            
            preparedStatement.setString(1, id);            

            preparedStatement.executeUpdate();            
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();            
        }
    }
    
    public ResultSet getData()
    {        
        String query = "SELECT * FROM users";
        
        try 
        {
            conn = (Connection) DriverManager.getConnection(db, user, password);
            state = (Statement) conn.createStatement();
        } 
        catch (Exception e) 
        {
            System.out.println("Connection Error");
        }
        
        try
        {
            state = (Statement) conn.createStatement();
            rs = state.executeQuery(query);
        }
        catch (Exception e)
        {
            System.out.println("Error");
        }
        
        return rs;
    }
    
    public ResultSet searchData(String username)
    {
        String query = "SELECT * FROM users WHERE username = '" + username + "'";
        
        try 
        {
            conn = (Connection) DriverManager.getConnection(db, user, password);
            state = (Statement) conn.createStatement();
        } 
        catch (Exception e) 
        {
            System.out.println("Connection Error");
        }
        
        try
        {
            state = (Statement) conn.createStatement();
            rs = state.executeQuery(query);
        }
        catch (Exception e)
        {
            System.out.println("Error");
        }
        
        return rs;
    }
}
