import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static final int MAX_N = 100;
    static final int MAX_M = 10000;
    static final int INT = Integer.MAX_VALUE;
    static int[] arr = new int[MAX_N + 1];
    static int[] dp = new int[MAX_M + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++) arr[i] = sc.nextInt();

        System.out.println(func());
        //print();
    }
    static void print() {
        for(int i = 0; i <= m; i++) System.out.print(dp[i] + " ");
        System.out.println();
    }
    static void init() {

        for(int i = 0; i <= m; i++) dp[i] = INT;
        dp[0] = 0;
    }
    static int func() {

        init();

        for(int i = 1; i <= n; i++) {
            for(int j = m; j >= 0; j--) {
                if(j >= arr[i]) {
                    if(dp[j - arr[i]] == INT) continue;

                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
                }
            }
        }

        if(dp[m] == INT) return -1;
        else return dp[m];
    }
}