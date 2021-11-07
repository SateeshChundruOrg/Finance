package com.myorg.finance.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.List;

@Setter
@Getter
public class Customer {
    private Long id;
    private String name;
    private String address;
    private List<PhoneNumber> phoneNumbers;
}
