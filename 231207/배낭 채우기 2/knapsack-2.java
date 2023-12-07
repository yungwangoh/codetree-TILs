import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static final int MAX_N = 100;
    static final int MAX_M = 10000;
    static final int INT = Integer.MIN_VALUE;
    static int[] w = new int[MAX_N + 1];
    static int[] v = new int[MAX_N + 1];
    static int[] dp = new int[MAX_M + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        func();
        System.out.println(max());
    }
    static void print() {

        for(int i = 0; i <= m; i++) System.out.print(dp[i] + " ");
        System.out.println();
    }
    static int max() {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= m; i++) max = Math.max(max, dp[i]);
        return max;
    }
    static void init() {
        for(int i = 0; i <= m; i++) {
            dp[i] = INT;
        }

        dp[0] = 0;
    }
    static void func() {

        init();

        for(int i = 0; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(i >= w[j]) {
                    if(dp[i - w[j]] == INT) continue;

                    dp[i] = Math.max(dp[i], dp[i - w[j]] + v[j]);
                }
            }
        }
    }
}