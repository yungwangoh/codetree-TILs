import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();

        func(K, N, 0);
    }
    static void func(int K, int N, int num) {

        if(num == N) {
            print();
            return;
        }

        for(int i = 1; i <= K; i++) {
            if(num >= 2 && i == list.get(list.size() - 1) && i == list.get(list.size() - 2))
                continue;

            list.add(i);
            func(K, N, num + 1);
            list.remove(list.size() - 1);
        }
    }
    static void print() {

        for(Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}