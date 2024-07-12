package main;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Peer {
    private String name;
    private int port;
    private ServerSocket serverSocket;
    private ConcurrentHashMap<String, PeerInfo> peerList;
    private boolean running = true;

    public Peer(String name, int port) {
        this.name = name;
        this.port = port;
        this.peerList = new ConcurrentHashMap<>();
    }

    public void start() {
        new Thread(this::listen).start();
    }

    public void stop() {
        running = false;
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listen() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println(name + " escuchando en el puerto " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connectToPeer(String peerName, String host, int port) {
        peerList.put(peerName, new PeerInfo(host, port));
        System.out.println(name + " connectado a " + peerName + " en " + host + ":" + port);
    }

    public void sendMessage(String peerName, String message) {
        PeerInfo peerInfo = peerList.get(peerName);
        if (peerInfo != null) {
            try (Socket socket = new Socket(peerInfo.getHost(), peerInfo.getPort());
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                out.println(name + ": " + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No se ha encontrado a " + peerName);
        }
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                String message = in.readLine();
                System.out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class PeerInfo {
        private final String host;
        private final int port;

        public PeerInfo(String host, int port) {
            this.host = host;
            this.port = port;
        }

        public String getHost() {
            return host;
        }

        public int getPort() {
            return port;
        }
    }
}
