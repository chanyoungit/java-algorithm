import java.io.*;;
import java.util.*;

class Main {

    static int[] parent;
    static boolean[] visit;
    static ArrayList<Integer>[] al;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        visit = new boolean[N + 1];

        al = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            al[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            al[a].add(b);
            al[b].add(a);
        }

        dfs(1);

        for (int i = 2; i <= N; i++) {
            bw.write(parent[i] + "\n");
        }

        bw.close();
    }

    public static void dfs(int a) {
        visit[a] = true;
        for (int i : al[a]) {
            if (!visit[i]) {
                parent[i] = a;
                dfs(i);
            }
        }
    }
}