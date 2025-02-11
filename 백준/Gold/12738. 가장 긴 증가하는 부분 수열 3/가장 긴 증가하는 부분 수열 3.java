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

public class Main {

    static int N;
    static int[] a;
    static ArrayList<Integer> al;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        a = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        al = new ArrayList<>();
        al.add(Integer.MIN_VALUE);

        for (int i = 0; i < N; i++) {
            int num = a[i];

            if (num > al.get(al.size() - 1)) {
                al.add(num);
            } else {
                binary(num);
            }
        }

        bw.write(al.size() - 1 + "");
        bw.close();
    }

    public static void binary(int num) {
        int s = 1;
        int e = al.size() - 1;

        while (s < e) {
            int mid = (s + e) / 2;

            if (al.get(mid) >= num) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }

        al.set(e, num);
    }
}