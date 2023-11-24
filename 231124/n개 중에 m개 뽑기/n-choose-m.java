import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static final int MX = 10;
    static boolean[] visit = new boolean[MX + 1];
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        func(1, 0);
    }
    static void func(int idx, int cnt) {
        if(idx == n + 1) {
            if(cnt == m)
                print();
            return;
        }

        list.add(idx);
        func(idx + 1, cnt + 1);
        list.remove(list.size() - 1);

        func(idx + 1, cnt);
    }
    static void print() {

        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        } 
        System.out.println();
    }
}