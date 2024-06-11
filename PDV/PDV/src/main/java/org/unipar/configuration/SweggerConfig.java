package org.unipar.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SweggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("PDV Unipar - Rest API")
                        .description("API para um aplicativo de Ponto de Vendas (PDV)." +
                                " Trabalho de Programação para Internet," +
                                " Curso de Análise e Desenvolvimento de Sistemas," +
                                " Universidade Paranaense - UNIPAR." +
                                " Valor: 2.0")
                        .version("1.0")
                ).externalDocs(
                        new ExternalDocumentation()
                                .description("Unipar")
                                .url("http://www.unipar.br"));
    }
}
