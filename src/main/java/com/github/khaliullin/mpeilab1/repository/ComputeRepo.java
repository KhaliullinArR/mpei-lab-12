package com.github.khaliullin.mpeilab1.repository;

import com.github.khaliullin.mpeilab1.entity.Computation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputeRepo extends JpaRepository<Integer, Computation> {
}
