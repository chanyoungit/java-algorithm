import java.io.*;
import java.util.*;

// map.put(str, map.getOrDefault(str, 0) + 1);
// ArrayList<String> al = new ArrayList<>(map.keySet());
// ArrayList<Integer> al = new ArrayList<>(map.values());
// Collections.sort(al, new Comparator<String>() { ... return o1.compareTo(o2)};
// String str = String.valueOf(ch).repeat(5);
// int[] alpha = new int[26];

//value = value.substring(0, value.length() - 1);
//value = new StringBuilder(value).reverse().toString();

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

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> map = new TreeMap<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            char[] ch = str.toCharArray();

            boolean check = false;
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < ch.length; j++) {
                if (ch[j] == '.') {
                    check = true;
                    continue;
                }

                if (check) {
                    key.append(ch[j]);
                }

                String lastKey = key.toString();

                if (j == ch.length - 1) {
                    map.put(lastKey, map.getOrDefault(lastKey, 0) + 1);
                }
            }
        }

        for (String keys : map.keySet()) {
            bw.write(keys + " " + map.get(keys) + "\n");
        }

        bw.close();
    }
}