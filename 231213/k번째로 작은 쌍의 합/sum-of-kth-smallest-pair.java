import java.io.*;
import java.util.*;

class Tuple implements Comparable<Tuple> {
    int pairSum, idx1, idx2;

    public Tuple(int pairSum, int idx1, int idx2) {
        this.pairSum = pairSum;
        this.idx1 = idx1;
        this.idx2 = idx2;
    }

    @Override
    public int compareTo(Tuple t) {
        if(pairSum != t.pairSum) return pairSum - t.pairSum;
        else if(idx1 != t.idx1) return idx1 - t.idx1;
        else return idx2 - t.idx2;
    }
}
public class Main {

    static int n, m, k;
    static final int MAX = 100000;
    static int[] arr = new int[MAX + 1];
    static int[] brr = new int[MAX + 1];
    static Queue<Tuple> q = new PriorityQueue<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < m; i++) {
            brr[i] = sc.nextInt();
        }

        Arrays.sort(arr, 0, n);
        Arrays.sort(brr, 0, m);

        for(int i = 0; i < n; i++) {
            q.add(new Tuple(arr[i] + brr[0], i, 0));
        }

        for(int i = 0; i < k - 1; i++) {
            Tuple t = q.poll();
            int idx1 = t.idx1;
            int idx2 = t.idx2;

            idx2++;
            if(idx2 < m) q.add(new Tuple(arr[idx1] + brr[idx2], idx1, idx2));
        }

        System.out.println(q.peek().pairSum);
    }
}