package com.aynulin.dalividali.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by Aynulin on 18.02.2017.
 */

@Configuration
@ComponentScan(basePackages = {
})
@Import({PersistenceContext.class, WebAppContext.class })
@PropertySource("classpath:application.properties")
public class ApplicationContext {
    @Bean
    public PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
