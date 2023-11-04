package uy.com.proitc.usecases.mockserver;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;
import org.testcontainers.containers.MockServerContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
class DefaultRepositoryIntegrationTest {

  // Containers declared as static fields will be shared between test methods.
  @Container
  static MockServerContainer container =
      new MockServerContainer(DockerImageName.parse("mockserver/mockserver:5.15.0"));

  static MockServerClient mockServerClient;

  @Test
  void givenId_whenFindAlbumById_thenGetResponse()
      throws URISyntaxException, IOException, InterruptedException {
    var client =
        new AlbumClient("http://%s:%d".formatted(container.getHost(), container.getServerPort()));

    var maybeAlbum = client.findAlbumById(1);

    assertThat(maybeAlbum)
        .isPresent()
        .asString()
        .contains("https://via.placeholder.com/600/92c952");
  }

  @BeforeAll
  static void init() {
    mockServerClient = new MockServerClient(container.getHost(), container.getServerPort());
    mockServerClient
        .when(request().withMethod("GET").withPath("/albums/1/photos"))
        .respond(
            response()
                .withStatusCode(200)
                .withBody(
                    """
                                [
                                  {
                                    "albumId": 1,
                                    "id": 1,
                                    "title": "accusamus beatae ad facilis cum similique qui sunt",
                                    "url": "https://via.placeholder.com/600/92c952",
                                    "thumbnailUrl": "https://via.placeholder.com/150/92c952"
                                  },
                                  {
                                    "albumId": 1,
                                    "id": 2,
                                    "title": "reprehenderit est deserunt velit ipsam",
                                    "url": "https://via.placeholder.com/600/771796",
                                    "thumbnailUrl": "https://via.placeholder.com/150/771796"
                                  }
                                ]
                                """));
  }

  @AfterAll
  static void close() {
    container.close();
  }
}
