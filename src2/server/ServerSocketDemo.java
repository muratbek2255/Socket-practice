package server;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class ServerSocketDemo {
    public static void main(String[] args) throws Exception{
        try (ServerSocket serverSocket = new ServerSocket(8081)) {
            Socket socket = serverSocket.accept();
            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Hello");

            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                writer.println("you've send " + str);
                System.out.println(str);
                if(str.equals("exit")) {
                    break;
                }
            }
        }
    }
}
