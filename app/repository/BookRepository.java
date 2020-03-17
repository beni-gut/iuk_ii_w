package repository;

import javax.inject.Inject;

public class BookRepository {
    private final JPAApi jpaApi;

    @Inject
    public BookRepository(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }
}
