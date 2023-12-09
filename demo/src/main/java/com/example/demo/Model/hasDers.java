package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hasDers")
@Getter
@Setter
public class hasDers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ortID")
    private Long ortID;

    @Id
    @Column(name = "dersID")
    private int dersID;
}
