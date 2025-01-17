import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N + 1];
        boolean[] check = new boolean[N + 1];

        int seq = 0;
        for (int i = 2; i <= N; i++) {
            if (!check[i]) {
                num[seq++] = i;
                for (int j = i * 2; j <= N; j += i) {
                    check[j] = true;
                }
            }
        }

        int answer = 0;
        if (N != 1 && !check[N]) {
            answer += 1;
        }

        int s = 0;
        int e = 1;
        int sum = num[s] + num[e];

        while (e < num.length) {
            if (num[e] == 0 || num[e] == N) {
                break;
            }

            if (sum == N) {
                answer++;
                sum -= num[s];
                s++;
            } else if (sum < N) {
                e++;
                if (e > N) break;
                sum += num[e];
            } else {
                sum -= num[s];
                s++;
            }
        }

        bw.write(answer + "");
        bw.close();
    }
}