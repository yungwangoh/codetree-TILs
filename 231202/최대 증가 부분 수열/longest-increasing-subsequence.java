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

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        func(n);
        System.out.println(init());
        //print(n);
    }
    static void print(int n) {

        for(int i = 0; i < n; i++) System.out.print(dp[i] + " ");
        System.out.println();
    }
    static int init(int n) {
        int max = 0;
        for(int i = 0; i < n; i++) max = Math.max(max, dp[i]);

        return max;
    }
    static int func(int n) {

        dp[0] = 1;

        int max = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                
                if(arr[i] > arr[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
                dp[i] = max;
            }
        }

        return dp[n - 1];
    }
}