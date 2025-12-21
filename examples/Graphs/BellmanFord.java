package examples.Graphs;
import java.util.*;

class BellmanFordGraph {
    static class Edge {
        int from, to, weight;
        Edge(int f, int t, int w) {
            from = f; to = t; weight = w;
        }
    }

    int V;
    List<Edge> edges = new ArrayList<>();

    BellmanFordGraph(int v) {
        V = v;
    }

    void addEdge(int from, int to, int weight) {
        edges.add(new Edge(from, to, weight));
    }

    void bellmanFord(int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i < V; i++) {
            for (Edge e : edges) {
                if (dist[e.from] != Integer.MAX_VALUE &&
                    dist[e.from] + e.weight < dist[e.to]) {
                    dist[e.to] = dist[e.from] + e.weight;
                }
            }
        }

        for (Edge e : edges) {
            if (dist[e.from] != Integer.MAX_VALUE &&
                dist[e.from] + e.weight < dist[e.to]) {
                System.out.println("Negative weight cycle detected!");
                return;
            }
        }

        System.out.println("Bellman-Ford shortest paths from " + src + ":");
        for (int i = 0; i < V; i++)
            System.out.println("To " + i + " = " + dist[i]);
    }
}

public class BellmanFord {
    public static void main(String[] args){
        BellmanFordGraph g = new BellmanFordGraph(7);
        g.addEdge(0,1,2);
        g.addEdge(1,2,-4); // negative value
        g.addEdge(2,3,2);
        g.addEdge(3,4,3);
        g.addEdge(4,5,2);
        g.addEdge(5,6,1);

        g.bellmanFord(0);

    }
}
