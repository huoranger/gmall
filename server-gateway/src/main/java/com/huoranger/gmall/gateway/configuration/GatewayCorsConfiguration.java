package com.huoranger.gmall.gateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class GatewayCorsConfiguration {

    @Bean
    public CorsWebFilter corsWebFilter() {
        return new CorsWebFilter(urlBasedCorsConfigurationSource());
    }

    private UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource() {
        //配置CORS
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //1.配置允许访问域名
        corsConfiguration.addAllowedOrigin("*");
        //2.配置允许访问方式 POST DELETE GET
        corsConfiguration.addAllowedMethod(HttpMethod.DELETE);
        corsConfiguration.addAllowedMethod(HttpMethod.GET);
        corsConfiguration.addAllowedMethod(HttpMethod.PUT);
        corsConfiguration.addAllowedMethod(HttpMethod.POST);
        corsConfiguration.addAllowedMethod(HttpMethod.OPTIONS);
        //3.配置允许提交头信息
        corsConfiguration.addAllowedHeader("*");
        //4.配置是否允许提交cookie
        corsConfiguration.setAllowCredentials(true);
        //5.配置预检请求有效时间
        corsConfiguration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //注册CORS配置
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

}
