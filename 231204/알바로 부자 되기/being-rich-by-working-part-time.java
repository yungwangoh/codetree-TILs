import java.io.*;
import java.util.*;

class Tuple implements Comparable<Tuple> {
    int s, e, p;

    public Tuple(int s, int e, int p) {
        this.s = s;
        this.e = e;
        this.p = p;
    }

    @Override
    public int compareTo(Tuple t) {
        return s - t.s;
    }
}
public class Main {

    static int n;
    static final int MAX = 1000;
    static final int INT = 1;
    static Tuple[] arr = new Tuple[MAX + 1];
    static int[] dp = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int p = sc.nextInt();

            arr[i] = new Tuple(s, e, p);
        }

        //Arrays.sort(arr, 0, n);

        func();

        System.out.println(max());
        //print();
    }   
    static void print() {

        for(int i = 0; i < n; i++) System.out.print(dp[i] + " ");
        System.out.println();
    }
    static int max() {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) max = Math.max(max, dp[i]);
        return max;
    }
    static void func() {

        for(int i = 0; i < n; i++) {

            dp[i] = arr[i].p;
            for(int j = 0; j < i; j++) {

                if(isRange(arr[j].s, arr[j].e, arr[i].s, arr[i].e)) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i].p);
                }
            }
        }
    }
    static boolean isRange(int s, int e, int ns, int ne) {
        return ne < s || e < ns;
    }
}