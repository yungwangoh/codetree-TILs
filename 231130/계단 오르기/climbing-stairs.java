import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 1000;
    static int[] memo = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 0; i <= n; i++) memo[i] = -1;

        System.out.println(dp(n) % 10007);
    }
    static int dp(int n) {
        if(memo[n] != -1) {
            return memo[n];
        }
        if(n == 0) memo[n] = 0;
        else if(n == 1) memo[n] = 0;
        else if(n == 2) memo[n] = 1;
        else if(n == 3) memo[n] = 1;
        else memo[n] = dp(n - 2) + dp(n - 3);

        return memo[n];
    }
}