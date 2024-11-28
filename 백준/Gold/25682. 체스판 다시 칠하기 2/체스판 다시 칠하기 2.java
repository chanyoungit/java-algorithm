import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int[][] sumArr = new int[N][M];
        char odd = 'W';
        char even = 'B';

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int check = (i + j) % 2;

                if (check == 0 && arr[i][j] == odd) {
                    sumArr[i][j] = 1;
                } else if (check == 1 && arr[i][j] == even) {
                    sumArr[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < M; j++) {
                sumArr[i][j] += sumArr[i][j - 1];
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 1; j < N; j++) {
                sumArr[j][i] += sumArr[j - 1][i];
            }
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = K - 1; i < N; i++) {
            for (int j = K - 1; j < M; j++) {
                if (i != K - 1 && j != K - 1) {
                    int cnt = sumArr[i][j] - (sumArr[i - K][j] + sumArr[i][j - K] - sumArr[i - K][j - K]);
                    min = Math.min(min, cnt);
                    max = Math.max(max, cnt);
                } else if (i != K - 1 && j == K - 1) {
                    int cnt = sumArr[i][j] - sumArr[i - K][j];
                    min = Math.min(min, cnt);
                    max = Math.max(max, cnt);
                } else if (i == K - 1 && j != K - 1) {
                    int cnt = sumArr[i][j] - sumArr[i][j - K];
                    min = Math.min(min, cnt);
                    max = Math.max(max, cnt);
                } else {
                    int cnt = sumArr[i][j];
                    min = Math.min(min, cnt);
                    max = Math.max(max, cnt);
                }
            }
        }

        int min2 = K * K - max;
        int answer = Math.min(min, min2);
        bw.write(answer + "");
        bw.close();
    }
}