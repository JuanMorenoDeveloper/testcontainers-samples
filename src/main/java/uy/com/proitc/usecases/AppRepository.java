package uy.com.proitc.usecases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

interface AppRepository {

  long countProductsWithVersion();

  String findNameById(int id);

  default ResultSet performQuery(DataSource dataSource, String sql)
      throws SQLException {
    try (var statement = dataSource.getConnection().prepareStatement(sql)) {
      return getResultSet(statement);
    }
  }

  default ResultSet performQuery(DataSource dataSource, String sql, int id)
      throws SQLException {
    try (var statement = dataSource.getConnection().prepareStatement(sql)) {
      statement.setInt(1, id);
      return getResultSet(statement);
    }
  }

  private ResultSet getResultSet(PreparedStatement statement) throws SQLException {
    statement.execute();
    var resultSet = statement.getResultSet();
    resultSet.next();
    return resultSet;
  }
}
