import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 45;
    static int[] memo = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 0; i <= MAX; i++) {
            memo[i] = -1;
        }

        System.out.println(fibo(n));
    }
    static int fibo(int n) {

        if(memo[n] != -1) {
            return memo[n];
        }
        if(n <= 2) memo[n] = 1;
        else memo[n] = fibo(n - 1) + fibo(n - 2);

        return memo[n];
    }
}