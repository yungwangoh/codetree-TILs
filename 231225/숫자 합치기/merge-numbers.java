import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static final int MAX = 100000;
    static Queue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            pq.add(sc.nextInt());
        }
      
        int sum = 0;
        while(true) {

            int a = pq.poll();
            int b = pq.poll();

            sum += (a + b);

            if(pq.isEmpty()) break;

            pq.add(a + b);
        }

        System.out.println(sum);
    }
}