import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static Queue<Integer> q = new PriorityQueue<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();

            q.add(-num);
        }

        while(true) {

            int n1 = -q.poll();
            int n2 = -q.poll();

            int diff = Math.abs(n1 - n2);

            if(diff != 0) q.add(-diff);

            if(q.size() == 0 || q.size() == 1) break;
        }

        if(q.size() == 0) System.out.println(-1);
        else System.out.println(-q.poll());
    }
}