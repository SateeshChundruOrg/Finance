package com.myorg.finance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "payment")
@Setter
@Getter
public class PaymentEntity {

    @Id
    private Long paymentId;
    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private CustomerEntity customer;

    @OneToOne
    @JoinTable(name = "payment_proof_doc", joinColumns = @JoinColumn(
            name = "payment_id",
            referencedColumnName = "payment_id"
    ),
            inverseJoinColumns = @JoinColumn(
                    name = "document_id",
                    referencedColumnName = "document_id"
            )
    )
    private Document document;


}
