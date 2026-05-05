import java.util.*;

class Edge {
    int dest, weight;

    public Edge(int d, int w) {
        dest = d;
        weight = w;
    }
}

class Dijkstra {

    static final int V = 6;

    static final int ARAD = 0;
    static final int SIBIU = 1;
    static final int RIMNICU = 2;
    static final int PITESTI = 3;
    static final int FAGARAS = 4;
    static final int BUCHAREST = 5;

    public static void dijkstra(List<List<Edge>> graph, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];

            for (Edge e : graph.get(u)) {
                if (dist[u] + e.weight < dist[e.dest]) {
                    dist[e.dest] = dist[u] + e.weight;
                    pq.add(new int[]{e.dest, dist[e.dest]});
                }
            }
        }

        System.out.println("Shortest Distance (Dijkstra): " + dist[BUCHAREST]);
    }

    public static void main(String[] args) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        graph.get(ARAD).add(new Edge(SIBIU, 140));
        graph.get(SIBIU).add(new Edge(RIMNICU, 80));
        graph.get(SIBIU).add(new Edge(FAGARAS, 99));
        graph.get(RIMNICU).add(new Edge(PITESTI, 97));
        graph.get(PITESTI).add(new Edge(BUCHAREST, 101));
        graph.get(FAGARAS).add(new Edge(BUCHAREST, 211));

        dijkstra(graph, ARAD);
    }
}
