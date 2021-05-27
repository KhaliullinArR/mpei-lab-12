package com.github.khaliullin.mpeilab1.controller;

import com.github.khaliullin.mpeilab1.entity.Computation;
import com.github.khaliullin.mpeilab1.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
public class ComputeController {


    private final ComputeService computeService;

    @Autowired
    public ComputeController(ComputeService computeService) {
        this.computeService = computeService;
    }

    @PostConstruct
    private void init() {
        computeService.compute_H();
        computeService.compute_B();
        computeService.compute_m();
    }

    @GetMapping("/J(h)")
    public String JofH() {
        List<Computation> computations = computeService.getAll();
        StringWriter output = new StringWriter();
        PrintWriter printWriter = new PrintWriter(output);

        double J;

        for (Computation computation : computations) {
            J = (computation.getB()/(1.2566*0.000001)) - computation.getH();
            printWriter.println(String.format("(%s; %s)",computation.getH(), J));
        }

        return output.toString();

    }

    @GetMapping("/b(h)")
    public String BofH() {
        List<Computation> computations = computeService.getAll();
        StringWriter output = new StringWriter();
        PrintWriter printWriter = new PrintWriter(output);
        for (Computation computation : computations) {
            //printWriter.println(String.format("B:%.4f H:%s",computation.getB(), Math.round(computation.getH())));
            printWriter.println(String.format("(%s; %.4f) ", Math.round(computation.getH()),computation.getB()));
        }

        return output.toString();

    }

    @GetMapping("/m(h)")
    public String UofH() {
        List<Computation> computations = computeService.getAll();
        StringWriter output = new StringWriter();
        PrintWriter printWriter = new PrintWriter(output);
        for (Computation computation : computations) {
            //printWriter.println(String.format("B:%.4f H:%s",computation.getB(), Math.round(computation.getH())));
            printWriter.println(String.format(Locale.US,"(%s; %s) ", Math.round(computation.getH()),computation.getM()));
        }
        return output.toString();

    }


    @GetMapping("/computations")
    public List<Computation> getComputes() {
        return computeService.getAll();
    }

    @GetMapping("/fault")
    public String getFault() {
        return computeService.getInfelicity();
    }

}
