/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class RegisterDAO extends DBContext {

    private boolean existUsername(String username) {
        String sql = "select username from Account";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
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

    
    public int registerAccount(String username, String password, String nickname) {
        String sql = "insert into Account values (?, ?, ?)";
        int result= 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            if (existUsername(username)) {
                return result;
            } else {
                st.setString(1, username);
                st.setString(2, password);
                st.setString(3, nickname);
                result = st.executeUpdate();
                return result;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }
    

    public static void main(String[] args) {
        RegisterDAO rdb = new RegisterDAO();
        int  a = rdb.registerAccount("mrc", "123", "userc");
        System.out.println(a);
    }
}
