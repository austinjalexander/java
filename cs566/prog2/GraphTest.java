// File: GraphTest.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 2
// Course: MET CS566 (SPRING 2015)

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.ArrayList;

public class GraphTest {

  // GLOBAL VARIABLE
  public static int time;

  // CONSTANTS 
  public final static String WHITE = "WHITE";
  public final static String GRAY = "GRAY";
  public final static String BLACK = "BLACK";

  // MAIN
  public static void main(String[] args) {

    // test vertex
    Vertex vertex = new Vertex();
    vertex.pi = new Vertex();
    vertex.name = 1;
    vertex.d = 1;
    vertex.f = 2;
    vertex.color = WHITE;

    // test file i/o
    try {
      Stream<String> lines = Files.lines(Paths.get("test_input.txt"));
      System.out.println("\nlines.forEach(s -> System.out.println(s)):");
      lines.forEach(s -> System.out.println(s));
    }
    catch(Exception e) {
      System.out.println(e);
    }

    // test stream to strings to vertices
    try {
      Stream<String> lines = Files.lines(Paths.get("test_input.txt"));
      String[] adj_list = lines.toArray(size -> new String[size]);

      // create graph
      Graph G = new Graph(adj_list.length);

      // index counter
      int index = 0;

      // create V
      for (String vertex_list : adj_list) {
        // separate vertex from adjacent vertices
        String[] rows = vertex_list.split(":");
        // create/store vertex
        int name = Integer.parseInt(rows[0]);
        G.V[index++] = new Vertex(name);
      }//end: for (String vertex_list : adj_list)

      // reset index counter
      index = 0;

      // create Adj
      for (String vertex_list : adj_list) {
        // separate vertex from adjacent vertices
        String[] rows = vertex_list.split(":");
        // create/store vertex
        int name = Integer.parseInt(rows[0]);
        // separate adjacent vertices
        String[] adj_vertices = rows[1].split(",");
        // store adjacent vertices (getting them from V)
        G.Adj[index] = new Vertex[adj_vertices.length];
        for (int i = 0; i < adj_vertices.length; i++) {
          for (int j = 0; j < G.V.length; j++) {
            if (G.V[j].name == Integer.parseInt(adj_vertices[i])) {
              G.Adj[index][i] = G.V[j];
            }
          }
        }
        // increment index
        index++;
      }//end: for (String vertex_list : adj_list)

      // check that V and Adj match input file
      G.printV();
      G.printAdj();

    }//end: try
    catch(Exception e) {
      System.out.println(e);
    }//end: catch(Exception e)

    // test CLRS algorithms
    try {
      Stream<String> lines = Files.lines(Paths.get("test_input.txt"));
      String[] adj_list = lines.toArray(size -> new String[size]);

      // create graph
      Graph G = new Graph(adj_list.length);

      // index counter
      int index = 0;

      // create V
      for (String vertex_list : adj_list) {
        // separate vertex from adjacent vertices
        String[] rows = vertex_list.split(":");
        // create/store vertex
        int name = Integer.parseInt(rows[0]);
        G.V[index++] = new Vertex(name);
      }//end: for (String vertex_list : adj_list)

      // reset index counter
      index = 0;

      // create Adj
      for (String vertex_list : adj_list) {
        // separate vertex from adjacent vertices
        String[] rows = vertex_list.split(":");
        // create/store vertex
        int name = Integer.parseInt(rows[0]);
        // separate adjacent vertices
        String[] adj_vertices = rows[1].split(",");
        // store adjacent vertices (getting them from V)
        G.Adj[index] = new Vertex[adj_vertices.length];
        for (int i = 0; i < adj_vertices.length; i++) {
          for (int j = 0; j < G.V.length; j++) {
            if (G.V[j].name == Integer.parseInt(adj_vertices[i])) {
              G.Adj[index][i] = G.V[j];
            }
          }
        }
        // increment index
        index++;
      }//end: for (String vertex_list : adj_list)

      // try DFS
      DFS(G);

      // check DFS
      G.printAdjTime();

    }//end: try
    catch(Exception e) {
      System.out.println(e);
    }//end: catch(Exception e)

    // test matrix transpose
    try {
      Stream<String> lines = Files.lines(Paths.get("test_input.txt"));
      String[] adj_list = lines.toArray(size -> new String[size]);

      // create graph
      Graph G = new Graph(adj_list.length);

      // index counter
      int index = 0;

      // create V
      for (String vertex_list : adj_list) {
        // separate vertex from adjacent vertices
        String[] rows = vertex_list.split(":");
        // create/store vertex
        int name = Integer.parseInt(rows[0]);
        G.V[index++] = new Vertex(name);
      }//end: for (String vertex_list : adj_list)

      // reset index counter
      index = 0;

      // create Adj
      for (String vertex_list : adj_list) {
        // separate vertex from adjacent vertices
        String[] rows = vertex_list.split(":");
        // create/store vertex
        int name = Integer.parseInt(rows[0]);
        // separate adjacent vertices
        String[] adj_vertices = rows[1].split(",");
        // store adjacent vertices (getting them from V)
        G.Adj[index] = new Vertex[adj_vertices.length];
        for (int i = 0; i < adj_vertices.length; i++) {
          for (int j = 0; j < G.V.length; j++) {
            if (G.V[j].name == Integer.parseInt(adj_vertices[i])) {
              G.Adj[index][i] = G.V[j];
            }
          }
        }
        // increment index
        index++;
      }//end: for (String vertex_list : adj_list)

      // try DFS
      DFS(G);

      // check DFS
      G.printAdjTime();

      // create G transpose
      Graph G_T = G;
      G_T.Adj = G.transpose();

      // check G transpose
      G_T.printAdjTime();


    }//end: try
    catch(Exception e) {
      System.out.println(e);
    }//end: catch(Exception e)
  }//end: public static void main(String[] args)

  // *** TEXTBOOK ALGORITHMS ***
  // REGARDING THE IMPLEMENTATION DETAILS BELOW 
  // (E.G., THE USE OF PUBLIC INSTANCE VARIABLES), 
  // PLEASE SEE THE NOTE (d) IN THE DOCUMENTATION FILE
  public static void DFS(Graph G) {
    // IF JAVA'S ENHANCED-FOR LOOP ALLOWED ASSIGNMENT,
    // THE FOR LOOP WOULD MUCH BETTER RESEMBLE THE CLRS ALGORITHM:
    //for (Vertex u : G.V) {
    //  u.color = WHITE;
    //  u.pi = null;
    //}
    // INSTEAD, AN INCREMENTAL-LOOP MUST BE USED TO MODIFY ARRAY ELEMENTS:
    for (int u = 0; u < G.V.length; u++) {
      G.V[u].color = WHITE;
      G.V[u].pi = null;
    }
    time = 0;
    // IF JAVA'S ENHANCED-FOR LOOP ALLOWED ASSIGNMENT,
    // THE FOR LOOP WOULD MUCH BETTER RESEMBLE THE CLRS ALGORITHM:
    //for (Vertex u : G.V) {
    //  if (u.color == WHITE) {
    //    DFS_VISIT(G,u);
    //  }
    //}
    // INSTEAD, AN INCREMENTAL-LOOP MUST BE USED TO MODIFY ARRAY ELEMENTS:
    for (int u = 0; u < G.V.length; u++) {
      if (G.V[u].color == WHITE) {
        DFS_VISIT(G,G.V[u]);
      }
    }
  }//end: public static void DFS(Graph G)

  public static void DFS_VISIT(Graph G, Vertex u) {
    time = time + 1;
    // THE CLRS ALGORITHM ALLOWS FOR MODIFYING VERTEX U DIRECTLY,
    // BUT IN JAVA ONLY THE LOCAL COPY WOULD BE MODIFIED:
    //u.d = time;
    //u.color = GRAY;
    // INSTEAD, DIRECTLY ACCESSING THE ARRAY ELEMENT IS NEEDED FOR ASSIGNMENT:
    // (index Adj[u.name-1] to conform CLRS algorithm to 0-based indexing)
    G.V[u.name-1].d = time;
    G.V[u.name-1].color = GRAY;
    // IF JAVA'S ENHANCED-FOR LOOP ALLOWED ASSIGNMENT,
    // THE FOR LOOP WOULD MUCH BETTER RESEMBLE THE CLRS ALGORITHM:
    //for (Vertex v : G.Adj[u.name-1]) {
    //  if (v.color == WHITE) {
    //    v.pi = u;
    //    DFS_VISIT(G,v);
    //  }
    //}
    // INSTEAD, AN INCREMENTAL-LOOP MUST BE USED TO MODIFY ARRAY ELEMENTS:
    for (int v = 0; v < G.Adj[u.name-1].length; v++) {
      if (G.Adj[u.name-1][v].color == WHITE) {
        G.Adj[u.name-1][v].pi = u;
        DFS_VISIT(G,G.Adj[u.name-1][v]);
      }
    }
    // THE CLRS ALGORITHM ALLOWS FOR MODIFYING VERTEX U DIRECTLY,
    // BUT IN JAVA ONLY THE LOCAL COPY WOULD BE MODIFIED;
    // INSTEAD, DIRECTLY ACCESSING THE ARRAY ELEMENT IS NEEDED FOR ASSIGNMENT
    // IN THE TWO CASES BELOW:
    // (index G.V[u.name-1] to conform CLRS algorithm to 0-based indexing)
    //u.color = BLACK;
    G.V[u.name-1].color = BLACK;
    time = time + 1;
    //u.f = time;
    G.V[u.name-1].f = time;
  }//end: public static void DFS_VISIT(Graph G, Vertex u)

}//end: public class GraphTest
