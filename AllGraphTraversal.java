import java.util.*;

public class AllGraphTraversal {
    static int V = 6;

    static Map<Integer, List<Integer>> undirectedAdjList() {
        int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 4 }, { 2, 5 }, { 3, 5 }, { 4, 6 }, { 5, 6 } };
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 1; i < edges.length; i++) {
            adj.put(i, new ArrayList<Integer>());
        }
        for (int[] i : edges) {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        return adj;
    }

    static Map<Integer, List<Integer>> directedAdjList() {
        int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 4 }, { 2, 5 }, { 3, 5 }, { 4, 6 }, { 5, 6 }, { 6, 1 } };
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 1; i < edges.length; i++) {
            adj.put(i, new ArrayList<Integer>());
        }
        for (int[] i : edges) {
            adj.get(i[0]).add(i[1]);
        }
        return adj;
    }

    public static void main(String[] args) {

        // System.out.println("UnDirected Adjacency List: ");
        // undirectedAdjList().forEach((k,v) -> System.out.println(k + " : " + v));

        System.out.println("Directed Adjacency List: ");
        directedAdjList().forEach((k, v) -> System.out.println(k + " : " + v));

    }
}