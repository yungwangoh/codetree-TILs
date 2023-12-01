import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 1000;
    static int[] dp = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(func(n));
    }
    static int func(int n) {
        
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++)
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;

        return dp[n];
    }
}