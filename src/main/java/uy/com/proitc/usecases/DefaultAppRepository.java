package uy.com.proitc.usecases;

import javax.sql.DataSource;

class DefaultAppRepository implements AppRepository {

  private final DataSource dataSource;

  public DefaultAppRepository(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public Long countProductsWithVersion() {
    return Long.parseLong(
        performQuery(
            dataSource,
            """
                select count(id) as count from application
                where details -> 'version' is not null
                """,
            "count"));
  }

  @Override
  public String findNameById(int id) {
    return performQuery(dataSource, "select name from application where id=?", "name", id);
  }
}
