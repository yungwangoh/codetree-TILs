import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 500;
    static final int INIT = -1;
    static int[][] arr = new int[MAX + 1][MAX + 1];
    static int[][] dp = new int[MAX + 1][MAX + 1];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        init(n);

        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                
                max = Math.max(max, func(i, j, n));
            }
        }

        System.out.println(max);
    }
    static void print(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static void init(int n) {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = INIT;
            }
        }
    }
    static int func(int x, int y, int n) {

        if(dp[x][y] != -1) {
            return dp[x][y];
        }

        int max = 1;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(!isRange(nx, ny, n) && arr[nx][ny] > arr[x][y]) {
                max = Math.max(max, func(nx, ny, n) + 1);
            }
        }

        return dp[x][y] = max;
    }
    static boolean isRange(int x, int y, int n) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}