import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static final int MAX = 200000;
    static final int MAX_NUM = 1000000000;
    static int[] arr = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        } 

        Arrays.sort(arr, 0, n);

        int nn = paramesticSearch();

        System.out.println(nn);
    }
    static boolean isPossible(int dist) {

        int cnt = 1;
        int lastIdx = 0;
        for(int i = 1; i < n; i++) {

            if(arr[i] - arr[lastIdx] >= dist) {
                cnt++;
                lastIdx = i;
            }
        }

        return cnt >= m;
    }
    static int paramesticSearch() {

        int left = 1;
        int right = MAX_NUM;
        int ans = 0;
        while(left <= right) {

            int mid = (left + right) / 2;

            if(isPossible(mid)) {
                left = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}