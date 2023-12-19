import java.io.*;
import java.util.*;

public class Main {
    
    static int n;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int nn = paramesticSearch(n);

        System.out.println(nn);
    }
    static int paramesticSearch(int n) {
    
        int left = 1;
        int right = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        while(left <= right) {
            int mid = (left + right) / 2;

            if(isPossible(mid) >= n) {
                right = mid - 1;
                min = Math.min(min, mid);
            } else {
                left = mid + 1;
            }
        }

        return min;
    }
    static int isPossible(int mid) {

        int sum = mid / 3 + mid / 5 - mid / 15;

        return mid - sum;
    }
}