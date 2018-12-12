package pl.sauermann.java.library.management;

import pl.sauermann.java.library.management.book.Book;

public interface Rentable {

    boolean rentBook(Book book);
    boolean returnBook(Book book);
    boolean isBookAvailable(Book book);

}
