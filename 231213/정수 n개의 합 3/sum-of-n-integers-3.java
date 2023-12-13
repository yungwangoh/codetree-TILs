import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static final int MAX = 500;
    static int[][] arr = new int[MAX + 1][MAX + 1];
    static int[][] prefix = new int[MAX + 1][MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                prefix[i][j] = prefix[i][j - 1] + prefix[i - 1][j] - prefix[i - 1][j - 1] + arr[i][j];
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n - k + 1; i++) {
            for(int j = 1; j <= n - k + 1; j++) {
                max = Math.max(max, prefix[i + k - 1][j + k - 1] - prefix[i - 1][j + k - 1] -
                                    prefix[i + k - 1][j - 1] + prefix[i - 1][j - 1]);
            }
        }

        System.out.println(max);
    }
}