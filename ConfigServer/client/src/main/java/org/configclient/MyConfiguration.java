package org.configclient;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    private final AppProperties appProperties;

    public MyConfiguration(AppProperties appProperties){
        this.appProperties = appProperties;
        System.out.println("username : " + appProperties.getUsername());
        System.out.println("password : " + appProperties.getPassword());

    }

}
