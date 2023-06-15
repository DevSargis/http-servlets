package com.devSargis.http.httpClient;

import java.io.IOException;
import java.net.URL;
/**
 * Okay in the socket package we already know how we should work with UDP and TCP protocols via Java language
 * Now We start learn How we should work with Tcp protocol via java language, and first we get accounted with URL class
 * URL class in general is created for only for GET method but we can use it for POST, UPDATE etc. methods too, for get we must pass url in the constructor
 * then we must open connection for that and then we can for example get which header return us form google.com
 * but also we can change protocol, and use URL class for read file from  our local machine
 * ***/
public class URLExample {
    public static void main(String[] args) throws IOException {
        var url =  new URL("file:C:\\Users\\PC\\Documents\\Microservices\\http-servlets-starter\\src\\com\\devSargis\\http\\socket\\SocketRunner.java");
        var urlConnection = url.openConnection();
        System.out.println(new String(urlConnection.getInputStream().readAllBytes()));
    }

    private static void checkGoogle()throws IOException{
        var url = new URL("https://www.google.com");
        var urlConnection = url.openConnection();
        System.out.println(urlConnection.getHeaderFields());
    }

}
