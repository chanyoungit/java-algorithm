import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int start;
    int end;
    int weight;

    Node(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class Main {
    static int[] index;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        index = new int[V + 1];
        sum = 0;
        for (int i = 1; i <= V; i++) index[i] = i;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            queue.add(new Node(u, v, w));
        }
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            union(node.start, node.end, node.weight);
        }
        bw.write(sum + "");
        bw.close();
    }

    public static void union(int a, int b, int c) {
        a = find(a);
        b = find(b);
        if (a != b) {
            index[b] = a;
            sum += c;
        }
    }

    public static int find(int a) {
        if (index[a] == a) return a;
        else return index[a] = find(index[a]);
    }
}