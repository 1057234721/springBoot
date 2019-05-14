package cn.enjoy;

import cn.enjoy.App;
import cn.enjoy.model.Orders;
import cn.enjoy.model.Users;
import cn.enjoy.service.IOrderService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = {App.class})
@RunWith(SpringRunner.class)
public class UserTest {

    @Resource
    private IOrderService iOrderService;

    @org.junit.Test
    public void test1() {
        Users users = new Users();
        users.setUsername("enjoy");
        users.setPasswd("123");
        users.setId(1);


        Orders orders = new Orders();
        orders.setAccount(12);
        orders.setName("娃娃");
        orders.setUserId(1);
        iOrderService.addOrder(orders,users);
    }
}


