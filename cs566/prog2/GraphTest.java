// File: GraphTest.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 2
// Course: MET CS566 (SPRING 2015)

// IMPORTS
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// PUBLIC CLASS
public class GraphTest {

  // GLOBAL VARIABLE
  public static int time;

  // CONSTANTS 
  public final static String WHITE = "WHITE";
  public final static String GRAY = "GRAY";
  public final static String BLACK = "BLACK";

  // MAIN
  public static void main(String[] args) {

    /*** TEST VERTEX ***/
    Vertex vertex = new Vertex();
    vertex.pi = new Vertex();
    vertex.name = 1;
    vertex.d = 1;
    vertex.f = 2;
    vertex.color = WHITE;

    /*** TEST FILE I/O ***/
    System.out.print("\n/*** TEST FILE I/O ***/");
    try {
      Stream<String> lines = Files.lines(Paths.get("p3_input.txt"));
      System.out.println("\nlines.forEach(s -> System.out.println(s)):");
      lines.forEach(s -> System.out.println(s));
    }
    catch(Exception e) {
      System.out.println(e);
    }

    /*** TEST STREAM TO STRINGS TO VERTICES ***/
    System.out.print("\n/*** TEST STREAM TO STRINGS TO VERTICES ***/");
    // create new graph
    Graph G = createGraph();
    // check that V and Adj match input file
    G.printV();
    G.printAdj();

    /*** TEST CLRS ALGORITHMS ***/
    System.out.print("\n/*** TEST CLRS ALGORITHMS ***/");
    // create new graph
    G = createGraph();
    // try DFS
    DFS(G);
    // check DFS
    G.printAdjTime();

    /*** TEST MATRIX TRANSPOSE ***/
    System.out.print("\n/*** TEST MATRIX TRANSPOSE ***/");
    //(1)
    System.out.print("\n(1)");
    // create new graph
    G = createGraph();
    // create G transpose
    Graph G_T = G;
    G_T.Adj = G.transpose();
    // check transpose
    G_T.printAdj();

    //(2)
    System.out.print("\n(2)");
    // create new graph
    G = createGraph();
    // try DFS
    DFS(G);
    // check DFS
    G.printAdjTime();
    // create G transpose
    G_T = G;
    G_T.Adj = G.transpose();
    // check G transpose
    G_T.printAdjTime();

    //(3)
    System.out.print("\n(3)");
    // create new graph
    G = createGraph();
    // try DFS
    DFS(G);
    // check DFS
    G.printAdjTime();
    // create G transpose
    G_T = G;
    G_T.Adj = G.transpose();
    // reorder by u.f
    G_T.orderByFdesc();
    // check order
    G_T.printV();
    // try DFS
    DFS(G_T);
    // check G transpose
    G_T.printAdjTime();
    // reorder by u.f
    G_T.orderByFasc();
    // check order
    G_T.printV();
    // check SCC
    G_T.printSCC();

  }//end: public static void main(String[] args)

  // HELPER METHODS
  public static Graph createGraph() {

    Graph G = new Graph();

    try {
      Stream<String> lines = Files.lines(Paths.get("p3_input.txt"));
      String[] adj_list = lines.toArray(size -> new String[size]);

      // create graph
      G = new Graph(adj_list.length);

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
    }//end: try
    catch(Exception e) {
      System.out.println(e);
    }//end: catch(Exception e)

    return G;
  }

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
    for (int i = 0; i < G.V.length; i++) {
      G.V[i].color = WHITE;
      G.V[i].pi = null;
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
    for (int i = 0; i < G.V.length; i++) {
      if (G.V[i].color == WHITE) {
        DFS_VISIT(G,G.V[i]);
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
    // swap vertex u with an int representation called u_i
    int u_i = G.getIndex(u);

    G.V[u_i].d = time;
    G.V[u_i].color = GRAY;
    // IF JAVA'S ENHANCED-FOR LOOP ALLOWED ASSIGNMENT,
    // THE FOR LOOP WOULD MUCH BETTER RESEMBLE THE CLRS ALGORITHM:
    //for (Vertex v : G.Adj[u.name-1]) {
    //  if (v.color == WHITE) {
    //    v.pi = u;
    //    DFS_VISIT(G,v);
    //  }
    //}
    // INSTEAD, AN INCREMENTAL-LOOP MUST BE USED TO MODIFY ARRAY ELEMENTS:
    // (unlike the textbook's algorithm, 
    // in practice, a condition needs to be added for when
    // G.Adj[u_i]) is NIL
    if (G.Adj[u_i] != null) {
      for (int i = 0; i < G.Adj[u_i].length; i++) {
        if (G.Adj[u_i][i].color == WHITE) {
          G.Adj[u_i][i].pi = G.V[u_i];
          DFS_VISIT(G,G.Adj[u_i][i]);
        }
      }
    }

    // THE CLRS ALGORITHM ALLOWS FOR MODIFYING VERTEX U DIRECTLY,
    // BUT IN JAVA ONLY THE LOCAL COPY WOULD BE MODIFIED;
    // INSTEAD, DIRECTLY ACCESSING THE ARRAY ELEMENT IS NEEDED FOR ASSIGNMENT
    // IN THE TWO CASES BELOW:
    //u.color = BLACK;
    G.V[u_i].color = BLACK;
    time = time + 1;
    //u.f = time;
    G.V[u_i].f = time;
  }//end: public static void DFS_VISIT(Graph G, Vertex u)

}//end: public class GraphTest
