package com.example.feelerbackend.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Controller
@ApiIgnore
public class SwaggerConfig {
    private final static String API_TITLE = "Feeler API";
    private final static String API_DESCRIPTION = "The API description for endpoints used by the front-end application of the Feeler project.";
    private final static String API_VERSION = "0.1.0";

    @GetMapping("/api")
    public String swagger(){
        return "redirect:/swagger-ui.html";
    }

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title(API_TITLE)
                        .description(API_DESCRIPTION)
                        .version(API_VERSION)
                        .build())
                .tags(
                        new Tag("Books", "Endpoints for book info interaction"),
                        new Tag("Bookshelves", "Endpoints for users' bookshelf interaction"),
                        new Tag("Exploring", "Endpoints for explore interactions"),
                        new Tag("Moods", "Endpoints for mood value interaction"),
                        new Tag("Users", "Endpoints for user interaction")
                );
    }
}
