import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    long x, y;

    public Pair(long x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p) {
        if(x > p.x) return 1;
        if(x < p.x) return -1;
        if(y > p.y) return 1;

        return -1;
    }
}
public class Main {

    static int n, m;
    static final int MAX = 100000;
    static final long MAX_NUM = Long.MAX_VALUE;
    static Pair[] p = new Pair[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            p[i] = new Pair(x, y);
        }

        Arrays.sort(p, 0, m);

        long nn = paramesticSearch();

        System.out.println(nn);
    }
    static long paramesticSearch() {

        long left = 0;
        long right = MAX_NUM;
        long max = Long.MIN_VALUE;;
        while(left <= right) {

            long mid = (left + right) / 2;

            if(isPossible(mid)) {
                left = mid + 1;
                max = Math.max(max, mid);
            } else {
                right = mid - 1;
            }
        }

        return max;
    }
    static boolean isPossible(long num) {
        
        int cnt = 0;
        long pos = Long.MIN_VALUE;
        for(int i = 0; i < m; i++) {
            
            long s = p[i].x;
            long e = p[i].y;

            while(pos + num <= e) {
                cnt++;
                pos = Math.max(s, pos + num);
                
                if(cnt >= n) break;
            }
        }

        return cnt >= n;
    }
}