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

    static int n, m;
    static final int MAX = 100000;
    static TreeSet<Pair> set = new TreeSet<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            set.add(new Pair(x, y));
        }

        for(int i = 0; i < m; i++) {
            int num = sc.nextInt();

            if(set.ceiling(new Pair(num, 0)) != null) {
                Pair p = set.ceiling(new Pair(num, 0));

                System.out.println(p.x + " " + p.y);

                set.remove(p);
            } else {
                System.out.println(-1 + " " + -1);
            }
        }
    }
}