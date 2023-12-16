import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static final int MAX_C = 1000000;
    static int[] arr = new int[MAX_C + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int candy = sc.nextInt();
            int loc = sc.nextInt();

            arr[loc] = candy;
        }

        int j = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= MAX_C; i++) {

            while(j + 1 <= 2 * k + i) {
                sum += arr[j + 1];
                j++;
            }

            if(j >= MAX_C) break;

            max = Math.max(max, sum);

            sum -= arr[i];
        }

        System.out.println(max);
    }
}