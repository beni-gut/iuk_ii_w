package services;

import models.Book;
import java.util.List;

public interface BookService {

    /**
     * Return's list of all books.
     * @return list of all books
     */
    List<Book> get();

    /**
     * Returns book with given identifier.
     * @param id book identifier
     * @return book with given identifier or {@code null}
     */
    Book get(final Long id);

    /**
     * Removes book with given identifier.
     * @param id book identifier
     * @return {@code true} on success  {@code false} on failure
     */
    boolean delete(final Long id);

    /**
     * Updates book with given identifier.
     * @param updatedBook book with updated fields
     * @return updated book
     */
    Book update(final Book updatedBook);

    /**
     * Adds the given book.
     * @param book to add
     * @return added book
     */
    Book add(final Book book);

}
