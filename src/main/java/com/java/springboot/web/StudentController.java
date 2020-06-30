package com.java.springboot.web;

import com.java.springboot.modal.Student;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class StudentController {
    @RequestMapping(value = "/student/add",method = RequestMethod.GET)
    public int insertStudent(@RequestBody HashMap<String, String> map) throws SQLException {
        String name = map.get("name");
        int sex = Integer.parseInt(map.get("sex"));
        String age = map.get("age");
        Student student = new Student(name, sex, age);
        int resInt = student.insert();
        return resInt;
    }
    @RequestMapping("/student/list")
    public ArrayList selectStudent() throws SQLException {
        Student st = new Student();
        ArrayList list = st.selectAll();
        return list;
    }
    @RequestMapping("/student/update")
    public int updateStudent(@RequestBody HashMap<String,String> map) throws SQLException {
        String name = map.get("name");
        int sex = Integer.parseInt(map.get("sex"));
        int id = Integer.parseInt(map.get("id"));
        String age = map.get("age");
        Student student = new Student(name, sex, age);
        int update = student.update(id);
        return update;
    }
    @RequestMapping("/student/delete")
    public int deleteStudent(@RequestBody HashMap<String,Integer> map) throws SQLException {
        int id = map.get("id");
        Student st = new Student();
        int delete = st.delete(id);
        return delete;
    }
}
