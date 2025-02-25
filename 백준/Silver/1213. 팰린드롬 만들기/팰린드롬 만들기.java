import java.io.*;
import java.util.*;

// map.put(str, map.getOrDefault(str, 0) + 1);
// ArrayList<String> al = new ArrayList<>(map.keySet());
// ArrayList<Integer> al = new ArrayList<>(map.values());
// Collections.sort(al, new Comparator<String>() { ... return o1.compareTo(o2)};

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
        StringBuilder sb = new StringBuilder();

        int[] alpha = new int[26];

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            alpha[str.charAt(i) - 'A']++;
        }

        int oddCnt = 0;
        int oddIdx = -1;
        boolean oddCheck = true;
        for (int i = 0; i < 26; i++) {
            if (alpha[i] % 2 == 1) {
                oddCnt++;
                oddIdx = i;

                if (oddCnt > 1) {
                    oddCheck = false;
                    break;
                }
            }
        }

        String front = "";
        String answer = "";

        if (!oddCheck) {
            bw.write("I'm Sorry Hansoo");
        } else {
            for (int i = 0; i < 26; i++) {
                if (alpha[i] != 0) {
                    char ch = (char) (i + 'A');
                    front += String.valueOf(ch).repeat(alpha[i] / 2);
                }
            }

            answer += front;

            if (oddIdx != -1) {
                char ch = (char) (oddIdx + 'A');
                answer += String.valueOf(ch);
            }

            String reversed = new StringBuilder(front).reverse().toString();
            answer += reversed;

            bw.write(answer + "");
        }

        bw.close();
    }
}