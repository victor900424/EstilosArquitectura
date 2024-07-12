package main;

import components.Product;
import components.User;

public class StoreManager {
    public void addUserToCart(User user, Product product) {
        user.getCart().addProduct(product);
        System.out.println(product.getName() + " added to " + user.getName() + "'s cart.");
    }

    public void removeUserFromCart(User user, Product product) {
        user.getCart().removeProduct(product);
        System.out.println(product.getName() + " removed from " + user.getName() + "'s cart.");
    }

    public void checkout(User user) {
        double total = user.getCart().getTotal();
        System.out.println(user.getName() + " checked out with total: $" + total);
        user.getCart().getProducts().clear();  // Limpiar el carrito después del checkout
    }
}
