import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static final int MAX = 100000;
    static int[] arr = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int nn = paramesticSearch();

        System.out.println(nn);
    }
    static int paramesticSearch() {

        int left = 1;
        int right = 1440;
        int min = 1440;
        while(left <= right) {
            int mid = (left + right) / 2;

            if(isPossible(mid)) {
                right = mid - 1;
                min = Math.min(min, mid);
            } else {
                left = mid + 1;
            }
        }

        return min;
    }
    static boolean isPossible(int mid) {

        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            
            if(arr[i] > mid) return false;

            sum += arr[i];

            if(sum > mid) {
                cnt++;
                sum = arr[i];
            }
        }

        return cnt < m;
    }
}