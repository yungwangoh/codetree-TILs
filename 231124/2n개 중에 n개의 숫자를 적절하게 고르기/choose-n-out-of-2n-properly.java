import java.io.*;
import java.util.*;

public class Main {
    
    static final int MAX = 10;
    static int n, min = Integer.MAX_VALUE;
    static int[] a = new int[MAX];
    static int[] b = new int[MAX];
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        func(0);
    }
    static void func(int idx) {
        if(idx == n) {
            return;
        }

        list
    }
    static int calculate() {

        
    }
}