package com.myorg.finance.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneNumber {
    private Long id;
    private String phoneNumber;
    private String phoneType;
}
