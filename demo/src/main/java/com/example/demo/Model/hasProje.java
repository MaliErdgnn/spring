package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hasProje")
@Getter
@Setter
public class hasProje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projeID")
    private Long projeID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hesapID")
    private Long hesapID;

}
