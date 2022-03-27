package ru.sinforge.demo1.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sinforge.demo1.OtherClasses.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    ITCompany company;

    @GetMapping
    public ITCompany getCompany() {
        return company;
    }

    @PostMapping("/employers/developers")
    public ResponseEntity addDeveloper(@RequestBody Developer developer) {
        log.info("add developer");
        company.addEntity(developer);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/employers/devops")
    public ResponseEntity addDevOps(@RequestBody DevOps devOps) {
        log.info("add DevOps");
        company.addEntity(devOps);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/employers/{index}")
    public ResponseEntity<Employer<ITrole>> getEmployerByIndex(@PathVariable int index) {
         try {
             Employer<ITrole> employer = company.getEmployers().get(index);
             return ResponseEntity.ok(employer);
         }
         catch(IndexOutOfBoundsException e) {
             return ResponseEntity.notFound().build();
         }
    }

    @GetMapping("/employers/find")
    public ResponseEntity<List<Employer<ITrole>>> getEmployerByRole(@RequestParam(name = "role") ITrole role) {
        List<Employer<ITrole>> employers = company.getEmployers().stream().filter(employer -> employer.getRole().equals(role)).collect(Collectors.toList());
        return ResponseEntity.ok(employers);
    }

}
