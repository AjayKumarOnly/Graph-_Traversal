import java.util.*;

public class DistanceVector {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of routers: ");
        int n = sc.nextInt();

        int[][] cost = new int[n][n];

        System.out.println("Enter cost matrix:");
        System.out.println("Enter 999 for no direct connection.");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = cost[i][j];
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] =
                            dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        System.out.println("\nShortest Path Cost:");

        for (int i = 0; i < n; i++) {
            System.out.println("Router " + i + ":");

            for (int j = 0; j < n; j++) {
                System.out.println(
                    "To Router " + j +
                    " = " + dist[i][j]
                );
            }

            System.out.println();
        }

        sc.close();
    }
}
