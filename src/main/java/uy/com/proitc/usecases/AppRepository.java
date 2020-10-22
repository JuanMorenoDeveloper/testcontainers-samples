package uy.com.proitc.usecases;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.JdbcDatabaseContainer;

interface AppRepository {

  long countProductsWithVersion();

  String findNameById(int id);

  default ResultSet performQuery(GenericContainer<?> container, String sql)
      throws SQLException {
    var ds = getDataSource((JdbcDatabaseContainer<?>) container);
    try (var statement = ds.getConnection().prepareStatement(sql)) {
      return getResultSet(statement);
    }
  }

  default ResultSet performQuery(GenericContainer<?> container, String sql, int id)
      throws SQLException {
    var ds = getDataSource((JdbcDatabaseContainer<?>) container);
    try (var statement = ds.getConnection().prepareStatement(sql)) {
      statement.setInt(1, id);
      return getResultSet(statement);
    }
  }

  default DataSource getDataSource(JdbcDatabaseContainer<?> container) {
    var config = new HikariConfig();
    config.setJdbcUrl(container.getJdbcUrl());
    config.setUsername(container.getUsername());
    config.setPassword(container.getPassword());
    config.setDriverClassName(container.getDriverClassName());
    return new HikariDataSource(config);
  }

  private ResultSet getResultSet(PreparedStatement statement) throws SQLException {
    statement.execute();
    var resultSet = statement.getResultSet();
    resultSet.next();
    return resultSet;
  }
}
