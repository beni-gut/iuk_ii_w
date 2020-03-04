package controllers;

import play.mvc.*;

public class BookController extends Controller {
    public Result getAll(String q) {
        if (q == null) {
            return ok("getAll works");
        } else {
            return ok("Parameter q ist: " + q);
        }
    }

    public Result add(Http.Request request) {
        return ok("Was probably posted, it was a request " + request);
    }

    public Result update(Long id) {
        if (id != null) {
            return ok("Updated the book with id " + id);
        } else {
            return badRequest("Please retry with other parameters");
        }
    }

    public Result get(Long id) {
        if (id != null) {
            return ok("Here's some info on book with id " + id);
        } else {
            return notFound("This seems to not exist");
        }
    }

    public Result remove(Long id) {
        if (id != null) {
            return ok("Removed book with id " + id);
        } else {
            return badRequest("Please retry with other parameters");
        }
    }
}
