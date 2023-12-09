import java.io.*;
import java.util.*;

public class Main {

    static int a, b;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        b = sc.nextInt();

        for(int i = 0; i < a; i++) {
            set.add(sc.nextInt());
        }

        int ans = 0;
        for(int i = 0; i < b; i++) {
            int num = sc.nextInt();

            if(set.contains(num)) ans++;
            
            set.add(num);
        }

        System.out.println(set.size() - ans);
    }
}