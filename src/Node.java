/**
 * Created by Chau Ngo.
 */
public class Node {
    int cost;
    char key;
    boolean known;
    int[] edges;
    char prev;

    public Node(int size, char key) {
        this.cost = 9999;
        this.key = key;
        this.known = false;
        this.edges = new int[size];
        this.prev = '*';
    }
}
