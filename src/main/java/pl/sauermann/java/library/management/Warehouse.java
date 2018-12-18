package pl.sauermann.java.library.management;

import pl.sauermann.java.library.management.book.Book;

import java.util.Map;
import java.util.Objects;

public class Warehouse {

    private static final int INCREASE = 1;
    private static final int DECREASE = -1;

    private static int warehouseCount = 0;

    private Map<Book, Long> booksNumberOfCopiesMap;

    public Warehouse(Map<Book, Long> booksNumberOfCopiesMap) {
        this.booksNumberOfCopiesMap = booksNumberOfCopiesMap;
        warehouseCount = warehouseCount + 1;
    }

    public Map<Book, Long> getBooksNumberOfCopiesMap() {
        return booksNumberOfCopiesMap;
    }

    public static int getWarehouseCount() {
        return warehouseCount;
    }

    public void addBookCopyToWarehouse(Book book, User user) {
        if (user.isAdmin()) {
            if (!replaceValueInMap(book, INCREASE)) {
                booksNumberOfCopiesMap.put(book, 1L);
            }
        }
    }

    public void removeBookCopyFromWarehouse(Book book, User user) {
        if (user.isAdmin()) {
            if (!replaceValueInMap(book, DECREASE)) {
                booksNumberOfCopiesMap.remove(book);
            }
        }
    }

    private boolean replaceValueInMap(Book book, int modifier) {
        boolean result = false;
        if (booksNumberOfCopiesMap.containsKey(book) && booksNumberOfCopiesMap.get(book) > 1) {
            Long temp = booksNumberOfCopiesMap.get(book);
            booksNumberOfCopiesMap.replace(book, temp + modifier);
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        return "All books available in library "+ warehouseCount +": \n" + booksNumberOfCopiesMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehouse warehouse = (Warehouse) o;
        return Objects.equals(getBooksNumberOfCopiesMap(), warehouse.getBooksNumberOfCopiesMap());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBooksNumberOfCopiesMap());
    }
}
