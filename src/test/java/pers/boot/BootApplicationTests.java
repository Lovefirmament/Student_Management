package pers.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.ssm.BootApplication;
import pers.ssm.mapper.LoginMapper;
import pers.ssm.po.Login;

@SpringBootTest(classes= BootApplication.class)
class BootApplicationTests {
    @Autowired
    private LoginMapper loginMapper;
    @Test
    void contextLoads() {
        Login login=new Login();
        login.setName("root");
        login.setPassword("123456");
        login.setType(1);
        Login l=loginMapper.query(login);
        System.out.println(l);
    }
}
