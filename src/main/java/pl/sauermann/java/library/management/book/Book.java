package pl.sauermann.java.library.management.book;

import java.time.LocalDate;
import java.util.Objects;

public class Book implements Comparable<Book> {

    private final String title;
    private final Author author;
    private final BookType bookType;
    private final long numberOfPages;
    private final LocalDate distributionDate;

    public Book(UserBuilder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.bookType = builder.bookType;
        this.numberOfPages = builder.numberOfPages;
        this.distributionDate = builder.distributionDate;
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
                title.compareToIgnoreCase(o.title);
    }

    public static class UserBuilder{
        private final String title;
        private final Author author;
        private final BookType bookType;
        private long numberOfPages = 0;
        private  LocalDate distributionDate = LocalDate.now();

        public UserBuilder(String title, Author author, BookType bookType) {
            this.title = title;
            this.author = author;
            this.bookType = bookType;
        }

        public UserBuilder numberOfPages(long numberOfPages){
            this.numberOfPages = numberOfPages;
            return this;
        }

        public UserBuilder distributionDate(LocalDate distributionDate){
            this.distributionDate = distributionDate;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
