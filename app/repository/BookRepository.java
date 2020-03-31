package repository;

import models.Book;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.concurrent.CompletableFuture.supplyAsync;


public class BookRepository {
    private final JPAApi jpaApi;

    @Inject
    public BookRepository(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    public CompletionStage<Book> add(Book book) {
        return supplyAsync(() -> wrap(em -> insert(em, book)));
    }

    public CompletionStage<Book> update(Book book) {
        return supplyAsync(() -> wrap(em -> update(em, book)));
    }

    public CompletionStage<Book> find(Long id) {
        return supplyAsync(() -> wrap(em -> find(em, id)));
    }

    public CompletionStage<Boolean> remove(Long id) {
        return supplyAsync(() -> wrap(em -> remove(em, id)));
    }

    public CompletionStage<Stream<Book>> list() {
        return supplyAsync(() -> wrap(em -> list(em)));
    }


    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    private Book insert(EntityManager em, Book book) {
        em.persist(book);
        return book;
    }

    private Book update(EntityManager em, Book book) {
        Book bookToUpdate = em.find(Book.class, book.getId());
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setIsbn13(book.getIsbn13());
        bookToUpdate.setIsbn10(book.getIsbn10());
        bookToUpdate.setDescription(book.getDescription());
        bookToUpdate.setPublisher(book.getPublisher());
        bookToUpdate.setPages(book.getPages());
        return bookToUpdate;
    }

    private Book find(EntityManager em, Long id) {
        return em.find(Book.class, id);
    }

    private Boolean remove(EntityManager em, Long id) {
        Book book = em.find(Book.class, id);
        if(null != book) {
            em.remove(book);
            return true;
        }
        return false;
    }

    private Stream<Book> list(EntityManager em) {
        List<Book> books = em.createQuery("select b from book b", Book.class).getResultList();
        return books.stream();
    }
}
