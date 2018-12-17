package pl.sauermann.java.library.management;

import org.junit.Before;
import org.junit.Test;
import pl.sauermann.java.library.management.book.Author;
import pl.sauermann.java.library.management.book.Book;
import pl.sauermann.java.library.management.book.BookType;
import pl.sauermann.java.library.management.services.RentManager;

import java.util.*;

import static org.junit.Assert.*;

public class UserManagerTest {

    private UserManager userManager;
    private User normalUser, normalUserTwo;
    private User adminUser;
    private Book book;
    private Author author;
    private Map<Book, Long> bookCopiesMap;
    private RentManager rentManager;
    private Warehouse warehouse;

    @Before
    public void init() {
        userManager = new UserManager();
        normalUser = new User("Bart", "Holders");
        normalUserTwo = new User("Tom", "Brands");
        adminUser = new User("Ali", "Guler", User.AccessType.ADMIN);
        author = new Author("Walery", "Jakobic");
        book = new Book("Book title", author, BookType.ACTION);
        bookCopiesMap = new HashMap<>();
        warehouse = new Warehouse(bookCopiesMap);
        rentManager = new RentManager(warehouse);
    }

    @Test
    public void shouldReturnAllAdminUsers() {
        userManager.addUser(adminUser);
        userManager.addUser(normalUser);
        userManager.addUser(normalUserTwo);

        Set<User> expected = new HashSet<>(Arrays.asList(adminUser));
        Set<User> result = userManager.getUsersWithAdminAccess();

        assertEquals(expected, result);
    }

    @Test
    public void shouldNotReturnAnyAdminUsers() {
        userManager.addUser(adminUser);
        userManager.addUser(normalUser);

        userManager.removeUser(adminUser);
        Set<User> result = userManager.getUsersWithAdminAccess();

        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldAddBookToUser() {
        bookCopiesMap.put(book, 5L);

        userManager.addUser(normalUser);
        userManager.addBookToUser(normalUser, book, rentManager);
        Set<Book> expected = new HashSet<>(Arrays.asList(book));
        Set<Book> result = userManager.getUsersRentedBookMap().get(normalUser);

        assertEquals(expected, result);
    }

    @Test
    public void shouldNotAddBookToUser() {
        bookCopiesMap.put(book, 0L);

        userManager.addUser(normalUser);
        userManager.addBookToUser(normalUser, book, rentManager);
        Set<Book> result = userManager.getUsersRentedBookMap().get(normalUser);

        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldRemoveBookFromUser() {
        bookCopiesMap.put(book, 1L);

        userManager.addUser(normalUser);
        userManager.addBookToUser(normalUser, book, rentManager);
        userManager.removeBookFromUser(normalUser, book, rentManager);
        Set<Book> result = userManager.getUsersRentedBookMap().get(normalUser);

        assertTrue(result.isEmpty());
    }


}