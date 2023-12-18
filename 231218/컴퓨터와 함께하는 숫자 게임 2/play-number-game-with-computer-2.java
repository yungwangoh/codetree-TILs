import java.io.*;
import java.util.*;

public class Main {

    static long m, a, b;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        m = sc.nextLong();
        a = sc.nextLong();
        b = sc.nextLong();


        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for(long i = a; i <= b; i++) {
            long nn = binarySearch(i);

            min = Math.min(min, nn);
            max = Math.max(max, nn);
        }

        System.out.println((min + 1) + " " + (max + 1));
    }
    static long binarySearch(long num) {

        long left = 1;
        long right = m;

        int cnt = 0;
        while(left <= right) {
            long mid = (left + right) / 2;

            if(mid == num) return cnt;

            if(mid > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            cnt++;
        }

        return cnt;
    }
}