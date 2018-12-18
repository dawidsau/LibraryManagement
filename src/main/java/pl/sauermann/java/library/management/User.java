package pl.sauermann.java.library.management;


import java.util.Objects;

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

    public Boolean isAdmin() {
        return accessType == AccessType.ADMIN;
    }

    @Override
    public String toString() {
        return "User:" + name + " " + surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName()) &&
                Objects.equals(getSurname(), user.getSurname()) &&
                getAccessType() == user.getAccessType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getAccessType());
    }

    enum AccessType {
        ADMIN, USER
    }
}
