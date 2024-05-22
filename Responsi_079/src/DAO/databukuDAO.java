/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import java.util.*;
import koneksi.*;
import model.*;
import DAOimplement.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author abaym
 */
public class databukuDAO implements databuku{
    Connection connection;
    
    final String select = "SELECT * FROM buku";
    final String insert = "INSERT INTO `buku`(`judul`, `penulis`, `rating`, `harga`) VALUES (?,?,?,?)";
    final String update = "UPDATE buku SET penulis=?,rating=?,harga=? WHERE judul=?";
    final String delete = "DELETE FROM buku WHERE judul=?";
    public databukuDAO(){
        connection = koneksi.connection();
    }
    @Override
    public void insert(buku b) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, b.getJudul());
            statement.setString(2, b.getPenulis());
            statement.setDouble(3, b.getRating());
            statement.setInt(4, b.getHarga());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(buku b) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, b.getPenulis());
            statement.setDouble(2, b.getRating());
            statement.setInt(3, b.getHarga());
            statement.setString(4, b.getJudul());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(buku b) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, b.getJudul());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<buku> getAll() {
        List<buku>dp = null;
        try{
            dp=new ArrayList<buku>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                buku b = new buku();
                b.setJudul(rs.getString("judul"));
                b.setPenulis(rs.getString("penulis"));
                b.setRating(rs.getDouble("rating"));
                b.setHarga(rs.getInt("harga"));
                dp.add(b);
            }
        }catch(SQLException ex){
            Logger.getLogger(databukuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dp;
    }
}
