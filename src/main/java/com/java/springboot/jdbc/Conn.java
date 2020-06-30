package com.java.springboot.jdbc;

import java.sql.*;

public class Conn {



    private Connection conn;

//    public static void main(String[] args) {
//        try {
//            execute();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }

//    public static void execute() throws SQLException {
//        Connection conn = getConn();
//        // 基本操作
//        // 获取执行sql语句的对象
////        String sql = "Select * from users where id = ?";
//        String sql = "insert into users (name,password) values (?,?)";
//        PreparedStatement prepareStatement = conn.prepareStatement(sql);
//        prepareStatement.setObject(1, "laojia");
//        prepareStatement.setObject(2, "7143489603");
////        ((PreparedStatement) prepareStatement).setObject(1,2);
////        ResultSet rs = prepareStatement.executeQuery(); // 查询使用
//        boolean res = prepareStatement.execute();
//        System.out.println(res);
//        ResultSet resultSet = prepareStatement.getResultSet();
//        System.out.println(resultSet);
////        System.out.println(rs.getInt("id"));
////        System.out.println(rs.getInt("id"));
////        System.out.println(rs.next());
////        System.out.println(rs.getInt("id"));
////        while (rs.next()) {
////            System.out.print(rs.getInt("id") + " ");
////            System.out.print(rs.getString("email") + " ");
////            System.out.println(rs.getString("name"));
////        }
//        // 释放资源
////        rs.close();
//        prepareStatement.close();
//        conn.close();
//    }
    public Conn() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/student_manage?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
        String user = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, user, password);
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }
    //    public void insert(String name, String password) throws SQLException {
//        String sql = "insert into users (name,password) values (?,?)";
//        PreparedStatement prepareStatement = conn.prepareStatement(sql);
//        prepareStatement.setObject(1, name);
//        prepareStatement.setObject(2, password);
//
//    }
}
