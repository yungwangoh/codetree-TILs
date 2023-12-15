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

        for(int i = 1; i <= n; i++) arr[i] = sc.nextInt();

        int j = 0;
        int cnt = 0;
        int sum = 0;
        for(int i = 1; i <= n; i++) {

            while(j + 1 <= n && sum < m) {
                sum += arr[j + 1];
                j++;
            }

            if(sum == m) cnt++;

            sum -= arr[i];
        }

        System.out.println(cnt);
    }
}