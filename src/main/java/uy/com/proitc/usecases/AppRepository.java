package uy.com.proitc.usecases;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

interface AppRepository {

  Long countProductsWithVersion();

  String findNameById(int id);

  default String performQuery(DataSource dataSource, String sql, String columName) {
    try (var statement = dataSource.getConnection().prepareStatement(sql)) {
      return getResultSet(statement, columName);
    } catch (SQLException e) {
      throw new IllegalStateException(e);
    }
  }

  default String performQuery(DataSource dataSource, String sql, String columName, int id) {
    try (var statement = dataSource.getConnection().prepareStatement(sql)) {
      statement.setInt(1, id);
      return getResultSet(statement, columName);
    } catch (SQLException e) {
      throw new IllegalStateException(e);
    }
  }

  private String getResultSet(PreparedStatement statement, String columName) throws SQLException {
    statement.execute();
    var resultSet = statement.getResultSet();
    resultSet.next();
    return resultSet.getString(columName);
  }
}
