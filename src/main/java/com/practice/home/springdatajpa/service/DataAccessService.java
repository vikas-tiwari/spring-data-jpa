package com.practice.home.springdatajpa.service;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContexts;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class DataAccessService {

    public void callApi() throws NoSuchAlgorithmException, KeyManagementException {
        RestTemplate restTemplate = createRestTemplate();
    }

    private RestTemplate createRestTemplate() throws KeyManagementException, NoSuchAlgorithmException {
        HttpClient httpClient = HttpClientBuilder.create().setSSLContext(SSLContexts.custom().useProtocol("TLSv1.2").build()).build();
        /*HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);*/
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        return new RestTemplate(factory);
    }
}


//Whenver we use restTemplate from jdk 7 to call apis which are running on jdk 8 , we might
//get into TLS version error.
