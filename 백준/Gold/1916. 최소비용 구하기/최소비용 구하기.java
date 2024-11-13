import java.io.*;
import java.util.*;

class Node {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class Main {

    static ArrayList<Node>[] al;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        al = new ArrayList[N + 1];
        result = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            al[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            al[a].add(new Node(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        result[start] = 0;
        djk(start);

        bw.write(result[end] + "");
        bw.close();
    }

    public static void djk(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (visited[now.end]) continue;

            for (Node next : al[now.end]) {
                if (!visited[next.end]) {
                    if (next.weight + result[now.end] < result[next.end]) {
                        result[next.end] = next.weight + result[now.end];
                        queue.add(new Node(next.end, result[next.end]));
                    }
                }
            }
            visited[now.end] = true;
        }
    }
}