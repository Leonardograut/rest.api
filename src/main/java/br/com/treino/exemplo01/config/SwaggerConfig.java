package br.com.treino.exemplo01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;

import springfox.documentation.spring.web.plugins.Docket;







@Configuration
public class SwaggerConfig {
    

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
        .useDefaultResponseMessages(false)
        .select()
        .apis(RequestHandlerSelectors.basePackage("br.com.treino.exemplo01.controle"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfo()); 
        
    }


    private ApiInfo apiInfo(){

        return new ApiInfoBuilder()

        .title("Simples API")
        .description("Api Spring Boot")
        .version("1.0.8")
        .contact( new Contact("Leonardo Nascimento","https://github.com/Leonardograut", "omgleo@live.com"))
        .build();
    }

    















}