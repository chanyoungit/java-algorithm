import java.io.*;
import java.util.*;

class Solution {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static HashSet<Integer> set;
	static int[][] arr;
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			arr = new int[4][4];
			set = new HashSet<>();
			for (int i =0; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<4; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i=0; i<4; i++) {
				for (int j=0; j<4; j++) {
					dfs("", i,j, 0);
				}
			}
			
			bw.write("#" + test_case + " " + set.size() + "\n");
		}		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(String str, int a, int b, int depth) {
		if (depth == 7) {
			set.add(Integer.parseInt(str));
			return;
		}
		
		for (int i=0; i<4; i++) {
			int x = a + dx[i];
			int y = b + dy[i];
			
			if(x>=0 && y>=0 && x<4 && y<4) {
				dfs(str+String.valueOf(arr[a][b]), x,y,depth+1);
			}
		}
	}
}