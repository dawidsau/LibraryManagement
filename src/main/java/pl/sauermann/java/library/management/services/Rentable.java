package pl.sauermann.java.library.management.services;

import pl.sauermann.java.library.management.book.Book;

import java.util.Set;

public interface Rentable {

    boolean rentBook(Book book);
    boolean returnBook(Book book);
    boolean isBookAvailable(Book book);
    Set<Book> getAllBooksAvailable();

}
