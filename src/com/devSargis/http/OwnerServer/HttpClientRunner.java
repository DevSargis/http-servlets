package com.devSargis.http.OwnerServer;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;

public class HttpClientRunner {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        var httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build();

        var request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:9000"))
                .header("content-type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString("Gagik")).build();

//        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        var response1 = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        var response2 = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        var response3 = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response3.get().headers());
        System.out.println(response3.get().body());
    }
}
