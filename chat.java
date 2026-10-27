import java.net.*;
import java.io.*;

public class ChatServer {
    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(5000);

        System.out.println("Waiting for client...");
        Socket s = ss.accept();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(s.getInputStream()));

        PrintWriter out = new PrintWriter(
                s.getOutputStream(), true);

        BufferedReader keyboard = new BufferedReader(
                new InputStreamReader(System.in));

        String msg;

        while (true) {

            // Receive message
            msg = in.readLine();

            if (msg.equals("exit"))
                break;

            System.out.println("Client: " + msg);

            // Send message
            System.out.print("You: ");
            msg = keyboard.readLine();

            out.println(msg);

            if (msg.equals("exit"))
                break;
        }

        s.close();
        ss.close();
    }
}

import java.net.*;
import java.io.*;

public class ChatClient {
    public static void main(String[] args) throws Exception {

        Socket s = new Socket("localhost", 5000);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(s.getInputStream()));

        PrintWriter out = new PrintWriter(
                s.getOutputStream(), true);

        BufferedReader keyboard = new BufferedReader(
                new InputStreamReader(System.in));

        String msg;

        while (true) {

            // Send message
            System.out.print("You: ");
            msg = keyboard.readLine();

            out.println(msg);

            if (msg.equals("exit"))
                break;

            // Receive message
            msg = in.readLine();

            System.out.println("Server: " + msg);

            if (msg.equals("exit"))
                break;
        }

        s.close();
    }
}
