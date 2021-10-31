package com.myorg.finance.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
@Setter
@Getter
public class Customer {
    private Long id;
    private String name;
    private String address;
    private String  phoneNumber;
}
