package ru.sinforge.demo1.DTO;

import lombok.Data;
import ru.sinforge.demo1.OtherClasses.Employer;
import ru.sinforge.demo1.OtherClasses.ITCompany;
import ru.sinforge.demo1.OtherClasses.ITrole;

import java.util.ArrayList;
import java.util.List;

@Data
public class ITCompanyDTO {
    String director;
    String name;
    List<Employer<ITrole>> employers = new ArrayList<>();
    public static ITCompanyDTO from(ITCompany company) {
        ITCompanyDTO companyDTO = new ITCompanyDTO();
        companyDTO.setDirector(company.getDirector());
        companyDTO.setName(company.getName());
        companyDTO.setEmployers(company.getEmployers());
        return companyDTO;
    }
}
