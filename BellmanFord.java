import java.util.*;

class EdgeBF {
    int src, dest, weight;

    public EdgeBF(int s, int d, int w) {
        src = s;
        dest = d;
        weight = w;
    }
}

public class BellmanFord {

    static final int V = 6;

    static final int ARAD = 0;
    static final int SIBIU = 1;
    static final int RIMNICU = 2;
    static final int PITESTI = 3;
    static final int FAGARAS = 4;
    static final int BUCHAREST = 5;

    public static void bellmanFord(List<EdgeBF> edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (EdgeBF e : edges) {
                if (dist[e.src] != Integer.MAX_VALUE &&
                        dist[e.src] + e.weight < dist[e.dest]) {
                    dist[e.dest] = dist[e.src] + e.weight;
                }
            }
        }

        System.out.println("Shortest Distance (Bellman-Ford): " + dist[BUCHAREST]);
    }

    public static void main(String[] args) {
        List<EdgeBF> edges = new ArrayList<>();

        edges.add(new EdgeBF(ARAD, SIBIU, 140));
        edges.add(new EdgeBF(SIBIU, RIMNICU, 80));
        edges.add(new EdgeBF(RIMNICU, PITESTI, 97));
        edges.add(new EdgeBF(PITESTI, BUCHAREST, 101));
        edges.add(new EdgeBF(SIBIU, FAGARAS, 99));
        edges.add(new EdgeBF(FAGARAS, BUCHAREST, 211));

        bellmanFord(edges, ARAD);
    }
}
