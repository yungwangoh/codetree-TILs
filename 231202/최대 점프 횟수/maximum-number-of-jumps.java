import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 1000;
    static final int INT_MIN = Integer.MIN_VALUE;
    static int[] arr = new int[MAX + 1];
    static int[] dp = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(func(n));
        //print(n);
    }
    static void print(int n) {
        for(int i = 0; i < n; i++) System.out.print(dp[i] + " ");
        System.out.println();
    }
    static int func(int n) {

        init(n);

        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] == INT_MIN) continue;

                if(j + arr[j] >= i) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1];
    }
    static void init(int n) {
        for(int i = 0; i < n; i++) dp[i] = INT_MIN;
    }
}