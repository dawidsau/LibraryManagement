package pl.sauermann.java.library.management;

import pl.sauermann.java.library.management.book.Book;
import pl.sauermann.java.library.management.services.Rentable;

import java.util.*;
import java.util.stream.Collectors;

public class UserManager {

    private Map<User, Set<Book>> usersRentedBookMap;


    public UserManager() {
        usersRentedBookMap = new HashMap<>();
    }

    public Map<User, Set<Book>> getUsersRentedBookMap() {
        return usersRentedBookMap;
    }

    public Set<User> getUsersWithAdminAccess() {
        return usersRentedBookMap.keySet().stream()
                .filter(User::isAdmin)
                .collect(Collectors.toSet());
    }

    public void addUser(User user) {
        usersRentedBookMap.putIfAbsent(user, new HashSet<>());
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
        if (usersRentedBookMap.containsKey(user)) {
            Set<Book> books = usersRentedBookMap.get(user);
            if (modifier == Modifier.REMOVE && rentManger.returnBook(book)) {
                books.remove(book);
            } else if (modifier == Modifier.ADD && rentManger.rentBook(book)) {
                books.add(book);
            }
        }
    }

    private enum Modifier {
        ADD, REMOVE
    }
}
