import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int x1, x2;

    public Pair(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public int compareTo(Pair p) {
        if(x1 == p.x1) return x2 - p.x2;
        return x1 - p.x1;
    }
}
public class Main {

    static int n;
    static final int MAX = 1000;
    static final int INT = Integer.MIN_VALUE;
    static Pair[] arr = new Pair[MAX + 1];
    static int[] dp = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();

            arr[i] = new Pair(x1, x2);
        }

        Arrays.sort(arr, 0, n);

        // for(int i = 0; i < n; i++) 
        //     System.out.println(arr[i].x1 + " " + arr[i].x2);

        func();
        System.out.println(max());
    }
    static void init() {
        for(int i = 0; i <= n; i++) dp[i] = INT;

        dp[0] = 1;
    }
    static void func() {

        init();

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] == INT) continue;

                if(isRange(arr[j].x1, arr[j].x2, arr[i].x1, arr[i].x2)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
    }
    static int max() {

        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= n; i++) max = Math.max(max, dp[i]);
        return max;
    }
    static boolean isRange(int x1, int x2, int nx1, int nx2) {
        return (x2 < nx1) || (nx2 < x1);
    }
}