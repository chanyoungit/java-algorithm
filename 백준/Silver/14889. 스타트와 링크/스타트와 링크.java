import java.io.*;
import java.util.*;

// map.put(str, map.getOrDefault(str, 0) + 1);
// ArrayList<String> al = new ArrayList<>(map.keySet());
// ArrayList<Integer> al = new ArrayList<>(map.values());
// Collections.sort(al, new Comparator<String>() { ... return o1.compareTo(o2)};

public class Main {

    static int N, min;
    static int[][] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;
        combi(1, 0);

        bw.write(min + "");
        bw.close();
    }

    public static void combi(int idx, int count) {
        if (count == N / 2) {
            diffCal();
            if (min == 0) {
                return;
            }
        }

        for (int i = idx; i <= N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                combi(i + 1, count + 1);
                visit[i] = false;
            }
        }
    }

    public static void diffCal() {
        int start = 0;
        int link = 0;

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (visit[i] && visit[j]) {
                    start += arr[i][j];
                    start += arr[j][i];
                } else if (!visit[i] && !visit[j]) {
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }

        int abs = Math.abs(start - link);
        min = Math.min(min, abs);
    }
}