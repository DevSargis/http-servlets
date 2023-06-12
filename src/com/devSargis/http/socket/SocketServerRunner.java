package com.devSargis.http.socket;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;


//We create Simple TCP server which accept our request first read request, then we check if from our client side
//not send us "stop" keyword we first print that request message, than collect response and inject that response text to output for server side
//then we wait when our client send us new message again
// We use DataInputStream and DataOutputStream classes for UTF format
public class SocketServerRunner {
    public static void main(String[] args) throws IOException {
        try (var serverSocket = new ServerSocket(7777);
             var socket = serverSocket.accept();
             var input = new DataInputStream(socket.getInputStream());
             var output = new DataOutputStream(socket.getOutputStream());
             var scanner = new Scanner(System.in)
             ){
             var request = input.readUTF();
            while (!"stop".equals(request)){
                System.out.println("Uxarkvel e -> "+request);
                var response = scanner.nextLine();
                output.writeUTF(response);
                request = input.readUTF();
            }
        }
    }
}
