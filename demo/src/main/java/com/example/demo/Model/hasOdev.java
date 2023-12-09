package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hasOdev")
@Getter
@Setter
public class hasOdev {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "odevID")
    private Long odevID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hesapID")
    private Long hesapID;
}
