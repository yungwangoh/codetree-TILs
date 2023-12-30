import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    static int n;
    static TreeMap<Integer, Integer> map = new TreeMap<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            String s = sc.next();
            int k = 0;
            if(!s.equals("print_list")) k = sc.nextInt();

            switch (s) {
                case "add":
                    int v = sc.nextInt();
                    map.put(k, v);

                    break;
                case "find":
                    if (map.containsKey(k)) {
                        System.out.println(map.get(k));
                    } else {
                        System.out.println("None");
                    }
                    break;
                case "print_list":
                    Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();

                    boolean flag = false;
                    while (it.hasNext()) {
                        Entry<Integer, Integer> entry = it.next();
                        System.out.print(entry.getValue() + " ");
                        flag = true;
                    }
                    if(!flag) System.out.print("None");
                    System.out.println();
                    break;
                case "remove":
                    map.remove(k);
                    break;
            }
        }
    }
}