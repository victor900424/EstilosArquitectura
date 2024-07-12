package components;

public class User {
    private String name;
    private Cart cart;

    public User(String name) {
        this.name = name;
        this.cart = new Cart();
    }

    public String getName() {
        return name;
    }

    public Cart getCart() {
        return cart;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', cart=" + cart + "}";
    }
}
