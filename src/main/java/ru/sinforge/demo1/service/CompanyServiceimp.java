package ru.sinforge.demo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sinforge.demo1.OtherClasses.*;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CompanyServiceimp implements CompanyService {
    @Autowired
    ITCompany company;


    @Override
    public ITCompany getCompany() {
        return null;
    }

    @Override
    public void addDeveloper(Developer developer) {
        company.addEntity(developer);
    }

    @Override
    public void addDevOps(DevOps devops) {
        company.addEntity(devops);
    }

    @Override
    public List<Employer<ITrole>> getEmployersByRole(ITrole role) {
        List<Employer<ITrole>> employers = company.getEmployers().stream().filter(employer -> employer.getRole().equals(role)).collect(Collectors.toList());
        return employers;
    }

    @Override
    public Employer<ITrole> getEmployerByName(int index) {
        Employer<ITrole> employer = company.getEmployers().get(index);
        return employer;
    }
}
