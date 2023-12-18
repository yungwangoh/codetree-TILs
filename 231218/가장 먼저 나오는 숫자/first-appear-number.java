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

        for(int i = 0; i < m; i++) {
            int num = sc.nextInt();

            int nn = lowerBound(num);
            
            System.out.println(nn);
        }
    }
    static int lowerBound(int num) {

        int left = 0;
        int right = n - 1;
        int min = n;

        boolean flag = false;
        while(left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] == num) flag = true;

            if(arr[mid] >= num) {
                right = mid - 1;
                min = Math.min(min, mid);
            } else {
                left = mid + 1;
            }
        }

        if(flag) {
            return min + 1;
        } else return -1;
    }
}