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
import model.Employee;

/**
 *
 * @author ASUS
 */
public class EmployeeDAO extends DBContext {

    public Employee getEmployee(String username, String password, String owner) {
        String sql = "select * from Employee where username = ? and password = ? and owner = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            st.setString(3, owner);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Employee e = new Employee(rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("nickname"),
                        rs.getString("owner"),
                        rs.getString("sdt"));
                return e;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Employee> getWorkEmployee(String owner) {
        String sql = "select * from Employee where owner = ?";
        List<Employee> eList = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, owner);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Employee e = new Employee(rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("nickname"),
                        rs.getString("owner"),
                        rs.getString("sdt"));
                eList.add(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return eList;
    }

    public Employee getEmployeeToUpdate(String username, String owner) {
        String sql = "select * from Employee where username = ? and owner = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, owner);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Employee e = new Employee(rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("nickname"),
                        rs.getString("owner"),
                        rs.getString("sdt"));
                return e;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }


    public void delete(String username, String owner) {
        String sql = "delete from Employee where username = ? and owner = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, owner);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void update(Employee e) {
        String sql = "update Employee set password = ?, nickname = ?, sdt = ? where username = ? and owner = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, e.getPassword());
            st.setString(2, e.getNickname());
            st.setString(3, e.getSdt());
            st.setString(4, e.getUsername());
            st.setString(5, e.getOwner());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void insert(Employee e) {
        String sql = "insert into Employee values(?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, e.getUsername());
            st.setString(2, e.getPassword());
            st.setString(3, e.getNickname());
            st.setString(4, e.getOwner());
            st.setString(5, e.getSdt());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public boolean existUsername(String username, String owner) {
        String sql = "select username from Employee where owner = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, owner);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if (username.equals(rs.getString(1))) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public static void main(String[] args) {
        EmployeeDAO edao = new EmployeeDAO();
//        Employee e = new Employee("emp2", "123", "Nhân Viên 2", "usera", "03334432");
//        edao.insert(e);
//        List<Employee> ep = edao.getWorkEmployee("usera");
//        for(Employee epl : ep){
//            System.out.println(epl.toString());
//        }
        boolean a = edao.existUsername("emp1", "usera");
        System.out.println(a);
    }
}
