package com.devSargis.http.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.Scanner;

//This is TCP Client, when we start our client without running server we get error because TCP work is following way, first of all we must check connection with server
//then when we get OK status we can use that server, our code is following, we use our local machine that is way we use localhost, and because we run our server on the 7777 port
//we must set on hte Socket object our port too, and then we declare scanner which get new line and that text we save on the request variable and send to request via toServerInput.writeUTF(request);
//then we wait server answer and print that answer
public class SocketRunner {
    public static void main(String[] args) throws IOException {
//        http -> 80;
//        https -> 443;

//       There we create simple CLIENT,who send request to google.com server and wait answer, we see that we have something response when we send Hello World text to google server
        var inetAddress = Inet4Address.getByName("localhost");
        try(var socket = new Socket(inetAddress, 7777);
            var toServerInput = new DataOutputStream(socket.getOutputStream());
            var ServerResponse = new DataInputStream(socket.getInputStream());
            var scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()){
                var request = scanner.nextLine();
                toServerInput.writeUTF(request);
                var response = ServerResponse.readUTF();
                System.out.println("serveric ekac -> "+ response);
            }

        }
    }
}
