import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static final int MAX_N = 100;
    static final int MAX_M = 10000;
    static final int INT = Integer.MIN_VALUE;
    static int[] v = new int[MAX_N + 1];
    static int[][] dp = new int[MAX_N + 1][MAX_M + 1];
    static int[] w = new int[MAX_N + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        System.out.println(func());
    }
    static void init() {
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                dp[i][j] = INT;
            }
        }
        dp[0][0] = 0;
    }
    static int func() {

        init();

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(j >= w[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }
}