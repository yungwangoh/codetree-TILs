import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static final int MAX_N = 100;
    static final int MAX_M = 100000;
    static int[] arr = new int[MAX_N + 1];
    static boolean[][] dp = new boolean[MAX_N + 1][MAX_M + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 1; i <= n; i++) arr[i] = sc.nextInt();

        for(int i = 1; i <= n; i++) m += arr[i];

        if(func()) System.out.println("No");
        else System.out.println("Yes");
        //print();
    }
    static void init() {
        dp[0][0] = true;
    }
    static void print() {

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(dp[i][j]) System.out.print(1 + " ");
                else System.out.print(0 + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static boolean func() {

        init();

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(j >= arr[i] && dp[i - 1][j - arr[i]]) dp[i][j] = true;
                if(dp[i - 1][j]) dp[i][j] = true;
            }
        }

        boolean flag = false;
        for(int j = 0; j <= m; j++) {
            if(!dp[n][j]) flag = true;
        }

        return flag;
    }
}