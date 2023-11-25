import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 20;
    static int n, m, min = Integer.MAX_VALUE;
    static int[] x = new int[MAX];
    static int[] y = new int[MAX];
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        func(0, 0);

        System.out.println(min);
    }
    static void func(int idx, int cnt) {
        if(idx == n) {
            if(cnt == m) {
                min = Math.min(min, calculate());
            }
            return;
        }

        list.add(idx);
        func(idx + 1, cnt + 1);
        list.remove(list.size() - 1);

        func(idx + 1, cnt);
    }
    static int calculate() {
        
        int m = Integer.MIN_VALUE;

        // for(int i = 0; i < list.size(); i++) System.out.print(list.get(i) + " ");
        // System.out.println();

        for(int i = 0; i < list.size(); i++) {

            int s1 = list.get(i);
            for(int j = i + 1; j < list.size(); j++) {
                int s2 = list.get(j);

                m = Math.max(m, (int) (Math.pow(x[s1] - x[s2], 2) + Math.pow(y[s1] - y[s2], 2)));
            }
        }

        return m;
    }
}