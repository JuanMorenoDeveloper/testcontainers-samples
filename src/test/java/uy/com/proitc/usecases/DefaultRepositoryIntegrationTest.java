package uy.com.proitc.usecases;

import static java.util.Collections.singletonMap;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
class DefaultRepositoryIntegrationTest {

  //Containers declared as static fields will be shared between test methods.
  @Container
  static final GenericContainer container = new PostgreSQLContainer(
      "postgres:9.6.12")
      .withDatabaseName("foo")
      .withUsername("foo")
      .withPassword("secret")
      .withInitScript("init_script.sql")
      // Container can have tmpfs mounts for storing data in host memory.
      // This is useful if you want to speed up your database tests.
      .withTmpFs(singletonMap("/var/lib/postgresql/data", "rw"));

  @Test
  void givenId_whenFindNameById_thenGetName() {
    var repository = new DefaultAppRepository(container);

    String name = repository.findNameById(1);

    assertThat(name).isEqualTo("Transcof");
  }

  @Test
  void givenAppsWithVersion_whenCountProductsWithVersion_thenGetCounter() {
    var repository = new DefaultAppRepository(container);

    long count = repository.countProductsWithVersion();

    assertThat(count).isEqualTo(4);
  }

}
