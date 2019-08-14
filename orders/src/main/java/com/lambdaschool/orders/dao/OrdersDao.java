package com.lambdaschool.orders.dao;

import com.lambdaschool.orders.models.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersDao extends CrudRepository<Orders, Long>
{
}
