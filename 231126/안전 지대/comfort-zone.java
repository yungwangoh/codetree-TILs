import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 50;
    static int n, m;
    static int[][] arr = new int[MAX + 1][MAX + 1];
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
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

        int start = 1;
        int safe = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        while(start <= 100) {
            visit = new boolean[MAX + 1][MAX + 1];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(arr[i][j] <= start) {
                        visit[i][j] = true;
                    }
                }
            }
            
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(visit[i][j]) continue;

                    dfs(i, j);
                    cnt++;
                }
            }

            //System.out.println(cnt);

            if(max < cnt) {
                max = cnt;
                safe = start;
            }

            start++;
        }

        System.out.println(max + " " + safe);
    }
    static void dfs(int x, int y) {

        visit[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isRange(nx, ny) || visit[nx][ny]) continue;

            dfs(nx, ny);
        }
    }
    static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= m;
    }
}