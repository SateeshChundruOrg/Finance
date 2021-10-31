package com.myorg.finance.controller.service;

import com.myorg.finance.entity.CustomerEntity;
import com.myorg.finance.model.Customer;
import com.myorg.finance.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CustomersService {

    @Autowired
    CustomersRepository customersRepository;
    @Transactional
    public Long saveOrUpdateCustomer(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customer.getName());
        customerEntity.setAddress(customer.getAddress());
        customerEntity.setPhoneNumber(customer.getPhoneNumber());
        customerEntity.setId(customer.getId());
        customersRepository.save(customerEntity);
        return customerEntity.getId();
    }

    public Customer getCustomer(Long customerId) {
        Optional<CustomerEntity> optional = customersRepository.findById(customerId);
        if (optional.isPresent()) {
            CustomerEntity customerEntity = optional.get();
            Customer customer = new Customer();
            customer.setName(customerEntity.getName());
            customer.setAddress(customerEntity.getAddress());
            customer.setPhoneNumber(customerEntity.getPhoneNumber());
            customer.setId(customerEntity.getId());
            return customer;
        }
        return null;
    }

    @Transactional
    public void deleteCustomer(Long customerId){
        customersRepository.deleteById(customerId);
    }



}
