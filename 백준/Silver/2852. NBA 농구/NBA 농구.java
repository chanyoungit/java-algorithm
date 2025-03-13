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
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int score1 = 0;
        int score2 = 0;

        int leadTime1 = 0;
        int leadTime2 = 0;

        int lastLeadTime = 0;
        int endTime = 48 * 60;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int team = Integer.parseInt(st.nextToken());

            String[] time = st.nextToken().split(":");
            int nowTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);

            if (score1 > score2) {
                leadTime1 += nowTime - lastLeadTime;
            } else if (score2 > score1) {
                leadTime2 += nowTime - lastLeadTime;
            }

            lastLeadTime = nowTime;

            if (team == 1) {
                score1++;
            } else {
                score2++;
            }
        }

        if (score1 > score2) {
            leadTime1 += endTime - lastLeadTime;
        } else if (score2 > score1) {
            leadTime2 += endTime - lastLeadTime;
        }

        bw.write(String.format("%02d:%02d\n", leadTime1 / 60, leadTime1 % 60));
        bw.write(String.format("%02d:%02d\n", leadTime2 / 60, leadTime2 % 60));

        bw.close();
    }
}