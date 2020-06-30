package com.java.springboot.modal;

import com.java.springboot.jdbc.Conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Student {
    private String name;
    private int sex;
    private String age;

    public Student() {
    }

    public Student(String name, int sex, String age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public int insert() throws SQLException {
        String nowDate = getNowDate();
        String sql = "insert into student (name,age,sex,create_date,update_date) values (?,?,?,?,?)";
        Connection conn = new Conn().getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,name);
        ps.setObject(2,age);
        ps.setObject(3,sex);
        ps.setObject(4,nowDate);
        ps.setObject(5,nowDate);
        int i = ps.executeUpdate();
        System.out.println(i);
        return i;
    }

    public int delete(int id) throws SQLException {
        String sql = "delete from student where id=?";
        Connection conn = new Conn().getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,id);
        int i = ps.executeUpdate();
        return i;
    }
    public String getNowDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowDate = sdf.format(new Date());
        return nowDate;
    }
    public int update(int id) throws SQLException {
        String nowDate = getNowDate();
        String sql = "update student set name=?,sex=?,age=?,update_date=? where id=?";
        Connection conn = new Conn().getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,name);
        ps.setObject(2,sex);
        ps.setObject(3,age);
        ps.setObject(4,nowDate);
        ps.setObject(5, id);

        int i = ps.executeUpdate();
        return i;
    }
    public ArrayList selectAll() throws SQLException {
        String sql = "select st.*,cs.value sex_value from student st,const_sex cs where st.sex = cs.id";
        Connection conn = new Conn().getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();

        ArrayList<HashMap<String, Object>> res = new ArrayList<>();
        while (resultSet.next()){
            HashMap<String, Object> tempMap = new HashMap<>();

            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String age = resultSet.getString("age");
            int sex = resultSet.getInt("sex");
            String create_date = resultSet.getString("create_date");
            String update_date = resultSet.getString("update_date");
            String sex_value = resultSet.getString("sex_value");

            tempMap.put("id",id);
            tempMap.put("name",name);
            tempMap.put("age",age);
            tempMap.put("sex",sex);
            tempMap.put("sex_value",sex_value);
            tempMap.put("create_date",create_date);
            tempMap.put("update_date",update_date);

            res.add(tempMap);

        }
        return res;
    }
}
