package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Book;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.BookService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

public class BookController extends Controller {
    private final BookService bookService;


    @Inject
    public BookController(BookService bookService, HttpExecutionContext ec) {
        this.bookService = bookService;
    }

    /**
     * Testmethod
     * @return Dummy book
     */
    public Result dummy() {
        return ok(Json.toJson(bookService.getDummy()));
    }

    /**
     * Alle Bücher abfragen
     *
     * @param q Suchparameter
     */
    public CompletionStage<Result> getAll(String q) {
        return bookService.get().thenApplyAsync(bookStream ->
                ok(Json.toJson(bookStream.collect(Collectors.toList())))
        );
    }

    /**
     * Neues Buchdetail erfassen
     *
     * @param request
     */
    public CompletionStage<Result> add(Http.Request request) {
        final JsonNode json = request.body().asJson();
        final Book newBook = Json.fromJson(json, Book.class);
        return bookService.add(newBook).thenApplyAsync(book -> ok(Json.toJson(book)));
    }

    /**
     * Buchdetail für Buch mit ID aktualisieren
     *
     * @param id Buch ID
     * @param request
     */
    public CompletionStage<Result> update(Long id, Http.Request request) {
        final JsonNode json = request.body().asJson();
        final Book updatedBook = Json.fromJson(json, Book.class);
        updatedBook.setId(id);
        return bookService.update(updatedBook).thenApplyAsync(book ->ok(Json.toJson(book)));
    }

    /**
     * Abfragen der Buchdetails für ein Buch mit ID
     *
     * @param id Buch ID
     */
    public CompletionStage<Result> getSpecific(Long id) {
        return bookService.get(id).thenApplyAsync(book -> ok(Json.toJson(book)));
    }

    /**
     * Buch mit entsprechender ID löschen
     *
     * @param id Buch ID
     */
    public CompletionStage<Result> remove(Long id) {
        return bookService.delete(id).thenApplyAsync(removed -> removed ? ok() : internalServerError());
    }

}
