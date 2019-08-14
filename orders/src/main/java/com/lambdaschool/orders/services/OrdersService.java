package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Orders;

import java.util.List;

public interface OrdersService
{
    List<Orders> findAll();
    Orders findOrdersById(long id);
    Orders save(Orders orders);
    Orders update(Orders orders, long id);
    Orders delete(long id);
}
