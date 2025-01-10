import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] city;
    static int[] index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        city = new int[N + 1][N + 1];

        index = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            index[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (city[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        int[] answer = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        boolean check = true;
        for (int i = 0; i < M - 1; i++) {
            if (index[answer[i]] != index[answer[i + 1]]) {
                check = false;
            }
        }

        if (check) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        bw.close();
    }

    public static void union(int num1, int num2) {
        int a = find(num1);
        int b = find(num2);

        if (a != b) {
            if (a > b) {
                index[num1] = index[num2];
            } else {
                index[num2] = index[num1];
            }
        }
    }

    public static int find(int a) {
        if (index[a] == a) {
            return a;
        } else {
            return index[a] = find(index[a]);
        }
    }
}