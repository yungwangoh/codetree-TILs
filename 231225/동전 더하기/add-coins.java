import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static final int MAX = 10;
    static Integer[] arr;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        arr = new Integer[n];
        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();

            arr[i] = num;
        }

        int ans = 0;

        Arrays.sort(arr, Collections.reverseOrder());

        for(int i = 0; i < n; i++) {
            ans += (k / arr[i]);

            k %= arr[i];
        }

        System.out.println(ans);
    }
}