package ru.sinforge.demo1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sinforge.demo1.OtherClasses.ITCompany;

@Configuration
public class CompanyConfig {
    @Bean
    public ITCompany getCompany() {
        return new ITCompany("Vlad","RTUITLab");
    }
}
