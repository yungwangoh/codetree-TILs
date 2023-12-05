import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static final int MAX = 1000;
    static final int INT = Integer.MIN_VALUE;
    static int[] arr = {1, 2, 5};
    static int[] dp = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        System.out.println(func());
        //print();
    }
    static void print() {

        for(int i = 0; i <= n; i++) System.out.print(dp[i] + " ");
        System.out.println();
    }
    static int func() {

        for(int i = 0; i <= n; i++) dp[i] = 0;
        dp[0] = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < 3; j++) {

                if(i >= arr[j]) {
                    if(dp[i - arr[j]] == INT) continue;

                    dp[i] = (dp[i] + dp[i - arr[j]]) % 10007;
                }
            }
        }

        return dp[n];
    }
}