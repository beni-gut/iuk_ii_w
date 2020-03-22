package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Book;
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

    public CompletionStage<Result> books(String q) {
        return bookService.get().thenApplyAsync(bookStream ->
                ok(Json.toJson(bookStream.collect(Collectors.toList())))
        );
    }


    /**
     * Alte Sachen unterhalb
     */


    /**
     * Alle Bücher abfragen
     *
     * @param q Suchparameter
     */
    public Result getAll(String q) {
        if (q != null) {
            //no method yet
            return ok("Parameter q ist: " + q);
        } else {
            JsonNode json = Json.toJson(bookService.get());
            return ok(json);
        }
    }

    /**
     * Neues Buchdetail erfassen
     *
     * @param request
     */
    public Result add(Http.Request request) {
        if (request != null) {
            JsonNode json = request.body().asJson();
            Book newBook = Json.fromJson(json, Book.class);
            bookService.add(newBook);
            return ok(Json.toJson(newBook));
        } else {
            //no method yet
            return badRequest("Nothing to POST");
        }
    }

    /**
     * Buchdetail für Buch mit ID aktualisieren
     *
     * @param request
     */
    public Result update(Http.Request request) {
        if (request != null) {
            JsonNode json = request.body().asJson();
            Book updatedBook = Json.fromJson(json, Book.class);
            bookService.update(updatedBook);
            return ok(Json.toJson(updatedBook));
        } else {
            //no method yet
            return badRequest("Please retry with other parameters");
        }
    }

    /**
     * Abfragen der Buchdetails für ein Buch mit ID
     *
     * @param id Buch ID
     */
    public Result get(Long id) {
        if (id != null) {
            JsonNode json = Json.toJson(bookService.get(id));
            return ok(json);
        } else {
            //no method yet
            return badRequest("This seems to not exist");
        }
    }

    /**
     * Buch mit entsprechender ID löschen
     *
     * @param id Buch ID
     */
    public Result remove(Long id) {
        if (id != null) {
            return ok(Json.toJson(bookService.delete(id)));
        } else {
            //no method yet
            return badRequest("Please retry with other parameters");
        }
    }
}
