package com.java.springboot.modal;

import com.java.springboot.jdbc.Conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void insert() throws SQLException {
        Connection conn = new Conn().getConn();
        String sql = "insert into users (name,password) values (?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,name);
        ps.setObject(2,password);
        int i = ps.executeUpdate();
        System.out.println(i);
    }
    public Object select() throws SQLException {
        Connection conn = new Conn().getConn();
        String sql = "select * from users where name=? and password = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,name);
        ps.setObject(2,password);
        ResultSet rs = ps.executeQuery();
        Object res = null;
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String password = rs.getString("password");
            User user = new User(name, password);
            res = user;
        }
        return res;
    }
}
