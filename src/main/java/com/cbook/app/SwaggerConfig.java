package com.cbook.app;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				//.paths(PathSelectors.ant("/api/capp/*"))
				.apis(RequestHandlerSelectors.basePackage("com.cbook.app")).paths(PathSelectors.any()).build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Contact REST API", "API for Contacts operations", "v.01", "Terms of service",
				new Contact("Rajesh", "https://www.github.com/itsmrajesh", "admin@nextgen.com"), "License of API", "https://www.github.com/itsmrajesh",
				Collections.emptyList());
	}
}
