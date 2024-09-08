/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Employee {
    private String username;
    private String password;
    private String nickname;
    private String owner;
    private String sdt;

    public Employee() {
    }

    public Employee(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }

    public Employee(String username, String password, String nickname, String owner, String sdt) {
        this.owner = owner;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.sdt = sdt;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return "Employee{" + "username=" + username + ", password=" + password + ", nickname=" + nickname + ", owner=" + owner + ", sdt=" + sdt + '}';
    }
}
