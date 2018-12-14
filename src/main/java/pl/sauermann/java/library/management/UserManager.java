package pl.sauermann.java.library.management;

import java.util.List;
import java.util.stream.Collectors;

public class UserManager {

    private List<User> users;

    public UserManager(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<User> getUsersWithAdminAccess(){
        return users.stream()
                    .filter(user -> user.getAccessType().equals(User.AccessType.ADMIN))
                    .collect(Collectors.toList());
    }

    public boolean addUser(User user){
        return  users != null && users.add(user);
    }

    public void removeUser(User user){
         users.remove(user);
    }

}
