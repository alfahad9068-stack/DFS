
package dfs.java;

import java.util.Scanner;

class DFS {
    int g[][], prev[], dis[], color[], n;

    DFS(int g[][], int n) {
        this.g = g;
        this.n = n;

        prev = new int[n];
        dis = new int[n];
        color = new int[n];

        for (int i = 0; i < n; i++) {
            dis[i] = Integer.MAX_VALUE;
            prev[i] = -1;
        }
    }

    void dfs(int u) {
        color[u] = 1;
        System.out.print(u + " ");

        for (int v = 0; v < n; v++) {
            if (g[u][v] == 1 && color[v] == 0) {
                prev[v] = u;
                dis[v] = dis[u] + 1;
                dfs(v);
            }
        }

        color[u] = 2;
    }

    void printPath(int s, int d) {
        if (s == d) {
            System.out.print(s);
            return;
        }

        if (prev[d] == -1) {
            System.out.print("No path exists");
            return;
        }

        printPath(s, prev[d]);
        System.out.print("->" + d);
    }
}

public class DFSJava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the num of vertices: ");
        int n = sc.nextInt();

        int g[][] = new int[n][n];

        System.out.println("Enter the graph:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = sc.nextInt();
            }
        }

        DFS d = new DFS(g, n);


        d.dis[0] = 0;
        d.dfs(0);

        System.out.println();

        System.out.print("Enter destination vertex: ");
        int dest = sc.nextInt();

        if (dest >= 0 && dest < n && d.color[dest] != 0) {
            d.printPath(0, dest);
        } else {
            System.out.print("Invalid destination or no path exists");
        }

        System.out.println();
        sc.close();
    }
}
