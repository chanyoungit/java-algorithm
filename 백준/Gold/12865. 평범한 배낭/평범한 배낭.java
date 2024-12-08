import java.io.*;
import java.util.*;

class Node {
    int w;
    int v;

    Node(int w, int v) {
        this.w = w;
        this.v = v;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Node[] arr = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[i] = new Node(w, v);
        }

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {

                // i번째 무게를 더 담을 수 없는 경우
                if (arr[i].w > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], arr[i].v + dp[i - 1][j - arr[i].w]);
                }
            }
        }

        bw.write(dp[N][K] + "");
        bw.close();
    }
}