package br.com.betApi.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Configuração global de CORS (Cross-Origin Resource Sharing).
 * Esta classe define as regras de CORS para permitir que aplicações front-end acessem a API.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Configura as regras de CORS para a aplicação.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Aplica as configurações de CORS a todas as rotas da API.
                .allowedOrigins("http://localhost:3000") // Permite solicitações CORS do front-end em desenvolvimento.
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permite métodos HTTP específicos nas solicitações CORS.
                .allowedHeaders("*") // Permite todos os cabeçalhos em solicitações CORS.
                .allowCredentials(true); // Permite o envio de credenciais (cookies, headers de autorização, etc.) nas solicitações CORS.
    }
}