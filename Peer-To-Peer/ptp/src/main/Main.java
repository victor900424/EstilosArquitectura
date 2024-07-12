package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa tu nombre:");
        String name = scanner.nextLine();

        System.out.println("Ingresa el puerto para comunicacion:");
        int port = Integer.parseInt(scanner.nextLine());

        Peer peer = new Peer(name, port);
        peer.start();

        System.out.println("Quieres chatear con alguien? (si/no)");
        String connect = scanner.nextLine();

        if (connect.equalsIgnoreCase("si")) {
            System.out.println("Ingresa el nombre de la persona con la que quieres chatear:");
            String peerName = scanner.nextLine();

            System.out.println("Ingresa su ip:");
            String host = scanner.nextLine();

            System.out.println("Ingresa su puerto para comunicacion:");
            int peerPort = Integer.parseInt(scanner.nextLine());

            peer.connectToPeer(peerName, host, peerPort);
        }

        System.out.println("Ya puedes comenzar a chatear...");

        while (true) {
            System.out.println("Ingresa el nombre de la persona con la que quieres chatear:");
            String recipientPeer = scanner.nextLine();
            System.out.println("Ingresa el mensaje:");
            String message = scanner.nextLine();
            peer.sendMessage(recipientPeer, message);
            if (message.equalsIgnoreCase("adios")) {
                System.out.println("Cerrando chat...");
                peer.stop();
                scanner.close();
                break;
            }
        }
    }
}
