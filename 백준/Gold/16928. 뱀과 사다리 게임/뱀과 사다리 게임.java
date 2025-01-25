import java.io.*;
import java.util.*;

// map.put(str, map.getOrDefault(str, 0) + 1);
// ArrayList<String> al = new ArrayList<>(map.keySet());
// ArrayList<Integer> al = new ArrayList<>(map.values());
// Collections.sort(al, new Comparator<String>() { ... return o1.compareTo(o2)};

class Node {
    int index;
    int weight;

    Node(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }
}

public class Main {

    static int N, M, answer;
    static int[][] road;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 사다리
        M = Integer.parseInt(st.nextToken());   // 뱀

        road = new int[N + M][2];
        visit = new boolean[101];

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            road[i][0] = Integer.parseInt(st.nextToken());
            road[i][1] = Integer.parseInt(st.nextToken());
        }

        answer = 0;
        bfs(1);

        bw.write(answer + "");
        bw.close();
    }

    public static void bfs(int index) {
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });

        queue.add(new Node(1, 0));
        visit[1] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int nowIndex = now.index;
            int nowWeight = now.weight;

            if (nowIndex == 100) {
                answer = nowWeight;
                break;
            }

            for (int i = 1; i <= 6; i++) {
                int plusIndex = nowIndex + i;

                if (plusIndex > 100) {
                    continue;
                }

                if (!visit[plusIndex]) {
                    visit[plusIndex] = true;

                    for (int j = 0; j < N + M; j++) {
                        if (plusIndex == road[j][0]) {
                            plusIndex = road[j][1];
                        }
                    }
                    queue.add(new Node(plusIndex, nowWeight + 1));
                }
            }
        }
    }
}