package pl.sauermann.java.library.management;

import pl.sauermann.java.library.management.book.Book;

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

    public Set<User> getUsersWithAdminAccess(){
        return usersRentedBookMap.keySet().stream()
                    .filter(User::isAdmin)
                    .collect(Collectors.toSet());
    }

    public void addUser(User user){
        usersRentedBookMap.putIfAbsent(user, Collections.emptySet());
    }

    public void removeUser(User user){
        usersRentedBookMap.remove(user);
    }

}
