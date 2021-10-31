package com.myorg.finance.repository;


import com.myorg.finance.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<CustomerEntity, Long> {
}
