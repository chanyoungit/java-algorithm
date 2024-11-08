import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] left = new int[N];
        int[] right = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            left[i] = 1;
            right[i] = 1;
        }

        // left
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    left[i] = Math.max(left[j] + 1, left[i]);
                }
            }
        }

        // right
        for (int i = N - 2; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    right[i] = Math.max(right[j] + 1, right[i]);
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (left[i] + right[i] > sum) {
                sum = left[i] + right[i];
            }
        }

        sum -= 1;
        bw.write(sum + "");
        bw.close();
    }
}