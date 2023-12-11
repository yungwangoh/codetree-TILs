import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] arr;
    static Queue<Integer> q = new PriorityQueue<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n];

        int sum = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        q.add(arr[n - 1]);
        sum += arr[n - 1];

        int k = n - 2;
        double max = 0;
        for(int i = k; i >= 1; i--) {
            
            q.add(arr[i]);
            sum += arr[i];

            double avg = (double) (sum - q.peek()) / (n - i - 1);

            max = Math.max(max, avg);
        }

        System.out.printf("%.2f", max);
    }
}