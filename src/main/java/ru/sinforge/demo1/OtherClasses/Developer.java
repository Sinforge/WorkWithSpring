package ru.sinforge.demo1.OtherClasses;

public class Developer extends Employer<ITrole> {
    public Developer(String name, int age) {
        super(name, age, ITrole.Developer);
    }
}
