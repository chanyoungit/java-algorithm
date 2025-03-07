import java.io.*;
import java.util.*;

class Solution {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static int answer;
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = 10;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[16][16];
			visited = new boolean[16][16];
			answer = 0;
			
			int a = 0;
			int b = 0;
			for (int i=0; i<16; i++) {
				char[] ch = br.readLine().toCharArray();
				
				for (int j=0; j<ch.length; j++) {
					arr[i][j] = ch[j] - '0';
					if (arr[i][j] == 2) {
						a = i;
						b = j;
					}
				}
			}
			
			bfs(a,b);
			bw.write("#" + test_case + " " + answer + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void bfs (int a, int b) {
		visited[a][b] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {a,b});
		
		while(!queue.isEmpty()) {
			int[] now  = queue.poll();
			
			for (int i=0; i<4; i++) {
				int x = now[0] + dx[i];
				int y = now[1] + dy[i];
				
				if (arr[x][y] == 3) {
					answer = 1;
					break;
				}
				
				if (x>=0 && y>=0 && x<16 && y<16) {
					if (!visited[x][y] && arr[x][y] == 0) {
						visited[x][y] = true;
						queue.add(new int[] {x,y});
					}
				}
			}
		}
	}
}