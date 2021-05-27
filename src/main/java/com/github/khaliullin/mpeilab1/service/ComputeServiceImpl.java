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
    public void compute_H() {

        List<Computation> computations = computeRepo.findAll();

        double H;

        for (Computation computation : computations) {
            H = (computation.getI() * 2500) / 0.3;
            computation.setH(H);
        }

        computeRepo.saveAll(computations);

    }

    @Override
    public void compute_B() {

        List<Computation> computations = computeRepo.findAll();

        double B;
        double C;
        double S;
        double A;

        for (Computation computation : computations) {
             A = 3d *  Math.pow(10, -8);
             S = 0.8 * Math.pow(10, -4);
             C = (A * 600) / (2 * S * 10);
             B = C * computation.getN();
             computation.setB(B);
             computation.setC(C);
        }

        computeRepo.saveAll(computations);

    }

    @Override
    public void compute_m() {

        List<Computation> computations = computeRepo.findAll();

        double m;

        for (Computation computation : computations) {
            m = computation.getB()/(computation.getH()*1.2566*0.000001);
            computation.setM(m);
        }

        computeRepo.saveAll(computations);

    }


    @Override
    public String getInfelicity() {

        Computation max = computeRepo.findById(1).get();

        double delta_h = max.getH()*Math.sqrt(
                Math.pow(0.00075/max.getI(),2)+
                Math.pow(0.5/2500, 2)+
                Math.pow(0.005/0.3, 2)
        );

        double delta_b = max.getB()*Math.sqrt(
                        Math.pow(0.02,2)+
                        Math.pow(1d/max.getN(), 2)+
                        Math.pow(0.05/600, 2)+
                        Math.pow(0.5/10,2)+
                        Math.pow(0.005/0.8,2)
        );


        double delta_m = max.getM()*Math.sqrt(
                        Math.pow(0.04/max.getB(),2)+
                        Math.pow(10/max.getH(), 2)
        );

        String FORMAT = "H = %s \u00B1 %s\n" +
                "B = %s \u00B1 %s\n" +
                "u = %s \u00B1 %s\n";



        return String.format(FORMAT, max.getH(), delta_h,
                max.getB(), delta_b,
                max.getM(), delta_m);
    }
}
