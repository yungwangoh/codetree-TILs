import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static final int MAX = 1000;
    static int[][] arr = new int[MAX + 1][MAX + 1];
    static int[][] prefix = new int[MAX + 1][MAX + 1];
    static int[] dp = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + arr[i][j];
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            for(int j = i; j <= n; j++) {
                max = Math.max(max, getMaxArea(i, j));
            }
        }

        System.out.println(max);
    }
    static int getMaxArea(int x1, int x2) {

        for(int y = 1; y <= n; y++) {
            int value = getSum(x1, y, x2, y);

            dp[y] = Math.max(value, dp[y - 1] + value);
        }

        int maxArea = Integer.MIN_VALUE;
        for(int y = 1; y <= n; y++) maxArea = Math.max(maxArea, dp[y]);

        return maxArea;
    }
    static int getSum(int x1, int y1, int x2, int y2) {
        return prefix[x2][y2]     - prefix[x1 - 1][y2] -
               prefix[x2][y1 - 1] + prefix[x1 - 1][y1 - 1];
    }
}