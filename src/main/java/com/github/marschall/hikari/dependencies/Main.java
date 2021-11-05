package com.github.marschall.hikari.dependencies;

import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class Main {

  public static void main(String[] args) throws SQLException {
    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setJdbcUrl("jdbc:h2:mem:");

    try (var connection = dataSource.getConnection();
         var preparedStatement = connection.prepareStatement("SELECT 1 FROM dual");
         var resultSet = preparedStatement.executeQuery()) {
      while (resultSet.next()) {
        System.out.println(resultSet.getString(1));
      }
    }

  }

}
