import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] arr;
    static ArrayList<Integer>[] al;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());    // 도시의 수
        M = Integer.parseInt(br.readLine());    // 여행 계획에 속한 도시들의 수

        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        al = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            al[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] == 1) {
                    al[i].add(j);
                    al[j].add(i);
                }
            }
        }

        visited = new boolean[N + 1];

        int[] answer = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        dfs(answer[0]);

        boolean bl = true;
        for (int i = 0; i < M; i++) {
            if (!visited[answer[i]]) {
                bl = false;
            }
        }

        if (bl) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        bw.close();
    }

    public static void dfs(int s) {
        visited[s] = true;

        for (int i : al[s]) {

            if (!visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}