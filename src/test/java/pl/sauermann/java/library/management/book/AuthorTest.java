package pl.sauermann.java.library.management.book;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class AuthorTest {

    @Test
    public void shouldCompareAuthorObjects() {
        Author author = new Author("Walery", "Jakobic");
        Author sameAuthor = new Author("Walery", "Jakobic");
        Author differentNameAuthor = new Author("Walenty", "Jakobic");
        Author differentSurnameAuthor = new Author("Walery", "Bar");
        Author fullyDifferentAuthor = new Author("Bob", "Kar");

        assertEquals("Author is not equal to same Author", author, sameAuthor);
        assertNotEquals("Author is equal to author with different name", author, differentNameAuthor);
        assertNotEquals("Author is equal to author with different surname", author, differentSurnameAuthor);
        assertNotEquals("Author is equal to fully different author", author, fullyDifferentAuthor);
    }

    @Test
    public void shouldSortAuthorList() {
        List<Author> sortedAuthorList = Arrays.asList(
                new Author("Adam", "Mickiewicz"),
                new Author("Henryk", "Sienkiewicz"),
                new Author("Wieslawa", "Szumborska")
        );
        List<Author> unSortedAuthorList = Arrays.asList(
                new Author("Wieslawa", "Szumborska"),
                new Author("Adam", "Mickiewicz"),
                new Author("Henryk", "Sienkiewicz")
        );

        Collections.sort(unSortedAuthorList);

        assertEquals("Issue in sorting method", sortedAuthorList,unSortedAuthorList);
    }

}