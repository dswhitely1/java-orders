package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customers;

import java.util.List;

public interface CustomersService
{
    List<Customers> findAll();
    Customers findById(long id);
    Customers findByName(String name);
    Customers save(Customers customer);
    Customers update(Customers customer, long id);
    Customers delete(long id);
}
