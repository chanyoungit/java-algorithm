import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			char[] ch = str.toCharArray();
			int mid = ch.length / 2;

			int k = mid + 1;
			boolean bl = true;
			for (int j = mid - 1; j >= 0; j--) {
				if (ch[j] != ch[k]) {
					bl = false;
					break;
				}
				k++;
				if (k == ch.length) break;
			}

			if (bl) {
				int b = mid - 1;
				int a = 0;

				while (a < b) {
					if (ch[b] != ch[a]) {
						bl = false;
						break;
					}
					b--;
					a++;
				}
			}

			int seq = i + 1;
			if (bl)
				bw.write("#" + seq + " YES\n");
			else
				bw.write("#" + seq + " NO\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}