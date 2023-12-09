import java.io.*;
import java.util.*;

public class Main {

    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 0; i < n; i++) set.add(sc.nextInt());

        System.out.println(set.size());
    }
}