package org.configclient;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "email")
@Getter
@Setter
public class AppProperties {
    private String username;
    private String password;
}
