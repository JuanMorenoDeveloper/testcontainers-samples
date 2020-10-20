package uy.com.proitc.testcontainers;

import static java.util.Collections.singletonMap;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class PostgresSqlIntegrationTest extends AbstractContainerDatabaseTest {

  //Containers declared as static fields will be shared between test methods.
  @Container
  static final GenericContainer postgresqlContainer = new PostgreSQLContainer(
      "postgres:9.6.12")
      .withDatabaseName("foo")
      .withUsername("foo")
      .withPassword("secret")
      .withInitScript("init_script.sql")
      // Container can have tmpfs mounts for storing data in host memory.
      // This is useful if you want to speed up your database tests.
      .withTmpFs(singletonMap("/var/lib/postgresql/data", "rw"));

  @Test
  void givenId_whenPerformQuery_thenGetApplicationName() throws SQLException {
    try (var result = performQuery(postgresqlContainer,
        "select id, name from application where id=1")) {

      assertThat(result.getString("name")).isEqualTo("Transcof");
    }
  }

  @Test
  void whenPerformQueryFilteredByVersion_thenGetCorrectCounter() throws SQLException {
    try (var result = performQuery(postgresqlContainer,
        """
            select count(id) as count from application 
            where details -> 'version' is not null
            """)) {

      assertThat(result.getInt("count")).isEqualTo(4);
    }
  }

}
