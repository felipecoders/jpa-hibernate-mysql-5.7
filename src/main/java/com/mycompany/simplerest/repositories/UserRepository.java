package com.mycompany.simplerest.repositories;

import com.mycompany.simplerest.entities.User;
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

}
