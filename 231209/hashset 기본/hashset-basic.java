import java.io.*;
import java.util.*;

public class Main {

    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            String s = sc.next();
            int num = sc.nextInt();
        
            if(s.equals("add")) {
                add(num);
            } else if(s.equals("remove")) {
                remove(num);
            } else {    
                System.out.println(find(num));
            }
        }
    }
    static void add(int x) {
        set.add(x);
    }
    static void remove(int x) {
        set.remove(x);
    }
    static boolean find(int x) {
        return set.contains(x);
    }
}