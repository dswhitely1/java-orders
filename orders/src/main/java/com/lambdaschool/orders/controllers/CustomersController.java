package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Customers;
import com.lambdaschool.orders.services.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class CustomersController
{
    @Autowired
    CustomersService customersService;

    @GetMapping(value = "/customer/order",
                produces = {"application/json"})
    public ResponseEntity<?> getAllCustomers()
    {
        List<Customers> myCustomers = customersService.findAll();
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }

    @GetMapping(value = "/customer/name/{custname}",
                produces = {"application/json"})
    public ResponseEntity<?> getCustomerByName(
            @PathVariable
                    String custname)
    {
        Customers c = customersService.findByName(custname);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @PostMapping(value = "/data/customer/new",
                 consumes = {"application/json"},
                 produces = {"application/json"})
    public ResponseEntity<?> addNewCustomer(@Valid
                                            @RequestBody
                                                    Customers newCustomer)
    {
        customersService.save(newCustomer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/data/customer/update/{custcode}",
                consumes = {"application/json"})
    public ResponseEntity<?> updateCustomer(
            @RequestBody
                    Customers updatedCustomer,
            @PathVariable
                    Long custcode)
    {
        customersService.update(updatedCustomer, custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/data/customer/delete/{custcode}")
    public ResponseEntity<?> deleteCustomer(
            @PathVariable
                    Long custcode)
    {
        customersService.delete(custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
