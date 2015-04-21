// File: StronglyConnectedComponents.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 2
// Course: MET CS566 (SPRING 2015)

// IMPORTS
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// PUBLIC CLASS
public class StronglyConnectedComponents {

  // GLOBAL VARIABLE
  public static int time;

  // CONSTANTS 
  public final static String WHITE = "WHITE";
  public final static String GRAY = "GRAY";
  public final static String BLACK = "BLACK";

  // MAIN
  public static void main(String[] args) {

    // WELCOME
    System.out.println("\n<<< STRONGLY-CONNECTED COMPONENTS PROGRAM >>>");

    // IMPORT
    // create new graph
    Graph G = createGraph(args[0]);

    // RUN SCC ALGORITHM
    System.out.print("\n*** RUN SCC ALGORITHM ***");

    // (1)
    System.out.println("\n(1) call DFS(G) to compute finishing times " +
                       "u.f for each vertex u:\n");
    // DFS on G
    DFS(G);
    // display DFS results
    G.printAdjTime();

    // (2)
    System.out.println("\n(2) compute G^T:\n");
    // compute G transpose
    Graph G_T = G;
    G_T.Adj = G.transpose();
    // display G transpose
    G_T.printAdjTime();

    // (3)
    System.out.println("\n(3) call DFS(G^T) but consider vertices in order " +
                       "of decreasing u.f:\n");
    // reorder by u.f
    G_T.orderByFdesc();
    // DFS on G^T
    DFS(G_T);
    // display G transpose
    G_T.printAdjTime();
    // reorder by u.f
    G_T.orderByFasc();

    // (4)
    System.out.println("\n(4) output the vertices of each tree in the depth-first " +
                       "forest\n    as a strongly-connected component; " +
                       "vertices are in ascending\n    order of u.f from DFS(G^T):\n");
    // display SCCs
    G_T.printSCC();
    // display final adjacency list
    G_T.printAdjTime();
    // output to file
    G_T.outputSCCandAdjList();

    // END PROGRAM
    System.out.println("\n<<< END PROGRAM >>>\n");

  }//end: public static void main(String[] args)

  // HELPER METHODS
  public static Graph createGraph(String filename) {

    Graph G = new Graph();

    try {
      Stream<String> lines = Files.lines(Paths.get(filename));
      System.out.println("*** IMPORT GRAPH FROM ADJ LIST FILE ***");
      lines.forEach(s -> System.out.println(s));

      lines = Files.lines(Paths.get(filename));      
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

}//end: public class StronglyConnectedComponents
