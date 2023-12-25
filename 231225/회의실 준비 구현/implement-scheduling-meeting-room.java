import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair>{

    int s, e;

    public Pair(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Pair p) {
        return e - p.e;
    }
}
public class Main {

    static int n;
    static final int MX = 100000;
    static Pair[] p = new Pair[MX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            p[i] = new Pair(s, e);
        }

        Arrays.sort(p, 0, n);

        //int cnt = 0;
        Stack<Pair> stack = new Stack();

        stack.push(p[0]);

        for(int i = 1; i < n; i++) {
            if(isRange(stack.peek(), p[i])) stack.push(p[i]);
        }

        System.out.println(stack.size());
    }
    static boolean isRange(Pair x1, Pair x2) {
        return x1.e <= x2.s || x2.e <= x1.s;
    }
}