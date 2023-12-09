package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ortHesap")
@Getter
@Setter
public class ortHesap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ortID")
    private Long ortID;

    @Column(name = "gno")//@Column(name = "gno", precision = 3, scale = 2)
    private Double gno;

    @Column(name = "yeniGno")//@Column(name = "yeniGno", precision = 3, scale = 2)
    private Double yeniGno;

    @Column(name = "donemOrt")//@Column(name = "donemOrt", precision = 3, scale = 2)
    private Double donemOrt;

    @Column(name = "harfSis")
    private String harfSis;

    @Column(name = "dersSy")
    private Integer dersSy;

    @Column(name = "eskiKredi")
    private int eskiKredi;

    private List<ders> dersList;
    @Column(name = "date")
    private Date date;
}
