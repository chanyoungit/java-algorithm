import javax.lang.model.SourceVersion;
import java.io.*;
import java.util.*;

// map.put(str, map.getOrDefault(str, 0) + 1);
// ArrayList<String> al = new ArrayList<>(map.keySet());
// ArrayList<Integer> al = new ArrayList<>(map.values());
// Collections.sort(al, new Comparator<String>() { ... return o1.compareTo(o2)};

class Node {
    int start;
    int end;
    double weight;

    Node(int start, int end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

public class Main {

    static int[][] arr;
    static boolean[] visit;
    static int[] index;
    static int N, M, cnt;
    static double answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][2];
        index = new int[N + 1];
        cnt = 0;
        answer = 0;

        for (int i = 1; i <= N; i++) {
            index[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i][0] = a;
            arr[i][1] = b;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b, 0);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                return Double.compare(o1.weight, o2.weight);
            }
        });

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (find(i) != find(j)) {
                    double weight = cal(i, j);
                    queue.add(new Node(i, j, weight));
                }
            }
        }

        while (cnt < N) {
            if (cnt == N - 1) {
                break;
            }
            Node now = queue.poll();
            int start = now.start;
            int end = now.end;
            double weight = now.weight;

            union(start, end, weight);
        }


        bw.write(String.format("%.2f", answer));
        bw.close();
    }

    public static double cal(int a, int b) {
        double value = Math.sqrt(Math.pow(arr[a][0] - arr[b][0], 2) + Math.pow(arr[a][1] - arr[b][1], 2));
        return value;
    }

    public static void union(int a, int b, double c) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a < b) {
                index[b] = a;
            } else {
                index[a] = b;
            }
            cnt++;
            answer += c;
        }
    }

    public static int find(int a) {
        if (a == index[a]) {
            return a;
        } else {
            return index[a] = find(index[a]);
        }
    }
}