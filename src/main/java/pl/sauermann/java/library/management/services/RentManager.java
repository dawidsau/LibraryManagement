package pl.sauermann.java.library.management.services;

import pl.sauermann.java.library.management.book.Book;

import java.util.Map;
import java.util.Set;


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
        Long oldValue = booksCopiesMap.get(book);
        return booksCopiesMap.replace(book, oldValue - 1) != null;

    }

    @Override
    public boolean returnBook(Book book) {
        Long oldValue = booksCopiesMap.get(book);
        return booksCopiesMap.replace(book, oldValue + 1) != null;

    }

    @Override
    public boolean isBookAvailable(Book book) {
        return getAmountOfBooks(book) > 0;
    }

    @Override
    public Set<Book> getAllBooksAvailable() {
        return booksCopiesMap.keySet();
    }

    private long getAmountOfBooks(Book book) {
        return booksCopiesMap.getOrDefault(book, 0L);
    }
}
