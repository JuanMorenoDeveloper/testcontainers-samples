package uy.com.proitc.testcontainers;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.testcontainers.containers.JdbcDatabaseContainer;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractContainerDatabaseTest {

    protected ResultSet performQuery(JdbcDatabaseContainer<?> container, String sql) throws SQLException {
        var ds = getDataSource(container);
        var statement = ds.getConnection().createStatement();
        statement.execute(sql);
        var resultSet = statement.getResultSet();
        resultSet.next();
        return resultSet;
    }

    protected DataSource getDataSource(JdbcDatabaseContainer<?> container) {
        var config = new HikariConfig();
        config.setJdbcUrl(container.getJdbcUrl());
        config.setUsername(container.getUsername());
        config.setPassword(container.getPassword());
        config.setDriverClassName(container.getDriverClassName());

        return new HikariDataSource(config);
    }
}