/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.History;
import model.Sell;

/**
 *
 * @author ASUS
 */
public class SellDAO extends DBContext {

    public List<History> sellHistory(String owner) {
        String sql = "select * from History where owner = ?";
        List<History> hl = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, owner);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                History h = new History(
                        rs.getString("owner"),
                        rs.getString("empName"),
                        rs.getString("name"),
                        rs.getInt("totalAmount"),
                        rs.getDouble("price"),
                        rs.getDouble("totalPrice")
                );
                hl.add(h);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return hl;
    }

    public List<Sell> sellList(String owner, String empName) {
        String sql = "select * from Sell where owner = ? and empName = ?";
        List<Sell> sl = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, owner);
            st.setString(2, empName);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Sell s = new Sell(
                        rs.getString("owner"),
                        rs.getString("empName"),
                        rs.getString("name"),
                        rs.getInt("totalAmount"),
                        rs.getDouble("price")
                );
                sl.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return sl;
    }

    public Sell sellGood(String owner, String empName, String name) {
        String sql = "select * from Sell where owner = ? and empName = ? and name = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, owner);
            st.setString(2, empName);
            st.setString(3, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Sell s = new Sell(
                        rs.getString("owner"),
                        rs.getString("empName"),
                        rs.getString("name"),
                        rs.getInt("totalAmount"),
                        rs.getDouble("price")
                );
                return s;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void refresh(String owner, String empName) {
        String sql = "delete from Sell where owner = ? and empName = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, owner);
            st.setString(2, empName);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteHis(String name, String owner) {
        String sql = "delete from History where name = ? and owner = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, owner);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void deleteAllHis(String owner) {
        String sql = "delete from History where owner = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, owner);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void update(Sell s) {
        String sql = "update Sell set price = ?, totalAmount = ? where name = ? and empName = ? and owner = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDouble(1, s.getPrice());
            st.setInt(2, s.getTotalAmount());
            st.setString(3, s.getName());
            st.setString(4, s.getEmpName());
            st.setString(5, s.getOwner());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void deleteSell(String name, String owner) {
        String sql = "delete from Sell where owner = ? and name = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, owner);
            st.setString(2, name);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void insertSell(Sell s) {
        String sql = "insert into Sell values(?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, s.getOwner());
            st.setString(2, s.getEmpName());
            st.setString(3, s.getName());
            st.setInt(4, s.getTotalAmount());
            st.setDouble(5, s.getPrice());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void insertHis(History s) {
        String sql = "insert into History values(?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, s.getOwner());
            st.setString(2, s.getEmpName());
            st.setString(3, s.getName());
            st.setInt(4, s.getTotalAmount());
            st.setDouble(5, s.getPrice());
            st.setDouble(6, s.getTotalPrice());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public List<History> searchEmp(String owner, String search) {
        String sql = "select * from History where owner = ?";
        List<History> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, owner);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if (rs.getString("empName").toLowerCase().contains(search.trim().toLowerCase())) {
                    History h = new History(
                            rs.getString("owner"),
                            rs.getString("empName"),
                            rs.getString("name"),
                            rs.getInt("totalAmount"),
                            rs.getDouble("price"),
                            rs.getDouble("totalPrice")
                    );
                    list.add(h);
                }
            }
        } catch (SQLException e) {

        }
        return list;
    }

    public List<History> searchCata(String owner, String search) {
        String sql = "select * from History where owner = ?";
        List<History> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, owner);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if (rs.getString("name").toLowerCase().contains(search.trim().toLowerCase())) {
                    History h = new History(
                            rs.getString("owner"),
                            rs.getString("empName"),
                            rs.getString("name"),
                            rs.getInt("totalAmount"),
                            rs.getDouble("price"),
                            rs.getDouble("totalPrice")
                    );
                    list.add(h);
                }
            }
        } catch (SQLException e) {

        }
        return list;
    }

    public static void main(String[] args) {
        SellDAO sdb = new SellDAO();
        List<History> hl = sdb.searchCata("usera", "g");
        for (History h : hl) {
            System.out.println(h.getTotalAmount());
        }
    }
}
