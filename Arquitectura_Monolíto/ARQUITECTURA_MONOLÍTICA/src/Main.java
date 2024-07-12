import java.util.Scanner;

import controller.BookController;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookController bookController = new BookController();

        System.out.println("Enter the number of books to add:");
        int numberOfBooks = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println("Enter title for book " + (i + 1) + ":");
            String title = scanner.nextLine();

            System.out.println("Enter author for book " + (i + 1) + ":");
            String author = scanner.nextLine();

            bookController.addBook(title, author);
        }

        bookController.displayBooks();
    }
}
