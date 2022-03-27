package ru.sinforge.demo1.service;

import ru.sinforge.demo1.OtherClasses.*;

import java.util.List;

public interface CompanyService {
    ITCompany getCompany();
    void addDeveloper(Developer developer);
    void addDevOps(DevOps devops);
    List<Employer<ITrole>>  getEmployersByRole(ITrole role);
    Employer<ITrole> getEmployerByName(int index);
}
