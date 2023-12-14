import java.io.*;
import java.util.*;

public class Main {

    static int n, q;
    static final int MAX_N = 100000;
    static final int MAX_Q = 1000000;
    static int[] arr = new int[MAX_N + 1];
    static int[] prefix = new int[MAX_Q + 2];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        q = sc.nextInt();

        int max = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        for(int i = 0; i < n; i++) {
            prefix[arr[i] + 1] = 1;
        }

        for(int i = 2; i <= MAX_Q + 1; i++) {
            prefix[i] += prefix[i - 1];
        }

        for(int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int sum = prefix[y + 1] - prefix[x];

            if(sum < 0) sum = 0;
    
            System.out.println(sum);
        }
    }
}