package model;

public class Ornamental extends Plant {
  
  private double altura;

  public Ornamental(String name, double cost, double altura) {
    super(name, cost);
    this.altura = altura;
  }
}