package pl.sauermann.java.library.management;


public class User {

    private String name;
    private String surname;
    private AccessType accessType;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
        accessType = AccessType.USER;
    }

    public User(String name, String surname, AccessType accessType) {
        this.name = name;
        this.surname = surname;
        this.accessType = accessType;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public AccessType getAccessType() {
        return accessType;
    }

    @Override
    public String toString() {
        return "User:" + name + " " + surname;
    }


    enum AccessType {
        ADMIN, USER
    }
}
