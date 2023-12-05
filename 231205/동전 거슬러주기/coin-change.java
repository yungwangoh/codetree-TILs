import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static final int MAX = 100;
    static final int INT = Integer.MAX_VALUE;
    static int[] arr = new int[MAX + 1];
    static int[] dp = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(func());
    }
    static void init() {

        for(int i = 0; i <= m; i++) {
            dp[i] = INT;
        }

        dp[0] = 0;
    }
    static int func() {

        init();

        for(int i = 1; i <= m; i++) {
            for(int j = 0; j < n; j++) {

                if(i >= arr[j]) {
                    if(dp[i - arr[j]] == INT) continue;

                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                }
            }
        }

        if(dp[m] == INT) return -1;
        else return dp[m];
    }
}