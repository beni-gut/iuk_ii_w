package services;

import com.fasterxml.jackson.databind.JsonNode;
import javax.inject.Inject;
import models.Posts;
import play.libs.Json;
import play.libs.ws.*;
import java.util.concurrent.CompletionStage;
import com.typesafe.config.Config;

public class DefaultNYTimesService implements NYTimesService, WSBodyReadables {

    private final WSClient ws;
    private final String apiKey;

    @Inject
    public DefaultNYTimesService(WSClient ws, Config config) {
        this.ws = ws;
        this.apiKey = config.getString("nytimes.api.key");

        //application.conf
        nytimes.api.key="";
    }

    @Override
    public CompletionStage<Posts> posts() {
        final String url = "https://jsonplaceholder.typicode.com/posts";
        final WSRequest request = ws.url(url);
        final CompletionStage<JsonNode> jsonPromise = request.get().thenApply(result -> result.getBody(json()));
        return jsonPromise.thenApplyAsync(json -> Json.fromJson(json, Posts.class));
    }

    @Override
    public void bestseller() {
        return;
    }


    /**
     * request.get() -> CompletionStage<WSResponse> ->
     *
     * result.getBody(json()) -> CompletionStage<JsonNode> ->
     *
     * Json.fromJson(json, NYTimesBestseller.class) -> CompletionStage<NYTimesBestseller> ->
     *
     * map(bestseller) -> CompletionStage<List<Book>>
     *
     */
}
