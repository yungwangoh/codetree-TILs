import java.io.*;
import java.util.*;

public class Main {

    static int n, m, sum = 0;
    static final int MAX = 10000;
    static int[] arr = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int nn = paramesticSearch(sum);

        System.out.println(nn);
    }
    static int paramesticSearch(int s) {

        int left = 1;
        int right = s;
        int max = Integer.MIN_VALUE;

        while(left <= right) {

            int mid = (left + right) / 2;

            if(isPossible(mid)) {
                left = mid + 1;
                max = Math.max(max, mid);
            } else {
                right = mid - 1;
            }
        }   

        return max;
    }
    static boolean isPossible(int ms) {

        int patitionCnt = 0;
        for(int i = 0; i < n; i++) {

            patitionCnt += (int) (arr[i] / ms);
        }

        return patitionCnt >= m;
    }
}