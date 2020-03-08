package services;

import models.Book;
import java.util.*;

public class DefaultBookService {
    ArrayList<Book> bookList = new ArrayList<Book>();

    public DefaultBookService() {}

    /**
     * Return's list of all books.
     *
     * @return list of all books
     */
    List<Book> get() {
        return bookList;
    }

    /**
     * Returns book with given identifier.
     *
     * @param id book identifier
     * @return book with given identifier or {@code null}
     */
    Book get(final Long id) {
        for (Book book: bookList ) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    /**
     * Removes book with given identifier.
     *
     * @param id book identifier
     * @return {@code true} on success  {@code false} on failure
     */
    boolean delete(final Long id) {
        for (Book book: bookList ) {
            if (book.getId() == id) {
                bookList.remove(book);
                return true;
            }
        }
        return false;
    }

    /**
     * Updates book with given identifier.
     *
     * @param updatedBook book with updated fields
     * @return updated book
     */
    Book update(final Book updatedBook) {
        for (Book book: bookList ) {
            if (book.getId() == updatedBook.getId()) {
                bookList.set(bookList.indexOf(book), updatedBook);
                return book;
            }
        }
        return null;
    }

    /**
     * Adds the given book.
     *
     * @param book to add
     * @return added book
     */
    Book add(final Book book) {
        bookList.add(book);
        return book;
    }
}
