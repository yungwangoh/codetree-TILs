import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 2000000;
    static int n;
    static int[] arr = new int[MAX + 1];
    static boolean[] visit = new boolean[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        visit[n] = true;
        bfs(n);

        System.out.println(arr[1]);
    }
    static void bfs(int x) {
        
        Queue<Integer> q = new LinkedList<>();

        q.add(x);
        while(!q.isEmpty()) {

            x = q.poll();

            //if(x == 1) break;

            for(int num : new int[]{one(x), two(x), three(x), four(x)}) {
                if(isRange(num) || visit[num]) continue;

                visit[num] = true;
                arr[num] = arr[x] + 1;
                q.add(num);
            }
        }
    }
    static int one(int x) {
        return x + 1;
    }
    static int two(int x) {
        return x - 1;
    }
    static int three(int x) {

        if(x % 2 == 0) return x / 2;
        else return x;
    }
    static int four(int x) {

        if(x % 3 == 0) return x / 3;
        else return x;
    }
    static boolean isRange(int x) {
        return x < 0 || x >= MAX;
    }
}