import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());

        int S = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals("all")) {
                S = (1 << 21) - 1;
            } else if (str.equals("empty")) {
                S = 0;
            } else {
                int num = Integer.parseInt(st.nextToken());

                switch (str) {
                    case "add":
                        S = S | (1 << num);
                        break;
                    case "remove":
                        S = S & ~(1 << num);
                        break;
                    case "check":
                        int a = S & (1 << num);
                        if (a != 0) {
                            bw.write("1\n");
                        } else {
                            bw.write("0\n");
                        }
                        break;
                    case "toggle":
                        S = S ^ (1 << num);
                        break;
                }
            }
        }

        bw.close();
    }
}