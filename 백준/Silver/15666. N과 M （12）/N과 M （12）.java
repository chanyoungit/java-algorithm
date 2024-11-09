import java.io.*;
import java.util.*;

class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] answer;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        answer = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0, 0);

        bw.write(sb.toString());
        bw.close();
    }

    public static void dfs(int index, int depth) {
        if (depth == M) {
            for (int i : answer) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for (int i = index; i < N; i++) {
            if (before != arr[i]) {
                answer[depth] = arr[i];
                before = arr[i];
                dfs(i, depth + 1);
            } else {
                continue;
            }
        }
    }
}