package pl.sauermann.java.library.management.book;

import java.time.LocalDate;
import java.util.Objects;

public class Book implements Comparable<Book>{

    private String title;
    private Author author;
    private long numberOfPages;
    private BookType bookType;
    private LocalDate distributionDate;

    public Book(String title, Author author, BookType bookType) {
        this.title = title;
        this.author = author;
        this.bookType = bookType;
    }

    public Book(String title, Author author, long numberOfPages, BookType bookType) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.bookType = bookType;
    }

    public Book(String title, Author author, long numberOfPages, LocalDate distributionDate, BookType bookType) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.distributionDate = distributionDate;
        this.bookType = bookType;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public long getNumberOfPages() {
        return numberOfPages;
    }

    public LocalDate getDistributionDate() {
        return distributionDate;
    }

    public BookType getBookType() {
        return this.bookType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return title.equals(book.title) &&
                author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getAuthor());
    }

    @Override
    public String toString() {
        return "Book: " + title + " " + author;
    }

    @Override
    public int compareTo(Book o) {
        return title.equals(o.title) ?
                author.getSurname().compareToIgnoreCase(o.author.getSurname()) :
                title.compareToIgnoreCase(o.title) ;
    }

    enum BookType {
        FICTION, ACTION, COOKBOOK, CRIME,
        DRAMA, GUIDE, FANTASY, HISTORY;
    }

}
