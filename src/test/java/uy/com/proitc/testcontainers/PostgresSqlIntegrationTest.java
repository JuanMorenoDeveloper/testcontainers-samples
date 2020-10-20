package uy.com.proitc.testcontainers;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Testcontainers
public class PostgresSqlIntegrationTest extends AbstractContainerDatabaseTest {

    @Container
    private PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer()
            .withDatabaseName("foo")
            .withUsername("foo")
            .withPassword("secret");

    @Test
    void test() throws SQLException {
        assertThat(postgresqlContainer.isRunning()).isTrue();

        try (var result = performQuery(postgresqlContainer, "select 1")) {
            assertThat(result.getInt(1)).isOne();
        }
    }

}
