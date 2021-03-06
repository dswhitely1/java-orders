package com.lambdaschool.orders.services;

import com.lambdaschool.orders.dao.AgentsDao;
import com.lambdaschool.orders.dao.CustomersDao;
import com.lambdaschool.orders.models.Agents;
import com.lambdaschool.orders.models.Customers;
import com.lambdaschool.orders.models.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Transactional
@Service(value = "customersService")
public class CustomersServiceImpl implements CustomersService
{
    @Autowired
    private CustomersDao customerDao;
    private AgentsDao agentsDao;

    @Override
    public List<Customers> findAll()
    {
        List<Customers> list = new ArrayList<>();
        customerDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customers findById(long id)
    {
        return customerDao.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public Customers findByName(String name)
    {
        Customers customer = customerDao.findByCustname(name);
        if (customer == null)
        {
            throw new EntityNotFoundException("Customer " + name + " not found!");
        }
        return customer;
    }

    @Transactional
    @Override
    public Customers save(Customers customer)
    {
        Customers newCustomer = new Customers();
        newCustomer.setCustname(customer.getCustname());
        newCustomer.setCustcity(customer.getCustcity());
        newCustomer.setWorkingarea(customer.getWorkingarea());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningamt(customer.getOpeningamt());
        newCustomer.setReceiveamt(customer.getReceiveamt());
        newCustomer.setPaymentamt(customer.getPaymentamt());
        newCustomer.setOutstandingamt(customer.getOutstandingamt());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setAgentcode(customer.getAgentcode());


        for (Orders o : customer.getOrders())
        {
            newCustomer.getOrders().add(new Orders(o.getOrdamount(), o.getAdvanceamount(), newCustomer, o.getOrddescription()));
        }
        return customerDao.save(newCustomer);
    }

    @Transactional
    @Override
    public Customers update(Customers customer, long id)
    {
        Customers currentCustomer = customerDao.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
        if (customer.getCustname() != null)
        {
            currentCustomer.setCustname(customer.getCustname());
        }
        if (customer.getCustcity()!=null)
        {
            currentCustomer.setCustcity(customer.getCustcity());
        }
        if (customer.getWorkingarea() != null)
        {
            currentCustomer.setWorkingarea(customer.getWorkingarea());
        }
        if (customer.getCustcountry()!=null)
        {
            currentCustomer.setCustcountry(customer.getCustcountry());
        }
        if (customer.getGrade()!=null)
        {
            currentCustomer.setGrade(customer.getGrade());
        }
        if (customer.getOpeningamt()!=null)
        {
            currentCustomer.setOpeningamt(customer.getOpeningamt());
        }
        if (customer.getReceiveamt()!=null){
            currentCustomer.setReceiveamt(customer.getReceiveamt());
        }
        if (customer.getPaymentamt()!=null){
            currentCustomer.setPaymentamt(customer.getPaymentamt());
        }
        if (customer.getPhone()!=null){
            currentCustomer.setPhone(customer.getPhone());
        }
        if (customer.getAgentcode()!=null) {
            currentCustomer.setAgentcode(customer.getAgentcode());
        }

        if (customer.getOrders().size()>0)
        {
            for (Orders o : customer.getOrders())
            {
                currentCustomer.getOrders().add(new Orders(o.getOrdamount(), o.getAdvanceamount(), customer, o.getOrddescription()));
            }
        }

        return customerDao.save(currentCustomer);

    }

    @Transactional
    @Override
    public void delete(long id)
    {
        if (customerDao.findById(id).isPresent())
        {
            customerDao.deleteById(id);
        } else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }
}
