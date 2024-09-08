/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Account;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author ASUS
 */
public class AccountDAO extends DBContext{
    public Account getAcccount(String username, String password){
        String sql = "select * from Account where username = ? and password = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Account a = new Account(rs.getString("username"), 
                        rs.getString("password"), 
                        rs.getString("nickname"));
                return a;
            }
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void update(Account e) {
        String sql = "update Account set password = ?, nickname = ? where username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, e.getPassword());
            st.setString(2, e.getNickname());
            st.setString(3, e.getUsername());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static void main(String[] args) {
        AccountDAO a = new AccountDAO();
        Account ac = a.getAcccount("usera", "123");
        System.out.println(ac.getNickname());
    }
}
