package uy.com.proitc.usecases.postgresql;

import javax.sql.DataSource;

class ApplicationRepository implements Repository {

  private final DataSource dataSource;

  public ApplicationRepository(DataSource dataSource) {
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
