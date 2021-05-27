package com.github.khaliullin.mpeilab1.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STATS")
@Data
public class Computation {

    @Id
    @Column(name = "ID")
    private  Integer id;

    @Column(name = "WORD_I")
    private Double I;

    @Column(name = "WORD_H")
    private Double H;

    @Column(name = "WORD_N")
    private Integer n;

    @Column(name = "WORD_B")
    private Double B;

    @Column(name = "WORD_M")
    private Double m;

    @Column(name = "WORD_C")
    private Double C;

}
