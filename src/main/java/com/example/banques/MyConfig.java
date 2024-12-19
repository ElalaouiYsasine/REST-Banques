package com.example.banques;

import com.example.banques.web.CompteRestJaxAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean //pour jersy activer/desactiver
    public ResourceConfig resourceConfig() {
        ResourceConfig jersey = new ResourceConfig();
        jersey.register(CompteRestJaxAPI.class);
        return jersey;
    }
}
