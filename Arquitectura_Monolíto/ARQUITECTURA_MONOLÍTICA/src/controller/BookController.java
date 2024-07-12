package controller;

import model.Book;
import service.BookService;

public class BookController {
    private BookService bookService;

    public BookController() {
        this.bookService = new BookService();
    }

    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        bookService.addBook(book);
    }

    public void displayBooks() {
        for (Book book : bookService.getBooks()) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
        }
    }
}

