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
public class MobilModel {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String db = "jdbc:mysql://localhost:3306/db_momobilan";
    private String user = "root";
    private String password = "";
    private Connection conn = null;
    private Statement state = null;
    private ResultSet rs = null;
    
    public void MobilModel()
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
    
    public boolean insert(String id, String jenis, String sewa, String stok)
    {
        String query = "INSERT INTO mobil VALUES (?, ?, ?, ?)";
        
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
            preparedStatement.setString(2, jenis);
            preparedStatement.setString(3, sewa);            
            preparedStatement.setString(4, stok);  

            preparedStatement.executeUpdate();
            return true;
        } 
        catch (SQLException e) 
        {            
            e.printStackTrace();
            return false;
        }
    }
    
    public void update(String id, String jenis, String sewa, String stok)
    {
        String query = "UPDATE mobil SET jenis = ?, sewa = ?, stok = ? WHERE id_mobil = ?";
        
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
            preparedStatement.setString(1, jenis);
            preparedStatement.setString(2, sewa);            
            preparedStatement.setString(3, stok);  
            preparedStatement.setString(4, id);

            preparedStatement.executeUpdate();            
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();            
        }
    }
    
    public void delete(String id)
    {
        String query = "DELETE FROM mobil WHERE id_mobil = ?";
        
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
    
    public ResultSet searchData(String jenis)
    {        
        String query = "SELECT * FROM mobil WHERE jenis LIKE '%" + jenis + "%'";
        
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
            e.printStackTrace();
        }
        
        return rs;
    }
    
    public ResultSet getData()
    {
        String query = "SELECT * FROM mobil";
        
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
