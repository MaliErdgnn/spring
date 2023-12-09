package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "harfHesap")
@Getter
@Setter
public class harfHesap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hesapID")
    private Long hesapID;

    @Column(name = "dersAd")
    private String dersAd;

    @Column(name = "tarih")
    private Date tarih;

    @Column(name = "puan")
    private Double puan;

    @Column(name = "vizeYuzde")
    private Integer vizeYuzde;

    @Column(name = "vizeNot")
    private Double vizeNot;

    @Column(name = "finalYuzde")
    private Integer finalYuzde;

    @Column(name = "finalNot")
    private Double finalNot;

    @Column(name = "notSis")
    private String notSis;

    @Column(name = "harfSIS")
    private String harfSIS;

    @Column(name = "sinifOrt")
    private Double sinifOrt;

    @Column(name = "odevSy")
    private Integer odevSy;

    @Column(name = "odevYuzde")
    private Integer odevYuzde;

    @Column(name = "quizSy")
    private Integer quizSy;

    @Column(name = "quizYuzde")
    private Integer quizYuzde;

    @Column(name = "labSy")
    private Integer labSy;

    @Column(name = "labYuzde")
    private Integer labYuzde;

    @Column(name = "projeSy")
    private Integer projeSy;

    @Column(name = "projeYuzde")
    private Integer projeYuzde;

    @Column(name = "harfNot")
    private String harfNot;

}
