import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {

    int n, v;

    public Pair(int n, int v) {
        this.n = n;
        this.v = v;
    }

    @Override
    public int compareTo(Pair p) {
        return v - p.v;
    }
}
public class Main {
    
    static int n;
    static final int MAX = 100000;
    static Pair[] arr = new Pair[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int v = sc.nextInt();
            arr[i] = new Pair(i + 1, v); 
        }

        Arrays.sort(arr, 0, n);

        int max = 0;
        for(int i = 1; i < n; i++) {
            if(arr[0].n < arr[i].n) {
                max = Math.max(max, arr[i].v - arr[0].v);
            }
        }

        System.out.println(max);
    }
}