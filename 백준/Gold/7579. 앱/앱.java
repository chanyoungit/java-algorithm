import java.io.*;
import java.util.*;

// map.put(str, map.getOrDefault(str, 0) + 1);
// ArrayList<String> al = new ArrayList<>(map.keySet());
// ArrayList<Integer> al = new ArrayList<>(map.values());
// Collections.sort(al, new Comparator<String>() { ... return o1.compareTo(o2)};

// public int compare(Node o1, Node o2) {
//    return Double.compare(o1.weight, o2.weight);
// }

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 실행되고 있는 앱의 수
        int M = Integer.parseInt(st.nextToken());

        int[] m = new int[N];
        int[] c = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][10001];
        boolean check = false;
        int answer = 0;

        for (int i = 0; i < 10001; i++) {
            for (int j = 1; j <= N; j++) {
                if (c[j - 1] <= i) {
                    dp[j][i] = Math.max(dp[j - 1][i], m[j - 1] + dp[j - 1][i - c[j - 1]]);

                    if (dp[j][i] >= M) {
                        answer = i;
                        check = true;
                    }
                } else {
                    dp[j][i] = dp[j - 1][i];
                }

                if (check) break;
            }
            if (check) break;
        }

        bw.write(answer + "");
        bw.close();
    }
}