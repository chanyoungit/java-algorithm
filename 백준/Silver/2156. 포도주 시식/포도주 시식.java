import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i] = arr[i];
            } else if (i == 1) {
                dp[i] = dp[0] + arr[i];
            } else if (i == 2) {
                dp[i] = Math.max(dp[0] + arr[i], arr[1] + arr[i]);
            } else {
                dp[i] = Math.max(dp[i - 2] + arr[i], arr[i - 1] + arr[i] + dp[i - 3]);
            }

            answer = Math.max(answer, dp[i]);
            dp[i] = answer;
        }

        bw.write(answer + "");

        bw.close();
    }
}