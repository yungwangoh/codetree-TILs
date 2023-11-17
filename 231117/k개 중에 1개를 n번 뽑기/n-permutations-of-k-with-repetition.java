import java.io.*;
import java.util.*;

public class Main {
    
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();

        combi(1, K, N);
    }
    static void combi(int idx, int k, int n) {

        if(idx == n + 1) {
            print();
            return;
        }

        for(int i = 1; i <= k; i++) {
            list.add(i);
            combi(idx + 1, k, n);
            list.remove(list.size() - 1);
        }
    }
    static void print() {

        for(int n : list) System.out.print(n + " ");
        System.out.println();
    }
}