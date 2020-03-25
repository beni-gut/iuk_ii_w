package controllers;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.DummyService;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class BestsellerController extends Controller {
    private final DummyService dummyService;

    @Inject
    public BestsellerController(DummyService dummyService) {
        this.dummyService = dummyService;
    }

    public CompletionStage<Result> posts() {
        return dummyService.posts().thenApplyAsync(posts -> ok(Json.toJson(posts)));
    }
}
