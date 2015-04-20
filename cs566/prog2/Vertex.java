// File: Vertex.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 2
// Course: MET CS566 (SPRING 2015)

// REGARDING THE IMPLEMENTATION DETAILS BELOW 
// (E.G., THE USE OF PUBLIC INSTANCE VARIABLES), 
// PLEASE SEE THE NOTE (d) IN THE DOCUMENTATION FILE

public class Vertex {

  // INSTANCE VARIABLES
  public Vertex pi;
  public Integer name;
  public Integer d;
  public Integer f;
  public String color;

  // CONSTRUCTORS
  public Vertex() {
    this.pi = null;
    this.name = null;
    this.d = null;
    this.f = null;
    this.color = null;
  }
  public Vertex(int name) {
    this.pi = null;
    this.name = name;
    this.d = null;
    this.f = null;
    this.color = null;
  }
}

