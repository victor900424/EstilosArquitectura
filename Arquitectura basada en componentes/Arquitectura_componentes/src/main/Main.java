package main;

import components.Product;
import components.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el nombre del usuario
        System.out.print("Ingrese el nombre del usuario: ");
        String userName = scanner.nextLine();
        User user = new User(userName);

        // Crear un StoreManager
        StoreManager storeManager = new StoreManager();

        // Bucle para añadir productos al carrito
        while (true) {
            System.out.print("Ingrese el nombre del producto (o 'salir' para finalizar): ");
            String productName = scanner.nextLine();
            if (productName.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.print("Ingrese el precio del producto: ");
            double productPrice = scanner.nextDouble();
            scanner.nextLine(); // Consumir la nueva línea

            Product product = new Product(productName, productPrice);
            storeManager.addUserToCart(user, product);
        }

        // Mostrar el total antes del checkout
        System.out.println("Total antes del checkout: $" + user.getCart().getTotal());

        // Realizar el checkout
        storeManager.checkout(user);

        scanner.close();
    }
}
