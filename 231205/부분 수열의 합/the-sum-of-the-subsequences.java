import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static final int MAX_N = 100;
    static final int MAX_M = 10000;
    static final int INT = Integer.MIN_VALUE;
    static int[] arr = new int[MAX_N + 1];
    static int[] dp = new int[MAX_M + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        if(func() != INT) System.out.println("Yes");
        else System.out.println("No");
    }
    static void init() {
        for(int i = 0; i <= m; i++) dp[i] = INT;

        dp[0] = 0;
    }
    static void print() {
        for(int i = 0; i <= m; i++) System.out.print(dp[i] + " ");
        System.out.println();
    }
    static int func() {

        init();

        for(int i = 0; i < n; i++) {
            for(int j = m; j >= 0; j--) {
                if(j >= arr[i]) {
                    if(dp[j - arr[i]] == INT) continue;

                    dp[j] = Math.max(dp[j], dp[j - arr[i]] + 1);
                }
            }
        }

        return dp[m];
    }
}