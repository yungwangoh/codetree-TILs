import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
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
    static final int MAX = 100000;
    static Pair[] plist = new Pair[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            plist[i] = new Pair(s, e);
        }

        Arrays.sort(plist, 0, n);

        Stack<Pair> stack = new Stack();
        
        stack.push(plist[0]);
        for(int i = 1; i < n; i++) {
            if(check(stack.peek(), plist[i])) stack.push(plist[i]);
        }

        System.out.println(n - stack.size());
    }
    static boolean check(Pair x1, Pair x2) {
        return x2.e <= x1.s || x1.e <= x2.s;
    }
}