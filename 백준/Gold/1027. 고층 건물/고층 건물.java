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
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            double[] check = new double[N + 1];
            check[i] = 0;
            int cnt = 0;

            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                check[j] = (double) (arr[j] - arr[i]) / (j - i);
            }

            double min = Double.MAX_VALUE;
            for (int j = i - 1; j > 0; j--) {
                if (min > check[j]) {
                    min = check[j];
                    cnt++;
                }
            }

            double max = -Double.MAX_VALUE;
            for (int j = i + 1; j <= N; j++) {
                if (max < check[j]) {
                    max = check[j];
                    cnt++;
                }
            }

            answer = Math.max(answer, cnt);
        }

        bw.write(answer + "");
        bw.close();
    }
}