package com.casa_camarim.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//Indica que esta classe é uma classe de configuração do Spring.
//Classes anotadas com @Configuration podem definir beans que serão gerenciados pelo Spring.
public class CorsConfig {
	
	// Cria um bean do tipo WebMvcConfigurer, que permite customizar a configuração do Spring MVC.
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
		
	// Configura o CORS (Cross-Origin Resource Sharing)		
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**") // todas as rotas
			.allowedOrigins("http://localhost:5173") // React
			.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Define os métodos HTTP permitidos
			.allowedHeaders("*") // Permite qualquer cabeçalho nas requisições
			.allowCredentials(true); // Permite envio de cookies e credenciais nas requisições
    }
   };
  };
 }


