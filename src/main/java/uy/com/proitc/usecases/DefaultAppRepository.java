package uy.com.proitc.usecases;

import java.sql.SQLException;
import javax.sql.DataSource;

class DefaultAppRepository implements AppRepository {

  private final DataSource dataSource;

  public DefaultAppRepository(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public long countProductsWithVersion() {
    try (var result = performQuery(dataSource,
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
    try (var result = performQuery(dataSource,
        "select name from application where id=?", id)) {
      return result.getString("name");
    } catch (SQLException e) {
      return "";
    }
  }
}
