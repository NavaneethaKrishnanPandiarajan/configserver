package org.placeholder;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@Slf4j
@RequestMapping(value="config/v1")
public class ProxyController {

    private final RestTemplate restTemplate;

    public ProxyController(RestTemplateBuilder builder){
        this.restTemplate = builder.rootUri("http://localhost:8888").build();
    }

    @GetMapping(value= "/{name}/{profile}")
    @PostMapping(value = "/{name}/{profile}")
    public ResponseEntity<?> get(@PathVariable("name") String applicationName,
                                 @PathVariable("profile") String profile){

        String path = "/"+applicationName+"/"+profile;
        UriComponents uriComponents = UriComponentsBuilder.fromPath(path).build();
        RequestEntity<Void> requestEntity = RequestEntity.get(uriComponents.toUri()).build();
        ParameterizedTypeReference<String> responseType = new ParameterizedTypeReference<String>() {
        };

        ResponseEntity<String> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET,requestEntity,responseType);
        String body = response.getBody();
        return ResponseEntity.ok(body);
    }

}
