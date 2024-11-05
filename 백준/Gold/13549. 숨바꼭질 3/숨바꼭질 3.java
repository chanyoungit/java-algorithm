import java.io.*;
import java.util.*;

class Node {
    int num;
    int depth;

    public Node(int num, int depth) {
        this.num = num;
        this.depth = depth;
    }
}

class Main {

    static int K;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100_001];

        bfs(N, 0);

        bw.write(min + "");
        bw.close();
    }

    public static void bfs(int num, int depth) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(num, depth));
        visited[num] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.num == K) {
                min = Math.min(min, now.depth);
            }

            if (now.num * 2 <= 100_000 && !visited[now.num * 2]) {
                queue.add(new Node(now.num * 2, now.depth));
                visited[now.num * 2] = true;
            }

            if (now.num - 1 >= 0 && !visited[now.num - 1]) {
                queue.add(new Node(now.num - 1, now.depth + 1));
                visited[now.num - 1] = true;
            }

            if (now.num + 1 <= 100_000 && !visited[now.num + 1]) {
                queue.add(new Node(now.num + 1, now.depth + 1));
                visited[now.num + 1] = true;
            }
        }
    }
}