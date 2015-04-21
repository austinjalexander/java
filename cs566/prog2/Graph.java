// File: Graph.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 2
// Course: MET CS566 (SPRING 2015)

// REGARDING THE IMPLEMENTATION DETAILS BELOW 
// (E.G., THE USE OF PUBLIC INSTANCE VARIABLES), 
// PLEASE SEE THE NOTE (d) IN THE DOCUMENTATION FILE

import java.util.ArrayList;

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

  // GETTERS
  public Integer getIndex(Vertex u) {
    for (int i = 0; i < this.V.length; i++) {
      if (this.V[i].name == u.name) {
        return i;
      }
    }
    return null;
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
    for (int j = 0; j < this.Adj.length; j++) {
      if ( (this.Adj[j]) != null ) {
        for (int k = 0; k < this.Adj[j].length; k++) {
          System.out.print(this.Adj[j][k].name);
          if ( (k + 1) != this.Adj[j].length ) {
            System.out.print(",");
          }
        }
      }
      else {
        System.out.print("NIL");
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

    // for each v in V
    for (int i = 0; i < this.V.length; i++) {

      int counter = 0;
      /* count the number of times 
       * the current vertex in V occurs
       * in the entire adjacency list Adj */
      // for each sub list in Adj
      for (Vertex[] list : this.Adj) {
        // for each vertex in each sub list
        for (Vertex v : list) {
          // if the current vertex in V occurs
          // in the current sub list
          if (this.V[i].name == v.name) {
            counter++;
          }
        }//end: for (Vertex v : list)
      }//end: for (Vertex[] list : this.Adj)

      // use the counter to make
      // sub lists where relevant
      if (counter > 0) {
        Adj_T[i] = new Vertex[counter];
      }

      int index = 0;
      // for each element in the adjacency list Adj,
      // if the current vertex in V occurs,
      // place the parent vertex in the new 
      // transposed adjacency list in the proper location
      for (int j = 0; j < this.Adj.length; j++) {
        for (int k = 0; k < this.Adj[j].length; k++) {
          if (this.V[i].name == this.Adj[j][k].name) {
            Adj_T[i][index++] = this.V[j];
          }
        }//end: for (int k = 0; k < this.Adj[j].length; k++)
      }//end: for (int j = 0; j < this.Adj.length; j++)
    }//end: for (int i = 0; i < this.V.length; i++)

    return Adj_T;
  }//end: public Graph transpose()

  public void orderByFdesc() {
    for (int i = 0; i < this.V.length; i++) {
      for (int j = 0; j < this.V.length; j++) {
        if (this.V[i].f > this.V[j].f) {
          Vertex temp = this.V[j];
          this.V[j] = this.V[i];
          this.V[i] = temp;

          Vertex[] temp_array = this.Adj[j];
          this.Adj[j] = this.Adj[i];
          this.Adj[i] = temp_array;
        }
      }
    }
  }

  public void orderByFasc() {
    for (int i = 0; i < this.V.length; i++) {
      for (int j = 0; j < this.V.length; j++) {
        if (this.V[i].f < this.V[j].f) {
          Vertex temp = this.V[j];
          this.V[j] = this.V[i];
          this.V[i] = temp;

          Vertex[] temp_array = this.Adj[j];
          this.Adj[j] = this.Adj[i];
          this.Adj[i] = temp_array;
        }
      }
    }
  }

  public void printSCC() {
    System.out.println("\nprintSCC():");
    int counter = 1;
    for (int i = 0; i < this.V.length; i++) {
      if (this.Adj[i] == null) {
        if (counter > 1) {
          System.out.println("}");
        }
        System.out.print("SCC" + (counter++) + ": { ");
      }
      System.out.print(this.V[i].name + " ");
    }
    System.out.println("}");
  }

}//end: public class Graph

