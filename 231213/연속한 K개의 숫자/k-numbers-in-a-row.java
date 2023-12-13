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

        for(int i = 0; i <= n; i++) arr[i] = 1;
        for(int i = 0; i < b; i++) {
            int num = sc.nextInt();

            arr[num] = 0;
        }  

        if(arr[1] == 0) prefix[1] = 0;
        else prefix[1] = 1;

        for(int i = 2; i <= n; i++) {

            if(arr[i] != 0) prefix[i] = prefix[i - 1] + 1;
            else prefix[i] = prefix[i - 1];
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            max = Math.max(max, prefix[i]);
        }

        if(max > k) System.out.println(0);
        else System.out.println(k - max);
    }
}