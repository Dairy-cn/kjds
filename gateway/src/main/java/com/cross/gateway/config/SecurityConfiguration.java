package com.cross.gateway.config;

import com.cross.gateway.config.oauth2.OAuth2JwtAccessTokenConverter;
import com.cross.gateway.config.oauth2.OAuth2Properties;
import com.cross.gateway.security.oauth2.OAuth2SignatureVerifierClient;
import com.cross.gateway.security.AuthoritiesConstants;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableResourceServer
public class SecurityConfiguration extends ResourceServerConfigurerAdapter {
    private final OAuth2Properties oAuth2Properties;

    private final CorsFilter corsFilter;

    public SecurityConfiguration(OAuth2Properties oAuth2Properties, CorsFilter corsFilter) {
        this.oAuth2Properties = oAuth2Properties;
        this.corsFilter = corsFilter;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
            .ignoringAntMatchers("/h2-console/**")
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        .and()
            .addFilterBefore(corsFilter, CsrfFilter.class)
            .headers()
            .frameOptions()
            .disable()
        .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
            .authorizeRequests()
            .antMatchers("/api/**").authenticated()
            .antMatchers("/api/auth/login").permitAll()
            .antMatchers("/management/health").permitAll()
            .antMatchers("/management/info").permitAll()
            .antMatchers("/management/prometheus").permitAll()
            .antMatchers("/management/**").hasAuthority(AuthoritiesConstants.ADMIN);
        http.csrf().disable();
    }

    @Bean
    public TokenStore tokenStore(JwtAccessTokenConverter jwtAccessTokenConverter) {
        return new JwtTokenStore(jwtAccessTokenConverter);
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(OAuth2SignatureVerifierClient signatureVerifierClient) {
        return new OAuth2JwtAccessTokenConverter(oAuth2Properties, signatureVerifierClient);
    }

    @Bean
    @Qualifier("loadBalancedRestTemplate")
    public RestTemplate loadBalancedRestTemplate(RestTemplateCustomizer customizer) {
        RestTemplate restTemplate = new RestTemplate();
        customizer.customize(restTemplate);
        return restTemplate;
    }

    @Bean
    @Qualifier("vanillaRestTemplate")
    public RestTemplate vanillaRestTemplate() {
        return new RestTemplate();
    }
}
