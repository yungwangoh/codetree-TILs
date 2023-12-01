import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 100;
    static int[][] arr = new int[MAX + 1][MAX + 1];
    static int[][] dp = new int[MAX + 1][MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(func(n));
        //print(n);
    }
    static void print(int n) {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static void init(int n) {

        dp[0][0] = arr[0][0];

        for(int i = 1; i < n; i++) {
            dp[i][0] += (arr[i][0] + dp[i - 1][0]);
        }

        for(int i = 1; i < n; i++) {
            dp[0][i] += (arr[0][i] + dp[0][i - 1]);
        }
    }
    static int func(int n) {

        init(n);

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j] + arr[i][j], dp[i][j - 1] + arr[i][j]);
            }
        }

        return dp[n - 1][n - 1];
    }
}