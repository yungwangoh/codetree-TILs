import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 100;
    static final int MAX_M = 10000;
    static int n;
    static int[] arr = new int[MAX + 1];
    static int[] dp = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(func());
    }
    static int func() {

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + arr[j]);
            }
        }

        return dp[n];
    }
}