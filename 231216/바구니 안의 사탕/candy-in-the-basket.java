import java.io.*;
import java.util.*;

class Candy implements Comparable<Candy> {

    int x, cnt;

    public Candy(int x, int cnt) {
        this.x = x;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Candy c) {
        return this.x - c.x;
    }
}
public class Main {

    static final int MAX_N = 1000000;
    static Candy[] candies = new Candy[MAX_N + 1];
    static int n, k;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            int cnt = sc.nextInt();
            int x = sc.nextInt();

            candies[i] = new Candy(x, cnt);
        }

        Arrays.sort(candies, 1, n + 1);

        int ans = 0;

        int totalNums = 0;
        int j = 0;
        for(int i = 1; i <= n; i++) {

            while(j + 1 <= n && getPosOfCandy(j + 1) - getPosOfCandy(i) <= 2 * k) {
                totalNums += getNumOfCandy(j + 1);
                j++;
            }

            ans = Math.max(ans, totalNums);

            totalNums -= getNumOfCandy(i);
        }

        System.out.println(ans);
    }
    static int getPosOfCandy(int candyIdx) {
        return candies[candyIdx].x;
    }
    static int getNumOfCandy(int candyIdx) {
        return candies[candyIdx].cnt;
    }
}