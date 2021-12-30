package com.myorg.finance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name="documents")
@Entity
public class DocumentChunk {
    @Id
    private Long chunkId;
    @Column(name="chunk_data")

    private byte[] chunkData;

    @Column(name="chunk_checksum")
    private String chunkChecksum;

    @ManyToOne
    @JoinColumn(name = "doc_id",  nullable=false)
    private Document document;
}
