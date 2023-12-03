import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 50;
    static final int INT = Integer.MIN_VALUE;
    static int n, m;
    static int[][] arr = new int[MAX + 1][MAX + 1];
    static int[][] dp = new int[MAX + 1][MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        func();
        //print();
        System.out.println(max());
    }
    static void print() {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static int max() {

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }
    static void init() {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) dp[i][j] = INT;
        }

        dp[0][0] = 1;
    }
    static void func() {

        init();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                func2(i, j);
            }
        }
    }
    static void func2(int x, int y) {

        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {

                if(arr[x][y] > arr[i][j]) {
                    dp[x][y] = Math.max(dp[x][y], dp[i][j] + 1);
                }
            }
        }
    }
}