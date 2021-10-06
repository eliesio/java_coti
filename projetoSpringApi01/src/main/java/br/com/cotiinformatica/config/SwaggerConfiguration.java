package br.com.cotiinformatica.config;

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

@Configuration //classe de configuração do Spring Boot
@EnableSwagger2 //habilitar a configuração do swagger
public class SwaggerConfiguration {

	/*
	 * Método que configura o modo de geração da documentação do Swagger
	 */
	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.cotiinformatica"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.apiInfo(apiInfo());
	}
	
	/*
	 * Método para personalizar o conteudo da documentação
	 */
	private ApiInfo apiInfo() {
		return new ApiInfo(
				"API para controle de clientes",
				"Sistema de API desenvolvido em SprignBoot com Hibernate e JPA",
				"Versão 1.0",
				"http://www.cotiinformatica.com.br",
				new Contact("COTI Informática", "http://www.cotiinformatica.com.br", 
						"contato@cotiinformatica.com.br"),
				"Licença da API",
				"http://www.cotiinformatica.com.br",
				Collections.emptyList()
				);
	}	
}
