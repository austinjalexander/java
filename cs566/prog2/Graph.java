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
    for (int i = 0; i < this.V.length; i++) {

      System.out.print(this.V[i].name + "(" + this.V[i].d + "/" + 
                       this.V[i].f + ")" + 
                       "[" + this.V[i].color + "]" + ":");

      // if the adjacency list row is empty
      if (this.Adj[i] == null) {
        System.out.println("NIL");
      }
      // otherwise
      else {
        for (int j = 0; j < this.Adj[i].length; j++) {
          System.out.print(this.Adj[i][j].name + "(" + this.Adj[i][j].d + 
                           "/" + this.Adj[i][j].f + ")" + 
                           "[" + this.Adj[i][j].color + "]");

          if ( (j + 1) != this.Adj[i].length ) {
            System.out.print(",");
          }
        }//end: for (int j = 0; j < this.Adj[i].length; j++)
        System.out.println();
      }

    }//end: for (int i = 0; i < this.V.length; i++)
  }//end: public void printAdjTime()

  public Vertex[][] transpose() {
    // create new adjacency list
    Vertex[][] Adj_T = new Vertex[this.Adj.length][];

    // for each vertex in V
    for (int i = 0; i < this.V.length; i++) {

      // set counter to 0
      int counter = 0;
      // set the new transpose adjacency list row to null
      Adj_T[i] = null;

      // initial count to see how long each transpose adjacency list row should be
      // for each vertex in the original adjacency list row
      for (int j = 0; j < this.Adj[i].length; j++) {
        // if the current vertex appears
        if (this.V[i].name == this.Adj[i][j].name) {
          // then that vertex appears in a row, and it should be counted
          counter++;
        }
      }//end: for (int j = 0; j < this.Adj[i].length; j++)

      // if the counter is greater than 0
      if (counter > 0) {
        // create an adjacency list row for this vertex
        Adj_T[i] = new Vertex[counter];
      }//end: if (counter > 0)

      int index = 0;

      for (int j = 0; j < this.Adj[i].length; j++) {
        // if the current vertex appears
        if (this.V[i].name == this.Adj[i][j].name) {
          // then that vertex appears in a row, and it should be counted
          Adj_T[i][index++] = this.V[i];
        }
      }//end: for (int j = 0; j < this.Adj[i].length; j++)

    }//end: for (int i = 0; i < this.V.length; i++)

    return Adj_T;
  }//end: public Graph transpose()

}//end: public class Graph

