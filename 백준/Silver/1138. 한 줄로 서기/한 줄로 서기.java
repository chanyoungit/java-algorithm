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
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            int num = arr[i];

            int cnt = 0;
            boolean check = false;
            while (cnt <= num) {
                for (int j = 0; j < N; j++) {
                    if (answer[j] == 0) {
                        if (cnt == num) {
                            answer[j] = i + 1;
                            check = true;
                        } else {
                            cnt++;
                        }
                    }
                    if (check) break;
                }
                if (check) break;
            }
        }

        for (int i = 0; i < N; i++) {
            bw.write(answer[i] + " ");
        }

        bw.close();
    }
}