package uy.com.proitc.usecases.postgresql;

import static java.util.Collections.singletonMap;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
class DefaultRepositoryIntegrationTest {

  // Containers declared as static fields will be shared between test methods.
  @Container
  private static final PostgreSQLContainer<?> container =
      new PostgreSQLContainer<>(DockerImageName.parse("postgres:13.7"))
          .withDatabaseName("product_db")
          .withUsername("user")
          .withPassword("password")
          .withInitScript("init_script.sql")
          // Container can have tmpfs mounts for storing data in host memory.
          // This is useful if you want to speed up your database tests.
          .withTmpFs(singletonMap("/var/lib/postgresql/data", "rw"));

  private static DataSource datasource;

  @Test
  void givenId_whenFindNameById_thenGetName() {
    var repository = new ApplicationRepository(datasource);

    String name = repository.findNameById(1);

    assertThat(name).isEqualTo("Transcof");
  }

  @Test
  void givenAppsWithVersion_whenCountProductsWithVersion_thenGetCounter() {
    var repository = new ApplicationRepository(datasource);

    long count = repository.countProductsWithVersion();

    assertThat(count).isEqualTo(4);
  }

  @BeforeAll
  static void init() {
    var config = new HikariConfig();
    config.setJdbcUrl(container.getJdbcUrl());
    config.setUsername(container.getUsername());
    config.setPassword(container.getPassword());
    config.setDriverClassName(container.getDriverClassName());
    datasource = new HikariDataSource(config);
  }

  @AfterAll
  static void close() {
    container.close();
  }
}
