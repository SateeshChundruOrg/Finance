package com.myorg.finance.repository;

import com.myorg.finance.entity.CustomerEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomersRepositoryTest {
    @Autowired
    CustomersRepository customersRepository;

    @Test
    public void testSaveCustomer(){
        CustomerEntity customer =new CustomerEntity();
        customer.setName("sateesh");
        customer.setAddress("Vadlamuru");

        customersRepository.save(customer);
        assertTrue(customer.getId() != null);
    }

}
