import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static final int MAX = 1000;
    static int[][] arr = new int[MAX + 1][MAX + 1];
    static int[][] prefix = new int[MAX + 1][MAX + 1];
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
        for(int k = 1; k <= n; k++) {
            for(int l = 1; l <= n; l++) {
                for(int i = 1; i <= n - k + 1; i++) {
                    for(int j = 1; j <= n - l + 1; j++) {
                        max = Math.max(max, getSum(i, j, i + k - 1, j + l - 1));
                    }
                }
            }
        }

        System.out.println(max);
    }
    static int getSum(int x1, int y1, int x2, int y2) {
        return prefix[x2][y2]     - prefix[x1 - 1][y2] -
               prefix[x2][y1 - 1] + prefix[x1 - 1][y1 - 1];
    }
}