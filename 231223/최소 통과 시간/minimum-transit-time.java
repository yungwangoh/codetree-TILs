import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static final int MAX = 100000;
    static final int MAX_NUM = 2000000000;
    static int[] arr = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, 0, m);

        long nn = paramesticSearch();

        System.out.println(nn);
    }
    static long paramesticSearch() {

        long left = 1;
        long right = MAX_NUM;
        long ans = Long.MAX_VALUE;
        while(left <= right) {

            long mid = (left + right) / 2;

            if(isPossible(mid)) {
                right = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                left = mid + 1;
            }  
        }

        return ans;
    }
    static boolean isPossible(long dist) {

        int cnt = 0;
        for(int i = 0; i < m; i++) {
            cnt += (dist / arr[i]);
        }

        return cnt >= n;
    }
}