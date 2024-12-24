import java.io.*;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			char[] arr = br.readLine().toCharArray();

			int chance = 15 - arr.length;
			int count = 0;

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 'o')
					count++;
			}
			
			int check = 8 - count;
			
			if (check > chance) 
				bw.write("#" + test_case + " NO\n");
			else
				bw.write("#" + test_case + " YES\n");
			
		}

		bw.flush();
		bw.close();
		br.close();
	}
}