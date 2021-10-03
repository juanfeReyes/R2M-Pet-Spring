package com.road.master.PetShelter.infrastructure.api.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .exceptionHandling()
        //.authenticationEntryPoint(new Http403ForbiddenEntryPoint())
        .and()
        .authorizeRequests()
        .antMatchers("/swagger-ui.html/**", "/swagger-ui/**", "/api-docs/**")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .oauth2ResourceServer(oauth2 -> oauth2.jwt());
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web
        .ignoring()
        .antMatchers(
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/api-docs/**");
  }
}
