package com.myorg.finance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="customers")
@Setter
@Getter
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customers_generator")
    @SequenceGenerator(name="customers_generator", sequenceName = "customers_seq" ,allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @OneToMany(mappedBy = "customer")
    private List<PhoneNumberEntity> phoneNumbers;

}
