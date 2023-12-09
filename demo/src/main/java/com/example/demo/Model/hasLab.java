package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hasLab")
@Getter
@Setter
public class hasLab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "labID")
    private Long labID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hesapID")
    private Long hesapID;
}
