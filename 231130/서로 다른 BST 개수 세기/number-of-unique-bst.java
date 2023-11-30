import java.io.*;
import java.util.*;

public class Main {

    static int[] dp = new int[20];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(func(n));
    }
    static int func(int n) {

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] += dp[i - j - 1] * dp[j];
            }
        }

        return dp[n];
    }
}