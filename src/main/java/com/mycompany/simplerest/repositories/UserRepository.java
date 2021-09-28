package com.mycompany.simplerest.repositories;

import com.mycompany.simplerest.config.ConexaoMySQL;
import com.mycompany.simplerest.entities.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepository {

  // temp
  private static List<User> users = new ArrayList<>();

  public void save(User user) throws Exception {
    user.setId(UUID.randomUUID().toString());

    users.add(user);
  }

  public User findOne(String id) {
    return users.stream().filter(user -> user.getId().equals(id)).findFirst().get();
  }
  
  public void save(String sql) throws Exception  {
    Connection conexaoMySQL = ConexaoMySQL.getConexaoMySQL();
    Statement statement = conexaoMySQL.createStatement();
    statement.execute(sql);
    
    ConexaoMySQL.FecharConexao();
  }
  
  public void findAllCompanies(String sql, String[] columns) throws Exception {
    Connection conexaoMySQL = ConexaoMySQL.getConexaoMySQL();
    Statement statement = conexaoMySQL.createStatement();
    ResultSet result = statement.executeQuery(sql);

    while (result.next()) {
      for (String column : columns) {
        System.out.println(result.getString(column));
      }
    }
    
    ConexaoMySQL.FecharConexao();
  }

}
