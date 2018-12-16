package pl.sauermann.java.library.management;

import pl.sauermann.java.library.management.book.Book;

import java.util.Map;
import java.util.Objects;

public class Warehouse {

    private static final int INCREASE = 1;
    private static final int DECREASE = -1;

    private static int warehouseCount = 0;

    private Map<Book, Integer> booksNumberOfCopies;

    public Warehouse(Map<Book, Integer> booksNumberOfCopies) {
        this.booksNumberOfCopies = booksNumberOfCopies;
        warehouseCount = warehouseCount + 1;
    }

    public Map<Book, Integer> getBooksNumberOfCopies() {
        return booksNumberOfCopies;
    }

    public static int getWarehouseCount() {
        return warehouseCount;
    }

    public void addBookCopyToWarehouse(Book book, User user) {
        if (user.isAdmin()) {
            if (!replaceValueInMap(book, INCREASE)) {
                booksNumberOfCopies.put(book, 1);
            }
        }
    }

    public void removeBookCopyFromToWarehouse(Book book, User user) {
        if (user.isAdmin()) {
            if (!replaceValueInMap(book, DECREASE)) {
                booksNumberOfCopies.remove(book);
            }
        }
    }

    private boolean replaceValueInMap(Book book, int modifier) {
        boolean result = false;
        if (booksNumberOfCopies.containsKey(book) && booksNumberOfCopies.get(book) > 1) {
            Integer temp = booksNumberOfCopies.get(book);
            booksNumberOfCopies.replace(book, temp + modifier);
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        return "All books available in library: \n" + booksNumberOfCopies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehouse warehouse = (Warehouse) o;
        return Objects.equals(getBooksNumberOfCopies(), warehouse.getBooksNumberOfCopies());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBooksNumberOfCopies());
    }
}
