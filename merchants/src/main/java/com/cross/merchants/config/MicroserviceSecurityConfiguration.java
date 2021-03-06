package com.cross.merchants.config;


import com.cross.merchants.security.AuthoritiesConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class MicroserviceSecurityConfiguration extends ResourceServerConfigurerAdapter {
    private final Logger log = LoggerFactory.getLogger(MicroserviceSecurityConfiguration.class);

    private final DiscoveryClient discoveryClient;

    public MicroserviceSecurityConfiguration(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    public void configure(WebSecurity web) {
        web.ignoring()
            .antMatchers(HttpMethod.OPTIONS, "/**")
            .antMatchers("/app/**/*.{js,html}")
            .antMatchers("/bower_components/**")
            .antMatchers("/i18n/**")
            .antMatchers("/content/**")
            .antMatchers("/swagger-ui/index.html")
            .antMatchers("/test/**")
            .antMatchers("/h2-console/**");
    }

    @Override
    public void configure(HttpSecurity http) {
        try {
            http
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()

                .antMatchers("/api/goods-by-condition-by-c").permitAll()
                .antMatchers("/api/goods/**").permitAll()

                .antMatchers("/api/goods/guess-you-like").permitAll()
                .antMatchers("/api/system-infos-background-pic/").permitAll()
                .antMatchers("/api/find-list-goods-by-condition-by-c").permitAll()
                .antMatchers("/api/find-list-brand-by-condition-by-c").permitAll()
                .antMatchers("/api/goods/**").permitAll()
                .antMatchers("/api/article-infos-c").permitAll()
                .antMatchers("/api/article-infos/**").permitAll()
                .antMatchers("/api/update-pageview-article-infos/**").permitAll()
                .antMatchers("/api/store-infos-c/**").permitAll()
                .antMatchers("/api/c-banner-infos-all").permitAll()
                .antMatchers("/api/c-banner-merchant-infos-all/**").permitAll()
                .antMatchers("/api/c-goods-recommends").permitAll()

                .antMatchers("/api/c-goods-recommends-all").permitAll()
                .antMatchers("/api/c-goods-categories").permitAll()
                .antMatchers("/api/c-goods-recommend-banners").permitAll()
                .antMatchers("/api/store-recommends-list").permitAll()
                .antMatchers("/api/c-banner-infos").permitAll()
                .antMatchers("/api/goods-categories-by-level/**").permitAll()

                .antMatchers("/api/goods-categories-by-level/**").permitAll()
                .antMatchers("/api/goods-categories-by-pid/**").permitAll()
                .antMatchers("/api/goods/keyword-query").permitAll()
                .antMatchers("/api/system-infos-background-pic").permitAll()
                .antMatchers("/api/notify/alipay/pay").permitAll()
                .antMatchers("/api/notify/weixin/pay").permitAll()
                .antMatchers("/api/**").authenticated()
                .antMatchers("/management/health").permitAll()
                .antMatchers("/management/**").hasAuthority(AuthoritiesConstants.ADMIN)
                .antMatchers("/swagger-resources/configuration/ui").permitAll();

        } catch (Exception e) {
            log.error("micro service security init fail:", e);
        }
    }

    @Bean
    public TokenStore tokenStore(JwtAccessTokenConverter jwtAccessTokenConverter) {
        return new JwtTokenStore(jwtAccessTokenConverter);
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(
        @Qualifier("loadBalancedRestTemplate") RestTemplate keyUriRestTemplate) {

        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setVerifierKey(getKeyFromAuthorizationServer(keyUriRestTemplate));
        return converter;
    }

    @Bean
    public RestTemplate loadBalancedRestTemplate(RestTemplateCustomizer customizer) {
        RestTemplate restTemplate = new RestTemplate();
        customizer.customize(restTemplate);
        return restTemplate;
    }

    private String getKeyFromAuthorizationServer(RestTemplate keyUriRestTemplate) {
        // Load available UAA servers
        discoveryClient.getServices();
        HttpEntity<Void> request = new HttpEntity<Void>(new HttpHeaders());
        return (String) keyUriRestTemplate
            .exchange("http://uaa/oauth/token_key", HttpMethod.GET, request, Map.class).getBody()
            .get("value");

    }
}

