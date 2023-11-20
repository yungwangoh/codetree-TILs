import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int a, b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Pair p) {
        if(a == p.a) return b - p.b;
        return b - p.b;
    }
}
public class Main {

    static final int MAX = 20;
    static Pair[] pairs = new Pair[MAX];
    static int[][] arr = new int[MAX][MAX];
    static List<Pair> list = new ArrayList<>();
    static int n, m, min = Integer.MAX_VALUE;
    static int[] numbers;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            pairs[i] = new Pair(a, b);
        }

        numbers = new int[MAX];
        for(int i = 1; i < MAX; i++) {
            numbers[i] = i;
        }

        Arrays.sort(pairs, 0, m);

        for(int i = 0; i < m; i++) {
            Pair p = pairs[i];

            swap(numbers, p.a, p.a + 1);
        }

        // for(int i = 1; i <= n; i++) {
        //     System.out.print(numbers[i] + " ");
        // }

        combi(0);
        System.out.println(min);
    }
    static void combi(int idx) {
        if(idx == m) {
            int[] a = result(list);
            if(check(a, numbers)) {
                min = Math.min(min, list.size());
            }
            return;
        }

        list.add(pairs[idx]);
        combi(idx + 1);
        list.remove(list.size() - 1);

        combi(idx + 1);
    }
    static int[] result(List<Pair> list) {
        int[] a = new int[MAX];
        
        for(int i = 1; i < MAX; i++) a[i] = i;

        Collections.sort(list);

        for(Pair p : list) {
            swap(a, p.a, p.a + 1);
        }

        return a;
    }
    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    static boolean check(int[] a, int[] b) {

        for(int i = 1; i <= n; i++) {
            if(a[i] != b[i]) return false;
        }

        return true;
    }
}