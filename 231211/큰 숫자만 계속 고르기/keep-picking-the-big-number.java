import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static Queue<Integer> q = new PriorityQueue<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            q.add(-sc.nextInt());
        }

        for(int i = 0; i < m; i++) {
            int nn = q.poll() + 1;
            q.add(nn);
        }

        System.out.println(-q.peek());
    }
}