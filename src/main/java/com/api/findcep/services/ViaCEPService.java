package com.api.findcep.services;

import com.api.findcep.entities.Address;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ViaCEPService {
    public Address getAdress(String cep) throws IOException {

        Address adress = null;
        HttpGet request = new HttpGet("https://viacep.com.br/ws/"+cep+"/json/");

        try(CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
            CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();

            if(entity != null) {
                String result = EntityUtils.toString(entity);

                Gson gson = new Gson();

                adress = gson.fromJson(result, Address.class);
            }
        }

        return adress;
    }
}
