import java.io.*;;
import java.util.*;

class Node {
    int start;
    int end;
    int weight;

    public Node(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

class Main {
    static int N, M;
    static Node[] arr;
    static long[] result;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            result[i] = Integer.MAX_VALUE;
        }

        arr = new Node[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            arr[i] = new Node(A, B, C);
        }

        result[1] = 0;
        check = true;
        bell();

        if (!check) {
            bw.write("-1\n");
        } else {
            for (int i = 2; i <= N; i++) {
                if (result[i] == Integer.MAX_VALUE) {
                    bw.write("-1\n");
                } else {
                    bw.write(result[i] + "\n");
                }
            }
        }

        bw.close();
    }

    public static void bell() {
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                int s = arr[j].start;
                int e = arr[j].end;
                int w = arr[j].weight;

                if (result[s] != Integer.MAX_VALUE) {
                    if (result[s] + w < result[e]) {
                        if (i == N) {
                            check = false;
                        }
                        result[e] = result[s] + w;
                    }
                }
            }
        }
    }
}