package services;

import models.Book;
import repository.BookRepository;

import javax.inject.Inject;
import java.util.*;

public class DefaultBookService {
    private BookRepository bookRepository;

    @Inject
    public DefaultBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Return's list of all books.
     *
     * @return list of all books
     */
    public List<Book> get() {
        return bookList;
    }

    /**
     * Returns book with given identifier.
     *
     * @param id book identifier
     * @return book with given identifier or {@code null}
     */
    public Book get(final Long id) {
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
    public boolean delete(final Long id) {
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
    public Book update(final Book updatedBook) {
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
    public Book add(final Book book) {
        bookList.add(book);
        return book;
    }
}
