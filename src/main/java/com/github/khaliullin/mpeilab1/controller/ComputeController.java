package com.github.khaliullin.mpeilab1.controller;

import com.github.khaliullin.mpeilab1.entity.Computation;
import com.github.khaliullin.mpeilab1.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ComputeController {

    @Autowired
    private ComputeService computeService;

    @GetMapping("/computations")
    public List<Computation> getComputes() {
        computeService.compute_H();
        return computeService.compute_B();
    }

}
