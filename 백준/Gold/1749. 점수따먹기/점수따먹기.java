import java.io.*;
import java.util.*;

// map.put(str, map.getOrDefault(str, 0) + 1);
// ArrayList<String> al = new ArrayList<>(map.keySet());
// ArrayList<Integer> al = new ArrayList<>(map.values());
// Collections.sort(al, new Comparator<String>() { ... return o1.compareTo(o2)};

public class Main {

    static int N, M, answer;
    static int[][] dp;
    static int x, y, c, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= M; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] += dp[i][j - 1];
            }
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                dp[j][i] += dp[j - 1][i];
            }
        }

//        for (int i = 0; i <= N; i++) {
//            for (int j = 0; j <= M; j++) {
//                bw.write(dp[i][j] + " ");
//            }
//            bw.write("\n");
//        }

        answer = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                check(i, j);
            }
        }

        bw.write(answer + "\n");
//        bw.write(x + " " + y + " " + c + " " + d + "\n");
        bw.close();
    }

    public static void check(int a, int b) {
        for (int i = a; i <= N; i++) {
            for (int j = b; j <= M; j++) {
                int value = dp[i][j] - dp[i][b - 1] - dp[a - 1][j] + dp[a - 1][b - 1];
                answer = Math.max(answer, value);

//                int value = 0;
//                if (a == i) {
//                    value = dp[i][j] - dp[i][b - 1];
//                } else if (b == j) {
//                    value = dp[i][j] - dp[a - 1][j];
//                } else {
//                    value = dp[i][j] - dp[i][b - 1] - dp[a - 1][j] + dp[a - 1][b - 1];
//                }
//
//                if (answer < value) {
//                    x = a;
//                    y = b;
//                    c = i;
//                    d = j;
//                    answer = Math.max(answer, value);
//                }

            }
        }
    }
}