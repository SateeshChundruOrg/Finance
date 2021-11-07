package com.myorg.finance.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "phone_type")
@Getter
@Setter
public class PhoneTypeEntity implements Serializable {

    @Id
    Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;
}
