import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static final int MAX = 100;
    static int[][] arr = new int[MAX + 1][MAX + 1];
    static int[][] dist = new int[MAX + 1][MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                dist[i][j] = (int)1e9;
            }
            dist[i][i] = 0;
        }

        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            dist[x][y] = Math.min(dist[x][y] , z);
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(dist[i][j] == (int)1e9) System.out.print(-1 + " ");
                else System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}