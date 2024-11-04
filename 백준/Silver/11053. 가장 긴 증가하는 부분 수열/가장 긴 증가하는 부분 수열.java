import java.io.*;
import java.util.*;

class Main {

    static int[] answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        answer = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int check = 0;
        for (int i = 0; i < N; i++) {
            int idx = search(arr[i], 0, check, check + 1);
            if (idx == -1) {
                answer[check++] = arr[i];
            } else {
                answer[idx] = arr[i];
            }
        }

        bw.write(check + "");
        bw.close();
    }

    public static int search(int num, int start, int end, int size) {
        int idx = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (num <= answer[mid]) {
                idx = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (start == size) {
            return -1;
        } else {
            return idx;
        }
    }
}