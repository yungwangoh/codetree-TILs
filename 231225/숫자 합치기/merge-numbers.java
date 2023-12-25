import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static final int MAX = 100000;
    static int[] arr = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, 0 , n);

        int sum = 0;
        while(n != 1) {

            for(int i = 0; i < n; i+=2) {

                if(i == 0) {
                    arr[i] = arr[i] + arr[i + 1];
                } else {
                    arr[i - 1] = arr[i] + arr[i + 1];
                }
            }

            n /= 2;
            
            for(int i = 0; i < n; i++) {
                sum += arr[i];
            }

        }

        System.out.println(sum);
    }
}