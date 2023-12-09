package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ders")
@Getter
@Setter
public class ders {


    @Id
    @Column(name = "dersid")
    private int dersID;

    @Column(name = "dersadi")
    private String dersAdi;

    @Column(name = "kredi")
    private int kredi;

    @Column(name = "harfnotu")
    private String harfNotu;



}

