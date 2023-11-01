package com.example.xml;

import com.example.xml.business.abstracts.IProduct;
import com.example.xml.business.concretes.ProductManager;
import com.example.xml.dataAccess.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class XmlApplication {



    public static void main(String[] args) {
        SpringApplication.run(XmlApplication.class, args);



    }


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.xml"))
                .build();
    }


}
