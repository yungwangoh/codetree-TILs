import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static final int MAX = 100000;
    static int[] arr = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];

            if(sum < 0) {
                sum = 0;
                continue;
            }

            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}