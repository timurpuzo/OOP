package org.example.week12;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.List;

import java.io.*;
import java.net.*;
import java.util.*;

public class Task {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java ChatClient <username> <server_ip>");
            return;
        }

        String username = args[0];
        String serverIp = args[1];
        int port = 12345;

        try (Socket socket = new Socket(serverIp, port);
             BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter serverWriter = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {

            serverWriter.println(username);

            new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = serverReader.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            String clientMessage;
            while ((clientMessage = consoleReader.readLine()) != null) {
                serverWriter.println(clientMessage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ChatServer {
    private final List<ClientHandler> clients = new ArrayList<>();

    public void start(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Chat server running on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void broadcastMessage(String message, ClientHandler sender) {
        synchronized (clients) {
            for (ClientHandler client : clients) {
                if (client != sender) {
                    client.sendMessage(message);
                }
            }
        }
    }


    private class ClientHandler implements Runnable {
        private final Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;
        private String username;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);

                username = reader.readLine();
                System.out.println(username + " has joined chat");
                broadcastMessage(username + " has joined chat.", this);

                String message;

                while ((message = reader.readLine()) != null) {
                    System.out.println(username + " : " + message);
                    broadcastMessage(username + " : " + message, this);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clients.remove(this);
                broadcastMessage(username + " has left chat.", this);
                System.out.println(username + " has left the chat");
            }
        }

        public void sendMessage(String message) {
            writer.println(message);
        }
    }
}
class ChatApplication {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        int port = 12345;
        chatServer.start(port);
    }
}