package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "proje")
@Getter
@Setter
public class proje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projeID")
    private Long projeID;

    @Column(name = "projeNot")//@Column(name = "projeNot", precision = 5, scale = 2)
    private Double projeNot;

}
