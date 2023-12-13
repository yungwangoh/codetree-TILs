import java.io.*;
import java.util.*;

class EnteringPerson implements Comparable<EnteringPerson> {
    int a, num, t;

    public EnteringPerson(int a, int num, int t) {
        this.a = a;
        this.num = num;
        this.t = t;
    }

    @Override
    public int compareTo(EnteringPerson ep) {
        if(a != ep.a) return a - ep.a;

        return num - ep.num;
    }
}
class WaitingPerson implements Comparable<WaitingPerson> {
    int num, a, t;

    public WaitingPerson(int num, int a, int t) {
        this.num = num;
        this.a = a;
        this.t = t;
    }

    @Override
    public int compareTo(WaitingPerson wp) {
        return num - wp.num;
    }
}
public class Main {

    static final int INT = Integer.MAX_VALUE;
    static final int MAX = 100000;

    static int n;
    static EnteringPerson[] p = new EnteringPerson[MAX + 1];
    static Queue<WaitingPerson> q = new PriorityQueue<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int ans = 0;

        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int t = sc.nextInt();

            p[i] = new EnteringPerson(a, i + 1, t);
        }

        p[n] = new EnteringPerson(INT, n + 1, 0);

        Arrays.sort(p, 0, n + 1);

        int exitTime = 0;
        for(int i = 0; i <= n; i++) {
            int a = p[i].a;
            int num = p[i].num;
            int t = p[i].t;

            while(a >= exitTime && !q.isEmpty()) {

                WaitingPerson nextWP = q.poll();
                int nextA = nextWP.a;
                int nextT = nextWP.t;

                ans = Math.max(ans, exitTime - nextA);

                exitTime += nextT;
            }

            if(a >= exitTime) exitTime = a + t;
            else q.add(new WaitingPerson(num, a, t));
        }

        System.out.println(ans);
    }
}