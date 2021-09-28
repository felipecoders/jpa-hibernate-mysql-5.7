package com.mycompany.simplerest.entities;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company {

  public Company() {
  }

  public Company(String name) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
  }

  @Id
  @Column(name="id")
  private String id;
  
  @Column(name = "name")
  private String name;

  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }
}
