import java.io.*;
import java.util.*;

// map.put(str, map.getOrDefault(str, 0) + 1);
// ArrayList<String> al = new ArrayList<>(map.keySet());
// ArrayList<Integer> al = new ArrayList<>(map.values());
// Collections.sort(al, new Comparator<String>() { ... return o1.compareTo(o2)};

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

class Node {
    int h;
    int w;

    Node(int h, int w) {
        this.h = h;
        this.w = w;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        ArrayList<Node> al = new ArrayList<>();
        for (int i = 1; i <= 150; i++) {
            for (int j = i + 1; j <= 150; j++) {
                al.add(new Node(i, j));
            }
        }

        Collections.sort(al, new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                if (check(o1.h, o1.w) == check(o2.h, o2.w)) {
                    return o1.h - o2.h;
                }

                return check(o1.h, o1.w) - check(o2.h, o2.w);
            }
        });

        while (true) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0) break;

            int idx = 0;
            for (int i = 0; i < al.size(); i++) {
                if (a == al.get(i).h && b == al.get(i).w) {
                    idx = i;
                    break;
                }
            }

            bw.write(al.get(idx + 1).h + " " + al.get(idx + 1).w + "\n");
        }

        bw.close();
    }

    public static int check(int x, int y) {
        return x * x + y * y;
    }
}