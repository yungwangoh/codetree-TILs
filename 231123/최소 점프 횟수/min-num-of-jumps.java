import java.io.*;
import java.util.*;

public class Main {

    static final int MX = 10;
    static int n, min = Integer.MAX_VALUE;
    static int[] arr = new int[MX];
    static boolean[] visit = new boolean[MX];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        func(0, 0);

        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }
    static void func(int idx, int cnt) {

        if(idx >= n - 1) {
            min = Math.min(min, cnt);
            return;
        }

        for(int i = 1; i <= arr[idx]; i++) {
            func(idx + i, cnt + 1);
        }
    }   
}