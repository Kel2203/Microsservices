package com.javalearn.hrworker.resources;

import com.javalearn.hrworker.entities.Worker;
import com.javalearn.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
    @Autowired
    private WorkerRepository repository;


    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs() {
        //logger.info("CONFIG = " + testConfig);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){

       Worker obj = repository.findById(id).get();
        return ResponseEntity.ok(obj);
    }
}
