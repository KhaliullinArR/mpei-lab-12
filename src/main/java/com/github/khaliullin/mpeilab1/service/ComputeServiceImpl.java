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
        return null;
    }

    @Override
    public List<Computation> compute_m() {
        return null;
    }


    @Override
    public String getInfelicity() {
        return null;
    }
}
