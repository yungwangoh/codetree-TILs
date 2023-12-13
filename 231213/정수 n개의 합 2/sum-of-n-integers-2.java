import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static final int MAX = 100000;
    static int[] arr = new int[MAX + 1];
    static int[] prefix = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n - k; i++) {
            max = Math.max(max, prefix[k + i - 1] - prefix[i] + arr[i]);
        }

        System.out.println(max);
    }
}