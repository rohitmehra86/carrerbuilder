package com.domain.carrer.builder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.carrer.builder.entity.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long>{

}