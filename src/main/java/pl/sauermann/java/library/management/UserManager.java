package pl.sauermann.java.library.management;

import pl.sauermann.java.library.management.book.Book;
import pl.sauermann.java.library.management.services.RentManager;
import pl.sauermann.java.library.management.services.Rentable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UserManager {

    private Map<User, Set<Book>> usersRentedBookMap;


    public UserManager() {
        usersRentedBookMap = new HashMap<>();
    }

    public Set<User> getUsers() {
        return usersRentedBookMap.keySet();
    }

    public Set<User> getUsersWithAdminAccess() {
        return usersRentedBookMap.keySet().stream()
                .filter(User::isAdmin)
                .collect(Collectors.toSet());
    }

    public void addUser(User user) {
        usersRentedBookMap.putIfAbsent(user, Collections.emptySet());
    }

    public void removeUser(User user) {
        usersRentedBookMap.remove(user);
    }

    public void addBookToUser(User user, Book book, Rentable rentManger) {
        changingInBookSet(user, book, Modifier.ADD, rentManger);
    }

    public void removeBookFromUser(User user, Book book, Rentable rentManger) {
        changingInBookSet(user, book, Modifier.REMOVE, rentManger);
    }

    private void changingInBookSet(User user, Book book, Modifier modifier, Rentable rentManger) {
        boolean modificationInRentMap = false;
        if (usersRentedBookMap.containsKey(user)) {
            Set<Book> books = usersRentedBookMap.get(user);
            if (modifier == Modifier.REMOVE) {
                books.remove(book);
                modificationInRentMap = rentManger.returnBook(book);
            } else if (modifier == Modifier.ADD) {
                books.add(book);
                modificationInRentMap = rentManger.rentBook(book);
            }
            if (modificationInRentMap) {
                usersRentedBookMap.replace(user, books);
            }
        }
    }

    private enum Modifier {
        ADD, REMOVE
    }
}
