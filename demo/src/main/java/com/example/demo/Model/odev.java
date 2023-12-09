package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "odev")
@Getter
@Setter
public class odev {

    @Id
    @Column(name = "odevID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long odevID;

    @Column(name = "odevNot")//@Column(name = "odevNot", precision = 5, scale = 2)
    private Double odevNot;
}
