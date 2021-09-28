package com.mycompany.simplerest.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class HibernateSession {

  @PersistenceContext
  private static EntityManager entityManager = null;

  public static EntityManager getEntityManager() {
    if (entityManager == null) {
      entityManager = Persistence.createEntityManagerFactory("simplerest").createEntityManager();
    }

    return entityManager;
  }
  
  public static void save(Object entity) {
    entityManager.getTransaction().begin();
    entityManager.persist(entity);
    entityManager.getTransaction().commit();
    entityManager.close();
  }

}
