import java.io.*;
import java.util.*;

public class Solution {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long answer = 0;
            int cnt = 0;
            int start = 0;
            int end = 0;

            while (cnt < N) {
                end = max(start, arr);
                for (int i = start; i <= end; i++) {
                    cnt++;
                    answer += arr[end] - arr[i];
                }
                start = end + 1;
            }

            bw.write("#" + test_case + " " + answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int max(int start, int[] arr) {
        int max = start;
        for (int i = start; i < N; i++) {
            if (arr[max] <= arr[i]) {
                max = i;
            }
        }

        return max;
    }
}