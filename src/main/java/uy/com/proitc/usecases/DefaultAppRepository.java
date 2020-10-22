package uy.com.proitc.usecases;

import java.sql.SQLException;
import org.testcontainers.containers.GenericContainer;

class DefaultAppRepository implements AppRepository {


  private final GenericContainer<?> postgresqlContainer;

  public DefaultAppRepository(
      GenericContainer<?> postgresqlContainer) {
    this.postgresqlContainer = postgresqlContainer;
  }

  @Override
  public long countProductsWithVersion() {
    try (var result = performQuery(postgresqlContainer,
        """
            select count(id) as count from application 
            where details -> 'version' is not null
            """)) {
      return result.getLong("count");
    } catch (SQLException e) {
      return 0;
    }
  }

  @Override
  public String findNameById(int id) {
    try (var result = performQuery(postgresqlContainer,
        "select name from application where id=?", id)) {
      return result.getString("name");
    } catch (SQLException e) {
      return "";
    }
  }
}
