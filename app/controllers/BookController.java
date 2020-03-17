package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Book;
import play.libs.Json;
import play.mvc.*;
import services.DefaultBookService;

import java.util.Optional;

public class BookController extends Controller {
    DefaultBookService bookService = new DefaultBookService();

    /**
     * Alle Bücher abfragen
     *
     * @param q Suchparameter
     */
    public Result getAll(String q) {
        if (q == null) {
            JsonNode json = Json.toJson(bookService.get());
            return ok(json);
        } else {
            //import method
            return ok("Parameter q ist: " + q);
        }
    }

    /**
     * Neues Buchdetail erfassen
     * @param request
     */
    public Result add(Http.Request request) {
        if (request == null) {
            return badRequest("Nothing to POST");
        } else {
            Optional<Book> newBook = request.body().parseJson(Book.class);
            bookService.add(newBook);
            return ok(Json.toJson(newBook));
        }
    }

    /**
     * Buchdetail für Buch mit ID aktualisieren
     * @param id Buch ID
     */
    public Result update(Long id) {
        if (id != null) {
            return ok("Updated the book with id " + id);
        } else {
            return badRequest("Please retry with other parameters");
        }
    }

    /**
     * Abfragen der Buchdetails für ein Buch mit ID
     * @param id Buch ID
     */
    public Result get(Long id) {
        if (id != null) {
            return ok("Here's some info on book with id " + id);
        } else {
            return notFound("This seems to not exist");
        }
    }

    /**
     * Buch mit entsprechender ID löschen
     * @param id Buch ID
     */
    public Result remove(Long id) {
        if (id != null) {
            return ok("Removed book with id " + id);
        } else {
            return badRequest("Please retry with other parameters");
        }
    }
}
