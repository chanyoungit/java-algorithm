import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] map;
    static int[][] dp;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        bw.write(dfs(0, 0) + "");
        bw.close();
    }

    public static int dfs(int a, int b) {

        if (a == M - 1 && b == N - 1) {
            return 1;
        }

        if (dp[a][b] == -1) {
            dp[a][b] = 0;

            for (int i = 0; i < 4; i++) {
                int x = a + dx[i];
                int y = b + dy[i];

                if (x >= 0 && x < M && y >= 0 && y < N) {
                    if (map[a][b] > map[x][y]) {
                        dp[a][b] += dfs(x, y);
                    }
                }
            }
        }

        return dp[a][b];
    }
}