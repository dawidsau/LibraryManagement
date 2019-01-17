package pl.sauermann.java.library.management.book;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void shouldCompareBookObjects() {
        Author author = new Author("Walery", "Jakobic");
        Book book = new Book.UserBuilder("Book title", author, BookType.ACTION)
                .distributionDate(LocalDate.now())
                .numberOfPages(250L)
                .build();
        Book sameBook = new Book.UserBuilder("Book title", author, BookType.FICTION)
                .distributionDate(LocalDate.now())
                .numberOfPages(250L)
                .build();

        assertEquals("Book equals method failed", book, sameBook);
    }

    @Test
    public void shouldSortAuthorList() {
        List<Book> sortedBookList = Arrays.asList(
                new Book.UserBuilder("Effective Java", new Author("Joshua", "Bloch"), BookType.GUIDE).build(),
                new Book.UserBuilder("Outsider", new Author("Stephen", "Kind"), BookType.CRIME).build(),
                new Book.UserBuilder("Thinking in Java", new Author("Bruce", "Eckel"), BookType.GUIDE).build()
        );
        List<Book> unSortedBookList = Arrays.asList(
                new Book.UserBuilder("Thinking in Java", new Author("Bruce", "Eckel"), BookType.GUIDE).build(),
                new Book.UserBuilder("Effective Java", new Author("Joshua", "Bloch"), BookType.GUIDE).build(),
                new Book.UserBuilder("Outsider", new Author("Stephen", "Kind"), BookType.CRIME).build()
        );

        Collections.sort(unSortedBookList);

        assertEquals("Issue in sorting method", sortedBookList, unSortedBookList);
    }
}