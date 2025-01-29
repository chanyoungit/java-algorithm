import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.util.*;

// map.put(str, map.getOrDefault(str, 0) + 1);
// ArrayList<String> al = new ArrayList<>(map.keySet());
// ArrayList<Integer> al = new ArrayList<>(map.values());
// Collections.sort(al, new Comparator<String>() { ... return o1.compareTo(o2)};

class Node {
    int end;
    int weight;

    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class Main {

    static int N, E;
    static ArrayList<Node>[] al;
    static boolean[] visit;
    static int[] result;
    static final int MAX = 800*2*1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        al = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            al[i] = new ArrayList<>();
            result[i] = MAX;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            al[a].add(new Node(b, c));
            al[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int answer1 = 0;
        int answer2 = 0;

        dj(1);
        answer1 += result[v1];
        answer2 += result[v2];

        dj(v1);
        answer1 += result[v2];
        answer2 += result[N];

        dj(v2);
        answer2 += result[v1];
        answer1 += result[N];

        int answer = Math.min(answer1, answer2);
        if (answer >= MAX) {
            bw.write("-1");
        } else {
            bw.write(answer + "");
        }

        bw.close();
    }

    public static void dj(int s) {
        reset();

        visit[s] = true;
        result[s] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });

        queue.add(new Node(s, result[s]));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int nowEnd = now.end;
            int nowWeight = now.weight;
            visit[nowEnd] = true;

            for (Node next : al[nowEnd]) {
                int nextEnd = next.end;
                int nextWeight = next.weight;

                if (!visit[nextEnd] && nowWeight + nextWeight < result[nextEnd]) {
                    result[nextEnd] = nowWeight + nextWeight;

                    queue.add(new Node(nextEnd, result[nextEnd]));
                }
            }
        }
    }

    public static void reset() {
        for (int i = 1; i <= N; i++) {
            visit[i] = false;
            result[i] = MAX;
        }
    }
}