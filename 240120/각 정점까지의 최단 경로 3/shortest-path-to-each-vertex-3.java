import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static final int MAX_N = 100;
    static int[][] arr = new int[MAX_N + 1][MAX_N + 1];
    static boolean[] visit = new boolean[MAX_N + 1];
    static int[] dist = new int[MAX_N + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int w = sc.nextInt();

            arr[s][e] = w;
        }

        for(int i = 1; i <= n; i++) {
            dist[i] = (int)1e9;
        }

        dist[1] = 0;

        for(int i = 1; i <= n; i++) {
            
            int minIndex = -1;
            for(int j = 1; j <= n; j++) {
                if(visit[j]) continue;

                if(minIndex == -1 || dist[minIndex] > dist[j]) 
                    minIndex = j;
            }

            visit[minIndex] = true;

            for(int j = 1; j <= n; j++) {

                if(arr[minIndex][j] == 0) continue;

                dist[j] = Math.min(dist[j], dist[minIndex] + arr[minIndex][j]);
            }
        }

        for(int i = 2; i <= n; i++) {

            if(dist[i] == (int)1e9) System.out.println(-1);
            else System.out.println(dist[i]);
        }
    }
}