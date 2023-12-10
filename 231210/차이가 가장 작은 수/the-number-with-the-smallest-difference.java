import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static TreeSet<Integer> set = new TreeSet<>();
    static TreeSet<Integer> ans = new TreeSet<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        set.add(sc.nextInt());

        for(int i = 1; i < n; i++) {
            int num = sc.nextInt();

            if(set.ceiling(num) != null) {
                ans.add(set.ceiling(num) - num);
            } 

            if(set.floor(num) != null)
                ans.add(num - set.floor(num));

            set.add(num);
        }

        //for(int s : ans) System.out.println(s);

        if(ans.ceiling(m) == null) System.out.println(-1);
        else System.out.println(ans.ceiling(m));
    }
}