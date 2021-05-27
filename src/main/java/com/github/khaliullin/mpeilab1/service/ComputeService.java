package com.github.khaliullin.mpeilab1.service;

import com.github.khaliullin.mpeilab1.entity.Computation;

import java.util.List;

public interface ComputeService {
    List<Computation> getAll();

    void compute_H();

    void compute_B();

    void compute_m();

    String getInfelicity();
}
