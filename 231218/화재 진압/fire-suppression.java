import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static final int MAX = 100000;
    static int[] arr = new int[MAX + 1];
    static int[] brr = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int j = 1; j <= m; j++) {
            brr[j] = sc.nextInt();
        }

        Arrays.sort(arr, 1, n + 1);
        Arrays.sort(brr, 1, m + 1);

        int j = 1;
        int max = 0;
        for(int i = 1; i <= n; i++) {

            while(j + 1 <= m && dist(i, j) > dist(i, j + 1)) {
                j++;
            }

            max = Math.max(max, dist(i ,j));

        }

        System.out.println(max);
    }
    static int dist(int i, int j) {
        return Math.abs(arr[i] - brr[j]);
    }
}