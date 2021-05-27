package com.github.khaliullin.mpeilab1.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stats")
@Data
public class Computation {

    @Id
    @Column(name = "id")
    private  Integer id;

    @Column(name = "word_i")
    private Double I;

    @Column(name = "word_h")
    private Double H;

    @Column(name = "word_n")
    private Integer n;

    @Column(name = "word_b")
    private Double B;

    @Column(name = "word_m")
    private Double m;

}
