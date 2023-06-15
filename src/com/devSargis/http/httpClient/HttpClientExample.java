package com.devSargis.http.httpClient;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

/**
 * HttpClient Class released in java 11 and it is vary modern class to work with Request and Response, it is also in the .net package and have very easy and very good functionality
 * to work with request for example we can Create simple HttpClient
 * We can easely create post, delete, update, get request via HttpClient Class, and also body etc.
 * */
public class HttpClientExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        var httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        var httpRequest = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                .GET()
                .build();
        HttpRequest request2 = HttpRequest.newBuilder(URI.create("https://google.com"))
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of("path", "to", "file")))
                .build();

        var response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.headers());
        System.out.println(response.body());
    }
}
