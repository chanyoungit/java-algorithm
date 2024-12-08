import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] arr = new int[N + 1][N + 1];
        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= j; i++) {
                if (i == j) {
                    arr[i][j] = 1;
                } else if (Math.abs(i - j) == 1) {
                    if (numArr[i] == numArr[j]) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = 0;
                    }
                } else if (Math.abs(i - j) == 2) {
                    if (numArr[i] == numArr[j]) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = 0;
                    }
                } else {
                    if (numArr[i] == numArr[j] && arr[i + 1][j - 1] == 1) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = 0;
                    }
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(arr[a][b] + "\n");
        }

        bw.close();
    }
}