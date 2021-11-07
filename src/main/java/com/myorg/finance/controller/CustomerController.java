package com.myorg.finance.controller;

import com.myorg.finance.controller.service.CustomersService;
import com.myorg.finance.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
public class CustomerController {

    @Autowired
    CustomersService customersService;

    @PostMapping("/customers")
    public ResponseEntity<Map<String,Long>> createCustomer(@RequestBody Customer customer){

        Long customerId = customersService.saveOrUpdateCustomer(customer);
        Map<String,Long> result =new HashMap<>();
                result.put("customerId", customerId);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/customers/{customer_id}")
    public ResponseEntity<Customer> getCustomerDetails(@PathVariable("customer_id") Long customerId){
        Customer customer =  customersService.getCustomer(customerId);

        return ResponseEntity.ok().body(customer);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
       List<Customer>customers =  customersService.getAllCustomers();

        return ResponseEntity.ok().body(customers);
    }

    @PutMapping("/customers")
    public ResponseEntity<Map<String,Long>> updateCustomer(@RequestBody Customer customer){

        Long customerId = customersService.saveOrUpdateCustomer(customer);
        Map<String,Long> result =new HashMap<>();
        result.put("customerId", customerId);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/customers/{customer_id}")
    public ResponseEntity updateCustomer(@PathVariable("customer_id") Long customerId){
        customersService.deleteCustomer(customerId);
        return ResponseEntity.ok().build();
    }
}
