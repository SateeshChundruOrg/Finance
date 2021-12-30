package com.myorg.finance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table(name="documents")
@Entity
public class Document {
    @Id
    @Column(name="doc_id")
    private Long documentId;

    @Column(name="doc_name")
    private String documentName;
    @Column(name="check_sum")
    private String documentChecksum;
    @Column(name="size_in_bytes")
    private Long documentSizeInBytes;

    @OneToMany(mappedBy = "document")
    private List<DocumentChunk> documentChunks;
}
