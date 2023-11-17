import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> list = new ArrayList<>();
    static int cnt = 0;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        search(0, n);

        System.out.println(cnt);
    }
    static void search(int idx, int n) {
        if(idx == n) {
            if(check()) cnt++;
            return;
        }
        
        for(int i = 1; i <= 4; i++) {
            list.add(i);
            search(idx + 1, n);
            list.remove(list.size() - 1);
        }
    }
    static boolean check() {
        
    }
}