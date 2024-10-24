package com.project.fixedasset;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "depreciation_method")
public class DepreciationMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "method_name", unique = true)
    private String methodName;
}
