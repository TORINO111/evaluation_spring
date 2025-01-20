package com.auchan.gestionauchan.data.entities;

import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
@Data
public class AbstractType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 255)
    private String code;

    @Column(nullable = false, unique = true, length = 255)
    private String name;

}
