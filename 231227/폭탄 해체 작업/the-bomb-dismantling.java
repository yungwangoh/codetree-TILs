import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int score, limit;

    public Pair(int score, int limit) {
        this.score = score;
        this.limit = limit;
    }

    @Override
    public int compareTo(Pair p) {
        if(limit != p.limit) return limit - p.limit;

        return score - p.score;
    }
}
public class Main {

    static int n;
    static final int MAX = 10000;
    static Pair[] plist = new Pair[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int l = sc.nextInt();

            plist[i] = new Pair(s, l);
        }

        Arrays.sort(plist, 0, n);

        Queue<Integer> pq = new PriorityQueue<>();
        int idx = n - 1;
        int ans = 0;

        for(int t = MAX; t >= 1; t--) {

            while(idx >= 0 && getTimeLimit(idx) >= t) {
                pq.add(-getScore(idx));
                idx--;
            }

            if(!pq.isEmpty()) {
                ans += -pq.poll();
            }
        }

        System.out.println(ans);
    }
    static int getTimeLimit(int idx) {
        int limit = plist[idx].limit;

        return limit;
    }
    static int getScore(int idx) {
        int score = plist[idx].score;

        return score;
    }
}