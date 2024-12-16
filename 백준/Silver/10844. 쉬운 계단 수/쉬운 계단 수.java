import java.io.*;
import java.util.*;

public class Main {
    static final int mod = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][10];

        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                dp[1][i] = 0;
            } else {
                dp[1][i] = 1;
            }
        }

        if (N > 1) {
            for (int i = 2; i <= N; i++) {
                for (int j = 0; j < 10; j++) {
                    if (dp[i - 1][j] != 0) {
                        if (j == 0) {
                            dp[i][j + 1] += dp[i - 1][j] % mod;
                        } else if (j == 9) {
                            dp[i][j - 1] += dp[i - 1][j] % mod;
                        } else {
                            dp[i][j - 1] += dp[i - 1][j] % mod;
                            dp[i][j + 1] += dp[i - 1][j] % mod;
                        }
                    }
                }
            }
        }

        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[N][i];
        }

        bw.write(answer % mod + "");
        bw.close();
    }
}