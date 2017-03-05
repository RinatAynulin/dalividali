package com.aynulin.dalividali.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by Aynulin on 18.02.2017.
 */

@Configuration
@ComponentScan(basePackages = {
        "com.aynulin.dalividali.app.service",
        "com.aynulin.dalividali.user.service"
})
@Import({PersistenceContext.class, WebAppContext.class, SocialContext.class, SecurityContext.class})
@PropertySource("classpath:application.properties")
public class ApplicationContext {
    @Bean
    public PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
