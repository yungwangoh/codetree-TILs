import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static Queue<Integer> q = new PriorityQueue<>((o1, o2) -> {
        if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;

        return Math.abs(o1) - Math.abs(o2); 
    });
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();

            if(x != 0) {
                q.add(x);
            } else {
                if(q.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(q.poll());
                }
            }
        }
    }
}