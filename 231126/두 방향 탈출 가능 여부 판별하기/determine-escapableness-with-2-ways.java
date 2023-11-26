import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 100;
    static int n, m, check = 0;
    static int[][] arr = new int[MAX + 1][MAX + 1];
    static boolean[][] visit = new boolean[MAX + 1][MAX + 1];
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0);

        if(visit[n - 1][m - 1]) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static void dfs(int x, int y) {

        for(int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isRange(nx, ny) || arr[nx][ny] == 0) continue;

            visit[nx][ny] = true;
            dfs(nx, ny);
        }
    }
    static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= m;
    }
}