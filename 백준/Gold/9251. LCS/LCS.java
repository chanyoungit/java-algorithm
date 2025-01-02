import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] dp = new int[str2.length() + 1][str1.length() + 1];

        for (int i = 0; i <= str2.length(); i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= str1.length(); i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= str1.length(); i++) {
            char ch1 = str1.charAt(i - 1);
            for (int j = 1; j <= str2.length(); j++) {
                char ch2 = str2.charAt(j - 1);

                if (ch1 == ch2) {
                    dp[j][i] = dp[j - 1][i - 1] + 1;
                } else {
                    if (j == 1) {
                        dp[j][i] = dp[j][i - 1];
                    } else {
                        dp[j][i] = Math.max(dp[j - 1][i], dp[j][i - 1]);
                    }
                }
            }
        }

        bw.write(dp[str2.length()][str1.length()] + "");
        bw.close();
    }
}