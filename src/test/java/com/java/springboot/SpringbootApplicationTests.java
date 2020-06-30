package com.java.springboot;

import com.java.springboot.modal.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest
class SpringbootApplicationTests {

    @Test
    void Test() throws SQLException {
        User user = new User("admin", "admin");
        user.insert();
//        Object select = user.select();
//        if (select != null){
//            System.out.println("有数据");
//        } else {
//            System.out.println("暂无数据");
//        }

    }

}
