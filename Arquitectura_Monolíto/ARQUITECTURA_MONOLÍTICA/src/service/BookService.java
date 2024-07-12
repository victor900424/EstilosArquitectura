package service;

import model.Book;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    private List<Book> books;

    public BookService() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }
}
