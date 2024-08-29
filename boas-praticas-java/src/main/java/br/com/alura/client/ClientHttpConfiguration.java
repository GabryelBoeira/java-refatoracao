package br.com.alura.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientHttpConfiguration {

    /**
     * Sends a GET request to the given URI and returns the response.
     * @param uri the URI to be queried
     * @return the response of the GET request
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public HttpResponse<String> dispararConsultaGet(String uri) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    /**
     * Sends a POST request with the given JSON to the given URI and returns the response.
     * @param uri the URI to be queried
     * @param object the JSON to be sent in the request
     * @return the response of the GET request
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public HttpResponse<String> dispararConsultaPost(String uri, Object object) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(new Gson().toJson(object)))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

}
