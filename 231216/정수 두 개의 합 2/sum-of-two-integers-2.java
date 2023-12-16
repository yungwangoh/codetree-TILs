import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static final int MAX = 100000;
    static int[] arr = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 1; i <= n; i++) arr[i] = sc.nextInt();


        Arrays.sort(arr, 1, n + 1);

        int j = n;
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            
            while(arr[i] + arr[j] > k) {
                j--;
            }

            if(j <= i) break;

            ans += j - i;
        }

        System.out.println(ans);
    }
}