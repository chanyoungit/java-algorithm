import java.io.*;
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

public class Main {

    static Node[] arr;
    static int[] index;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if (m == 0 && n == 0) break;

            arr = new Node[n];
            index = new int[m];

            for (int i = 0; i < m; i++) {
                index[i] = i;
            }

            int sum = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                sum += c;

                arr[i] = new Node(a, b, c);
            }

            Arrays.sort(arr, new Comparator<Node>() {
                public int compare(Node o1, Node o2) {
                    return o1.weight - o2.weight;
                }
            });

            cnt = 0;
            int answer = 0;

            for (int i = 0; i < n; i++) {
                int s = arr[i].start;
                int e = arr[i].end;
                int w = arr[i].weight;

                if (find(s) != find(e)) {
                    cnt++;
                    union(s, e);
                    answer += w;
                }

                if (cnt == m - 1) {
                    break;
                }
            }

            bw.write(sum - answer + "\n");
        }
        bw.close();
    }

    public static void union(int a, int b) {
        int a1 = find(a);
        int b1 = find(b);

        if (a1 != b1) {
            if (a1 > b1) {
                index[a1] = b1;
            } else {
                index[b1] = a1;
            }
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