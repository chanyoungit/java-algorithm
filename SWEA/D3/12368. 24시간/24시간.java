import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int sum = A+B;
			
			if(sum < 24) {
				bw.write("#" + test_case + " " + sum + "\n");
			} else {
				sum -= 24;
				bw.write("#" + test_case + " " + sum + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}