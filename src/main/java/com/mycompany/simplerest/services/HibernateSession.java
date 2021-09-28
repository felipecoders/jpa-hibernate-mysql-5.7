package com.mycompany.simplerest.services;

import com.mycompany.simplerest.entities.Company;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateSession {

  private EntityManagerFactory entityManagerFactory = null;
  private EntityManager entityManager = null;

  private EntityManager getEntityManager() {
    if (this.entityManagerFactory == null) {

      this.entityManagerFactory = Persistence.createEntityManagerFactory("simplerest");
    }

    if (this.entityManager == null) {
      this.entityManager = this.entityManagerFactory.createEntityManager();
    }

    return this.entityManager;
  }

  public void save(Object entity) {
    this.entityManager.getTransaction().begin();
    this.entityManager.persist(entity);
    this.entityManager.getTransaction().commit();
    this.entityManager.close();
  }

}
