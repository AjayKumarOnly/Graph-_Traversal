import java.util.*;

public class LinkState {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of routers: ");
        int n = sc.nextInt();

        int[][] cost = new int[n][n];

        System.out.println("Enter cost matrix:");

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cost[i][j] = sc.nextInt();

        System.out.print("Enter source router: ");
        int source = sc.nextInt();

        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, 999);
        dist[source] = 0;
        for (int count = 0; count < n; count++) {

            int u = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] &&
                    (u == -1 || dist[i] < dist[u])) {
                    u = i;
                }
            }

            visited[u] = true;

            // Update distances
            for (int v = 0; v < n; v++) {

                if (!visited[v] &&
                    dist[u] + cost[u][v] < dist[v]) {

                    dist[v] = dist[u] + cost[u][v];
                }
            }
        }

        System.out.println("\nLink State Routing Table:");

        for (int i = 0; i < n; i++) {
            System.out.println(
                "Router " + i +
                " = " + dist[i]
            );
        }

        sc.close();
    }
}
