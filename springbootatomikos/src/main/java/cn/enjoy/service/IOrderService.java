package cn.enjoy.service;

import cn.enjoy.model.Orders;
import cn.enjoy.model.Users;

public interface IOrderService {
     void addOrder(Orders orders, Users users);
}