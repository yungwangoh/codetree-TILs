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
        if((x + y) == (p.x + p.y)) return x - p.x;
        return (x + y) - (p.x + p.y);
    }
}
public class Main {

    static int n, m;
    static Queue<Pair> q = new PriorityQueue<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            q.add(new Pair(x, y));
        }

        for(int i = 0; i < m; i++) {
            Pair p = q.poll();

            Pair np = new Pair(p.x + 2, p.y + 2);

            q.add(np);
        }

        Pair p = q.peek();
        System.out.println(p.x + " " + p.y);
    }
}