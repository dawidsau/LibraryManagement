package pl.sauermann.java.library.management.book;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void shouldCompareBookObjects() {
        Author author = new Author("Walery", "Jakobic");
        Book book = new Book("Book title", author, BookType.ACTION);
        Book sameBook = new Book("Book title", author, BookType.FICTION);

        assertEquals("Book equals method failed", book, sameBook);
    }

    @Test
    public void shouldSortAuthorList() {
        List<Book> sortedBookList = Arrays.asList(
                new Book("Effective Java", new Author("Joshua", "Bloch"), BookType.GUIDE),
                new Book("Outsider", new Author("Stephen", "Kind"), BookType.CRIME),
                new Book("Thinking in Java", new Author("Bruce", "Eckel"), BookType.GUIDE)
        );
        List<Book> unSortedBookList = Arrays.asList(
                new Book("Thinking in Java", new Author("Bruce", "Eckel"), BookType.GUIDE),
                new Book("Effective Java", new Author("Joshua", "Bloch"), BookType.GUIDE),
                new Book("Outsider", new Author("Stephen", "Kind"), BookType.CRIME)
        );

        Collections.sort(unSortedBookList);

        assertEquals("Issue in sorting method", sortedBookList, unSortedBookList);
    }
}