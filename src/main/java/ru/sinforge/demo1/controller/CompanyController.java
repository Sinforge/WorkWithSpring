package ru.sinforge.demo1.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sinforge.demo1.DTO.ITCompanyDTO;
import ru.sinforge.demo1.OtherClasses.*;
import ru.sinforge.demo1.service.CompanyService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ITCompanyDTO getCompany() {
        return ITCompanyDTO.from(companyService.getCompany());
    }

    @PostMapping("/employers/developers")
    public ResponseEntity addDeveloper(@RequestBody Developer developer) {
        log.info("add developer");
        companyService.addDeveloper(developer);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/employers/devops")
    public ResponseEntity addDevOps(@RequestBody DevOps devOps) {
        log.info("add DevOps");
        companyService.addDevOps(devOps);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/employers/{index}")
    public ResponseEntity<Employer<ITrole>> getEmployerByIndex(@PathVariable int index) {
         try {

             return ResponseEntity.ok(companyService.getEmployerByName(index));
         }
         catch(IndexOutOfBoundsException e) {
             return ResponseEntity.notFound().build();
         }
    }

    @GetMapping("/employers/find")
    public ResponseEntity<List<Employer<ITrole>>> getEmployerByRole(@RequestParam(name = "role") ITrole role) {
        return ResponseEntity.ok(companyService.getEmployersByRole(role));
    }

}
