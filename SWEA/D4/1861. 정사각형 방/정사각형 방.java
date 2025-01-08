import java.io.*;
import java.util.*;

class Solution {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static boolean[][] visited;
	static int[][] arr;
	static int N;
	static int maxDepth;
	static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {
        	N = Integer.parseInt(br.readLine());
        	arr = new int[N][N];
        	visited = new boolean[N][N];
        	
        	for (int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for (int j=0; j<N; j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	answer = Integer.MAX_VALUE;
        	maxDepth = 0;
        	
        	for (int i=0; i<N; i++) {
        		for (int j=0; j<N; j++) {
        			bfs(i,j,1);
        		}
        	}
        	
        	bw.write("#" + test_case + " " + answer + " " + maxDepth + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void bfs(int xx, int yy, int depth) {
    	visited[xx][yy] = true;
    	Queue<int[]> queue = new LinkedList<>();
    	queue.add(new int[]{xx,yy,depth});
    	
    	while(!queue.isEmpty()) {
    		
    		int[] now = queue.poll();
    		int a = now[0];
    		int b = now[1];
    		int nowDepth = now[2];
    		
    		if (maxDepth < nowDepth) {
    			maxDepth = nowDepth;
    			answer = arr[xx][yy];
    		} else if (maxDepth == nowDepth) {
    			answer = Math.min(answer, arr[xx][yy]);
    		}
    		
    		for (int i=0; i<4; i++){
    			int x = a + dx[i];
    			int y = b + dy[i];
    			
    			if (x>=0 && y>=0 && x<N && y<N) {
    				if (!visited[x][y]) {
    					if (arr[x][y] - arr[a][b] == 1) {
    						visited[x][y] = true;
        					queue.add(new int[] {x,y, nowDepth+1});
    	    			}
    				}
    			}
    		}
    	}
    	
    	for (int i=0; i<N; i++) {
    		for (int j=0; j<N; j++) {
    			visited[i][j] = false;
    		}
    	}
    }
}