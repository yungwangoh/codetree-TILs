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

        Arrays.sort(arr, 0, n);

        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int up = lowerBound(x);
            int down = customLowerBound(y);

            //System.out.println(up + " " + down);

            if((up >= 0 && up < n) && (down >= 0 && down < n)) {
                System.out.println(down - up + 1);
            } else {
                System.out.println(0);
            }
        }
    }
    static int lowerBound(int num) {

        int left = 0;
        int right = n - 1;
        int min = n;
        while(left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] >= num) {
                right = mid - 1;
                min = Math.min(min, mid);
            } else {
                left = mid + 1;
            }
        }

        return min;
    }
    static int customLowerBound(int num) {

        int left = 0;
        int right = n - 1;
        int max = -1;
        while(left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] <= num) {
                left = mid + 1;
                max = Math.max(max, mid);
            } else {
                right = mid - 1;
            }
        }

        return max;
    }
}