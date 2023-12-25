import java.io.*;
import java.util.*;

public class Main {

    static int n, t;
    static final int MAX = 10000;
    static int[] arr = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        t = sc.nextInt();

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int nn = paramesticSearch();

        System.out.println(nn);
    }
    static int paramesticSearch() {

        int left = 1;
        int right = n;
        int ans = n;

        while(left <= right) {

            int mid = (left + right) / 2;

            if(isPossible(mid)) {
                right = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
    static boolean  isPossible(int k) {

        Queue<Integer> q = new PriorityQueue<>();

        for(int i = 0; i < k; i++) {
            q.add(arr[i]);
        }

        for(int i = k; i < n; i++) {
            int cTime = q.poll();

            q.add(cTime + arr[i]);
        }

        int eTime = 0;
        while(!q.isEmpty()) {
            eTime = Math.max(eTime, q.poll());
        }

        return eTime <= t;
    }
}