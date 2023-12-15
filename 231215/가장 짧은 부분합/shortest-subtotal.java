import java.io.*;
import java.util.*;

public class Main {

    static int n, s;
    static final int MAX = 100000;
    static int[] arr = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        s = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int j = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {

            while(j + 1 <= n && sum < s) {
                sum += arr[j + 1];
                j++;
            }

            if(sum >= s) 
                ans = Math.min(ans, j - i + 1);

            sum -= arr[i];
        }

        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
}