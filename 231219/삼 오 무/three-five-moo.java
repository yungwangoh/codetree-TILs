import java.io.*;
import java.util.*;

public class Main {
    
    static int n;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        long nn = paramesticSearch(n);

        bw.write(String.valueOf(nn));

        bw.flush();
        bw.close();
    }
    static long paramesticSearch(long n) {
    
        long left = 0L;
        long right = Long.MAX_VALUE;
        long min = Long.MAX_VALUE;
        while(left <= right) {
            long mid = (left + right) / 2;

            if(isPossible(mid) >= n) {
                right = mid - 1;
                min = Math.min(min, mid);
            } else {
                left = mid + 1;
            }
        }

        return min;
    }
    static long isPossible(long mid) {

        long sum = mid / 3 + mid / 5 - mid / 15;

        return mid - sum;
    }
}