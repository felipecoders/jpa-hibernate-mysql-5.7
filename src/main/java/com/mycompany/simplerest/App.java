/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simplerest;

import com.mycompany.simplerest.entities.Company;
import com.mycompany.simplerest.repositories.UserRepository;
import com.mycompany.simplerest.services.HibernateSession;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

/**
 *
 * @author Administrador
 */
public class App {
  
  public static void main(String[] args) {
    
    try {
//      Map<String, String> properties = new HashMap<String, String>();
//      properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
//      properties.put("javax.persistence.jdbc.user", "root");
//      properties.put("javax.persistence.jdbc.password", "");
//      EntityManagerFactory emf = Persistence.createEntityManagerFactory(
//        "jdbc:mysql://localhost:3306/simplerest?zeroDateTimeBehavior=convertToNull&characterEncoding=UTF-8&autoReconnect=true&useSSL=false",
//         properties);
//
//      EntityManager entityManager = emf.createEntityManager();
//      entityManager.getTransaction().begin();
//      entityManager.persist(new Company("Felipe 3"));
//      entityManager.getTransaction().commit();
//      entityManager.close();

//      new UserRepository().save("INSERT INTO company (id, name) VALUES ('" + UUID.randomUUID().toString() + "', 'new company')");
//      new UserRepository().findAllCompanies("SELECT * FROM company", new String[]{"name", "id"});
//      new UserRepository().findAllCompanies("SELECT * FROM users", new String[]{"name", "id", "sex", "age"});

//      System.out.println(companies);
      new App().estaFuncionando();
    } catch (Exception e) {
      System.out.println(e);
    } finally {
    }
  }
  
  private void estaFuncionando() throws Exception {
    EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("simplerest");
    EntityManager entityManager = sessionFactory.createEntityManager();
    
    entityManager.getTransaction().begin();
    entityManager.persist(new Company("Felipe 4"));
    entityManager.getTransaction().commit();
    entityManager.close();
  }
  
}
