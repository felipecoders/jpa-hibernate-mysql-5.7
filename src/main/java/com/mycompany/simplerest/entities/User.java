package com.mycompany.simplerest.entities;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

  public User() {}
  
  public User(String name, String sex, int age) {
    this.age = age;
    this.id = UUID.randomUUID().toString();
    this.name = name;
    this.sex = sex;
  }
  
  @Id
  @Column(name="id")
  private String id;
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "age")
  private int age;
  
  @Column(name = "sex")
  private String sex;

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

  /**
   * @return the age
   */
  public int getAge() {
    return age;
  }

  /**
   * @param age the age to set
   */
  public void setAge(int age) {
    this.age = age;
  }

  /**
   * @return the sex
   */
  public String getSex() {
    return sex;
  }

  /**
   * @param sex the sex to set
   */
  public void setSex(String sex) {
    this.sex = sex;
  }

}
