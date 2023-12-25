import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static final int MAX = 400;
    static int[][] arr = new int[MAX + 1][MAX + 1];
    static int[][] arr2 = new int[MAX + 1][MAX + 1];
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
                
                arr2[i + j - 1][n - i + j] = arr[i][j];
            }
        }

        for(int i = 1; i <= 2 * n; i++) {
            for(int j = 1; j <= 2 * n; j++) {
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + arr2[i][j];
            }
        }

        int k2 = Math.min(2 * k + 1, 2 * n);
        int ans = 0;
        for(int i = k2; i <= 2 * n; i++)
            for(int j = k2; j <= 2 * n; j++) {
            ans = Math.max(ans, prefix[i][j] - prefix[i][j - k2] - prefix[i - k2][j] + prefix[i - k2][j - k2]);
        }

        System.out.println(ans);
    }
}