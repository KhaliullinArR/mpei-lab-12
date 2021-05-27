package com.github.khaliullin.mpeilab1.service;

import com.github.khaliullin.mpeilab1.entity.Computation;

import java.util.List;

public interface ComputeService {
    List<Computation> getAll();

    List<Computation> compute_H();

    List<Computation> compute_B();

    List<Computation> compute_m();

    String getInfelicity();
}
