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
public class PeminjamanModel {
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
    
    public boolean insert(String id, String idPeg, String idPel, String idMo, String tglPinjam, String tglKembali, int lama, int telat, String biaya, String denda)
    {
        String query = "INSERT INTO peminjaman VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
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
            preparedStatement.setString(2, idPeg);
            preparedStatement.setString(3, idPel);
            preparedStatement.setString(4, idMo);
            preparedStatement.setString(5, tglPinjam);
            preparedStatement.setString(6, tglKembali);
            preparedStatement.setInt(7, lama);
            preparedStatement.setInt(8, telat);
            preparedStatement.setString(9, biaya);
            preparedStatement.setString(10, denda);

            preparedStatement.executeUpdate();
            return true;
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public void update(String id, int telat, String denda)
    {
        String query = "UPDATE peminjaman SET telat = ?, denda = ? WHERE id_peminjaman = ?";
        
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
            preparedStatement.setInt(1, telat);
            preparedStatement.setString(2, denda);
            preparedStatement.setString(3,id);                                  

            preparedStatement.executeUpdate();            
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();            
        }
    }
    
    public void delete(String id)
    {
        String query = "DELETE FROM peminjaman WHERE id_peminjaman = ?";
        
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
    
    public ResultSet searchData(String id)
    {        
        String query = "SELECT * FROM peminjaman WHERE id_peminjaman = '" + id + "'";
        
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
        String query = "SELECT * FROM peminjaman";
        
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
