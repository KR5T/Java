package examples.Graphs;
import java.util.*;

class Graph {
    private int V;
    private LinkedList<Integer>[] adj;

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int from, int to) {
        adj[from].add(to);
    }

    boolean isCyclic() {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfsCycle(i, visited, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfsCycle(int v, boolean[] visited, boolean[] recStack) {
        visited[v] = true;
        recStack[v] = true;

        for (int neighbor : adj[v]) {
            if (!visited[neighbor]) {
                if (dfsCycle(neighbor, visited, recStack))
                    return true;
            } else if (recStack[neighbor]) {
                return true; 
            }
        }

        recStack[v] = false;
        return false;
    }
}

public class CycleDetection {
    public static void main(String[] args) {

        Graph graph = new Graph(7);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1); 
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);

        if (graph.isCyclic()) {
            System.out.println("Graph contains a cycle.");
        } else {
            System.out.println("Graph does NOT contain a cycle.");
        }
    }
}
