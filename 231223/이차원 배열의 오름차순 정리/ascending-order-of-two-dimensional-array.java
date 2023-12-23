import java.io.*;
import java.util.*;

public class Main {

    static long n, k;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextLong();
        k = sc.nextLong();

        long lo = 1;
        long hi = n * n;
        long ans = n * n;

        while(lo <= hi) {
            long mid = (lo + hi) / 2;

            long val = 0;
            for(int i = 1; i <= n; i++) {
                val += Math.min(n, mid / i);
            }

            if(val >= k) {
                hi = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(ans);
    }
}