package com.myorg.finance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name="doc_type_lkp")
public class DocumentType {
    @Id
    @Column(name="doc_type_id")
    private Long documentTypeId;

    @Column(name="doc_type")
    private String documentType;

    @Column(name="mime_type")
    private String mimeType;
}
