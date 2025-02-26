import java.io.*;
import java.util.*;

// map.put(str, map.getOrDefault(str, 0) + 1);
// ArrayList<String> al = new ArrayList<>(map.keySet());
// ArrayList<Integer> al = new ArrayList<>(map.values());
// Collections.sort(al, new Comparator<String>() { ... return o1.compareTo(o2)};
// String str = String.valueOf(ch).repeat(5);
// int[] alpha = new int[26];

// public int compare(Node o1, Node o2) {
//    return Double.compare(o1.weight, o2.weight);
// }

// Arrays.sort(a, Collections.reverseOrder())

// Lower Bound -> LIS
//while (s < e) {
//    int mid = (s + e) / 2;
//    if (al.get(mid) >= num) {
//        e = mid;
//    } else {
//        s = mid + 1;
//    }
//}
// al.set(e, num);

// Math.round(num1 * 100.0) / 100.0 -> 3.14
// IFNULL(name, 'park') AS name, WHERE NAME IS NOT NULL, COUNT(DISTINCT NAME)

class Node {
    String str;
    int depth;

    Node(String str, int depth) {
        this.str = str;
        this.depth = depth;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String value = br.readLine();

        while (true) {

            if (value.length() == str.length()) {
                if (value.equals(str)) {
                    bw.write("1");
                } else {
                    bw.write("0");
                }
                break;
            }

            char ch = value.charAt(value.length() - 1);

            if (ch == 'A') {
                value = value.substring(0, value.length() - 1);
            } else {
                value = value.substring(0, value.length() - 1);
                value = new StringBuilder(value).reverse().toString();
            }
        }


        bw.close();
    }
}