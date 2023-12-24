import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p) {
        if(x == p.x) return y - p.y;

        return x - p.x;
    }
}
public class Main {
    
    static int n;
    static final int MAX = 100000;
    static final int MAX_NUM = (int) 1e9;
    static Pair[] plist = new Pair[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            plist[i] = new Pair(x, y);
        }

        Arrays.sort(plist, 0, n);

        int nn = paramesticSearch();

        System.out.println(nn);
    }
    static int paramesticSearch() {

        int left = 1;
        int right = MAX_NUM;
        int max = 0;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(isPossible(mid)) {
                left = mid + 1;
                max = Math.max(max, mid);
            } else {
                right = mid - 1;
            }
        }

        return max;
    }
    static boolean isPossible(int dist) {

        int cnt = 0;
        int pos = plist[0].x;
        for(int i = 1; i < n; i++) {

            int s = plist[i].x;
            int e = plist[i].y;

            if(e < pos + dist) return false;

            pos = Math.max(pos + dist, s);
        }

        return true;
    }
}