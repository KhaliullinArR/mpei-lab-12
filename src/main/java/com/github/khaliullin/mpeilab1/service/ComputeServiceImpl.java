package com.github.khaliullin.mpeilab1.service;

import com.github.khaliullin.mpeilab1.entity.Computation;
import com.github.khaliullin.mpeilab1.repository.ComputeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComputeServiceImpl implements ComputeService{


    private ComputeRepo computeRepo;

    @Autowired
    public void setComputeRepo(ComputeRepo computeRepo) {
        this.computeRepo = computeRepo;
    }

    @Override
    public List<Computation> getAll() {
        return computeRepo.findAll();
    }

    @Override
    public List<Computation> compute_H() {

        List<Computation> computations = computeRepo.findAll();

        double H;

        for (Computation computation : computations) {
            H = (computation.getI() * 2500) / 0.3;
            computation.setH(H);
        }

        computeRepo.saveAll(computations);

        return computations;
    }

    @Override
    public List<Computation> compute_B() {

        List<Computation> computations = computeRepo.findAll();

        double B;
        double C;
        double S;
        double A;

        for (Computation computation : computations) {
             A = Math.pow(3d, -8d);
             S = Math.pow(0.8, -4d);
             C = (A * 600) / (2 * S * 10);
             B = C * computation.getN();
             computation.setB(B);
             computation.setC(C);
        }

        computeRepo.saveAll(computations);

        return computations;
    }

    @Override
    public List<Computation> compute_m() {

        List<Computation> computations = computeRepo.findAll();

        double m;

        for (Computation computation : computations) {


        }

        computeRepo.saveAll(computations);

        return null;
    }


    @Override
    public String getInfelicity() {
        return null;
    }
}
