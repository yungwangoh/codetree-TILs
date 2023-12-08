import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static final int MAX = 100000;
    static final int INT = Integer.MIN_VALUE;
    static int[] arr = new int[MAX + 1];
    static int[] dp = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 1; i <= n; i++) arr[i] = sc.nextInt();

        System.out.println(func());
        //print();
    }
    static void print() {
        
        for(int i = 1; i <= n; i++) System.out.print(dp[i] + " ");
        System.out.println();
    }
    static void init() {
        for(int i = 1; i <= n; i++) dp[i] = INT;
        dp[1] = arr[1];
    }
    static int func() {

        init();

        for(int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }

        int max = INT;
        for(int i = 1; i <= n; i++) max = Math.max(max, dp[i]);

        return max;
    }
}