// File: Graph.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 2
// Course: MET CS566 (SPRING 2015)

// REGARDING THE IMPLEMENTATION DETAILS BELOW 
// (E.G., THE USE OF PUBLIC INSTANCE VARIABLES), 
// PLEASE SEE THE NOTE (d) IN THE DOCUMENTATION FILE

public class Graph {

  // INSTANCE VARIABLES
  public Vertex[] V;
  public Vertex[][] Adj;

  // CONSTRUCTORS
  public Graph() {
    this.V = null;
    this.Adj = null;
  }
  public Graph(int number_of_vertices) {
    this.V = new Vertex[number_of_vertices];
    this.Adj = new Vertex[number_of_vertices][];
  }

  // METHODS
  public void printV() {
    System.out.println("\nprintV():");
    for (Vertex u : this.V) {
      System.out.println(u.name);
    }
  }
  public void printAdj() {
    System.out.println("\nprintAdj():");
    for (Vertex[] list : this.Adj) {
      for (Vertex u : list) {
        System.out.print(u.name + ",");
      }
      System.out.println();
    }
  }
  public void printAdjTime() {
    System.out.println("\nprintAdjTime():");
    for (Vertex u : this.V) {
      System.out.print(u.name + "(" + u.d + "/" + u.f + ")" + 
                       "[" + u.color + "]" + ":");
      for (Vertex v : this.Adj[u.name-1]) {
        System.out.print(v.name + "(" + v.d + "/" + v.f + ")" + 
                       "[" + v.color + "]" + ",");
      }
      System.out.println();
    }
  }
  public Vertex[][] transpose() {
    // create new adjacency list
    Vertex[][] Adj_T = new Vertex[this.Adj.length][];

    // for each vertex in V
    for (int i = 0; i < this.V.length; i++) {

      int counter = 0;

      Adj_T[i] = null;

      for (int j = 0; j < this.Adj[i].length; j++) {
        if (this.Adj[i][j].name == this.V[i].name) {
          counter++;
        }
      }//end: for (int j = 0; j < this.Adj[i].length; j++)

      if (counter > 0) {
        Adj_T[i] = new Vertex[counter];
      }

      int index = 0;

      for (int j = 0; j < this.Adj[i].length; j++) {
        if (this.Adj[i][j].name == this.V[i].name) {
          Adj_T[i][index++] = this.V[i];
        }
      }//end: for (int j = 0; j < this.Adj[i].length; j++)
    }//end: for (int i = 0; i < this.V.length; i++)

    return Adj_T;
  }//end: public Graph transpose()

}//end: public class Graph

