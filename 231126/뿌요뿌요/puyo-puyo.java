import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 100;
    static int n, count = 0;
    static int[][] arr = new int[MAX + 1][MAX + 1];
    static boolean[][] visit = new boolean[MAX + 1][MAX + 1];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 1; i <= 100; i++) {
            int tmp = bomb(i);
            if(tmp != -1) {
                sum += tmp;
            }
            max = Math.max(max, count);
        }
        System.out.println(sum + " " + max);

    }
    static int bomb(int k) {

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visit[i][j]) continue;

                if(arr[i][j] == k) {
                    count = 1;
                    dfs(i, j, k);
                    cnt++;
                }
            }
        }

        if(count >= 4) {
            return cnt;
        } else {
            return -1;
        }
    }
    static void dfs(int x, int y, int k) {

        visit[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isRange(nx, ny) || visit[nx][ny]) continue;

            if(arr[nx][ny] == k) {
                dfs(nx, ny, k);
                count++;
            }
        }
    }
    static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}