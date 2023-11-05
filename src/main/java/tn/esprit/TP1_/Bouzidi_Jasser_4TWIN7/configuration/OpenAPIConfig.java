package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(infoAPI());

    }
    public Info infoAPI() {
        return new Info().title("SpringDoc-Demo")
                .description("TP étude de cas")
                .contact(contactAPI());

    }
    public Contact contactAPI() {
        Contact contact = new Contact().name("Equipe ASI II")

                        .email("*************@esprit.tn")
                .url("https://www.linkedin.com/in/**********/");
        return contact;


}
    @Bean
    public GroupedOpenApi foyerPublicApi() {
        return GroupedOpenApi.builder()

                .group("Only Foyer Management API").pathsToMatch("/foyers/**")
                .pathsToExclude("**")
                .build();

    }
    @Bean
    public GroupedOpenApi PublicApi() {
        return GroupedOpenApi.builder()

                .group("ALL APIS")

                                .pathsToMatch("/**")

                                .build();

    }}
