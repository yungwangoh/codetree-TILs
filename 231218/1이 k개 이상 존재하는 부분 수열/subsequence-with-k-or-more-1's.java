import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static final int MAX = 1000000;
    static int number = 0;
    static int[] arr = new int[MAX + 1];
    static int[] count = new int[3];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int j = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {

            while(j + 1 <= n && number != k) {
                int key = arr[j + 1];

                if(key == 1) number++;

                j++;
            }

            if(number == k) min = Math.min(min, j - i + 1);

            if(arr[i] == 1) number--; 
        }

        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }
}