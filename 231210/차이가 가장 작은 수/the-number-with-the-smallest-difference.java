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

        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();

            if(!set.isEmpty()) {
                if(set.higher(num) != null) {
                    ans.add(set.higher(num) - num);
                } 

                if(set.lower(num) != null) {
                    ans.add(num - set.lower(num));
                }
            }

            set.add(num);
        }

        if(ans.ceiling(m) == null) System.out.println(-1);
        else System.out.println(ans.ceiling(m));
    }
}