package ru.sinforge.demo1.OtherClasses;

import java.util.ArrayList;
import java.util.List;

public class ITCompany {
    String director;
    String name;
    List<Employer<ITrole>> employers = new ArrayList<>();




    public ITCompany(String director, String name) {
        this.director = director;
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addEntity(Employer<ITrole> employer) {
        employers.add(employer);
    }
    public List<Employer<ITrole>> getEmployers () {
        return employers;
    }
}
