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

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        ArrayList<Node>[] al = new ArrayList[V + 1];
        boolean[] visited = new boolean[V + 1];
        int[] result = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            al[i] = new ArrayList<Node>();
            result[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            al[u].add(new Node(v, m));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        result[start] = 0;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (!visited[now.end]) visited[now.end] = true;

            for (Node next : al[now.end]) {
                if (!visited[next.end] && next.weight + result[now.end] < result[next.end]) {
                    result[next.end] = next.weight + result[now.end];
                    queue.add(new Node(next.end, result[next.end]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                bw.write("INF" + "\n");
            } else {
                bw.write(result[i] + "\n");
            }
        }

        bw.close();
    }
}