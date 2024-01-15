package com.mad.openltablets.model;

import lombok.Data;

@Data
public class Person {
  private String name;
  private int age;
  private String discount;
  private boolean isSenior;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }
}
