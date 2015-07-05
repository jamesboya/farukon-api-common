package com.farukon.common.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jamesyan on 7/5/15.
 */
public class RawHttpRequest {
    public static String doHttpGet(String url) {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        StringBuilder pageContent = new StringBuilder();
        try {
            HttpResponse response = client.execute(request);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            reader.lines().forEach(
                    (String data) -> {
                        pageContent.append(data);
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pageContent.toString();
    }

}
