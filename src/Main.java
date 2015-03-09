/**
 * Created by Chau Ngo.
 */
public class Main {
    public static void main(String[] args) {
        int size = 7;
        Node[] graph = new Node[size];

        for (int i = 0; i < size; i++) {
            int a = 65 + i;
            char c = (char) a;
            graph[i] = new Node(size, c);
        }

        graph[0].edges[1] = 5;
        graph[0].edges[2] = 3;
        graph[1].edges[2] = 2;
        graph[1].edges[4] = 3;
        graph[1].edges[6] = 1;
        graph[2].edges[3] = 7;
        graph[2].edges[4] = 7;
        graph[3].edges[0] = 2;
        graph[3].edges[5] = 6;
        graph[4].edges[3] = 2;
        graph[4].edges[5] = 1;
        graph[6].edges[4] = 1;

        // Start the traversal with A (graph[0])
        dijkstra(graph, graph[0]);

        System.out.println();
        for(Node n : graph)
        {
            System.out.println(n.key + ": " + n.prev);
        }
    }

    /**
     * Dijkstra's algorithm
     * @param g the graph to traverse
     * @param s the starting node
     */
    public static void dijkstra(Node[] g, Node s) {
        for (Node n : g) {
            n.cost = 9999;
            n.known = false;
        }

        s.cost = 0;

        while (!allKnown(g)) {
            Node b = leastCostNode(g);
            b.known = true;

            System.out.print(b.key + "-" + b.cost);

            if (!allKnown(g)) System.out.print(", ");


            int i = 0;

            for (int e : b.edges) {
                Node a = g[i];

                if (!a.known && b.edges[i] != 0) {
                    if (b.cost + e < a.cost) {
                        a.cost = b.cost + e;
                        a.prev = b.key;
                    }
                }

                i++;
            }
        }
    }

    /**
     * @param g the graph to check.
     * @return true once all vertices are visited, false otherwise.
     */
    private static boolean allKnown(Node[] g) {
        for (Node n : g) {
            if (!n.known) {
                return false;
            }
        }

        return true;
    }

    /**
     * @param g the graph to check
     * @return the Node with the lowest cost.
     */
    private static Node leastCostNode(Node[] g) {
        int i = 0;
        int min = 9999;

        for (int j = 0; j < g.length; j++) {
            if (g[j].cost < min && !g[j].known) {
                i = j;
                min = g[j].cost;
            }
        }

        return g[i];
    }
}
