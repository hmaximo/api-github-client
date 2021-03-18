package br.com.desafio.githubclient.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo())
            .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
            "Tagging GitHub Repositories", 
            "API to create the possibility for you to tag your starred GitHub repositories", 
            "1.0.0", 
            "", 
            new Contact("Helena Maximo", "https://github.com/hmaximo", "hmaximo@gmail.com") , 
            "free license", 
            "undefined yet", 
            Collections.emptyList());
    }
}
