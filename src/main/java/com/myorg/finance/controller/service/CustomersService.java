package com.myorg.finance.controller.service;

import com.myorg.finance.entity.CustomerEntity;
import com.myorg.finance.entity.PhoneNumberEntity;
import com.myorg.finance.entity.PhoneTypeEntity;
import com.myorg.finance.model.Customer;
import com.myorg.finance.model.PhoneNumber;
import com.myorg.finance.model.PhoneType;
import com.myorg.finance.repository.CustomersRepository;
import com.myorg.finance.repository.PhoneNumbersRepository;
import com.myorg.finance.repository.PhoneTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CustomersService {

    @Autowired
    private  CustomersRepository customersRepository;
    @Autowired
    private PhoneNumbersRepository phoneNumbersRepository;
    @Autowired
    private PhoneTypeRepository phoneTypeRepository;

    @Transactional
    public Long saveOrUpdateCustomer(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customer.getName());
        customerEntity.setAddress(customer.getAddress());
       // customerEntity.setPhoneNumber(customer.getPhoneNumber());
        customerEntity.setId(customer.getId());
        customersRepository.save(customerEntity);

        List<PhoneNumberEntity> phoneNumberEntities = getPhoneNumbers(customer, customerEntity);
        phoneNumbersRepository.saveAll(phoneNumberEntities);
        return customerEntity.getId();
    }

    private List<PhoneNumberEntity> getPhoneNumbers(Customer customer, CustomerEntity customerEntity) {
        List<PhoneNumber>phoneNumbers = customer.getPhoneNumbers();
        List<PhoneNumberEntity>phoneNumberEntities=new ArrayList<>();
        List<PhoneTypeEntity>phoneTypes =phoneTypeRepository.findAll();
        Map<String,PhoneTypeEntity> typeAndPhoneTypeMap = phoneTypes
                .stream()
                .collect(
                        Collectors.toMap(
                                PhoneTypeEntity::getType, phoneTypeEntity -> phoneTypeEntity));
        for(PhoneNumber phoneNumber: phoneNumbers){
            PhoneNumberEntity phoneNumberEntity = new PhoneNumberEntity();
            phoneNumberEntity.setCustomer(customerEntity);
            phoneNumberEntity.setPhoneNumber(phoneNumber.getPhoneNumber());
            phoneNumberEntity.setPhoneType(typeAndPhoneTypeMap.get(phoneNumber.getPhoneType()));
            phoneNumberEntities.add(phoneNumberEntity);
        }

        return phoneNumberEntities;
    }

    public Customer getCustomer(Long customerId) {
        Optional<CustomerEntity> optional = customersRepository.findById(customerId);
        if (optional.isPresent()) {
            CustomerEntity customerEntity = optional.get();
            Customer customer = new Customer();
            customer.setName(customerEntity.getName());
            customer.setAddress(customerEntity.getAddress());

         //   customer.setPhoneNumber(customerEntity.getPhoneNumber());
            customer.setId(customerEntity.getId());
            return customer;
        }
        return null;
    }

    @Transactional
    public void deleteCustomer(Long customerId){
        customersRepository.deleteById(customerId);
    }

    @Transactional
    public List<Customer> getAllCustomers() {
        List<CustomerEntity> allCustomerEtities=customersRepository.findAll();
        List<Customer> customers= new ArrayList<>();
       return allCustomerEtities.stream().map(customerEntity->getCustomer(customerEntity)).collect(Collectors.toList());
    }

    private Customer getCustomer(CustomerEntity customerEntity) {
        Customer customer = new Customer();
        customer.setName(customerEntity.getName());
        customer.setAddress(customerEntity.getAddress());
        customer.setId(customerEntity.getId());
        List<PhoneNumberEntity> phoneNumberEntities = customerEntity.getPhoneNumbers();
        List<PhoneNumber> phoneNumbers =phoneNumberEntities.stream().map(phoneNumberEntity->getPhoneNumber(phoneNumberEntity)).collect(Collectors.toList());
        customer.setPhoneNumbers(phoneNumbers);
        return customer;
    }

    private PhoneNumber getPhoneNumber(PhoneNumberEntity phoneNumberEntity) {
        PhoneNumber phoneNumber =new PhoneNumber();
        phoneNumber.setPhoneNumber(phoneNumberEntity.getPhoneNumber());
        phoneNumber.setPhoneType(phoneNumberEntity.getPhoneType().getType());
        phoneNumber.setId(phoneNumber.getId());
        return phoneNumber;
    }


}
