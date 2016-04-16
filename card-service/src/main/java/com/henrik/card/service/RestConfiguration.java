package com.henrik.card.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * This class is only needed to enable CORS (Cross Origin Resource Sharing).
 * Spring Data Rest uses the HATEOAS style for the rest services and this is not supported by Angular out of the box.
 * Therefore some magic is required to make that work in the controller. In addition, this is needed to make sure the data gets back to the caller. Wothout this class
 * it would be stopped and the result would be an HTML error in loading the page and showing empty results.
 */
//@Configuration
public class RestConfiguration {

    @Bean
    public CorsFilter corsFilter() {

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // you USUALLY want this
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }


}
