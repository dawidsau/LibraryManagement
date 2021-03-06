package pl.sauermann.java.library.management.book;

import java.util.Objects;

public class Author implements Comparable<Author> {

    private String name;
    private String surname;

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Author author = (Author) other;

        return name.equals(author.name) &&
                surname.equals(author.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname());
    }

    @Override
    public String toString() {
        return "Author:" + name + " " + surname;
    }

    @Override
    public int compareTo(Author o) {
        return surname.equals(o.surname) ?
                name.compareToIgnoreCase(o.name) :
                surname.compareToIgnoreCase(o.surname);
    }
}
