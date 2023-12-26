import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static final int MAX = 50000;
    static int[] brr = new int[MAX + 1];
    static int[] arr = new int[MAX + 1];
    static boolean[] check = new boolean[2 * MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            brr[i] = sc.nextInt();

            check[brr[i]] = true;
        }

        int c = 0;
        for(int i = 1; i <= 2 * n; i++) {
            if(!check[i]) arr[c++] = i;
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] > brr[i]) cnt++;
        }

        System.out.println(cnt);
    }
}