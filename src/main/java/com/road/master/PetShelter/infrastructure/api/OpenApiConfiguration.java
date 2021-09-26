package com.road.master.PetShelter.infrastructure.api;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(name = "security_auth", type = SecuritySchemeType.OAUTH2,
    flows = @OAuthFlows(authorizationCode = @OAuthFlow(
        authorizationUrl = "${springdoc.oAuthFlow.authorizationUrl}"
        , tokenUrl = "${springdoc.oAuthFlow.tokenUrl}",scopes = {
        @OAuthScope(name = "IdentityPortal.API", description = "IdentityPortal.API")})))
public class OpenApiConfiguration {

/*  @Bean
  public OpenAPI openAPI(){
    return new OpenAPI()
        .components(new Components()
            .addSecuritySchemes("OAuthScheme", new SecurityScheme()
                .type(SecurityScheme.Type.OAUTH2)
                .description("OAuth2 authentication")
                .flows(new OAuthFlows()
                    .clientCredentials(new OAuthFlow()
                        .authorizationUrl("https://github.com/login/oauth/authorize")
                        .tokenUrl("https://github.com/login/oauth/access_token")
                        .scopes(new Scopes()
                            .addString("full_access", "access pets")
                        )
                    ))));*//*
        .addSecurityItem(new SecurityRequirement().addList("OAuthScheme"));*//*
  }*/
}
