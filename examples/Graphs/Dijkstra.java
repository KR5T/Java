package examples.Graphs;
import java.util.*;

class DijkstraGraph {
    int V;
    List<List<Edge>> adj;

    static class Edge {
        int to, weight;
        Edge(int t, int w) {
            to = t;
            weight = w;
        }
    }

    DijkstraGraph(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());
    }

    void addEdge(int from, int to, int weight) {
        adj.get(from).add(new Edge(to, weight));
    }

    void dijkstra(int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];

            for (Edge e : adj.get(u)) {
                if (dist[u] + e.weight < dist[e.to]) {
                    dist[e.to] = dist[u] + e.weight;
                    pq.add(new int[]{e.to, dist[e.to]});
                }
            }
        }

        System.out.println("Dijkstra shortest paths from " + src + ":");
        for (int i = 0; i < V; i++)
            System.out.println("To " + i + " = " + dist[i]);
    }
}

public class Dijkstra {
    public static void main(String[] args){
        DijkstraGraph g = new DijkstraGraph(7);
        g.addEdge(0,1,2);
        g.addEdge(0,2,4);
        g.addEdge(1,3,1);
        g.addEdge(2,3,3);
        g.addEdge(3,4,2);
        g.addEdge(4,5,1);
        g.addEdge(5,6,2);

        g.dijkstra(0); 
    }   
}