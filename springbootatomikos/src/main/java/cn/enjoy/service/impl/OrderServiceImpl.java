package cn.enjoy.service.impl;

import cn.enjoy.dao.orders.OrdersMapper;
import cn.enjoy.dao.users.UsersMapper;
import cn.enjoy.model.Orders;
import cn.enjoy.model.Users;
import cn.enjoy.service.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl  implements IOrderService{

    @Resource
    private UsersMapper usersMapper;

    @Resource
    private OrdersMapper ordersMapper;

    @Override
    @Transactional
    public void addOrder(Orders orders, Users users) {
        usersMapper.insertSelective(users);
        int i = 10/0;
        ordersMapper.insertSelective(orders);
    }
}