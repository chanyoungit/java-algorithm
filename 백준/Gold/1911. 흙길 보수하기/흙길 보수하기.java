import java.io.*;
import java.util.*;

// map.put(str, map.getOrDefault(str, 0) + 1);
// ArrayList<String> al = new ArrayList<>(map.keySet());
// ArrayList<Integer> al = new ArrayList<>(map.values());
// Collections.sort(al, new Comparator<String>() { ... return o1.compareTo(o2)};
// String str = String.valueOf(ch).repeat(5);
// int[] alpha = new int[26];

//value = value.substring(0, value.length() - 1);
//value = new StringBuilder(value).reverse().toString();

// public int compare(Node o1, Node o2) {
//    return Double.compare(o1.weight, o2.weight);
// }

// Arrays.sort(a, Collections.reverseOrder())

// Lower Bound -> LIS
//while (s < e) {
//    int mid = (s + e) / 2;
//    if (al.get(mid) >= num) {
//        e = mid;
//    } else {
//        s = mid + 1;
//    }
//}
// al.set(e, num);

// Math.round(num1 * 100.0) / 100.0 -> 3.14
// bw.write(String.format("%02d:%02d\n", leadTime1 / 60, leadTime1 % 60));
// IFNULL(name, 'park') AS name, WHERE NAME IS NOT NULL, COUNT(DISTINCT NAME)

class Node {
    int s;
    int e;

    Node(int s, int e) {
        this.s = s;
        this.e = e;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                return o1.s - o2.s;
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            queue.add(new Node(s, e));
        }

        int fillMax = 0;
        int answer = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            
            if (now.e <= fillMax) continue;

            if (now.s > fillMax) {
                fillMax = now.s;
            } else {
                now.s = fillMax;
            }

            int mod = (now.e - now.s) / L;
            int remain = (now.e - now.s) % L;

            answer += mod;
            fillMax = now.e;

            if (remain != 0) {
                answer++;
                fillMax += L - remain;
            }
        }

        bw.write(answer + "");
        bw.close();
    }
}