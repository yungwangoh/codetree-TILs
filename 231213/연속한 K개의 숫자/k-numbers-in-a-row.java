import java.io.*;
import java.util.*;

public class Main {

    static int n, k, b;
    static final int MAX = 100000;
    static int[] arr = new int[MAX + 1];
    static int[] prefix = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        b = sc.nextInt();

        for(int i = 0; i < b; i++) {
            int num = sc.nextInt();

            arr[num] = 1;
        }  

        for(int i = 1; i <= n; i++) prefix[i] = prefix[i - 1] + arr[i];

        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n - k + 1; i++) {
            min = Math.min(min, prefix[i + k - 1] - prefix[i - 1]);
        }

        System.out.println(min);
    }
}