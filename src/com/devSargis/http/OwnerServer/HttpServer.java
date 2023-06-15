package com.devSargis.http.OwnerServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {
    private final int PORT;
    private final ExecutorService pool;

    private boolean stopped;

    public HttpServer(int port, int poolSize) {
        PORT = port;
        this.pool = Executors.newFixedThreadPool(poolSize);
    }

    public void run(){
        try{
            var server = new ServerSocket(PORT);
            while (!stopped) {
                var socket = server.accept();
                System.out.println("Socket accepted");
                pool.submit(() -> {
                    processSocket(socket);
                });
            }
        }catch (IOException ex){
            throw new RuntimeException();
        }
    }

    private void processSocket(Socket socket) {
        try(socket;
            var inputStream = new DataInputStream(socket.getInputStream());
            var outputStream = new DataOutputStream(socket.getOutputStream())) {
                  // step 1 handle request
                        System.out.println(" Request " + new String(inputStream.readNBytes(200)));
                  // step 2 handle response
                  var body = "BODY: S";

                  var headers = """
                               HTTP/1.1 200 OK
                               content-type: text/html
                               content-length: %s
                               """.formatted(body.length()).getBytes();

                  outputStream.write(headers);
                  outputStream.write(System.lineSeparator().getBytes());
                  outputStream.write(body.getBytes());
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}
