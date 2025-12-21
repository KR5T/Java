package examples.Graphs;
import java.util.*;

class PrimGraph {
    int V;
    int[][] graph;

    PrimGraph(int v) {
        V = v;
        graph = new int[v][v];
    }

    void addEdge(int u, int v, int w) {
        graph[u][v] = w;
        graph[v][u] = w;
    }

    void primMST() {
        int[] key = new int[V];
        boolean[] mstSet = new boolean[V];
        int[] parent = new int[V];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        for (int i = 0; i < V - 1; i++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] &&
                        graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        System.out.println("Prim MST edges:");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + " : " + graph[i][parent[i]]);
    }

    int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, index = -1;
        for (int i = 0; i < V; i++) {
            if (!mstSet[i] && key[i] < min) {
                min = key[i];
                index = i;
            }
        }
        return index;
    }
}

public class Prim {
    public static void main(String[] args){
        PrimGraph graph = new PrimGraph(7);

        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 3);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 1);
        graph.addEdge(5, 6, 2);
        graph.addEdge(2, 6, 5);

        graph.primMST();
    }
}
