package com.lambdaschool.orders.dao;

import com.lambdaschool.orders.models.Customers;
import org.springframework.data.repository.CrudRepository;

public interface CustomersDao extends CrudRepository<Customers, Long>
{
    Customers findByCustname(String name);
}
