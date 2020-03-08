package controllers;

import play.mvc.*;
import services.DefaultBookService;

public class BookController extends Controller {
    DefaultBookService bookService;

    /**
     * Alle Bücher abfragen
     * @param q Suchparameter
     */
    public Result getAll(String q) {
        if (q == null) {
            return ok("getAll works");
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
        return ok("Was probably posted, it was a request " + request);
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
