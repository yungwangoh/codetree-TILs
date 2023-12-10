import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static final int MAX = 100000;
    static TreeSet<Integer> set = new TreeSet<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) set.add(sc.nextInt());
        for(int i = 0; i < m; i++) {
            int num = sc.nextInt();

            System.out.println(search(num));
        }
    }
    static int search(int num) {
        
        if(set.ceiling(num) == null) return -1;
        else return set.ceiling(num);
    }
}