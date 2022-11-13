package org.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = {"org.configclient"})
public class SpringClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringClientApplication.class, args);
    }
}
