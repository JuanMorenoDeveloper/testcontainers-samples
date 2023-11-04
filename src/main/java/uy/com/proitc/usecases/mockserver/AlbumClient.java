package uy.com.proitc.usecases.mockserver;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

class AlbumClient {

  private final String baseUrl;

  AlbumClient(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public Optional<String> findAlbumById(int id)
      throws URISyntaxException, IOException, InterruptedException {
    var request =
        HttpRequest.newBuilder()
            .uri(new URI("%s/albums/%d/photos".formatted(baseUrl, id)))
            .GET()
            .build();
    try (var client = HttpClient.newBuilder().build()) {
      var response = client.send(request, HttpResponse.BodyHandlers.ofString());
      if (response.statusCode() == 200) {
        return Optional.of(response.body());
      }
    }
    return Optional.empty();
  }
}
