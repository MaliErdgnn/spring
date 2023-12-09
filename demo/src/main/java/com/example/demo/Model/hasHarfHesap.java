package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hasHarfHesap")
@Getter
@Setter
public class hasHarfHesap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hesapID")
    private Long hesapID;

    @Id
    @Column(name = "email")
    private String email;

}
