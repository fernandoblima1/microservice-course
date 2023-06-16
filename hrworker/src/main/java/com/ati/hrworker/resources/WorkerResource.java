package com.ati.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ati.hrworker.entities.Worker;
import com.ati.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping("/worker")
public class WorkerResource {
  
  @Autowired
  private WorkerRepository repository;

  @GetMapping
  public ResponseEntity<List<Worker>> findAll(){
    List<Worker> list = repository.findAll();
    return ResponseEntity.ok(list);
  }

}
