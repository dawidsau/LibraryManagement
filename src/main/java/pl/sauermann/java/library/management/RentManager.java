package pl.sauermann.java.library.management;

import pl.sauermann.java.library.management.book.Book;

import java.util.Map;

// TODO: Users map,
// TODO: rentBook and retrunBook method,
// TODO: amount of all books method

public class RentManager implements Rentable {

    private Map<Book, Long> bookAmountMap;

    public RentManager(Map<Book, Long> bookAmountMap) {
        this.bookAmountMap = bookAmountMap;
    }

    public Map<Book, Long> getBookAmountMap() {
        return bookAmountMap;
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
        return bookAmountMap.getOrDefault(book, 0L);
    }
}
