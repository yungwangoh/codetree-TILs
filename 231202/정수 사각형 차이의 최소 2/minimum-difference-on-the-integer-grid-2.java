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

        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= MAX; i++) {
            int upperBound = func(i, n);

            if(upperBound == Integer.MAX_VALUE) continue;

            min = Math.min(min, upperBound - i);
        }

        System.out.println(min);
    }
    static void init(int n) {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dp[0][0] = arr[0][0];

        for(int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], arr[0][i]);
        } 

        for(int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], arr[i][0]);
        }
    }
    static int func(int lowerBound, int n) {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] < lowerBound) arr[i][j] = Integer.MAX_VALUE;
            }
        }

        init(n);

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = Math.max(Math.min(dp[i - 1][j], dp[i][j - 1]), arr[i][j]);
            }
        }

        return dp[n - 1][n - 1];
    }
}