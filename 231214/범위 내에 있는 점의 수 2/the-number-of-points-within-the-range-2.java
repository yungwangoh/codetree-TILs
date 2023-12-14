import java.io.*;
import java.util.*;

public class Main {

    static int n, q;
    static final int MAX_N = 100000;
    static final int MAX_Q = 1000000;
    static int[] arr = new int[MAX_N + 1];
    static int[] prefix = new int[MAX_Q + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        q = sc.nextInt();

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            prefix[arr[i]]++;
        }

        for(int i = 1; i <= MAX_Q; i++) {
            prefix[i] += prefix[i - 1];
        }

        for(int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            System.out.println(sum(x, y));
        }
    }
    static int sum(int s, int e) {
        if(s == 0) return prefix[e];
        return prefix[e] - prefix[s];
    }
}