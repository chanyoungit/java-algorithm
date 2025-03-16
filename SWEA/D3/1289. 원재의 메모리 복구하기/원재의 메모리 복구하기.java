import java.io.*;
import java.util.*;

class Solution {
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			char[] ch = br.readLine().toCharArray();
			int answer = 0;
			char now = '0';
			for (int i=0; i<ch.length; i++) {
				if (ch[i] != now) {
					answer++;
					now = ch[i];
				}
			}
			bw.write("#" + test_case + " " + answer + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}