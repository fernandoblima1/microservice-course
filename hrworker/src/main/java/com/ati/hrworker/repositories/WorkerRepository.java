package com.ati.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ati.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{
  
}
