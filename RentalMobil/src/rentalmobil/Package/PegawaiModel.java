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
    
    public void update(String id, String nama, String alamat, String contact)
    {
        String query = "UPDATE pegawai SET nama = ?, alamat = ?, contact = ? WHERE id_pegawai = ?";
        
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
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, alamat);            
            preparedStatement.setString(3, contact);  
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
        String query = "DELETE FROM pegawai WHERE id_pegawai = ?";
        
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
    
    public ResultSet searchData(String nama)
    {        
        String query = "SELECT * FROM pegawai JOIN users ON pegawai.id_pegawai = users.id_pegawai WHERE pegawai.nama LIKE '%" + nama + "%'";
        
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
    
    public ResultSet searchDataId(String id)
    {        
        String query = "SELECT * FROM pegawai JOIN users ON pegawai.id_pegawai = users.id_pegawai WHERE pegawai.id_pegawai = '" + id + "'";
        
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
        String query = "SELECT * FROM pegawai JOIN users ON pegawai.id_pegawai = users.id_pegawai";
        
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
