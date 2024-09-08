/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.List;
import model.Catagories;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class CatagoriesDAO extends DBContext {

    public List<Catagories> getAllCata(String owner) {
        String sql = "select * from Catagories where owner = ?";
        List<Catagories> cList = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, owner);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Catagories c = new Catagories(
                        rs.getString("owner"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("totalAmount")
                );
                cList.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cList;
    }

    public Catagories getCata(String name, String owner) {
        String sql = "select * from Catagories where name = ? and owner = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, owner);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Catagories c = new Catagories(
                        rs.getString("owner"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("totalAmount")
                );
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void delete(String name, String owner) {
        String sql = "delete from Catagories where name = ? and owner = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, owner);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void update(Catagories c) {
        String sql = "update Catagories set price = ?, totalAmount = ? where name = ? and owner = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDouble(1, c.getPrice());
            st.setInt(2, c.getTotalAmount());
            st.setString(3, c.getName());
            st.setString(4, c.getOwner());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updateAmount(Catagories c) {
        String sql = "update Catagories set totalAmount = ? where name = ? and owner = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getTotalAmount());
            st.setString(2, c.getName());
            st.setString(3, c.getOwner());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void insert(Catagories c) {
        String sql = "insert into Catagories values(?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getOwner());
            st.setString(2, c.getName());
            st.setDouble(3, c.getPrice());
            st.setInt(4, c.getTotalAmount());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public boolean exist(String name, String owner) {
        String sql = "select name from Catagories where owner = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, owner);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if (name.toLowerCase().equals(rs.getString(1).toLowerCase())) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public static void main(String[] args) {
        CatagoriesDAO cdb = new CatagoriesDAO();
        List<Catagories> cl = cdb.getAllCata("usera");
        for (Catagories c : cl) {
            System.out.println(c.getName());
        }
    }
}
