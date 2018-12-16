package pl.sauermann.java.library.management.services;

import pl.sauermann.java.library.management.User;
import pl.sauermann.java.library.management.book.Book;

import java.util.List;
import java.util.Map;

// TODO: rentBook and returnBook method,


public class RentManager implements Rentable {

    private Map<Book, Long> booksCopiesMap;

    public RentManager(Map<Book, Long> booksCopiesMap) {
        this.booksCopiesMap = booksCopiesMap;
    }

    public Map<Book, Long> getBooksCopiesMap() {
        return booksCopiesMap;
    }

    @Override
    public boolean rentBook(Book book) {
        return false;
    }

    @Override
    public boolean returnBook(Book book) {
        return false;
    }

    @Override
    public boolean isBookAvailable(Book book) {
        return getAmountOfBooks(book) > 0;
    }

    private long getAmountOfBooks(Book book) {
        return booksCopiesMap.getOrDefault(book, 0L);
    }
}
