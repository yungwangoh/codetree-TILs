import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static final int MAX = 100000;
    static int[] memo = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int ans = MAX;
        for(int i = 0; i <= MAX; i++) {
            int cnt = n - 5 * i;
            if(cnt >= 0 && cnt % 2 == 0) {
                ans = Math.min(ans, i + (cnt / 2));
            }
        }

        if(ans == MAX) ans = -1;

        System.out.println(ans);
    }
}