package com.java.springboot.web;

import com.java.springboot.modal.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.HashMap;

@RestController
public class UserController {

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public HashMap selectUser(@RequestBody HashMap<String, String> map) throws SQLException {
        String name = map.get("name");
        String password = map.get("password");
        User user = new User(name, password);
        Object select = user.select();
        System.out.println(name);
        System.out.println(password);


        HashMap<String, Boolean> res = new HashMap<>();
        if (select != null){
            res.put("data",true);
        } else {
            res.put("data",false);
        }
        return res;
    }
    @RequestMapping("/user/info")
    public String infoUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String token = request.getParameter("token");
        return token;
    }
    @RequestMapping("user/register")
    public void registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String name = (String) request.getParameter("name");
        String password = (String) request.getParameter("password");
        User user = new User(name, password);
        user.insert();
    }
}
