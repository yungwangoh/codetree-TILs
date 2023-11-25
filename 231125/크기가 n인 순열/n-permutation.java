import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 8;
    static int n;
    static List<Integer> list = new ArrayList<>();
    static boolean[] visit = new boolean[MAX];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        func(0);
    }   
    static void func(int idx) {
        if(idx == n) {
            
            for(int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(visit[i]) continue;

            visit[i] = true;
            list.add(i);
            func(idx + 1);
            list.remove(list.size() - 1);
            visit[i] = false;
        }
    }
}