import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static final int MAX = 100000;
    static int[] arr = new int[MAX + 1];
    static Queue<Integer> q = new PriorityQueue<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int mul = 1;
        for(int i = 0; i < n; i++) {
            int x = arr[i];

            q.add(x);

            if(q.size() >= 3) {
                int a = q.poll();
                int b = q.poll();
                int c = q.poll();
                System.out.println(a * b * c);
                q.add(a);
                q.add(b);
                q.add(c);
            } else {
                System.out.println(-1);
            }
        }
    }
}