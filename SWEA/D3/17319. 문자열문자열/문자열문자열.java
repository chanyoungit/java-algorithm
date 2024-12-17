import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			char[] ch = str.toCharArray();
			int k = 0;
			int t = N / 2;

			boolean bl = true;
			if (N % 2 == 1)
				bl = false;

			while (bl) {
				if (ch[k] != ch[t]) {
					bl = false;
					break;
				}
				k++;
				t++;
				if (t == N)
					break;
			}

			int seq = i + 1;
			if (bl)
				bw.write("#" + seq + " Yes\n");
			else
				bw.write("#" + seq + " No\n");

		}

		bw.flush();
		bw.close();
		br.close();
	}
}