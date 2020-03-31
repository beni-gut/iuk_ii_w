package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Book;
import org.jetbrains.annotations.NotNull;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.BookService;
import services.DefaultBookService;

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
    public CompletionStage<Result> add(@NotNull Http.Request request) {
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
    public CompletionStage<Result> update(Long id, @NotNull Http.Request request) {
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
