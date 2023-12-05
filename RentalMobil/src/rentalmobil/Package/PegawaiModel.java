/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentalmobil.Package;
import java.sql.*;

/**
 *
 * @author nurka
 */
public class PegawaiModel {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String db = "jdbc:mysql://localhost:3306/db_momobilan";
    private String user = "root";
    private String password = "";
    private Connection conn = null;
    private Statement state = null;
    private ResultSet rs = null;
    
    public void PegawaiModel()
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
    
    public boolean insert(String id, String nama, String alamat, String kontak)
    {
        String query = "INSERT INTO pegawai VALUES (?, ?, ?, ?)";
        
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
            preparedStatement.setString(2, nama);
            preparedStatement.setString(3, alamat);            
            preparedStatement.setString(4, kontak);  

            preparedStatement.executeUpdate();
            return true;
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public void update()
    {
        // TODO
    }
    
    public void delete()
    {
        // TODO
    }
    
    public ResultSet searchData(String id)
    {        
        String query = "SELECT * FROM pegawai WHERE id_pegawai = " + id ;
        
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
    
    public ResultSet getData()
    {
        String query = "SELECT * FROM pegawai";
        
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
