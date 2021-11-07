package com.myorg.finance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "phone_numbers")
@Setter
@Getter
public class PhoneNumberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_numbers_generator")
    @SequenceGenerator(name="phone_numbers_generator", sequenceName = "phone_numbers_seq" ,allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private CustomerEntity customer;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "type",referencedColumnName="type", nullable=false)
    private PhoneTypeEntity phoneType;

}
