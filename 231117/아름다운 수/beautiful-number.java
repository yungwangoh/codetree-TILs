import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> list = new ArrayList<>();
    static int cnt = 0, n;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        search(0);

        System.out.println(cnt);
    }
    static void search(int idx) {
        if(idx == n) {
            if(check()) cnt++;
            return;
        }
        
        for(int i = 1; i <= 4; i++) {
            list.add(i);
            search(idx + 1);
            list.remove(list.size() - 1);
        }
    }
    static boolean check() {

        for(int i = 0; i < n; i += list.get(i)) {

            if(i + list.get(i) - 1 >= n)
                return false;

            for(int j = i; j < i + list.get(i); j++)
                if(list.get(j) != list.get(i))
                    return false;
        }
        return true;
    }
}