package pl.sauermann.java.library.management.services;

import pl.sauermann.java.library.management.Warehouse;
import pl.sauermann.java.library.management.book.Book;

import java.util.Map;


public class RentManager implements Rentable {

    private static final int INCREASE_VALUE = 1;
    private static final int DECREASE_VALUE = -1;

    private Map<Book, Long> bookCopiesMap;

    public RentManager(Warehouse warehouse) {
        bookCopiesMap = warehouse.getBooksNumberOfCopiesMap();
    }

    public Map<Book, Long> getBookCopiesMap() {
        return bookCopiesMap;
    }

    @Override
    public boolean rentBook(Book book) {
        return isBookAvailable(book) && modificationInBookCopiesMap(book, DECREASE_VALUE);
    }

    @Override
    public boolean returnBook(Book book) {
        return modificationInBookCopiesMap(book, INCREASE_VALUE);
    }

    private boolean modificationInBookCopiesMap(Book book, int modifier) {
        Long oldValue = bookCopiesMap.get(book);
        return bookCopiesMap.replace(book, oldValue + modifier) != null;
    }

    @Override
    public boolean isBookAvailable(Book book) {
        return getAmountOfBooks(book) > 0;
    }

    private long getAmountOfBooks(Book book) {
        return bookCopiesMap.getOrDefault(book, 0L) != null ? bookCopiesMap.getOrDefault(book, 0L) : 0;
    }
}
