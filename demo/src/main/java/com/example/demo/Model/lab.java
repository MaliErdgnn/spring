package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "lab")
@Getter
@Setter
public class lab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "labID")
    private Long labID;

    @Column(name = "labNot")//@Column(name = "labNot", precision = 5, scale = 2)
    private Double labNot;
}
