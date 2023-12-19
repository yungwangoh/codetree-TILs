import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static long s;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        s = sc.nextLong();

        long a = parametricSearch(s);

        System.out.println(a);
    }
    static long parametricSearch(long s) {

        long left = 1;
        long right = s;
        long max = 0;

        while(left <= right) {

            long mid = (left + right) / 2;

            if(mid * (mid + 1) / 2 <= s) {
                left = mid + 1;
                max = Math.max(max, mid);
            } else {
                right = mid - 1;
            }
        }

        return max;
    }
}