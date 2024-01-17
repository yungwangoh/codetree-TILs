import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 1000;
    static int[][] dp = new int[MAX + 1][MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        int str1Len = s1.length();
        s1 = " " + s1;
        String s2 = sc.next();
        int str2Len = s2.length();
        s2 = " " + s2;

        if(s1.charAt(1) == s2.charAt(1)) dp[1][1] = 1;
        else dp[1][1] = 0;

        for(int i = 2; i <= str1Len; i++) {
            if(s1.charAt(i) == s2.charAt(1)) {
                dp[i][1] = 1;
            } else {
                dp[i][1] = dp[i - 1][1];
            }
        }

        for(int i = 2; i <= str2Len; i++) {
            if(s1.charAt(1) == s2.charAt(i)) {
                dp[1][i] = 1;
            } else {
                dp[1][i] = dp[1][i - 1];
            }
        }

        for(int i = 2; i <= str1Len; i++) {
            for(int j = 2; j <= str2Len; j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[str1Len][str2Len]);
    }
}