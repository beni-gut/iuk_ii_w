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

    private Stream<Book> list(EntityManager em) {
        List<Book> books = em.createQuery("select b from book b", Book.class).getResultList();
        return books.stream();
    }
}
